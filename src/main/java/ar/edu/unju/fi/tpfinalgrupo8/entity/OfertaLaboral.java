package ar.edu.unju.fi.tpfinalgrupo8.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "ofertas laborales")
public class OfertaLaboral {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oferta_id")
	private long id;
	
	@Min(value = 1, message = "*El valor del código debe ser mayor o igual a 1")
	@Max(value = 9999, message = "*El valor del codigo debe ser menor o igual a 9999")
	@Column(name = "cur_codigo")
	private int codigo; //DUDA
	
	@Min(value = 1, message = "*La cantidad de vacantes debe ser mayor o igual a 1")
	@Max(value = 150, message = "*La cantidad de vacantes debe ser menor o igual a 150")
	@Column(name = "oferta_vacantes")
	private int cantidad_vacantes;
	
	@NotEmpty(message = "*Debe ingresar un puesto requerido")
	@Column(name = "oferta_puestoRequerido")
	private String puesto_req;
	
	@NotEmpty(message = "*Debe ingresar resumen del puesto")
	@Column(name = "oferta_puestoRresumen")
	private String puesto_resum;
	
	@NotEmpty(message = "*Debe ingresar una disponibilidad horaria")
	@Column(name = "oferta_dispHoraria")
	private String disp_horaria;
	
	@NotEmpty(message = "*Debe ingresar al menos una tarea principal")
	@Column(name = "oferta_tareasPrincipales")
	private String tareas_principales;
	
	@Email(message = "Debe ingresar un correo electronico válido")
	@NotNull(message = "El campo email no puede ser nulo")
	@Column(name = "oferta_email")
	private String email;
	
	@Positive(message = "Debe ingresar valores positivos")
	@NotNull(message = "El campo Telefono no puede ser nulo")
	@Column(name = "oferta_telefono")
	private int telefono;
	
	@NotEmpty(message = "*Debe ingresar una jornada laboral")
	@Column(name = "oferta_jornada")
	private String jornada;
	
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
	
	/*
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(	name = "oferta_ciudadano",
				joinColumns = @JoinColumn(name = "oferta_id"),
				inverseJoinColumns = @JoinColumn(name = "ciudadano_id")
			) //ENCARGADO DE CREAR LA TABLA DE RELACION
	private List<Ciudadano> ciudadanos = new ArrayList<Ciudadano>();
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(	name = "oferta_empleador",
				joinColumns = @JoinColumn(name = "oferta_id"),
				inverseJoinColumns = @JoinColumn(name = "empleador_id")
			) //ENCARGADO DE CREAR LA TABLA DE RELACION
	private List<Empleador> empleadores = new ArrayList<Empleador>();
	*/
	
	public OfertaLaboral() {
		// TODO Auto-generated constructor stub
	}

	public OfertaLaboral(int codigo, int cantidad_vacantes, String puesto_req, String puesto_resum, String disp_horaria,
			String tareas_principales, int telefono, String email, String jornada, String requisitos, int salario,
			String beneficios, boolean disponible) {
		super();
		this.codigo = codigo;
		this.cantidad_vacantes = cantidad_vacantes;
		this.puesto_req = puesto_req;
		this.puesto_resum = puesto_resum;
		this.disp_horaria = disp_horaria;
		this.tareas_principales = tareas_principales;
		this.telefono = telefono;
		this.email = email;
		this.jornada = jornada;
		this.requisitos = requisitos;
		this.salario = salario;
		this.beneficios = beneficios;
		this.disponible = disponible;
	}

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

	public int getCantidad_vacantes() {
		return cantidad_vacantes;
	}

	public void setCantidad_vacantes(int cantidad_vacantes) {
		this.cantidad_vacantes = cantidad_vacantes;
	}

	public String getPuesto_req() {
		return puesto_req;
	}

	public void setPuesto_req(String puesto_req) {
		this.puesto_req = puesto_req;
	}

	public String getPuesto_resum() {
		return puesto_resum;
	}

	public void setPuesto_resum(String puesto_resum) {
		this.puesto_resum = puesto_resum;
	}

	public String getDisp_horaria() {
		return disp_horaria;
	}

	public void setDisp_horaria(String disp_horaria) {
		this.disp_horaria = disp_horaria;
	}

	public String getTareas_principales() {
		return tareas_principales;
	}

	public void setTareas_principales(String tareas_principales) {
		this.tareas_principales = tareas_principales;
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

	public String getJornada() {
		return jornada;
	}

	public void setJornada(String jornada) {
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
	
}


