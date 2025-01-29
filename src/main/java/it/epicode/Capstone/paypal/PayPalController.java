package it.epicode.Capstone.paypal;

import com.paypal.core.PayPalHttpClient;
import com.paypal.orders.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class PayPalController {

    @Autowired
    private PayPalHttpClient payPalClient;

    @Value("${paypal.returnUrl}")
    private String returnUrl;

    @Value("${paypal.cancelUrl}")
    private String cancelUrl;

    @PostMapping("/createOrder")
    public String createOrder() {
        System.out.println("Richiesta ricevuta per creare un ordine PayPal");

        OrdersCreateRequest request = new OrdersCreateRequest();
        request.requestBody(buildRequestBody());

        try {
            Order order = payPalClient.execute(request).result();

            String approvalUrl = order.links().stream()
                    .filter(link -> "approve".equals(link.rel()))
                    .findFirst()
                    .map(LinkDescription::href)
                    .orElseThrow(() -> new RuntimeException("Nessun link di approvazione trovato"));

            return approvalUrl; //URL DA INVIARE AL FRONTEND

        } catch (Exception e) {
            return e.getMessage();
        }
    }

    // curl.exe -X POST http://localhost:8080/createOrder ----> COMANDO PER TERMINALE DI CREATE ORDER

    /*@PostMapping("/createOrder")
    public String createOrder() {
        System.out.println("Richiesta ricevuta per creare un ordine PayPal");

        OrdersCreateRequest request = new OrdersCreateRequest();
        request.requestBody(buildRequestBody());

        try {
            Order order = payPalClient.execute(request).result();
            return order.id();
        } catch (Exception e) {
            return e.getMessage();
        }
    }*/

    /*@PostMapping("/createOrder")
    public String createOrder() {
        OrdersCreateRequest request = new OrdersCreateRequest();
        request.requestBody(buildRequestBody());

        try {
            Order order = payPalClient.execute(request).result();
            return order.id();
        } catch (Exception e) {
            return e.getMessage();
        }
    }*/

    private OrderRequest buildRequestBody() {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.checkoutPaymentIntent("CAPTURE"); // Usa il metodo corretto

        ApplicationContext applicationContext = new ApplicationContext()
                .brandName("YourBrandName")
                .landingPage("BILLING")
                .cancelUrl(cancelUrl)
                .returnUrl(returnUrl);

        AmountWithBreakdown amount = new AmountWithBreakdown()
                .currencyCode("USD")
                .value("100.00");

        PurchaseUnitRequest purchaseUnit = new PurchaseUnitRequest()
                .amountWithBreakdown(amount); // Metodo corretto

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