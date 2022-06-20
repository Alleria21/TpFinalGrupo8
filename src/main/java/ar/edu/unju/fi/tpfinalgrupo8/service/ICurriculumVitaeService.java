package ar.edu.unju.fi.tpfinalgrupo8.service;

import java.util.List;

import ar.edu.unju.fi.tpfinalgrupo8.entity.CurriculumVitae;

public interface ICurriculumVitaeService {
	
	//agregados a funcionar
	
	public CurriculumVitae getCurriculumVitae();
	
	public boolean guardarCurriculumVitae(CurriculumVitae curriculumVitae);
	public void modificarCurriculumVitae(CurriculumVitae curriculumVitae);
	public void eliminarCurriculumVitae(long dni);
	public CurriculumVitae buscarCurriculumVitae(long dni);
	public List<CurriculumVitae> obtenerCurriculumVitae();
}