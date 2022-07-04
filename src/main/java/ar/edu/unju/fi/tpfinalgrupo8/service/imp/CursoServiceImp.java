package ar.edu.unju.fi.tpfinalgrupo8.service.imp;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.tpfinalgrupo8.entity.Curso;
import ar.edu.unju.fi.tpfinalgrupo8.repository.CursoRepository;
import ar.edu.unju.fi.tpfinalgrupo8.service.ICursoService;
import ar.edu.unju.fi.tpfinalgrupo8.util.Categoria;

//Servicio de implementacion del Curso
@Service("CursoServiceImpList")
public class CursoServiceImp implements ICursoService {
	
	//Inyeccion del cursoRepository
	@Autowired
	private CursoRepository cursoRepository;
	
	//Metodo para crear un nuevo objeto Curso
	@Override
	public Curso getCurso() {
		return new Curso();
	}

	//Metodo para guardar un Curso
	@Override
	public boolean guardarCurso(Curso curso) {
		Curso curs = cursoRepository.findByCodigo(curso.getCodigo());
		if(curs==null) {
			curso.setDisponible(true);
			cursoRepository.save(curso);
			return true;
		}
		return false;
	}

	//Metodo para modificar un Curso mediante su Codigo
	@Override
	public void modificarCurso(Curso curso) {
		Curso curs = cursoRepository.findByCodigo(curso.getCodigo());
		curso.setId(curs.getId());
		cursoRepository.save(curso);
	}

	//Metodo para guardar el Ciudadano que quiere inscribirse
	//a un Curso especifico (Utiliza el codigo del curso)
	@Override
	public boolean guardarInscripto(Curso curso) {
		Curso curs = cursoRepository.findByCodigo(curso.getCodigo());
		curso.setId(curs.getId());
		cursoRepository.save(curso);
		return true;
	}
	
	//Metodo para eliminar un Curso mediante su codigo
	@Override
	public void eliminarCurso(int codigo) {
		Curso curso = buscarCurso(codigo);
		curso.setDisponible(false);
		cursoRepository.save(curso);
	}

	//Metodo para obtener la lista de Cursos disponibles
	@Override
	public List<Curso> getListaCurso() {
		return cursoRepository.findByDisponible(true);
	}

	//Metodo para buscar un curso especifico mediante su codigo
	@Override
	public Curso buscarCurso(int codigo) {
		return cursoRepository.findByCodigo(codigo);
	}

	//Metodo para obtener la busqueda de Cursos por su categoria
	@Override
	public Optional<List<Curso>> findByCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return cursoRepository.findByCategoria(categoria);
	}

}
