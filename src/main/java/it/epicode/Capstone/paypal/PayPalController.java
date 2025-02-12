package it.epicode.Capstone.paypal;

import com.paypal.core.PayPalHttpClient;
import com.paypal.orders.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @Value("${paypal.returnUrl}")
    private String returnUrl;

    @Value("${paypal.cancelUrl}")
    private String cancelUrl;

    @PostMapping("/createOrder")
    public ResponseEntity<Map<String, String>> createOrder(@RequestParam int totalScoops) {

        // CREAZIONE ORDINE PAYPAL
        OrdersCreateRequest request = new OrdersCreateRequest();
        request.requestBody(buildRequestBody(totalScoops));

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

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            e.printStackTrace(); // STAMPA TUTTO L'ERRORE
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Errore PayPal: " + e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }

    private OrderRequest buildRequestBody(int totalScoops) {
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

        orderRequest.applicationContext(applicationContext);
        orderRequest.purchaseUnits(Collections.singletonList(purchaseUnit));

        return orderRequest;
    }

    // ENDPOINT PER CATTURARE IL PAGAMENTO E FINALIZZARE LA TANSAZIONE
    @PostMapping("/captureOrder")
    public ResponseEntity<Map<String, String>> captureOrder(@RequestParam String token) {
        Map<String, String> response = new HashMap<>();

        try {
            OrdersCaptureRequest request = new OrdersCaptureRequest(token);
            Order order = payPalClient.execute(request).result();

            if ("COMPLETED".equals(order.status())) {
                response.put("status", "success");
                response.put("transactionId", order.id());
                response.put("message", "Pagamento completato con successo!");
                return ResponseEntity.ok(response);  // ✅ Ritorna un oggetto JSON
            } else {
                response.put("status", "failure");
                response.put("message", "Pagamento non completato. Stato: " + order.status());
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
            }
        } catch (Exception e) {
            System.err.println("Errore durante la cattura del pagamento: " + e.getMessage());
            response.put("status", "error");
            response.put("message", "Errore nella cattura del pagamento: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}