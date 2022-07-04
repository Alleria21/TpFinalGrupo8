package ar.edu.unju.fi.tpfinalgrupo8.service.imp;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinalgrupo8.entity.OfertaLaboral;
import ar.edu.unju.fi.tpfinalgrupo8.util.Provincias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinalgrupo8.entity.Ciudadano;
import ar.edu.unju.fi.tpfinalgrupo8.repository.CiudadanoRepository;
import ar.edu.unju.fi.tpfinalgrupo8.service.ICiudadanoService;

import static ar.edu.unju.fi.tpfinalgrupo8.security.MainSecurity.passwordEncoder;

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
		
		Optional<Ciudadano> ciu=ciudadanoRepository.findByDni(ciudadano.getDni());
		if(ciu.isEmpty()) {
			ciudadano.setEstado(true);
			ciudadano.setPassword(passwordEncoder().encode(ciudadano.getPassword()));
			ciudadanoRepository.save(ciudadano);
			return true;
		}
		return false;
	}

	@Override
	public void modificarCiudadano(Ciudadano ciudadano) {
		Ciudadano ciud=ciudadanoRepository.findByDni(ciudadano.getDni()).get();
		ciudadano.setId(ciud.getId());
		/*
		ciud.setEmail(ciudadano.getEmail());
		ciud.setEstadoCivil(ciudadano.getEstadoCivil());
		ciud.setFechaNac(ciudadano.getFechaNac());
		//ciud.setOfertas(ciudadano.getOfertas());
		ciud.setPassword(ciudadano.getPassword());
		ciud.setProvincia(ciudadano.getProvincia());
		ciud.setTelefono(ciudadano.getTelefono());*/
		ciudadanoRepository.save(ciudadano);
		
	}

	@Override
	public void eliminarCiudadano(long dni) {
		Ciudadano ciudadano=buscarCiudadano(dni);
		ciudadano.setEstado(false);
		ciudadanoRepository.save(ciudadano);
		
	}

	@Override
	public List<Ciudadano> getListaCiudadano() {
		return ciudadanoRepository.findByEstado(true);
	}

	@Override
	public Ciudadano buscarCiudadano(long dni) {
		return ciudadanoRepository.findByDni(dni).get();
	}

	
	
	@Override
	public Optional<List<Ciudadano>> findByProvincia(Provincias provincia) {
		return ciudadanoRepository.findByProvincia(provincia);
	}

	@Override
	public List<Ciudadano> findByOferta(OfertaLaboral ofertaLaboral) {
		return ciudadanoRepository.findByOfertas(ofertaLaboral);
	}

	@Override
	public Ciudadano findById(long id) {
		return ciudadanoRepository.findById(id).get();
	}


}
