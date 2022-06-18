package ar.edu.unju.fi.tpfinalgrupo8.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ar.edu.unju.fi.tpfinalgrupo8.entity.OfertaLaboral;
import ar.edu.unju.fi.tpfinalgrupo8.service.IOfertaLaboralService;

@Controller
@RequestMapping("/oferta")
public class OfertaLaboralController {
	
	@Autowired
	@Qualifier("OfertaLaboralServiceImpList")
	private IOfertaLaboralService ofertaLaboralService;
	
	private static final Log LOGGER = LogFactory.getLog(OfertaLaboral.class);
	
	@GetMapping("/nuevo")
	public String getFormNuevoOfertaLaboralPage(Model model) {
		model.addAttribute("oferta", ofertaLaboralService.getOfertaLaboral());
		LOGGER.info("Se ha asociado un objeto OfertaLaboral al formulario");
		return "nuevo_ofertaLaboral";
	}
	
	@PostMapping("/agregar")
	public ModelAndView getListaOfertaLaboralPage(@Validated @ModelAttribute("oferta")OfertaLaboral ofertaLaboral,
	BindingResult bindingresult) {
		if(bindingresult.hasErrors()){
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_ofertaLaboral");
			mav.addObject("oferta", ofertaLaboral);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("redirect:/oferta/ListaOfertasLaborales");
		if(ofertaLaboralService.guardarOfertaLaboral(ofertaLaboral)) {
			LOGGER.info("Se ha agregado una oferta laboral");
		}else {
			LOGGER.info("No se ha agregado una oferta laboral"); 
		}
		return mav;
	}
	
	@GetMapping("/ListaOfertasLaborales")
	public ModelAndView getListaOfertasLaborales() {
		ModelAndView mav = new ModelAndView("lista_ofertasLaborales");
		mav.addObject("unaOfertaLaboral", ofertaLaboralService.getListaOfertaLaboral());
		return mav;
	}
	
	@GetMapping("/editar/{codigo}")
	public ModelAndView getEditarOfertaLaboralPage(@PathVariable(value = "codigo")int codigo) {
		ModelAndView mav = new ModelAndView("edicion_ofertaLaboral");
		OfertaLaboral ofertaLaboral = ofertaLaboralService.buscarOfertaLaboral(codigo);
		mav.addObject("oferta", ofertaLaboral);
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView getEditarDatosOfertaLaboral(@Validated @ModelAttribute("oferta")OfertaLaboral ofertaLaboral,
	BindingResult bindingresult) {
		
		if(bindingresult.hasErrors()){
			LOGGER.info("Ha ocurrido un error en la edicion" + ofertaLaboral);
			ModelAndView mav = new ModelAndView("edicion_ofertaLaboral");
			mav.addObject("oferta", ofertaLaboral);
			return mav; 
		}
		LOGGER.info("Se ha modificado una oferta laboral");
		ofertaLaboralService.modificarOfertaLaboral(ofertaLaboral);
		ModelAndView mav = new ModelAndView("redirect:/oferta/ListaOfertasLaborales");
		return mav;
	}
	
	@GetMapping("/eliminar/{codigo}")
	public ModelAndView getEliminarOfertaLaboral(@PathVariable(value="codigo")int codigo) {
		LOGGER.info("Se ha eliminado una oferta laboral");
		ModelAndView mav=new ModelAndView("redirect:/oferta/ListaOfertasLaborales");
		ofertaLaboralService.eliminarOfertaLaboral(codigo);
		return mav;
	}
}
