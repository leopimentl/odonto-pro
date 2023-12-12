package br.com.leandrokhalel.OdontoPro.repository;

import br.com.leandrokhalel.OdontoPro.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DentistRepository extends JpaRepository<Dentist, Long> {
}
