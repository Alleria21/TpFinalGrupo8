package ar.edu.unju.fi.tpfinalgrupo8.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinalgrupo8.entity.OfertaLaboral;
import ar.edu.unju.fi.tpfinalgrupo8.repository.OfertaLaboralRepository;
import ar.edu.unju.fi.tpfinalgrupo8.service.IOfertaLaboralService;

@Service("OfertaLaboralServiceImpList")
public class OfertaLaboralServiceImp implements IOfertaLaboralService {
	
	@Autowired
	private OfertaLaboralRepository ofertaLaboralRepository;
	
	//@Autowired
	//private CiudadanoRepository ciudadanoRepository;
	
	@Override
	public OfertaLaboral getOfertaLaboral() {
		return new OfertaLaboral();
	}

	@Override
	public boolean guardarOfertaLaboral(OfertaLaboral ofertaLaboral) {
		OfertaLaboral oferta = ofertaLaboralRepository.findByCodigo(ofertaLaboral.getCodigo());
		if(oferta==null) {
			ofertaLaboral.setDisponible(true);
			ofertaLaboralRepository.save(ofertaLaboral);
			return true;
		}
		return false;
		/*
		if(ofertaLaboralRepository.save(ofertaLaboral) != null) {
			return true;
		}
		return false;
		*/
	}

	@Override
	public void modificarOfertaLaboral(OfertaLaboral ofertaLaboral) {
		OfertaLaboral oferta = ofertaLaboralRepository.findByCodigo(ofertaLaboral.getCodigo());
		ofertaLaboral.setId(oferta.getId());
		/*oferta.setCodigo(ofertaLaboral.getCodigo());
		oferta.setCantidadVacantes(ofertaLaboral.getCantidadVacantes());
		oferta.setPuestoReq(ofertaLaboral.getPuestoReq());
		oferta.setPuestoResum(ofertaLaboral.getPuestoReq());
		oferta.setDispHoraria(ofertaLaboral.getDispHoraria());
		oferta.setTareasPrincipales(ofertaLaboral.getTareasPrincipales());
		oferta.setEmail(ofertaLaboral.getEmail());
		oferta.setTelefono(ofertaLaboral.getTelefono());
		oferta.setJornada(ofertaLaboral.getJornada());
		oferta.setRequisitos(ofertaLaboral.getRequisitos());
		oferta.setSalario(ofertaLaboral.getSalario());
		oferta.setBeneficios(ofertaLaboral.getBeneficios());*/
		ofertaLaboralRepository.save(ofertaLaboral);
	}

	@Override
	public void eliminarOfertaLaboral(int codigo) {
		OfertaLaboral ofertaLaboral = buscarOfertaLaboral(codigo);
		ofertaLaboral.setDisponible(false);
		ofertaLaboralRepository.save(ofertaLaboral);
	}

	@Override
	public List<OfertaLaboral> getListaOfertaLaboral() {
		return ofertaLaboralRepository.findByDisponible(true);
	}

	@Override
	public OfertaLaboral buscarOfertaLaboral(int codigo) {
		return ofertaLaboralRepository.findByCodigo(codigo);
	}

	@Override
	public OfertaLaboral findById(long id) {
		return ofertaLaboralRepository.getById(id);
	}

}
