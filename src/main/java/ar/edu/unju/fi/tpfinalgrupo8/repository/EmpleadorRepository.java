package ar.edu.unju.fi.tpfinalgrupo8.repository;

import ar.edu.unju.fi.tpfinalgrupo8.entity.Empleador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadorRepository extends JpaRepository<Empleador,Long>{
    //TODO:descomentar cuando se complete entidad Ciudadano
    boolean existsByCuit(Long cuit);

}
