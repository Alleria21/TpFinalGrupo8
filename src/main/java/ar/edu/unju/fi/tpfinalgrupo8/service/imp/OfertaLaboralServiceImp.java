package ar.edu.unju.fi.tpfinalgrupo8.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinalgrupo8.entity.OfertaLaboral;
import ar.edu.unju.fi.tpfinalgrupo8.repository.OfertaLaboralRepository;
import ar.edu.unju.fi.tpfinalgrupo8.service.IOfertaLaboralService;

//Servicio de implementacion de una Oferta Laboral
@Service("OfertaLaboralServiceImpList")
public class OfertaLaboralServiceImp implements IOfertaLaboralService {
	
	//Inyeccion de OfertaLaboralRepository
	@Autowired
	private OfertaLaboralRepository ofertaLaboralRepository;
	
	//Metodo para crear un nuevo objeto OfertaLaboral
	@Override
	public OfertaLaboral getOfertaLaboral() {
		return new OfertaLaboral();
	}
	
	//Metodo para guardar una OfertaLaboral mediante su codigo
	@Override
	public boolean guardarOfertaLaboral(OfertaLaboral ofertaLaboral) {
		OfertaLaboral oferta = ofertaLaboralRepository.findByCodigo(ofertaLaboral.getCodigo());
		if(oferta==null) {
			ofertaLaboral.setDisponible(true);
			ofertaLaboralRepository.save(ofertaLaboral);
			return true;
		}
		return false;
	}

	//Metodo para modificar una OfertaLaboral mediante su ID en la BD
	@Override
	public void modificarOfertaLaboral(OfertaLaboral ofertaLaboral) {
		OfertaLaboral oferta = ofertaLaboralRepository.findByCodigo(ofertaLaboral.getCodigo());
		ofertaLaboral.setId(oferta.getId());
		ofertaLaboralRepository.save(ofertaLaboral);
	}

	//Metodo para eliminar una OfertaLaboral mediante su codigo
	@Override
	public void eliminarOfertaLaboral(int codigo) {
		OfertaLaboral ofertaLaboral = buscarOfertaLaboral(codigo);
		ofertaLaboral.setDisponible(false);
		ofertaLaboralRepository.save(ofertaLaboral);
	}
	
	//Metodo para obtener la lista de Ofertas disponibles
	@Override
	public List<OfertaLaboral> getListaOfertaLaboral() {
		return ofertaLaboralRepository.findByDisponible(true);
	}
	
	//Metodo para buscar una OfertaLaboral mediante su codigo
	@Override
	public OfertaLaboral buscarOfertaLaboral(int codigo) {
		return ofertaLaboralRepository.findByCodigo(codigo);
	}

	//Metodo para encontrar una OfertaLaboral por su ID en la BD
	@Override
	public OfertaLaboral findById(long id) {
		return ofertaLaboralRepository.findById(id).get();
	}

}
