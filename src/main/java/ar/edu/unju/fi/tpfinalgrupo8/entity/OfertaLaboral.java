package ar.edu.unju.fi.tpfinalgrupo8.entity;

import ar.edu.unju.fi.tpfinalgrupo8.util.DisponibilidadHoraria;
import ar.edu.unju.fi.tpfinalgrupo8.util.Jornada;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "ofertas_laborales")
public class OfertaLaboral {
	
	//Atributos de la Oferta Laboral
	//con sus respectivas validaciones
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oferta_id")
	private long id;
	
	@Min(value = 1, message = "*El valor del código debe ser mayor o igual a 1")
	@Max(value = 9999, message = "*El valor del codigo debe ser menor o igual a 9999")
	@Column(name = "cur_codigo")
	private int codigo; //DUDA
	
	@Min(value = 0, message = "*La cantidad de vacantes debe ser mayor o igual a 0")
	@Max(value = 150, message = "*La cantidad de vacantes debe ser menor o igual a 150")
	@Column(name = "oferta_vacantes")
	private int cantidadVacantes;
	
	@NotEmpty(message = "*Debe ingresar un puesto requerido")
	@Column(name = "oferta_puestoRequerido")
	private String puestoReq;
	
	@NotEmpty(message = "*Debe ingresar resumen del puesto")
	@Column(name = "oferta_puestoRresumen")
	private String puestoResum;

	@NotNull( message = "*Debe ingresar disponibilidad horaria")
	@Column(name = "oferta_dispHoraria")
	@Enumerated(EnumType.STRING)
	private DisponibilidadHoraria dispHoraria;
	
	@NotEmpty(message = "*Debe ingresar al menos una tarea principal")
	@Column(name = "oferta_tareasPrincipales")
	private String tareasPrincipales;
	
	@Email(message = "Debe ingresar un correo electronico válido")
	@NotNull(message = "El campo email no puede ser nulo")
	@Column(name = "oferta_email")
	private String email;
	
	@Positive(message = "Debe ingresar valores positivos")
	@NotNull(message = "El campo Telefono no puede ser nulo")
	@Column(name = "oferta_telefono")
	private int telefono;

	@NotNull(message = "*Debe ingresar una jornada laboral")
	@Column(name = "oferta_jornada")
	@Enumerated(EnumType.STRING)
	private Jornada jornada;
	
	@NotEmpty(message = "*Debe ingresar al menos un requisito necesario")
	@Column(name = "oferta_requisitos")
	private String requisitos;
	
	@NotNull(message = "*Debe ingresar un salario")
	@Min(value = 1, message = "*El salario debe ser mayor o igual a 1") //DUDA
	@Column(name = "oferta_salario")
	private int salario;
	
	@NotEmpty(message = "*Debe ingresar al menos un beneficio")
	@Column(name = "oferta_beneficios")
	private String beneficios;
	
	@Column(name = "oferta_disponible")
	private boolean disponible;

	@ManyToMany(mappedBy = "ofertas")
	private List<Ciudadano> ciudadanos;

	@ManyToOne
	@JoinColumn(name = "empleador_id")
	//ENCARGADO DE CREAR LA TABLA DE RELACION
	private Empleador empleador;

	@ManyToMany(mappedBy = "ofertasAceptadas")
	private List<Contratado> contratados;
	
	public OfertaLaboral() {
		// TODO Auto-generated constructor stub
	}

	//Metodos accesores
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getCantidadVacantes() {
		return cantidadVacantes;
	}

	public void setCantidadVacantes(int cantidadVacantes) {
		this.cantidadVacantes = cantidadVacantes;
	}

	public String getPuestoReq() {
		return puestoReq;
	}

	public void setPuestoReq(String puestoReq) {
		this.puestoReq = puestoReq;
	}

	public String getPuestoResum() {
		return puestoResum;
	}

	public void setPuestoResum(String puestoResum) {
		this.puestoResum = puestoResum;
	}

	public DisponibilidadHoraria getDispHoraria() {
		return dispHoraria;
	}

	public void setDispHoraria(DisponibilidadHoraria dispHoraria) {
		this.dispHoraria = dispHoraria;
	}

	public String getTareasPrincipales() {
		return tareasPrincipales;
	}

	public void setTareasPrincipales(String tareasPrincipales) {
		this.tareasPrincipales = tareasPrincipales;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Jornada getJornada() {
		return jornada;
	}

	public void setJornada(Jornada jornada) {
		this.jornada = jornada;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public int getSalario() {
		return salario;
	}

	public void setSalario(int salario) {
		this.salario = salario;
	}

	public String getBeneficios() {
		return beneficios;
	}

	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Empleador getEmpleador() {
		return empleador;
	}

	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}
	public List<Ciudadano> getCiudadanos() {
		return ciudadanos;
	}
	public void setCiudadanos(List<Ciudadano> ciudadanos) {
		this.ciudadanos = ciudadanos;
	}

	public List<Contratado> getContratados() {
		return contratados;
	}

	public void setContratados(List<Contratado> contratados) {
		this.contratados = contratados;
	}
}


