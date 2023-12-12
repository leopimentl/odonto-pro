package br.com.leandrokhalel.OdontoPro.api;

public record DentistaRequest(
        Long id,
        String name,
        String cro,
        String email,
        String phone
) {
}
