package ar.edu.unju.fi.tpfinalgrupo8.entity;


import ar.edu.unju.fi.tpfinalgrupo8.util.Provincias;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "empleador")
public class Empleador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Min(value=1000000, message="debe ingresar un cuit válido")
    @Positive(message = "El cuit debe ser un numero valido")
    @Column(name = "cuit", nullable = false)
    private long cuit;

    @NotEmpty(message = "Este campo no debe ser vacio ni nulo" )
    @Column(name = "password",nullable = false)
    private String password;

    @NotEmpty(message = "Este campo no debe ser vacio ni nulo" )
    @Column(name = "razon_social", nullable = false)
    private String razonSocial;

    @NotEmpty(message = "Este campo no debe ser vacio ni nulo" )
    @Column(name = "nombre_comercial")
    private String nombreComercial;

    @Column(name = "inicio_actividad",nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inicioActividad;

    @NotEmpty(message = "Este campo no debe ser vacio ni nulo" )
    @Column(name = "email",nullable = false)
    private String email;

    @Positive(message = "el campo debe poseer valores positivos")
    @Column(name = "telefono")
    private long telefono;

    @NotEmpty(message = "Este campo no debe ser vacio ni nulo" )
    @Column(name = "domicilio",nullable = false)
    private String domicilio;

    @Enumerated(EnumType.STRING)
    @Column(name = "provincia")
    private Provincias provincia;


    @Column(name = "pagina_web")
    private String paginaWeb;

    @Column(name = "descripcion")
    private String descripcion;

    //TODO : revisar cascada
    @OneToMany(mappedBy = "empleador", fetch = FetchType.EAGER,cascade = {CascadeType.MERGE})
    private List<OfertaLaboral> ofertasLaborales;

    public Empleador() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public LocalDate getInicioActividad() {
        return inicioActividad;
    }

    public void setInicioActividad(LocalDate inicioActividad) {
        this.inicioActividad = inicioActividad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Provincias getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincias provincia) {
        this.provincia = provincia;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<OfertaLaboral> getOfertasLaborales() {
        return ofertasLaborales;
    }

    public void setOfertasLaborales(List<OfertaLaboral> ofertas) {
        this.ofertasLaborales = ofertas;
    }
}

