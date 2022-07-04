package ar.edu.unju.fi.tpfinalgrupo8.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.tpfinalgrupo8.entity.Ciudadano;
import ar.edu.unju.fi.tpfinalgrupo8.entity.CurriculumVitae;
import ar.edu.unju.fi.tpfinalgrupo8.entity.Curso;
import ar.edu.unju.fi.tpfinalgrupo8.entity.Empleador;
import ar.edu.unju.fi.tpfinalgrupo8.entity.OfertaLaboral;
import ar.edu.unju.fi.tpfinalgrupo8.service.ICiudadanoService;
import ar.edu.unju.fi.tpfinalgrupo8.service.ICursoService;
import ar.edu.unju.fi.tpfinalgrupo8.util.Categoria;
import ar.edu.unju.fi.tpfinalgrupo8.util.Provincias;

@Controller
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	@Qualifier("CursoServiceImpList")
	private ICursoService cursoService;
	
	@Autowired
	private ICiudadanoService ciudadanoService;
	
	private static final Log LOGGER = LogFactory.getLog(Curso.class);
	
	//Empece desde aquí
	@GetMapping("/{id}/nuevo")
	public String getCursoPage(@PathVariable(value = "id")Long id,Model model) {
		Curso curso = new Curso();
		Empleador empleador = new Empleador();
		empleador.setId(id);
		curso.setCreador(empleador);
		model.addAttribute("curso", curso);
		model.addAttribute("id",id);
		LOGGER.info("Se ha asociado un objeto Curso al formulario");
		return "nuevo_curso";
	}
	
	@PostMapping("/{id}/agregar")
	public ModelAndView getListaCursoPage(@Validated @ModelAttribute("curso")Curso curso,
	BindingResult bindingresult) {
		if(bindingresult.hasErrors()){
			LOGGER.error("No se cumplen las reglas de validación");
			ModelAndView mav = new ModelAndView("nuevo_curso");
			mav.addObject("curso", curso);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("redirect:/curso/ListaCursos");
		if(cursoService.guardarCurso(curso)) {
			LOGGER.info("Se ha agregado un curso");
		}else {
			LOGGER.info("No se ha agregado un curso"); 
		}
		return mav;
	}
	
	@GetMapping("/ListaCursosAdmin")
	public ModelAndView getListaCursosAdmin() {
		ModelAndView mav = new ModelAndView("lista_cursos_empleador");
		mav.addObject("unCurso", cursoService.getListaCurso());
		return mav;
	}
	
	@GetMapping("/ListaCursos")
	public ModelAndView getListaCursos(@AuthenticationPrincipal User user) {
		ModelAndView mav = new ModelAndView("lista_cursos_ciudadano");
		mav.addObject("ciudadano", ciudadanoService.buscarCiudadano(Long.parseLong(user.getUsername())));
		mav.addObject("unCurso", cursoService.getListaCurso());
		return mav;
	}
	
	@GetMapping("/editar/{codigo}")
	public ModelAndView getEditarCursoPage(@PathVariable(value = "codigo")int codigo) {
		ModelAndView mav = new ModelAndView("edicion_curso");
		Curso curso = cursoService.buscarCurso(codigo);
		mav.addObject("curso", curso);
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView getEditarDatosCursos(@Validated @ModelAttribute("curso")Curso curso,
	BindingResult bindingresult) {
		
		if(bindingresult.hasErrors()){
			LOGGER.info("Ha ocurrido un error en la edicion" + curso);
			ModelAndView mav = new ModelAndView("edicion_curso");
			mav.addObject("curso", curso);
			return mav; 
		}
		LOGGER.info("Se ha modificado un curso");
		cursoService.modificarCurso(curso);
		ModelAndView mav = new ModelAndView("redirect:/curso/ListaCursos");
		return mav;
	}
	
	@GetMapping("/eliminar/{codigo}")
	public ModelAndView getEliminarCurso(@PathVariable(value="codigo")int codigo) {
		LOGGER.info("Se ha eliminado un curso");
		ModelAndView mav=new ModelAndView("redirect:/curso/ListaCursos");
		cursoService.eliminarCurso(codigo);
		return mav;
	}
	
	
	@GetMapping("/BusquedaCursos")
    public ModelAndView findByCategoria(@RequestParam(required = false) Categoria categoria,@AuthenticationPrincipal User user){
        ModelAndView modelAndView = new ModelAndView("busquedaCursos");
        modelAndView.addObject("unCurso",cursoService.findByCategoria(categoria).get() );
        modelAndView.addObject("ciudadano", ciudadanoService.buscarCiudadano(Long.parseLong(user.getUsername())));
        return modelAndView;
    }
	
	
}
