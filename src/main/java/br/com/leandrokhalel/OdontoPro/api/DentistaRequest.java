package br.com.leandrokhalel.OdontoPro.api;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DentistaRequest(

        @NotBlank
        String name,
        @NotBlank
        String cro,
        @Email
        String email,
        String phone
) {
}
