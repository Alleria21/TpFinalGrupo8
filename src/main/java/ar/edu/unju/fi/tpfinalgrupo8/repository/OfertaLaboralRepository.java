package ar.edu.unju.fi.tpfinalgrupo8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ar.edu.unju.fi.tpfinalgrupo8.entity.OfertaLaboral;

public interface OfertaLaboralRepository extends JpaRepository<OfertaLaboral, Long> {
	//@Modifying
	@Query("delete from OfertaLaboral c where c.codigo = ?1")
	public void deleteByCodigo(int codigo);
	
	public OfertaLaboral findByCodigo(int codigo);
	public List<OfertaLaboral> findByDisponible(boolean disponible);
	
	@Query("select c from OfertaLaboral c order by c.codigo")
	public List<OfertaLaboral> ordenarPorCodigo();

}
