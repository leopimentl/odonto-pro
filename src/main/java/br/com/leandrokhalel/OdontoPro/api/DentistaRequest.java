package br.com.leandrokhalel.OdontoPro.api;

public record DentistaRequest(
        String name,
        String cro,
        String email,
        String phone
) {
}
