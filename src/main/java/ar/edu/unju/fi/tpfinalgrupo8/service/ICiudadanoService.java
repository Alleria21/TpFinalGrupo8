package ar.edu.unju.fi.tpfinalgrupo8.service;

import java.util.List;
import java.util.Optional;

import ar.edu.unju.fi.tpfinalgrupo8.entity.Ciudadano;
import ar.edu.unju.fi.tpfinalgrupo8.entity.OfertaLaboral;
import ar.edu.unju.fi.tpfinalgrupo8.util.Provincias;

public interface ICiudadanoService {

	public Ciudadano getCiudadano();
	public boolean guardarCiudadano(Ciudadano ciudadano);
	public void modificarCiudadano(Ciudadano ciudadano);
	public void eliminarCiudadano(long dni);
	public List<Ciudadano> getListaCiudadano();
	public Ciudadano buscarCiudadano(long dni);
	Optional<List<Ciudadano>> findByProvincia(Provincias provincia) ;
	List<Ciudadano> findByOferta(OfertaLaboral ofertaLaboral);
	Ciudadano findById(long id);
}
