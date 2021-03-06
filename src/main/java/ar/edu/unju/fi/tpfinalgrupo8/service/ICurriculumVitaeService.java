package ar.edu.unju.fi.tpfinalgrupo8.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinalgrupo8.entity.CurriculumVitae;

public interface ICurriculumVitaeService {
	
	public CurriculumVitae getCurriculumVitae();
	public boolean guardarCurriculumVitae(CurriculumVitae curriculumVitae);
	public void modificarCurriculumVitae(CurriculumVitae curriculumVitae);
	public void eliminarCurriculumVitae(long dni);
	public CurriculumVitae buscarCurriculumVitae(long dni);
	public List<CurriculumVitae> obtenerCurriculumVitae();
	Optional<List<CurriculumVitae>> findByExperiencia(String experiencia);
}