package ar.edu.unju.fi.tpfinalgrupo8.service.imp;

import java.util.List;
import java.util.Optional;
import ar.edu.unju.fi.tpfinalgrupo8.entity.OfertaLaboral;
import ar.edu.unju.fi.tpfinalgrupo8.util.Provincias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.edu.unju.fi.tpfinalgrupo8.entity.Ciudadano;
import ar.edu.unju.fi.tpfinalgrupo8.repository.CiudadanoRepository;
import ar.edu.unju.fi.tpfinalgrupo8.service.ICiudadanoService;
import static ar.edu.unju.fi.tpfinalgrupo8.security.MainSecurity.passwordEncoder;

//Servicio de implementacion del Ciudadano
@Service
public class CiudadanoServiceImp implements ICiudadanoService{

	//Inyeccion del ciudadanoRepository
	@Autowired
	private CiudadanoRepository ciudadanoRepository;
	
	//Metodo para crear un nuevo objeto Ciudadano
	@Override
	public Ciudadano getCiudadano() {
		return new Ciudadano();
	}
	
	//Metodo para guardar un Ciudadano
	//utiliza funciones de SpringSecurity
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

	//Metodo para modificar un ciudadano mediante su DNI
	@Override
	public void modificarCiudadano(Ciudadano ciudadano) {
		Ciudadano ciud=ciudadanoRepository.findByDni(ciudadano.getDni()).get();
		ciudadano.setId(ciud.getId());
		ciudadanoRepository.save(ciudadano);
	}

	//Metodo para eliminar un ciudadano mediante su DNI
	@Override
	public void eliminarCiudadano(long dni) {
		Ciudadano ciudadano=buscarCiudadano(dni);
		ciudadano.setEstado(false);
		ciudadanoRepository.save(ciudadano);
		
	}

	//Metodo para obtener la lista de Ciudadanos
	//que no han sido borrados de manera logica
	@Override
	public List<Ciudadano> getListaCiudadano() {
		return ciudadanoRepository.findByEstado(true);
	}

	//Metodo para buscar un Ciudadano mediante su DNI
	@Override
	public Ciudadano buscarCiudadano(long dni) {
		return ciudadanoRepository.findByDni(dni).get();
	}
	
	//Metodo para encontrar un Ciudadano mediante su Provincia
	@Override
	public Optional<List<Ciudadano>> findByProvincia(Provincias provincia) {
		return ciudadanoRepository.findByProvincia(provincia);
	}
	
	//Metodo para encontrar una Oferta Laboral de un Ciudadano especifico
	@Override
	public List<Ciudadano> findByOferta(OfertaLaboral ofertaLaboral) {
		return ciudadanoRepository.findByOfertas(ofertaLaboral);
	}

	//Metodo para encontrar un Ciudadani por su ID en la Base de Datos
	@Override
	public Ciudadano findById(long id) {
		return ciudadanoRepository.findById(id).get();
	}

}
