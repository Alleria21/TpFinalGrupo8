package ar.edu.unju.fi.tpfinalgrupo8.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.fi.tpfinalgrupo8.entity.Ciudadano;

public interface CiudadanoRepository extends JpaRepository<Ciudadano, Long>{

	@Query("delete from Ciudadano d where d.dni = ?1")
	public void deleteByDni(int dni);
	
	public Ciudadano findByDni(int dni);
	public List<Ciudadano> findByEstado(boolean estado);
	
	@Query("select c from Ciudadano c order by c.dni")
	public List<Ciudadano> ordenarPorDni();
	
}
