package ar.edu.unju.fi.tpfinalgrupo8.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.tpfinalgrupo8.entity.CurriculumVitae;
import ar.edu.unju.fi.tpfinalgrupo8.repository.CurriculumVitaeRepository;
import ar.edu.unju.fi.tpfinalgrupo8.service.ICurriculumVitaeService;

@Service
public class CurriculumVitaeServiceImp implements ICurriculumVitaeService {

	@Autowired
	private CurriculumVitaeRepository curriculumVitaeImp;
	
	@Override
	public CurriculumVitae getCurriculumVitae() {
		return new CurriculumVitae();
	}
	
	@Override
	public boolean guardarCurriculumVitae(CurriculumVitae curriculumVitae) {
		
		CurriculumVitae cv=curriculumVitaeImp.findByDni(curriculumVitae.getDni());
		if(cv==null) {
			curriculumVitae.setEstado(true);
			curriculumVitaeImp.save(curriculumVitae);
		}
		return false;
	}
	@Override
	public void modificarCurriculumVitae(CurriculumVitae curriculumVitae) {
		CurriculumVitae cv = curriculumVitaeImp.findByDni(curriculumVitae.getDni());
		cv.setNombre(curriculumVitae.getNombre());
		cv.setApellido(curriculumVitae.getApellido());
		cv.setCantidadDeHijos(curriculumVitae.getCantidadDeHijos());
		cv.setCiudad(curriculumVitae.getCiudad());
		cv.setCiudadano(curriculumVitae.getCiudadano());
		cv.setCiudadResidencia(curriculumVitae.getCiudadResidencia());
		cv.setConocimientosInformaticos(curriculumVitae.getConocimientosInformaticos());
		cv.setDomicilio(curriculumVitae.getDomicilio());
		cv.setEducacion(curriculumVitae.getEducacion());
		cv.setEmail(curriculumVitae.getEmail());	
		cv.setEscualaUniversidadFacultad(curriculumVitae.getEscualaUniversidadFacultad());
		cv.setEscuelaColegioSecundario(curriculumVitae.getEscuelaColegioSecundario());
		cv.setEstadoCivil(curriculumVitae.getEstadoCivil());
		cv.setEstadoVidaPadres(curriculumVitae.getEstadoVidaPadres());
		cv.setExperienciaLaboral(curriculumVitae.getExperienciaLaboral());
		cv.setFechaEgresadoSecundaria(curriculumVitae.getFechaEgresadoSecundaria());
		cv.setFechaEgresadoUniversidad(curriculumVitae.getFechaEgresadoUniversidad());
		cv.setFechaNacimiento(curriculumVitae.getFechaNacimiento());
		cv.setIdiomas(curriculumVitae.getIdiomas());
		cv.setLogrosObtenidos(curriculumVitae.getLogrosObtenidos());
		cv.setNacionalidad(curriculumVitae.getNacionalidad());
		cv.setPaisDeResidencia(curriculumVitae.getPaisDeResidencia());
		cv.setProvinciaDeResidencia(curriculumVitae.getProvinciaDeResidencia());
		cv.setProvincias(curriculumVitae.getProvincias());
		cv.setTelefono(curriculumVitae.getTelefono());
		cv.setTituloUniversitarioOSecundario(curriculumVitae.getTituloUniversitarioOSecundario());
		curriculumVitaeImp.save(cv);
	}

	@Override
	public void eliminarCurriculumVitae(long dni) {
		CurriculumVitae cuv = buscarCurriculumVitae(dni);
		cuv.setEstado(false);
		curriculumVitaeImp.delete(cuv); // en comoparacion con el imp ciudadano posee save yo delete
	}

	@Override
	public List<CurriculumVitae> obtenerCurriculumVitae() {
		return curriculumVitaeImp.findByEstado(true); // controlar con Ciudadano
	}


	@Override
	public CurriculumVitae buscarCurriculumVitae(long dni) {
		// TODO Auto-generated method stub
		return curriculumVitaeImp.findByDni(dni);
	}


	
}