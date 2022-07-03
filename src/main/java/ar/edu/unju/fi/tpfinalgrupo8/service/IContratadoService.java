package ar.edu.unju.fi.tpfinalgrupo8.service;

import ar.edu.unju.fi.tpfinalgrupo8.entity.Ciudadano;
import ar.edu.unju.fi.tpfinalgrupo8.entity.Contratado;
import ar.edu.unju.fi.tpfinalgrupo8.entity.OfertaLaboral;

import java.util.List;

public interface IContratadoService {
    boolean save(Ciudadano ciudadano, long idOferta);
    void delete(long id);
    List<Contratado> findByOferta(OfertaLaboral ofertaLaboral);
    List<Contratado> findAllByOferta(List<OfertaLaboral> ofertas);



}
