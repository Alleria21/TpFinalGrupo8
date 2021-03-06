package ar.edu.unju.fi.tpfinalgrupo8.repository;

import java.util.List;
import java.util.Optional;
import ar.edu.unju.fi.tpfinalgrupo8.entity.OfertaLaboral;
import ar.edu.unju.fi.tpfinalgrupo8.util.Provincias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ar.edu.unju.fi.tpfinalgrupo8.entity.Ciudadano;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadanoRepository extends JpaRepository<Ciudadano, Long>{
	
	@Query("delete from Ciudadano d where d.dni = ?1")
	public void deleteByDni(long dni);
	
	public Optional<Ciudadano> findByDni(long dni);
	
	public List<Ciudadano> findByEstado(boolean estado);
	
	@Query("select c from Ciudadano c order by c.dni")
	public List<Ciudadano> ordenarPorDni();
	
	Optional<List<Ciudadano>> findByProvincia(Provincias provincia);
	
	List<Ciudadano> findByOfertas(OfertaLaboral ofertaLaboral);
}
