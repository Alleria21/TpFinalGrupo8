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
import ar.edu.unju.fi.tpfinalgrupo8.entity.CurriculumVitae;
import ar.edu.unju.fi.tpfinalgrupo8.entity.Empleador;
import ar.edu.unju.fi.tpfinalgrupo8.entity.OfertaLaboral;
import ar.edu.unju.fi.tpfinalgrupo8.service.ICiudadanoService;
import ar.edu.unju.fi.tpfinalgrupo8.service.ICurriculumVitaeService;



@Controller
@RequestMapping("/curriculumVitae")
public class CurriculumVitaeController {
	
	private static final Log LOGGER = LogFactory.getLog(CurriculumVitae.class);
	
	@Autowired
	private ICurriculumVitaeService curriculumVitaeService;
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	/*
	@GetMapping("/nuevo")
	public String agregar(Model model) {
		model.addAttribute("curriculumVitae", curriculumVitaeService.getCurriculumVitae());
		return "nuevo_curriculumVitae";
	}*/
	@GetMapping("/{id}/nuevo")
	public String getFormNuevoOfertaLaboralPage(@PathVariable(value = "id")Long id,Model model) {
		Ciudadano ciudadano = new Ciudadano();
		CurriculumVitae curriculumVitae = new CurriculumVitae();
		ciudadano.setId(id);
		Ciudadano ciudadanoEncontrado = ciudadanoService.buscarCiudadanoPorId(ciudadano.getId());
		LOGGER.info(ciudadanoEncontrado.getEmail());
		curriculumVitae.setCiudadano(ciudadanoEncontrado);
		model.addAttribute("curriculumVitae", curriculumVitae);
		model.addAttribute("ciudadano", ciudadanoEncontrado);
		model.addAttribute("id",id);
		LOGGER.info("Se ha asociado un objeto Curriculum al formulario");
		return "nuevo_curriculumVitae";
	}
	/*
	@PostMapping("/guardar")
	public ModelAndView getListaCurriculumVitaePage(@Validated @ModelAttribute("curriculumVitae")CurriculumVitae curriculumVitae, 
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("Error generando Curriculum Vitae");
			ModelAndView mav= new ModelAndView("nuevo_curriculumVitae");
			mav.addObject("curriculumVitae", curriculumVitae);
			return mav;
		}
		ModelAndView mav=new ModelAndView("redirect:/curriculumVitae/listaCurriculumVitae");
		if(curriculumVitaeService.guardarCurriculumVitae(curriculumVitae)) {
			LOGGER.info("Se agregó un objeto al arrayList de Curriculum Vitae");
		}
		return mav;
	}*/
	@PostMapping("/{id}/guardar")
	public ModelAndView getListaOfertaLaboralPage(@Validated @ModelAttribute("curriculumVitae")CurriculumVitae curriculum,
	BindingResult bindingresult) {
		if(bindingresult.hasErrors()){
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_curriculumVitae");
			mav.addObject("curriculumVitae", curriculum);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("redirect:/ciudadano/welcome");
		if(curriculumVitaeService.guardarCurriculumVitae(curriculum)) {
			LOGGER.info("Se ha agregado un curriculum");
		}else {
			LOGGER.info("No se ha agregado un curriculum"); 
		}
		return mav;
	}
	
	@GetMapping("/listaCurriculumVitae")
	public String getListaCargadaCurriculumVitae(Model model) {
		model.addAttribute("unCurriculumVitae", curriculumVitaeService.obtenerCurriculumVitae());
		return "lista_curriculumVitae";
	}
	
	@GetMapping("/editar/{dni}")
	public ModelAndView getEditarCurriculumVitae(@PathVariable(value="dni")long dni) {
		ModelAndView mav = new ModelAndView("edicion_curriculumVitae");
		mav.addObject("curriculumVitae", curriculumVitaeService.buscarCurriculumVitae(dni));
		return mav;
	}
	@PostMapping("/modificar")
	public ModelAndView editarDatosCurriculumVitae(@Validated @ModelAttribute("curriculumVitae")CurriculumVitae curriculumVitae, 
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("Error agregando el Curriculum Vitae");
			ModelAndView mav= new ModelAndView("edicion_curriculumVitae");
			mav.addObject("curriculumVitae", curriculumVitae);
			return mav;
		}
		ModelAndView mav=new ModelAndView("redirect:/curriculumVitae/listaCurriculumVitae");
		curriculumVitaeService.modificarCurriculumVitae(curriculumVitae);
		return mav;
	}
	
	@GetMapping("/eliminar/{dni}")
	public ModelAndView getEliminarCurriculumVitae(@PathVariable(value="dni")long dni) {
		ModelAndView mav=new ModelAndView("redirect:/curriculumVitae/listaCurriculumVitae");
		curriculumVitaeService.eliminarCurriculumVitae(dni);
		return mav;
	}
	
	@GetMapping("/masInfo/{dni}")
	public String getCurriculumCompleto(@PathVariable(value="dni")long dni, Model model) {
		model.addAttribute("curriculum", curriculumVitaeService.buscarCurriculumVitae(dni));
		return "currriculum_completo";
	}
}