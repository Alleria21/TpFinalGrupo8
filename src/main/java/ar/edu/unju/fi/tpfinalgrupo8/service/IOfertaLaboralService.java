package ar.edu.unju.fi.tpfinalgrupo8.service;

import java.util.List;

import ar.edu.unju.fi.tpfinalgrupo8.entity.OfertaLaboral;

public interface IOfertaLaboralService {
	public OfertaLaboral getOfertaLaboral();
	public boolean guardarOfertaLaboral(OfertaLaboral ofertaLaboral);
	public void modificarOfertaLaboral(OfertaLaboral ofertaLaboral);
	public void eliminarOfertaLaboral(int codigo);
	public List<OfertaLaboral> getListaOfertaLaboral();
	public OfertaLaboral buscarOfertaLaboral(int codigo);
	//public Ciudadano getCiudadano();
	//public List<Ciudadano> getListaCiudadano();
	OfertaLaboral findById(long id);
}

