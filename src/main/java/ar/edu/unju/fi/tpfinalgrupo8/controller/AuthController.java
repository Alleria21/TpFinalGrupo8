package ar.edu.unju.fi.tpfinalgrupo8.controller;

import ar.edu.unju.fi.tpfinalgrupo8.entity.Ciudadano;
import ar.edu.unju.fi.tpfinalgrupo8.entity.Empleador;
import ar.edu.unju.fi.tpfinalgrupo8.service.ICiudadanoService;
import ar.edu.unju.fi.tpfinalgrupo8.service.IEmpleadorService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {
    @Autowired
    private IEmpleadorService empleadorService;
    @Autowired
    private ICiudadanoService ciudadanoService;
    private static final Log LOGGER = LogFactory.getLog(EmpleadorController.class);

    @GetMapping("/login")
    public ModelAndView getLoginEmpleador(){
        ModelAndView modelAndView= new ModelAndView("login");
        return modelAndView;
    }

    @GetMapping("/register/empleador")
    public ModelAndView getRegisterEmpleador(Empleador empleador){
        ModelAndView modelAndView= new ModelAndView("nuevo_empleador");
        modelAndView.addObject("empleador",new Empleador());
        return modelAndView;
    }
    @PostMapping("/register/empleador")
    public ModelAndView registerEmpleador(@Validated @ModelAttribute("empleador")Empleador empleador, BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            LOGGER.info("Error agregando empleador");
            ModelAndView modelAndView= new ModelAndView("nuevo_empleador");
            modelAndView.addObject("empleador",empleador);
            return modelAndView;
        }
        if(empleadorService.guardar(empleador)){
            LOGGER.info("Registro de empleador correcto");
            ModelAndView modelAndView = new ModelAndView("layouts/registro_exitoso");
            return modelAndView;
        }
        LOGGER.info("El empleador ingresado ya existe en la base de datos ");
        return new ModelAndView("layouts/registro_fracasado");

    }
    @GetMapping("/register/ciudadano")
    public String getRegisterCiudadano(Model model) {
        model.addAttribute("ciudadano", ciudadanoService.getCiudadano());
        return "nuevo_ciudadano";
    }

    @PostMapping("/register/ciudadano")
    public ModelAndView registerCiudadano(@Validated @ModelAttribute("ciudadano") Ciudadano ciudadano,
                                               BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            LOGGER.info("Error agregando un ciudadano");
            ModelAndView mav= new ModelAndView("nuevo_ciudadano");
            mav.addObject("ciudadano", ciudadano);
            return mav;
        }
        if(ciudadano.getEdad()>=18) {
        	if(ciudadanoService.guardarCiudadano(ciudadano)) {
       		 	LOGGER.info("Registro de ciudadano correcto");
                return new ModelAndView("layouts/registro_exitoso");
        	}else {
        		LOGGER.info("El ciudadano ingresado ya existe en la base de datos ");
                return new ModelAndView("layouts/registro_fracasado");
        	}
        }
        LOGGER.info("El ciudadano ingresado no es mayor de edad");
        return new ModelAndView("layouts/registroEdad_fracasado");
    }
}