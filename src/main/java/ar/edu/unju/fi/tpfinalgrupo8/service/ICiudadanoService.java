package ar.edu.unju.fi.tpfinalgrupo8.service;

import java.util.List;

import ar.edu.unju.fi.tpfinalgrupo8.entity.Ciudadano;

public interface ICiudadanoService {

	public Ciudadano getCiudadano();
	public boolean guardarCiudadano(Ciudadano ciudadano);
	public void modificarCiudadano(Ciudadano ciudadano);
	public void eliminarCiudadano(int dni);
	public List<Ciudadano> getListaCiudadano();
	public Ciudadano buscarCiudadano(int dni);
}
