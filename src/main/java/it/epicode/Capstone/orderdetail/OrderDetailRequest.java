package it.epicode.Capstone.orderdetail;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import java.util.List;

@Data
public class OrderDetailRequest {
    @NotNull(message = "L'ID del dettaglio ordine non può essere nullo")
    private Long id;

    @NotEmpty(message = "La lista dei gusti non può essere vuota")
    private List<Long> flavourIds;

    @Positive(message = "Il numero di palline deve essere un numero positivo")
    private int numberOfScoops;

    @PositiveOrZero(message = "Il prezzo deve essere un numero positivo o zero")
    private int price;
}
