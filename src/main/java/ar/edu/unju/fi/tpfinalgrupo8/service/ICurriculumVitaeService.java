package ar.edu.unju.fi.tpfinalgrupo8.service;

import ar.edu.unju.fi.tpfinalgrupo8.entity.CurriculumVitae;
import java.util.List;

public interface ICurriculumVitaeService {
	public void guardar(CurriculumVitae curriculumvitae);
	public List<CurriculumVitae> listarTodos();
	public CurriculumVitae buscarPordni(Long dni);
	public void eliminar(Long dni);
	public void modificar(CurriculumVitae curriculumvitae);
	//public Ciudadano getCiudadano();
	//public List<Ciudadano> getListaCiudadano();
}
