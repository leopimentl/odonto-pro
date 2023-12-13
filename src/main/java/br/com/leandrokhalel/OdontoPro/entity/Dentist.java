package br.com.leandrokhalel.OdontoPro.entity;

import br.com.leandrokhalel.OdontoPro.api.DentistaRequest;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Dentists")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cro;
    private String email;
    private String phone;
    private boolean active;

    public Dentist() {
    }

    public Dentist(Long id, String name, String cro, String email, String phone) {
        this.id = id;
        this.name = name;
        this.cro = cro;
        this.email = email;
        this.phone = phone;
        this.active = true;
    }

    public Dentist(DentistaRequest request) {
        this.name = request.name();
        this.cro = request.cro();
        this.email = request.email();
        this.phone = request.phone();
        this.active = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dentist dentist = (Dentist) o;

        return Objects.equals(id, dentist.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
