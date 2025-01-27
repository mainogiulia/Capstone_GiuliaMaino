package it.epicode.Capstone.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CostumerRequest {

    @NotEmpty(message = "Il campo username non può essere vuoto")
    private String username;

    @Email(message = "Email non valida")
    @NotBlank(message = "Il campo email non può essere vuoto")
    private String email;
}
