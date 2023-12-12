package br.com.leandrokhalel.OdontoPro.controller;

import br.com.leandrokhalel.OdontoPro.api.DentistResponse;
import br.com.leandrokhalel.OdontoPro.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/dentists")
public class DentistController {

    @Autowired
    private DentistService dentistService;

    @GetMapping
    public ResponseEntity<Page<DentistResponse>> findAll(Pageable pageable) {
        Page<DentistResponse> dentists = dentistService.findAll(pageable);
        return ResponseEntity.ok(dentists);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DentistResponse> getById(@PathVariable Long id) {
        DentistResponse response = dentistService.getReferenceById(id);
        return ResponseEntity.ok(response);
    }
}
