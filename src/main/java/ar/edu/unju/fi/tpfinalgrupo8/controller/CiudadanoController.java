package ar.edu.unju.fi.tpfinalgrupo8.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import ar.edu.unju.fi.tpfinalgrupo8.service.ICiudadanoService;


@Controller
@RequestMapping("/ciudadano")
public class CiudadanoController {

	private static final Log LOGGER = (Log) LogFactory.getLog(CiudadanoController.class);
	
	@Autowired
	private ICiudadanoService ciudadanoService;

	
	@GetMapping("/nuevo")
	public String getCiudadano(Model model) {
		model.addAttribute("ciudadano", ciudadanoService.getCiudadano());
		return "nuevo_ciudadano";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaCiudadanosPage(@Validated @ModelAttribute("ciudadano")Ciudadano ciudadano, 
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("Error agregando un ciudadano");
			ModelAndView mav= new ModelAndView("nuevo_ciudadano");
			mav.addObject("ciudadano", ciudadano);
			return mav;
		}
		ModelAndView mav=new ModelAndView("redirect:/ciudadano/listaCiudadanos");
		if(ciudadanoService.guardarCiudadano(ciudadano)) {
			LOGGER.info("Se agregó un objeto al arrayList de alumnos");
		}
		return mav;
	}
	
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
	
		
	
}
