package ar.edu.unju.fi.tpfinalgrupo8.util;

import ar.edu.unju.fi.tpfinalgrupo8.entity.Ciudadano;
import ar.edu.unju.fi.tpfinalgrupo8.entity.Empleador;
import ar.edu.unju.fi.tpfinalgrupo8.repository.CiudadanoRepository;
import ar.edu.unju.fi.tpfinalgrupo8.repository.EmpleadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class UserSeeder implements CommandLineRunner {
    @Autowired
    private EmpleadorRepository empleadorRepository;
    @Autowired
    private CiudadanoRepository ciudadanoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {
        /*for (int i=1;i<=10;i++){
            ofertaLaboralRepository.save(generarOferta(i));

        }
        System.out.println("fin seeder");*/
        if(empleadorRepository.count()==0) {
            empleadorRepository.save(buildEmpleador("pedro", 123456789));
            empleadorRepository.save(buildEmpleador("pepe", 12341234));
        }
        if(ciudadanoRepository.count()==0) {
            ciudadanoRepository.save(buildCiudadano("delfin", 987654321));
            ciudadanoRepository.save(buildCiudadano("pedro", 87654321));
        }

        System.out.println("Fin seeder");

    }
    private Empleador buildEmpleador(String name, int cuit){
        Empleador empleador = new Empleador();
        empleador.setCuit(cuit);
        empleador.setPassword(passwordEncoder.encode(String.valueOf(cuit)));
        empleador.setEmail(name+"@email.com");
        empleador.setRazonSocial(name);
        empleador.setDescripcion("tienda de comestibles");
        empleador.setDomicilio("Los pinos 123");
        empleador.setInicioActividad(LocalDate.of(2000,12,12));
        empleador.setNombreComercial(name);
        empleador.setPaginaWeb(name+".com.ar");
        empleador.setProvincia(Provincias.JUJUY);
        empleador.setTelefono(cuit);
        return empleador;
    }
    private Ciudadano buildCiudadano(String name, int dni){
        Ciudadano ciudadano = new Ciudadano();
        ciudadano.setDni(dni);
        ciudadano.setPassword(passwordEncoder.encode(String.valueOf(dni)));
        ciudadano.setEmail(name+"@email.com");
        ciudadano.setEstado(false);
        ciudadano.setEstadoCivil(EstadoCivil.SOLTERO);
        ciudadano.setProvincia(Provincias.SALTA);
        ciudadano.setFechaNac(LocalDate.of(1980,1,10));
        ciudadano.setTelefono(123123123);
        return ciudadano;
    }

}
