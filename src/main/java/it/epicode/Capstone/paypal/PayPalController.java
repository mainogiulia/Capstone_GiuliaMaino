package it.epicode.Capstone.paypal;

import com.paypal.core.PayPalHttpClient;
import com.paypal.orders.*;
import it.epicode.Capstone.gelatoorder.GelatoOrder;
import it.epicode.Capstone.gelatoorder.GelatoOrderRequest;
import it.epicode.Capstone.gelatoorder.GelatoOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/paypal")
public class PayPalController {

    @Autowired
    private PayPalHttpClient payPalClient;

    @Autowired
    private final GelatoOrderService gelatoOrderService;

    @Value("${paypal.returnUrl}")
    private String returnUrl;

    @Value("${paypal.cancelUrl}")
    private String cancelUrl;

    @PostMapping("/createOrder")
    public ResponseEntity<Map<String, String>> createOrder(@RequestParam int totalScoops, @RequestBody GelatoOrderRequest gelatoOrderRequest) {

        GelatoOrder pendingOrder = gelatoOrderService.createOrder(gelatoOrderRequest, OrderStatusEnum.PENDING);

        // Conserva l'ID dell'ordine per il successivo aggiornamento
        Long orderId = pendingOrder.getId();

        // CREAZIONE ORDINE PAYPAL
        OrdersCreateRequest request = new OrdersCreateRequest();
        request.requestBody(buildRequestBody(totalScoops, orderId));

        try {
            // ESECUZIONE DELLA RICHIESTA PER CREARE L'ORDINE
            Order order = payPalClient.execute(request).result();

            // ESTRAZIONE DEL LINK DI APPROVAZIONE DI PAYPAL
            String approvalUrl = order.links().stream()
                    .filter(link -> "approve".equals(link.rel()))
                    .findFirst()
                    .map(LinkDescription::href)
                    .orElseThrow(() -> new RuntimeException("Nessun link di approvazione trovato"));

            // CREAZIONE DELLA MAPPA PER RESTITUIRE L'URL COME JSON
            Map<String, String> response = new HashMap<>();
            response.put("approvalUrl", approvalUrl);
            response.put("orderId", orderId.toString());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace(); // STAMPA TUTTO L'ERRORE
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Errore PayPal: " + e.getMessage());

            gelatoOrderService.updateOrderStatus(orderId, OrderStatusEnum.FAILED);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    private OrderRequest buildRequestBody(int totalScoops, Long orderId) {
        BigDecimal totalAmount = BigDecimal.valueOf(totalScoops * 2.00);
        String formattedAmount = totalAmount.setScale(2, RoundingMode.HALF_UP).toPlainString(); // Forza due decimali

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.checkoutPaymentIntent("CAPTURE");

        ApplicationContext applicationContext = new ApplicationContext()
                .brandName("Pertilia")
                .landingPage("BILLING")
                .cancelUrl(cancelUrl)
                .returnUrl(returnUrl);

        AmountWithBreakdown amount = new AmountWithBreakdown()
                .currencyCode("EUR")
                .value(formattedAmount);

        PurchaseUnitRequest purchaseUnit = new PurchaseUnitRequest()
                .amountWithBreakdown(amount);

        purchaseUnit.referenceId(orderId.toString());

        orderRequest.applicationContext(applicationContext);
        orderRequest.purchaseUnits(Collections.singletonList(purchaseUnit));

        return orderRequest;
    }

    // ENDPOINT PER CATTURARE IL PAGAMENTO E FINALIZZARE LA TANSAZIONE
    @PostMapping("/captureOrder")
    public ResponseEntity<Map<String, String>> captureOrder(@RequestParam String token, @RequestParam Long orderId) {
        Map<String, String> response = new HashMap<>();

        try {
            OrdersCaptureRequest request = new OrdersCaptureRequest(token);
            Order order = payPalClient.execute(request).result();

            if ("COMPLETED".equals(order.status())) {
                // Aggiorna l'ordine nel database a "completed"
                GelatoOrder completedOrder = gelatoOrderService.updateOrderStatus(orderId, OrderStatusEnum.COMPLETED);

                response.put("status", "success");
                response.put("transactionId", order.id());
                response.put("message", "Pagamento completato con successo!");
                return ResponseEntity.ok(response);  // ✅ Ritorna un oggetto JSON
            } else {
                gelatoOrderService.updateOrderStatus(orderId, OrderStatusEnum.FAILED);

                response.put("status", "failure");
                response.put("message", "Pagamento non completato. Stato: " + order.status());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        } catch (Exception e) {
            gelatoOrderService.updateOrderStatus(orderId, OrderStatusEnum.ERROR);

            System.err.println("Errore durante la cattura del pagamento: " + e.getMessage());
            response.put("status", "error");
            response.put("message", "Errore nella cattura del pagamento: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}