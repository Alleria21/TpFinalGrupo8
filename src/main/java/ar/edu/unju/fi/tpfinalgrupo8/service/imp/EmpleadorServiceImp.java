package ar.edu.unju.fi.tpfinalgrupo8.service.imp;

import ar.edu.unju.fi.tpfinalgrupo8.entity.Empleador;
import ar.edu.unju.fi.tpfinalgrupo8.repository.EmpleadorRepository;
import ar.edu.unju.fi.tpfinalgrupo8.service.IEmpleadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpleadorServiceImp implements IEmpleadorService {

    @Autowired
    private EmpleadorRepository empleadorRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public boolean guardar(Empleador empleador) {
        if(!empleadorRepository.existsByCuit(empleador.getCuit())) {
            empleador.setPassword(passwordEncoder.encode(empleador.getPassword()));//codifica password
            empleadorRepository.save(empleador);
            return true;
        }
        return false;
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
        empleador.setPassword(passwordEncoder.encode(empleador.getPassword()));//codifica password
        empleadorRepository.save(empleador);
    }

    @Override
    public Empleador buscarPorCuit(Long cuit) {
        return empleadorRepository.findByCuit(cuit).get();
    }

}
