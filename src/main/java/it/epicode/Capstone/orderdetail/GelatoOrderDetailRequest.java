package it.epicode.Capstone.orderdetail;

import it.epicode.Capstone.scoopquantity.ScoopQuantityRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import java.util.List;

@Data
public class GelatoOrderDetailRequest {
    @Positive(message = "Il numero di palline deve essere un numero positivo")
    private int totalScoops;

    @NotNull(message = "Campo mancante")
    private List<ScoopQuantityRequest> scoopQuantities;
}
