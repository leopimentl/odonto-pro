package br.com.leandrokhalel.OdontoPro.service;

import br.com.leandrokhalel.OdontoPro.api.DentistResponse;
import br.com.leandrokhalel.OdontoPro.repository.DentistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DentistService {

    @Autowired
    private DentistRepository dentistRepository;

    public Page<DentistResponse> findAll(Pageable pageable) {
        return dentistRepository
                .findAll(pageable)
                .map(dentist -> new DentistResponse(dentist));
    }

    @Transactional
    public DentistResponse getReferenceById(Long id) {
         return new DentistResponse(
                dentistRepository.
                        getReferenceById(id));
    }
}
