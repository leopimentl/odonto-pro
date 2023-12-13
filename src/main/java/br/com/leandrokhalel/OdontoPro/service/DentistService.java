package br.com.leandrokhalel.OdontoPro.service;

import br.com.leandrokhalel.OdontoPro.api.DentistResponse;
import br.com.leandrokhalel.OdontoPro.api.DentistaRequest;
import br.com.leandrokhalel.OdontoPro.entity.Dentist;
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

    @Transactional(readOnly = true)
    public Page<DentistResponse> findAll(Pageable pageable) {
        return dentistRepository
                .findAll(pageable)
                .map(dentist -> new DentistResponse(dentist));
    }

    @Transactional(readOnly = true)
    public DentistResponse getReferenceById(Long id) {
         return new DentistResponse(
                dentistRepository.
                        getReferenceById(id));
    }

    @Transactional
    public DentistResponse save(DentistaRequest request) {
         Dentist dentist = dentistRepository.save(new Dentist(request));

         return new DentistResponse(dentist);
    }

    public DentistResponse update(Long id, DentistaRequest request) {
        Dentist resourceById = dentistRepository.findById(id).get();

        updateDentist(resourceById, request);

        Dentist updatedResource = dentistRepository.save(resourceById);

        return new DentistResponse(updatedResource);
    }

    private void updateDentist(Dentist dentist, DentistaRequest request) {
        if (request.name() != null) {
            dentist.setName(request.name());
        }
        if (request.cro() != null) {
            dentist.setCro(request.cro());
        }
        if (request.email() != null) {
            dentist.setEmail(request.email());
        }
        if (request.phone() != null) {
            dentist.setPhone(request.phone());
        }
    }
}
