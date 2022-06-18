package ar.edu.unju.fi.tpfinalgrupo8.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ar.edu.unju.fi.tpfinalgrupo8.util.EstadoCivil;
import org.springframework.format.annotation.DateTimeFormat;


import ar.edu.unju.fi.tpfinalgrupo8.util.Provincias;



@Entity
@Table(name="ciudadano")
public class Ciudadano {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ciudadano_id")
	private long id;
	
	@Min(value=1000000, message="*El n° de DNI debe ser mayor a 1.000.000")
	@Column(name="ciudadano_dni")
	private int dni;
	
	@Email
	@Column(name="ciudadano_email")
	private String email;
	
	@NotNull(message = "*Este campo no puede ser nulo" )
	@Column(name="ciudadano_estadoCivil")
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;
	
	
	@NotNull(message = "debe ingresar una provincia")
	@Column(name="ciudadano_provincia")
	@Enumerated(EnumType.STRING)
	private Provincias provincia;
	
	@Column(name="ciudadano_telefono")
	private int telefono;
	
	@NotNull(message = "*Debe ingresar una fecha") 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name="ciudadano_fechaNac")
	private LocalDate fechaNac;
	
	@Size(min=3, max=100, message="El nombre debe tener entre 8 a 14 caracteres")
	@NotNull(message = "*Debe ingresar una contraseña")
	@Column(name="ciudadano_password")
	private String password;
	/*
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable( name="ciudadano_oferta",
				joinColumns = @JoinColumn(name="ciudadano_id"),
				inverseJoinColumns = @JoinColumn(name="oferta_id")
			)
	private List<OfertaLaboral> ofertas=new ArrayList<OfertaLaboral>();
	*/
	@ManyToMany(mappedBy="ciudadanos")
	private List<OfertaLaboral> ofertas=new ArrayList<OfertaLaboral>();
	
	@Column(name="estado")
	private boolean estado;
	
	
	public Ciudadano() {
		// TODO Auto-generated constructor stub
	}


	public Ciudadano(long id, int dni, String email, EstadoCivil estadoCivil, Provincias provincia, int telefono, LocalDate fechaNac, String password, List<OfertaLaboral> ofertas, boolean estado) {
		this.id = id;
		this.dni = dni;
		this.email = email;
		this.estadoCivil = estadoCivil;
		this.provincia = provincia;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
		this.password = password;
		this.ofertas = ofertas;
		this.estado = estado;
	}

	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<OfertaLaboral> getOfertas() {
		return ofertas;
	}


	public void setOfertas(List<OfertaLaboral> ofertas) {
		this.ofertas = ofertas;
	}


	public boolean isEstado() {
		return estado;
	}


	public void setEstado(boolean estado) {
		this.estado = estado;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

}
