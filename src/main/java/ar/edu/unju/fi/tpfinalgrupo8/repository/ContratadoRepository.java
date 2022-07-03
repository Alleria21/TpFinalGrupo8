package ar.edu.unju.fi.tpfinalgrupo8.repository;

import ar.edu.unju.fi.tpfinalgrupo8.entity.Contratado;
import ar.edu.unju.fi.tpfinalgrupo8.entity.OfertaLaboral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContratadoRepository extends JpaRepository<Contratado, Long> {
    Optional<List<Contratado>> findByOfertasAceptadas(OfertaLaboral ofertaLaboral);
}
