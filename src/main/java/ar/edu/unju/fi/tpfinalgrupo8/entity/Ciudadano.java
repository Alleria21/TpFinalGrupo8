package ar.edu.unju.fi.tpfinalgrupo8.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
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
	private long dni;
	
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
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="oferta_ciudadano",
				joinColumns = @JoinColumn(name="ciudadanos_id"),
				inverseJoinColumns = @JoinColumn(name="ofertas_id")
			)
	private Set<OfertaLaboral> ofertas;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="curso_ciudadano",
				joinColumns = @JoinColumn(name="inscripto_id"),
				inverseJoinColumns = @JoinColumn(name="curso_id")
			)
	private Set<Curso> unCurso;
	
	@Column(name="estado")
	private boolean estado;
	
	
	@OneToOne(mappedBy = "ciudadano", fetch = FetchType.EAGER,cascade = {CascadeType.MERGE})
	private CurriculumVitae curriculum;
	
	public Ciudadano() {
		// TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}


	public long getDni() {
		return dni;
	}


	public void setDni(long dni) {
		this.dni = dni;
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
	
	public Set<OfertaLaboral> getOfertas() {
		return ofertas;
	}


	public void setOfertas(Set<OfertaLaboral> ofertas) {
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


	public CurriculumVitae getCurriculum() {
		return curriculum;
	}


	public void setCurriculum(CurriculumVitae curriculum) {
		this.curriculum = curriculum;
	}


	public Set<Curso> getUnCurso() {
		return unCurso;
	}


	public void setUnCurso(Set<Curso> unCurso) {
		this.unCurso = unCurso;
	}

}
