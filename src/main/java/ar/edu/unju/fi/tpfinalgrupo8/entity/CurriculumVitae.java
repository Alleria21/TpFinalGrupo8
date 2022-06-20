package ar.edu.unju.fi.tpfinalgrupo8.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import ar.edu.unju.fi.tpfinalgrupo8.util.ConocimientoInformatico;
import ar.edu.unju.fi.tpfinalgrupo8.util.EstadoCivil;
import ar.edu.unju.fi.tpfinalgrupo8.util.EstadoVidaPadres;
import ar.edu.unju.fi.tpfinalgrupo8.util.Nacionalidad;
import ar.edu.unju.fi.tpfinalgrupo8.util.NivelEducacion;
import ar.edu.unju.fi.tpfinalgrupo8.util.Provincias;

@Entity
@Table(name = "curriculumVitae")

public class CurriculumVitae {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_id")
	private long id;
	
	@OneToOne(cascade = {CascadeType.ALL})
	@JoinColumn(name = "ciudadano_id")
	private Ciudadano ciudadano;
	
	@Column(name="ESTADO")
	public boolean estado;
	
	
	//Datos personales del ciudadano en relacion a identidad
	
	@NotEmpty(message="Este campo debe estar completo")
	@Column(name = "cv_nombre")
	private String nombre;
	
	@NotEmpty(message="Este campo debe estar completo")
	@Column(name = "cv_apellido")
	private String apellido;
	
	@Email
	@NotEmpty(message="Este campo debe estar completo")
	@Column(name = "cv_mail")
	private String email;
	
	@NotNull(message="Este campo debe estar completo")
	@Min(value=1000000, message="*El N° de DNI debe ser mayor a 1.000.000")
	@Column(name = "DNI", length = 9, nullable = true)
	private long dni;
	
	@Column(name = "cv_hijos")
	private int cantidadDeHijos;
	
