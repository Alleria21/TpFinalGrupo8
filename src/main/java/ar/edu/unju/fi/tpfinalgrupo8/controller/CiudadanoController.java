package ar.edu.unju.fi.tpfinalgrupo8.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.tpfinalgrupo8.entity.Ciudadano;
import ar.edu.unju.fi.tpfinalgrupo8.entity.Curso;
import ar.edu.unju.fi.tpfinalgrupo8.entity.OfertaLaboral;
import ar.edu.unju.fi.tpfinalgrupo8.service.ICiudadanoService;
import ar.edu.unju.fi.tpfinalgrupo8.service.ICursoService;
import ar.edu.unju.fi.tpfinalgrupo8.service.IOfertaLaboralService;


@Controller
@RequestMapping("/ciudadano")
public class CiudadanoController {

	private static final Log LOGGER = (Log) LogFactory.getLog(CiudadanoController.class);
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
	@Autowired
	private ICursoService cursoService;
	
	@Autowired
	private IOfertaLaboralService ofertaService;

	@GetMapping("/listaCiudadanos")
	public String getListaCargadaCiudadanos(Model model) {
		model.addAttribute("unCiudadano", ciudadanoService.getListaCiudadano());
		return "lista_ciudadanos";
	}
	
	@GetMapping("/welcome")
    public ModelAndView welcomePage(@AuthenticationPrincipal User user){
        ModelAndView modelAndView= new ModelAndView("welcomeCiudadano");
        Ciudadano ciudadano= ciudadanoService.buscarCiudadano(Long.parseLong(user.getUsername()));
        LOGGER.info("usuario que hizo login: " + ciudadano.getEmail());
        modelAndView.addObject("ciudadano",ciudadano);
        return modelAndView;
    }
	
	@GetMapping("/welcome/miCurriculum")
    public ModelAndView welcomeCurriculumPage(@AuthenticationPrincipal User user){
        ModelAndView modelAndView= new ModelAndView("welcomeMiCurriculum");
        Ciudadano ciudadano= ciudadanoService.buscarCiudadano(Long.parseLong(user.getUsername()));
        LOGGER.info("usuario que hizo login: " + ciudadano.getEmail());
        modelAndView.addObject("ciudadano",ciudadano);
        modelAndView.addObject("curriculum", ciudadano.getCurriculum());
        return modelAndView;
    }
	
	@GetMapping("/welcome/misOfertas")
    public ModelAndView welcomeOfertasPage(@AuthenticationPrincipal User user){
        ModelAndView modelAndView= new ModelAndView("welcomeMisOfertasCiudadano");
        Ciudadano ciudadano= ciudadanoService.buscarCiudadano(Long.parseLong(user.getUsername()));
        LOGGER.info("usuario que hizo login: " + ciudadano.getEmail());
        modelAndView.addObject("ciudadano",ciudadano);
        modelAndView.addObject("oferta", ofertaService.getListaOfertaLaboral()); //MAL, MODIFICAR
        return modelAndView;
    }
	
	@GetMapping("/{dni}/inscribirse/{codigo}")
	public ModelAndView getCursoInscripcionPage(@PathVariable(value="dni")Long dni,@PathVariable(value="codigo")int codigo) {
		Ciudadano ciudadano=ciudadanoService.buscarCiudadano(dni);
		boolean bandera=true;
		for(Curso curs: ciudadano.getUnCurso()) {
			if(curs.getCodigo()==codigo) {
				bandera=false;
			}
		}
	//Comprobamos que el Ciudadano no este ya
	//inscripto en ese curso
		if(bandera==true) {
			Curso cursoEncontrado=cursoService.buscarCurso(codigo);
			ciudadano.getUnCurso().add(cursoEncontrado);
			ciudadanoService.modificarCiudadano(ciudadano);
			ModelAndView mav=new ModelAndView("layouts/inscripcion_exitosa");
			 LOGGER.info("El usuario se ha inscripto a un curso");
			return mav;
		}else {
	//Si ya esta inscripto saltara mensaje de aviso
			ModelAndView mav=new ModelAndView("layouts/inscripcion_rechazada");
			 LOGGER.info("El usuario ya se encuentra inscripto en el curso");
			return mav;
		}
	}
	
	@GetMapping("/welcome/misCursos")
    public ModelAndView welcomeCursosPage(@AuthenticationPrincipal User user){
        ModelAndView modelAndView= new ModelAndView("welcomeMisCursosCiudadano");
        Ciudadano ciudadano= ciudadanoService.buscarCiudadano(Long.parseLong(user.getUsername()));
        LOGGER.info("usuario que hizo login: " + ciudadano.getEmail());
        modelAndView.addObject("ciudadano",ciudadano);
        modelAndView.addObject("curso", ciudadano.getUnCurso());
        return modelAndView;
    }
	
	@GetMapping("/{dni}/postular/{codigo}")
	public ModelAndView getPostularAOferta(@PathVariable(value="dni")Long dni,@PathVariable(value="codigo")int codigo) {
		OfertaLaboral ofertaEncontrada=ofertaService.buscarOfertaLaboral(codigo);
		Ciudadano ciudadano=ciudadanoService.buscarCiudadano(dni);
		boolean band=true;
		//Se verifica que el ciudadano
		//no se encuentra ya postulado a esa oferta
		for(OfertaLaboral of: ciudadano.getOfertas()) {
			if(of.getCodigo()==codigo) {
				band=false;
			}
		}
		//Situacion en que el usuario le falte el Curriculum
		if(ciudadano.getCurriculum()==null) {
			ModelAndView mav=new ModelAndView("layouts/curriculum_faltante");
			return mav;
		}
		//Situacion en que la inscripcion sea exitosa
		if(band==true) {
			ciudadano.getOfertas().add(ofertaEncontrada);
			ciudadanoService.modificarCiudadano(ciudadano);
			ModelAndView mav=new ModelAndView("layouts/postulacion_exitosa");
			return mav;
		}else {
		//Situacion en que el usuario ya este inscripto a esa oferta
		//se mostrara un mensaje por medio de la vista
			ModelAndView mav=new ModelAndView("layouts/postulacion_rechazada");
			LOGGER.info("El ciudadano "+ciudadano.getEmail()+" ya se encuentra inscripto");
			return mav;
		}
	}
	
	@GetMapping("/MisPostulaciones")
	public ModelAndView getMisPostulacionesAOfertas(@AuthenticationPrincipal User user) {
		ModelAndView mav=new ModelAndView("welcomeMisPostulacionesCiudadano");
		Ciudadano ciudadano= ciudadanoService.buscarCiudadano(Long.parseLong(user.getUsername()));
        LOGGER.info("usuario que hizo login: " + ciudadano.getEmail());
        mav.addObject("oferta",ciudadano.getOfertas());
        return mav;
	}
}
