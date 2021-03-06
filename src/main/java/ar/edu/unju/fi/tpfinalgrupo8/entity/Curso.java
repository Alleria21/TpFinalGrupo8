package ar.edu.unju.fi.tpfinalgrupo8.entity;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
import ar.edu.unju.fi.tpfinalgrupo8.util.Categoria;
import ar.edu.unju.fi.tpfinalgrupo8.util.Modalidad;

@Entity
@Table(name = "cursos")
public class Curso {
	
	//Atributos del Curso
	//con sus respectivas validaciones
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "curso_id")
	private long id;
	
	@Min(value = 1, message = "*El valor del código debe ser mayor o igual a 1")
	@Max(value = 9999, message = "*El valor del codigo debe ser menor o igual a 9999")
	@Column(name = "curso_codigo")
	private int codigo;
	
	@NotEmpty(message = "*Debe ingresar un título")
	@Column(name = "curso_titulo")
	private String titulo;
	
	@NotNull(message = "*Debe ingresar una categoría")
	@Column(name = "curso_categoria")
	@Enumerated(EnumType.STRING)
	private Categoria categoria;
	
	@NotNull(message = "*Debe ingresar una fecha") 
	@FutureOrPresent(message = "*La fecha debe ser igual o posterior a la actual")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "curso_fechaInicio")
	private LocalDate fechaInicio;
	
	@NotNull(message = "*Debe ingresar una fecha") 
	@Future(message = "*La fecha debe ser posterior a la actual")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "curso_fechaFin")
	private LocalDate fechaFin;
	
	@Min(value = 1, message = "*El valor de las horas debe ser mayor o igual a 1")
	@Column(name = "curso_horas")
	private int horas;
	
	@NotNull(message = "*Debe ingresar una modalidad")
	@Column(name = "curso_modalidad")
	@Enumerated(EnumType.STRING)
	private Modalidad modalidad;
	
	@Column(name = "curso_disponible")
	private boolean disponible;
	
	@ManyToOne()
	@JoinColumn(name = "empleador_id")
	//ENCARGADO DE CREAR LA TABLA DE RELACION
	private Empleador creador;
	
	@ManyToMany(mappedBy = "unCurso")
	private List<Ciudadano> inscripto;
	
	public Curso() {
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

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public Modalidad getModalidad() {
		return modalidad;
	}

	public void setModalidad(Modalidad modalidad) {
		this.modalidad = modalidad;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public Empleador getCreador() {
		return creador;
	}

	public void setCreador(Empleador creador) {
		this.creador = creador;
	}

	public List<Ciudadano> getInscripto() {
		return inscripto;
	}

	public void setInscripto(List<Ciudadano> inscripto) {
		this.inscripto = inscripto;
	}
	
}
