package ar.edu.unju.fi.tpfinalgrupo8.service.imp;

import ar.edu.unju.fi.tpfinalgrupo8.entity.CurriculumVitae;
import ar.edu.unju.fi.tpfinalgrupo8.repository.CurriculumVitaeRepository;
import ar.edu.unju.fi.tpfinalgrupo8.service.ICurriculumVitaeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CurriculumVitaeServiceImp implements ICurriculumVitaeService{
	@Autowired
	private CurriculumVitaeRepository curriculumvitaeRepository;
	
	@Override
	public void guardar(CurriculumVitae curriculumvitae) {
		curriculumvitaeRepository.save(curriculumvitae);
	}
	
	@Override
	public List<CurriculumVitae> listarTodos(){
		return curriculumvitaeRepository.findAll();
	}
	
	@Override
	public CurriculumVitae buscarPordni(Long dni) {
		return curriculumvitaeRepository.findById(dni).get();	
	}
	
	@Override
	public void eliminar(Long dni) {
		CurriculumVitae curriculumvitae= curriculumvitaeRepository.findById(dni).get();
		curriculumvitaeRepository.delete(curriculumvitae);
	}
	
	@Override
	public void modificar(CurriculumVitae curriculumvitae) {
		curriculumvitaeRepository.save(curriculumvitae);
	}
}