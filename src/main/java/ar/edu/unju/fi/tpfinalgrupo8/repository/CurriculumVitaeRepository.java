package ar.edu.unju.fi.tpfinalgrupo8.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.tpfinalgrupo8.entity.CurriculumVitae;

public interface CurriculumVitaeRepository extends JpaRepository<CurriculumVitae, Long> {
	
	@Query("from CurriculumVitae e order by e.apellido")
	public List<CurriculumVitae> obtenerCurriculumVitae();

	public CurriculumVitae findByDni(long dni);
	
	public List<CurriculumVitae> findByEstado(boolean estado);
	
	@Query("delete from CurriculumVitae f where f.dni = ?1")
	public void deleteByDni(long dni);
	
	Optional<List<CurriculumVitae>> findByExperienciaLaboral(String experiencia);

}