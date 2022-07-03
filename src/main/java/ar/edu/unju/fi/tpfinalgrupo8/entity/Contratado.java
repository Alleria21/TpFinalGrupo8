package ar.edu.unju.fi.tpfinalgrupo8.entity;

import ar.edu.unju.fi.tpfinalgrupo8.util.EstadoCivil;
import ar.edu.unju.fi.tpfinalgrupo8.util.Provincias;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "contratado")
@SQLDelete(sql = "UPDATE users SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete=false")
public class Contratado {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="dni")
    private long dni;

    @Column(name="email")
    private String email;

    @Column(name="estado_civil")
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Column(name="provincia")
    @Enumerated(EnumType.STRING)
    private Provincias provincia;

    @Column(name="telefono")
    private int telefono;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="fecha_nac")
    private LocalDate fechaNac;

    @Column(name="soft_delete")
    private Boolean softDelete = Boolean.FALSE;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
    @JoinTable(name="contratado_oferta",
            joinColumns = @JoinColumn(name="contratados_id"),
            inverseJoinColumns = @JoinColumn(name="ofertas_id")
    )
    private List<OfertaLaboral> ofertasAceptadas=new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Provincias getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincias provincia) {
        this.provincia = provincia;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public List<OfertaLaboral> getOfertasAceptadas() {
        return ofertasAceptadas;
    }

    public Boolean getSoftDelete() {
        return softDelete;
    }

    public void setSoftDelete(Boolean softDelete) {
        this.softDelete = softDelete;
    }

    public void setOfertasAceptadas(List<OfertaLaboral> ofertas) {
        this.ofertasAceptadas = ofertas;
    }
}