	@NotNull(message = "*Debe ingresar una fecha") 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "cv_fechaNac")
	private LocalDate fechaNacimiento;
	
	@NotNull(message="Debe completar este parámetro")
	@Column(name = "cv_estadoCivil", nullable = true)
	@Enumerated(EnumType.STRING)
	private EstadoCivil estadoCivil;
	
	@Min(value=1000, message="Ingrese un valor valido")
	@Column(name = "cv_telefono")
	private long telefono;
	
	@Column(name = "cv_padres")
	@Enumerated(EnumType.STRING)
	private EstadoVidaPadres estadoVidaPadres;
	
	//Datos personales del ciudadano en relacion al lugar de nacimiento
	
	@NotNull(message="Debe completar este parámetro")
	@Column(name = "cv_nacionalidadNac", nullable = true)
	@Enumerated(EnumType.STRING)
	private Nacionalidad nacionalidad;
	
	@NotNull(message="Debe completar este parámetro")
	@Column(name = "cv_provinciaNac", nullable = true)
	@Enumerated(EnumType.STRING)
	private Provincias provincias; // controlar
	
	@Column(name = "cv_ciudadNac")
	private String ciudad;
	
	//Datos personales del usuario en relacion al lugar donde vive
	
	@NotNull(message="Debe completar este parámetro")
	@Column(name = "cv_domicilio", nullable = true)
	private String domicilio;
	
	@NotNull(message="Debe completar este parámetro")
	@Column(name = "cv_paisResidencia", nullable = true)
	@Enumerated(EnumType.STRING)
	private Nacionalidad paisDeResidencia;
	
	@NotNull(message="Debe completar este parámetro")
	@Column(name = "cv_provinciaResidencia", nullable = true)
	@Enumerated(EnumType.STRING)
	private Provincias provinciaDeResidencia;
	
	@Column(name = "cv_ciudadResidencia", nullable = true)
	private String ciudadResidencia;

	//Datos personales del usuario en relacion a experiencia laboral
	
	@NotNull(message="Debe completar este parámetro")
	@Column(name = "cv_experienciaLaboral")
	private String experienciaLaboral;

	//Datos personales del usuario en relacion a la educacion
	
	@NotNull(message="Debe completar este parámetro")
	@Column(name = "cv_educacion")
	@Enumerated(EnumType.STRING)
	private NivelEducacion educacion;
	
	@Column(name = "cv_logros")
	private String logrosObtenidos;

	@NotNull(message="Debe completar este parámetro")
	@Column(name = "cv_egresoSecundario")
	private String escuelaColegioSecundario;
	
	@NotNull(message = "*Debe ingresar una fecha") 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "cv_fechaEgresoSec")
	private LocalDate fechaEgresadoSecundaria;
	
	@Column(name = "cv_egresoFacultad")
	private String escualaUniversidadFacultad;
	
	@NotNull(message = "*Debe ingresar una fecha") 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "cv_fechaEgresoFac")
	private LocalDate fechaEgresadoUniversidad;

	@NotNull(message="Debe completar este parámetro")
	@Column(name = "cv_titulo")
	private String tituloUniversitarioOSecundario;

	//Datos personales del usuario en relacion a habilidades
	
	@Column(name = "cv_idiomas")
	private String idiomas;
	
	@Column(name = "cv_conocimientosInformaticos")
	@Enumerated(EnumType.STRING)
	private ConocimientoInformatico conocimientosInformaticos;

	public CurriculumVitae(long id, Ciudadano ciudadano, String nombre, String apellido, String email, long dni,
			int cantidadDeHijos, LocalDate fechaNacimiento, EstadoCivil estadoCivil, long telefono,
			EstadoVidaPadres estadoVidaPadres, Nacionalidad nacionalidad, Provincias provincias, String ciudad,
			String domicilio, Nacionalidad paisDeResidencia, Provincias provinciaDeResidencia, String ciudadResidencia,
			String experienciaLaboral, NivelEducacion educacion, String logrosObtenidos,
			String escuelaColegioSecundario, LocalDate fechaEgresadoSecundaria, String escualaUniversidadFacultad,
			LocalDate fechaEgresadoUniversidad, String tituloUniversitarioOSecundario, String idiomas,
			ConocimientoInformatico conocimientosInformaticos, boolean estado) {
		super();
		this.id = id;
		this.ciudadano = ciudadano;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.dni = dni;
		this.cantidadDeHijos = cantidadDeHijos;
		this.fechaNacimiento = fechaNacimiento;
		this.estadoCivil = estadoCivil;
		this.telefono = telefono;
		this.estadoVidaPadres = estadoVidaPadres;
		this.nacionalidad = nacionalidad;
		this.provincias = provincias;
		this.ciudad = ciudad;
		this.domicilio = domicilio;
		this.paisDeResidencia = paisDeResidencia;
		this.provinciaDeResidencia = provinciaDeResidencia;
		this.ciudadResidencia = ciudadResidencia;
		this.experienciaLaboral = experienciaLaboral;
		this.educacion = educacion;
		this.logrosObtenidos = logrosObtenidos;
		this.escuelaColegioSecundario = escuelaColegioSecundario;
		this.fechaEgresadoSecundaria = fechaEgresadoSecundaria;
		this.escualaUniversidadFacultad = escualaUniversidadFacultad;
		this.fechaEgresadoUniversidad = fechaEgresadoUniversidad;
		this.tituloUniversitarioOSecundario = tituloUniversitarioOSecundario;
		this.idiomas = idiomas;
		this.conocimientosInformaticos = conocimientosInformaticos;
		this.estado = estado;
	}

	public CurriculumVitae() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Ciudadano getCiudadano() {
		return ciudadano;
	}

	public void setCiudadano(Ciudadano ciudadano) {
		this.ciudadano = ciudadano;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public int getCantidadDeHijos() {
		return cantidadDeHijos;
	}

	public void setCantidadDeHijos(int cantidadDeHijos) {
		this.cantidadDeHijos = cantidadDeHijos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public EstadoCivil getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public EstadoVidaPadres getEstadoVidaPadres() {
		return estadoVidaPadres;
	}

	public void setEstadoVidaPadres(EstadoVidaPadres estadoVidaPadres) {
		this.estadoVidaPadres = estadoVidaPadres;
	}

	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Provincias getProvincias() {
		return provincias;
	}

	public void setProvincias(Provincias provincias) {
		this.provincias = provincias;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Nacionalidad getPaisDeResidencia() {
		return paisDeResidencia;
	}

	public void setPaisDeResidencia(Nacionalidad paisDeResidencia) {
		this.paisDeResidencia = paisDeResidencia;
	}

	public Provincias getProvinciaDeResidencia() {
		return provinciaDeResidencia;
	}

	public void setProvinciaDeResidencia(Provincias provinciaDeResidencia) {
		this.provinciaDeResidencia = provinciaDeResidencia;
	}

	public String getCiudadResidencia() {
		return ciudadResidencia;
	}

	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	public String getExperienciaLaboral() {
		return experienciaLaboral;
	}

	public void setExperienciaLaboral(String experienciaLaboral) {
		this.experienciaLaboral = experienciaLaboral;
	}

	public NivelEducacion getEducacion() {
		return educacion;
	}

	public void setEducacion(NivelEducacion educacion) {
		this.educacion = educacion;
	}

	public String getLogrosObtenidos() {
		return logrosObtenidos;
	}

	public void setLogrosObtenidos(String logrosObtenidos) {
		this.logrosObtenidos = logrosObtenidos;
	}

	public String getEscuelaColegioSecundario() {
		return escuelaColegioSecundario;
	}

	public void setEscuelaColegioSecundario(String escuelaColegioSecundario) {
		this.escuelaColegioSecundario = escuelaColegioSecundario;
	}

	public LocalDate getFechaEgresadoSecundaria() {
		return fechaEgresadoSecundaria;
	}

	public void setFechaEgresadoSecundaria(LocalDate fechaEgresadoSecundaria) {
		this.fechaEgresadoSecundaria = fechaEgresadoSecundaria;
	}

	public String getEscualaUniversidadFacultad() {
		return escualaUniversidadFacultad;
	}

	public void setEscualaUniversidadFacultad(String escualaUniversidadFacultad) {
		this.escualaUniversidadFacultad = escualaUniversidadFacultad;
	}

	public LocalDate getFechaEgresadoUniversidad() {
		return fechaEgresadoUniversidad;
	}

	public void setFechaEgresadoUniversidad(LocalDate fechaEgresadoUniversidad) {
		this.fechaEgresadoUniversidad = fechaEgresadoUniversidad;
	}

	public String getTituloUniversitarioOSecundario() {
		return tituloUniversitarioOSecundario;
	}

	public void setTituloUniversitarioOSecundario(String tituloUniversitarioOSecundario) {
		this.tituloUniversitarioOSecundario = tituloUniversitarioOSecundario;
	}

	public String getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}

	public ConocimientoInformatico getConocimientosInformaticos() {
		return conocimientosInformaticos;
	}

	public void setConocimientosInformaticos(ConocimientoInformatico conocimientosInformaticos) {
		this.conocimientosInformaticos = conocimientosInformaticos;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
}