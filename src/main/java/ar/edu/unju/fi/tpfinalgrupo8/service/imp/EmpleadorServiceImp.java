package ar.edu.unju.fi.tpfinalgrupo8.service.imp;

import ar.edu.unju.fi.tpfinalgrupo8.entity.Empleador;
import ar.edu.unju.fi.tpfinalgrupo8.repository.EmpleadorRepository;
import ar.edu.unju.fi.tpfinalgrupo8.service.IEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpleadorServiceImp implements IEmpleadorService {

    @Autowired
    private EmpleadorRepository empleadorRepository;

    @Override
    public void guardar(Empleador empleador) {
        empleadorRepository.save(empleador);
    }

    @Override
    public List<Empleador> listarTodos() {
        return empleadorRepository.findAll();
    }

    @Override
    public Empleador buscarPorId(Long id) {
        return empleadorRepository.findById(id).get();
    }

    @Override
    public boolean existePorCuit(Long cuit) {
        return empleadorRepository.existsByCuit(cuit);
    }

    @Override
    public void eliminar(Long id) {
        Empleador empleador= empleadorRepository.findById(id).get();
        empleadorRepository.delete(empleador);
    }

    @Override
    public void modificar(Empleador empleador) {
        empleadorRepository.save(empleador);
    }
}
