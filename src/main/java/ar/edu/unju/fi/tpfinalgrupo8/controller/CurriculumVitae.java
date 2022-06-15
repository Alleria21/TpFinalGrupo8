/*package ar.edu.unju.fi.tpfinalgrupo8.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinalgrupo8.service.ICurriculumVitaeService;

@Controller
@RequestMapping("/curriculumvitae")
public class CurriculumVitae {

	@Autowired
	@Qualifier("CurriculumVitaeServiceImpList")
	public ICurriculumVitaeService curriculumVitaeService;
	private static final Log LOGGER = LogFactory.getLog(CurriculumVitae.class);
	
	@GetMapping("/nuevo")
	public String getFormNuevoCurriculumVitae(Model model) {
		LOGGER.info("Se ha incorporado un objeto Curriculum Vitae al formulario");
		return "nuevo_curriculumvitae";
	}
	
	@PostMapping("/agregar")
	public ModelAndView getListaCurriculumVitaePage(@Validated @ModelAttribute("curriculumvitae")CurriculumVitae curriculumvitae, BindingResult bindingresult) {
		if(bindingresult.hasErrors()){
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_curriculumvitae");
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("redirect:/curriculumvitae/ListaCurriculumVitae");
		if(curriculumVitaeService.guardar(curriculumVitae)) {
			LOGGER.info("Se ha agregado un curriculum vitae");
		}
		return mav;
		
		}
	}
	*/

