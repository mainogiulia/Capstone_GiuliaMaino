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

import java.io.IOException;
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
    public ResponseEntity<Map<String, String>> createOrder() {
        System.out.println("Richiesta ricevuta per creare un ordine PayPal");

        // CREAZIONE ORDINE PAYPAL
        OrdersCreateRequest request = new OrdersCreateRequest();
        request.requestBody(buildRequestBody());

        try {
            // ESECUZIONE DELLA RICHIESTA PER CREARE L'ORDINE
            Order order = payPalClient.execute(request).result();

            System.out.println("Risposta di PayPal: " + order);

            // ESTRAZIONE DEL LINK DI APPROVAZIONE DI PAYPAL
            String approvalUrl = order.links().stream()
                    .filter(link -> "approve".equals(link.rel()))
                    .findFirst()
                    .map(LinkDescription::href)
                    .orElseThrow(() -> new RuntimeException("Nessun link di approvazione trovato"));

            // CREAZIONE DELLA MAPPA PER RESTITUIRE L'URL COME JSON
            Map<String, String> response = new HashMap<>();
            response.put("approvalUrl", "https://www.sandbox.paypal.com/checkoutnow?token=0PH93964XV355061V");

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            System.err.println("Errore durante la creazione dell'ordine: " + e.getMessage());
            e.printStackTrace(); // STAMPA TUTTO L'ERRORE
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", "Errore PayPal: " + e.getMessage());

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);}
    }

    private OrderRequest buildRequestBody() {
        System.out.println("URL di ritorno: " + returnUrl);
        System.out.println("URL di annullamento: " + cancelUrl);

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.checkoutPaymentIntent("CAPTURE");

        ApplicationContext applicationContext = new ApplicationContext()
                .brandName("Pertilia")
                .landingPage("BILLING")
                .cancelUrl(cancelUrl)
                .returnUrl(returnUrl);

        AmountWithBreakdown amount = new AmountWithBreakdown()
                .currencyCode("EUR")
                .value("10.00");

        PurchaseUnitRequest purchaseUnit = new PurchaseUnitRequest()
                .amountWithBreakdown(amount);

        orderRequest.applicationContext(applicationContext);
        orderRequest.purchaseUnits(Collections.singletonList(purchaseUnit));

        return orderRequest;
    }

    // ENDPOINT PER CATTURARE IL PAGAMENTO E FINALIZZARE LA TANSAZIONE
    @PostMapping("/captureOrder")
    public String captureOrder(@RequestParam String token) {
        System.out.println("Richiesta di cattura per l'ordine PayPal: " + token);

        OrdersCaptureRequest request = new OrdersCaptureRequest(token);

        try {
            Order order = payPalClient.execute(request).result();

            if ("COMPLETED".equals(order.status())) {
                return "Pagamento completato con successo! ID Transazione: " + order.id();
            } else {
                return "Pagamento non completato. Stato: " + order.status();
            }
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}