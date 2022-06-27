package ar.edu.unju.fi.tpfinalgrupo8.service;

import ar.edu.unju.fi.tpfinalgrupo8.entity.Ciudadano;
import ar.edu.unju.fi.tpfinalgrupo8.entity.Empleador;

import java.util.List;
import java.util.Optional;

public interface IEmpleadorService {
    boolean guardar(Empleador empleador);
    List<Empleador> listarTodos();
    Empleador buscarPorId(Long id);
    boolean existePorCuit(Long cuit);
    void eliminar(Long id);
    void modificar(Empleador empleador);
    Empleador buscarPorCuit(Long cuit);

}
