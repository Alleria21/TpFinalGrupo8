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
		ofertaLaboral.setDisponible(true);
		if(ofertaLaboralRepository.save(ofertaLaboral) != null) {
			return true;
		}
		return false;
	}

	@Override
	public void modificarOfertaLaboral(OfertaLaboral ofertaLaboral) {
		OfertaLaboral oferta = ofertaLaboralRepository.findByCodigo(ofertaLaboral.getCodigo());
		oferta.setCodigo(ofertaLaboral.getCodigo());
		oferta.setCantidad_vacantes(ofertaLaboral.getCantidad_vacantes());
		oferta.setPuesto_req(ofertaLaboral.getPuesto_req());
		oferta.setPuesto_resum(ofertaLaboral.getPuesto_req());
		oferta.setDisp_horaria(ofertaLaboral.getDisp_horaria());
		oferta.setTareas_principales(ofertaLaboral.getTareas_principales());
		oferta.setEmail(ofertaLaboral.getEmail());
		oferta.setTelefono(ofertaLaboral.getTelefono());
		oferta.setJornada(ofertaLaboral.getJornada());
		oferta.setRequisitos(ofertaLaboral.getRequisitos());
		oferta.setSalario(ofertaLaboral.getSalario());
		oferta.setBeneficios(ofertaLaboral.getBeneficios());
		
		ofertaLaboralRepository.save(oferta);
	}

	@Override
	public void eliminarOfertaLaboral(int codigo) {
		OfertaLaboral ofertaLaboral = buscarOfertaLaboral(codigo);
		ofertaLaboral.setDisponible(false);
		ofertaLaboralRepository.save(ofertaLaboral);
	}

	@Override
	public List<OfertaLaboral> getListaOfertaLaboral() {
		return ofertaLaboralRepository.ordenarPorCodigo();
	}

	@Override
	public OfertaLaboral buscarOfertaLaboral(int codigo) {
		return ofertaLaboralRepository.findByCodigo(codigo);
	}

}
