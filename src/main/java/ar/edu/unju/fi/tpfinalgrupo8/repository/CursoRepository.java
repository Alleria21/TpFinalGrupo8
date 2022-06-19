package ar.edu.unju.fi.tpfinalgrupo8.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ar.edu.unju.fi.tpfinalgrupo8.entity.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	//@Modifying
	@Query("delete from Curso c where c.codigo = ?1")
	public void deleteByCodigo(int codigo);
	
	public Curso findByCodigo(int codigo);
	
	public List<Curso> findByDisponible(boolean disponible);
	
	@Query("select c from Curso c order by c.codigo")
	public List<Curso> ordenarPorCodigo();
}
