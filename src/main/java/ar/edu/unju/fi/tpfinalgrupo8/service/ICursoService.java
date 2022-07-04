package ar.edu.unju.fi.tpfinalgrupo8.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinalgrupo8.entity.Curso;
import ar.edu.unju.fi.tpfinalgrupo8.util.Categoria;

public interface ICursoService {
	public Curso getCurso();
	public boolean guardarCurso(Curso curso);
	public void modificarCurso(Curso curso);
	public void eliminarCurso(int codigo);
	public List<Curso> getListaCurso();
	public Curso buscarCurso(int codigo);
	//public Ciudadano getCiudadano();
	//public List<Ciudadano> getListaCiudadano();
	boolean guardarInscripto(Curso curso);
	
	Optional<List<Curso>> findByCategoria(Categoria categoria);
}
