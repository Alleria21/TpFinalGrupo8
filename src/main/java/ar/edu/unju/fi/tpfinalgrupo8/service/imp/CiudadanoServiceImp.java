package ar.edu.unju.fi.tpfinalgrupo8.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinalgrupo8.entity.Ciudadano;
import ar.edu.unju.fi.tpfinalgrupo8.repository.CiudadanoRepository;
import ar.edu.unju.fi.tpfinalgrupo8.service.ICiudadanoService;

@Service
public class CiudadanoServiceImp implements ICiudadanoService{

	@Autowired
	private CiudadanoRepository ciudadanoRepository;
	
	//@Autowired
	//private OfertaLaboralRepository ofertaLaboralRepository;
	
	@Override
	public Ciudadano getCiudadano() {
		return new Ciudadano();
	}

	@Override
	public boolean guardarCiudadano(Ciudadano ciudadano) {
		
		Ciudadano ciu=ciudadanoRepository.findByDni(ciudadano.getDni());
		if(ciu==null) {
			ciudadano.setEstado(true);
			ciudadanoRepository.save(ciudadano);
		}
		return false;
	}

	@Override
	public void modificarCiudadano(Ciudadano ciudadano) {
		Ciudadano ciud=ciudadanoRepository.findByDni(ciudadano.getDni());
		ciud.setEmail(ciudadano.getEmail());
		ciud.setEstadoCivil(ciudadano.getEstadoCivil());
		ciud.setFechaNac(ciudadano.getFechaNac());
		//ciud.setOfertas(ciudadano.getOfertas());
		ciud.setPassword(ciudadano.getPassword());
		ciud.setProvincia(ciudadano.getProvincia());
		ciud.setTelefono(ciudadano.getTelefono());
		ciudadanoRepository.save(ciud);
		
	}

	@Override
	public void eliminarCiudadano(int dni) {
		Ciudadano ciudadano=buscarCiudadano(dni);
		ciudadano.setEstado(false);
		ciudadanoRepository.save(ciudadano);
		
	}

	@Override
	public List<Ciudadano> getListaCiudadano() {
		return ciudadanoRepository.findByEstado(true);
	}

	@Override
	public Ciudadano buscarCiudadano(int dni) {
		return ciudadanoRepository.findByDni(dni);
	}
	

}
