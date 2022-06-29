package ar.edu.unju.fi.tpfinalgrupo8.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinalgrupo8.entity.Ciudadano;
import ar.edu.unju.fi.tpfinalgrupo8.entity.Curso;
import ar.edu.unju.fi.tpfinalgrupo8.entity.Empleador;
import ar.edu.unju.fi.tpfinalgrupo8.entity.OfertaLaboral;
import ar.edu.unju.fi.tpfinalgrupo8.service.ICiudadanoService;
import ar.edu.unju.fi.tpfinalgrupo8.service.ICursoService;


@Controller
@RequestMapping("/ciudadano")
public class CiudadanoController {

	private static final Log LOGGER = (Log) LogFactory.getLog(CiudadanoController.class);
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
	@Autowired
	private ICursoService cursoService;

	@GetMapping("/listaCiudadanos")
	public String getListaCargadaCiudadanos(Model model) {
		model.addAttribute("unCiudadano", ciudadanoService.getListaCiudadano());
		return "lista_ciudadanos";
	}
	
	@GetMapping("/editar/{dni}")
	public ModelAndView getEditarCiudadanoPage(@PathVariable(value="dni")int dni) {
		ModelAndView mav = new ModelAndView("edicion_ciudadano");
		mav.addObject("ciudadano", ciudadanoService.buscarCiudadano(dni));
		return mav;
	}
	@PostMapping("/modificar")
	public ModelAndView editarDatosCiudadanos(@Validated @ModelAttribute("ciudadano")Ciudadano ciudadano, 
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("Error agregando un ciudadano");
			ModelAndView mav= new ModelAndView("edicion_ciudadano");
			mav.addObject("ciudadano", ciudadano);
			return mav;
		}
		ModelAndView mav=new ModelAndView("redirect:/ciudadano/listaCiudadanos");
		ciudadanoService.modificarCiudadano(ciudadano);
		return mav;
	}
	
	@GetMapping("/eliminar/{dni}")
	public ModelAndView getEliminarAlumno(@PathVariable(value="dni")int dni) {
		ModelAndView mav=new ModelAndView("redirect:/ciudadano/listaCiudadanos");
		ciudadanoService.eliminarCiudadano(dni);
		return mav;
	}
	
	@GetMapping("/welcome")
    public ModelAndView welcomePage(@AuthenticationPrincipal User user){
        ModelAndView modelAndView= new ModelAndView("welcomeCiudadano");
        Ciudadano ciudadano= ciudadanoService.buscarCiudadano(Long.parseLong(user.getUsername()));
        LOGGER.info("usuario que hizo login: " + ciudadano.getEmail());
        modelAndView.addObject("ciudadano",ciudadano);
       // modelAndView.addObject("curriculum", ciudadano.getCurriculum());
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
	@GetMapping("/welcome/misCursos")
    public ModelAndView welcomeCursosPage(@AuthenticationPrincipal User user){
        ModelAndView modelAndView= new ModelAndView("welcomeMisCursosCiudadano");
        Ciudadano ciudadano= ciudadanoService.buscarCiudadano(Long.parseLong(user.getUsername()));
        LOGGER.info("usuario que hizo login: " + ciudadano.getEmail());
        modelAndView.addObject("ciudadano",ciudadano);
        modelAndView.addObject("curso", ciudadano.getUnCurso());
        return modelAndView;
    }
	
	@GetMapping("/{id}/inscribirse/{idCurso}")
	public ModelAndView getCursoInscripcionPage(@PathVariable(value = "id")Long id,@PathVariable(value = "idCurso")int idCurso) {
		Curso cursoEncontrado = cursoService.buscarCurso(idCurso);
		Ciudadano ciudadano = new Ciudadano();
		ciudadano.setId(id);
		cursoEncontrado.setCiudadano(ciudadano);
		if(cursoService.guardarInscripto(cursoEncontrado)) {
			LOGGER.info("Se ha agregado un Curso");
		}else {
			LOGGER.info("No se ha agregado un Curso"); 
		}
		ModelAndView mav = new ModelAndView("layouts/inscripcion_exitosa");
		LOGGER.info("Se ha asociado un objeto Curso al Ciudadano");
		return mav;
	}
}
