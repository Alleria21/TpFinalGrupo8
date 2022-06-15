package ar.edu.unju.fi.tpfinalgrupo8.entity;

import javax.persistence.*;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

@Entity
@Table(name = "curriculumvitae" )
public class CurriculumVitae {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@NotEmpty(message = "Este campo no debe ser vacio ni nulo")
	@Column(name = "cv_nombre")
	public String name;
	
	@NotEmpty(message = "Este campo no debe ser vacio ni nulo")
	@Column(name = "cv_apellido")
	public String apeliido;
	
	@Positive(message = "Este campo no puede ser un numero negativo")
	@Column(name = "cv_dni")
	public int dni;

	@Positive(message = "Este campo no puede ser un numero negativo")	
	@Column(name = "cv_contacto")
	public int telefono;

	@NotEmpty(message = "No debe ingresar un dato nulo")
	@Column(name = "cv_experiencia")
	public String experencia;
	
	@NotEmpty(message = "No debe ingresar un dato nulo")
	@Column(name = "cv_exp_laboral")
	public String exp_laboral;
	
	@NotEmpty(message = "No debe ingresar un dato nulo")
	@Column(name = "cv_educacion")
	public String educacion;	
	
	@NotEmpty(message = "No debe ingresar un dato nulo")
	@Column(name = "cv_idiomas")
	public String idiomas;		
	
	@NotEmpty(message = "No debe ingresar un dato nulo")
	@Column(name = "cv_conocimientoinf")
	public String conocimientoinf;	
	
	/*@OneToOne(mappedBy = "curriculumvitae")
	private List<Candidato>candidato;
	Private Candidato candidato;*/
	
	public CurriculumVitae() {
		
	}

	public CurriculumVitae(String name, String apeliido,int dni, int telefono,String experencia,String exp_laboral,String educacion, String idiomas, String conocimientoinf) {
		super();
		this.name = name;
		this.apeliido = apeliido;
		this.dni = dni;
		this.telefono = telefono;
		this.experencia = experencia;
		this.exp_laboral = exp_laboral;
		this.educacion = educacion;
		this.idiomas = idiomas;
		this.conocimientoinf = conocimientoinf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApeliido() {
		return apeliido;
	}

	public void setApeliido(String apeliido) {
		this.apeliido = apeliido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getExperencia() {
		return experencia;
	}

	public void setExperencia(String experencia) {
		this.experencia = experencia;
	}

	public String getExp_laboral() {
		return exp_laboral;
	}

	public void setExp_laboral(String exp_laboral) {
		this.exp_laboral = exp_laboral;
	}

	public String getEducacion() {
		return educacion;
	}

	public void setEducacion(String educacion) {
		this.educacion = educacion;
	}

	public String getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}

	public String getConocimientoinf() {
		return conocimientoinf;
	}

	public void setConocimientoinf(String conocimientoinf) {
		this.conocimientoinf = conocimientoinf;
	}
}

