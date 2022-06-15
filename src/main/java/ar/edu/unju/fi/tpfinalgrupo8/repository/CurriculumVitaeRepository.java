package ar.edu.unju.fi.tpfinalgrupo8.repository;

import ar.edu.unju.fi.tpfinalgrupo8.entity.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurriculumVitaeRepository extends JpaRepository<CurriculumVitae,Long>{
	boolean existsByCuit (Long cuit);
}
