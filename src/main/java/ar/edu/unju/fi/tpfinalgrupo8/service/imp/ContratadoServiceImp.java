package ar.edu.unju.fi.tpfinalgrupo8.service.imp;

import ar.edu.unju.fi.tpfinalgrupo8.entity.Ciudadano;
import ar.edu.unju.fi.tpfinalgrupo8.entity.Contratado;
import ar.edu.unju.fi.tpfinalgrupo8.entity.OfertaLaboral;
import ar.edu.unju.fi.tpfinalgrupo8.repository.ContratadoRepository;
import ar.edu.unju.fi.tpfinalgrupo8.repository.OfertaLaboralRepository;
import ar.edu.unju.fi.tpfinalgrupo8.service.IContratadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ContratadoServiceImp implements IContratadoService {
    @Autowired
    private ContratadoRepository contratadoRepository;
    @Autowired
    private OfertaLaboralRepository ofertaLaboralRepository;

    @Override
    public boolean save(Ciudadano ciudadano, long idOferta) {
        List<Contratado> contratados = contratadoRepository.findByOfertasAceptadas(ofertaLaboralRepository.findById(idOferta).get()).get();
        if(isContratado(contratados, ciudadano.getDni())){
            return false;
        }
        Contratado contratado = this.buildContratado(ciudadano,idOferta);
        contratadoRepository.save(contratado);
        return true;
    }
    @Override
    public void delete(long id){
        Optional<Contratado> contratado = contratadoRepository.findById(id);
        if (contratado.isPresent()) {
            contratadoRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Contratado not found.");
        }
    }
    @Override
    public List<Contratado> findByOferta(OfertaLaboral ofertaLaboral){
        return contratadoRepository.findByOfertasAceptadas(ofertaLaboral).get();
    }

    @Override
    public List<Contratado> findAllByOferta(List<OfertaLaboral> ofertas) {
        List<Contratado> contratados=new ArrayList<>();
        for(OfertaLaboral oferta: ofertas) {
            contratados.addAll(this.findByOferta(oferta));
        }
        return contratados;
    }

    private Contratado buildContratado(Ciudadano ciudadano, long idOferta){
        Contratado contratado = new Contratado();
        contratado.setDni(ciudadano.getDni());
        contratado.setEmail(ciudadano.getEmail());
        contratado.setEstadoCivil(ciudadano.getEstadoCivil());
        contratado.setProvincia(ciudadano.getProvincia());
        contratado.setFechaNac(ciudadano.getFechaNac());
        OfertaLaboral ofertaLaboral = new OfertaLaboral();
        ofertaLaboral.setId(idOferta);
        contratado.getOfertasAceptadas().add(ofertaLaboral);
        return contratado;
    }
    private boolean isContratado(List<Contratado> contratados, long dni){
        if(contratados.stream().filter(contratado -> contratado.getDni()==dni).findFirst().orElse(null)!=null){
            return true;
        }
        return false;
    }
}
