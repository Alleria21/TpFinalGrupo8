/*package ar.edu.unju.fi.tpfinalgrupo8.util;

import ar.edu.unju.fi.tpfinalgrupo8.entity.OfertaLaboral;
import ar.edu.unju.fi.tpfinalgrupo8.repository.OfertaLaboralRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class OfertasSeeder implements CommandLineRunner {
    @Autowired
    private OfertaLaboralRepository ofertaLaboralRepository;
    @Override
    public void run(String... args) throws Exception {
        for (int i=1;i<=10;i++){
            ofertaLaboralRepository.save(generarOferta(i));

        }
        System.out.println("fin seeder");
    }

    private OfertaLaboral generarOferta(int contador){
      OfertaLaboral ofertaLaboral = new OfertaLaboral();
      ofertaLaboral.setDisponible(true);
      ofertaLaboral.setCantidad_vacantes(10);
      ofertaLaboral.setPuesto_req("puesto" + contador);
      ofertaLaboral.setDisp_horaria("fulltime");
      ofertaLaboral.setSalario(1000);
      ofertaLaboral.setBeneficios("Seguro oftalmologico");
      ofertaLaboral.setTareas_principales("verificacion de datos");
      ofertaLaboral.setEmail("email@email.com");
      ofertaLaboral.setTelefono(123456789);
      ofertaLaboral.setJornada("noche");
      ofertaLaboral.setRequisitos("terciario o universitario completo");
      ofertaLaboral.setCodigo(1);
      ofertaLaboral.setPuesto_resum("contabilizar");

        return ofertaLaboral;
    };
}
*/