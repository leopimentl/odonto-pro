package br.com.leandrokhalel.OdontoPro.controller;

import br.com.leandrokhalel.OdontoPro.api.DentistResponse;
import br.com.leandrokhalel.OdontoPro.api.DentistaRequest;
import br.com.leandrokhalel.OdontoPro.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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

    @PostMapping
    public ResponseEntity<DentistResponse> save(@RequestBody DentistaRequest request) {

        DentistResponse response = dentistService.save(request);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.id())
                .toUri();

        return ResponseEntity.created(location).body(response);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<DentistResponse> update(@PathVariable Long id, @RequestBody DentistaRequest request) {
        DentistResponse response = dentistService.update(id, request);

        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        dentistService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
