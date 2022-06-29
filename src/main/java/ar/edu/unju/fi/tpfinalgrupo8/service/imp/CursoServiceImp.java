package ar.edu.unju.fi.tpfinalgrupo8.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.tpfinalgrupo8.entity.Curso;
import ar.edu.unju.fi.tpfinalgrupo8.repository.CursoRepository;
import ar.edu.unju.fi.tpfinalgrupo8.service.ICursoService;

@Service("CursoServiceImpList")
public class CursoServiceImp implements ICursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public Curso getCurso() {
		return new Curso();
	}

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

	@Override
	public void modificarCurso(Curso curso) {
		Curso curs = cursoRepository.findByCodigo(curso.getCodigo());
		curso.setId(curs.getId());
		cursoRepository.save(curso);
	}

	@Override
	public boolean guardarInscripto(Curso curso) {
		Curso curs = cursoRepository.findByCodigo(curso.getCodigo());
		curso.setId(curs.getId());
		cursoRepository.save(curso);
		return true;
	}
	
	@Override
	public void eliminarCurso(int codigo) {
		Curso curso = buscarCurso(codigo);
		curso.setDisponible(false);
		cursoRepository.save(curso);
	}

	@Override
	public List<Curso> getListaCurso() {
		return cursoRepository.findByDisponible(true);
	}

	@Override
	public Curso buscarCurso(int codigo) {
		return cursoRepository.findByCodigo(codigo);
	}

}
