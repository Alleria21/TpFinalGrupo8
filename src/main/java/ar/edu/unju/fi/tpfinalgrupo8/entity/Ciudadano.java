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
	
	@NotEmpty(message = "*Este campo no debe ser vacio ni nulo" )
	@Column(name="ciudadano_estadoCivil")
	private String estadoCivil;
	
	
	@NotEmpty(message = "*Este campo no debe ser vacio ni nulo" )
	@Column(name="ciudadano_provincia")
	private String provincia;
	
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


	public Ciudadano(int dni, String email, String estadoCivil, String provincia, int telefono, LocalDate fechaNac,
			String password,boolean estado) {
		super();
		this.dni = dni;
		this.email = email;
		this.estadoCivil = estadoCivil;
		this.provincia = provincia;
		this.telefono = telefono;
		this.fechaNac = fechaNac;
		this.password = password;
		this.estado=estado;
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


	public String getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
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
