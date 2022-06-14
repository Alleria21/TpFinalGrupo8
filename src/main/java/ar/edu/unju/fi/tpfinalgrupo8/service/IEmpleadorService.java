package ar.edu.unju.fi.tpfinalgrupo8.service;

import ar.edu.unju.fi.tpfinalgrupo8.entity.Empleador;

import java.util.List;

public interface IEmpleadorService {
    void guardar(Empleador empleador);
    List<Empleador> listarTodos();
    Empleador buscarPorId(Long id);
    boolean existePorCuit(Long cuit);
    void eliminar(Long id);
    void modificar(Empleador empleador);

}
