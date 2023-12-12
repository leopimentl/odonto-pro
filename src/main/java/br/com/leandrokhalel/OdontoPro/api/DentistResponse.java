package br.com.leandrokhalel.OdontoPro.api;

import br.com.leandrokhalel.OdontoPro.entity.Dentist;

public record DentistResponse(
        Long id,
        String name,
        String cro,
        String email,
        String phone
) {

    public DentistResponse(Dentist dentist) {
        this(dentist.getId(), dentist.getName(), dentist.getCro(), dentist.getEmail(), dentist.getPhone());
    }
}
