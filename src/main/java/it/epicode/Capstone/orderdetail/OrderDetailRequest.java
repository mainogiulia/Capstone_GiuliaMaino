package it.epicode.Capstone.orderdetail;

import it.epicode.Capstone.scoopquantity.ScoopQuantityRequest;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import java.util.List;

@Data
public class OrderDetailRequest {
    @Positive(message = "Il numero di palline deve essere un numero positivo")
    private int totalScoops;

    @NotNull(message = "Campo mancante")
    private List<ScoopQuantityRequest> scoopQuantities;
}
