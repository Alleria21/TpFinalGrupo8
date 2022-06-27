package ar.edu.unju.fi.tpfinalgrupo8.controller;


import ar.edu.unju.fi.tpfinalgrupo8.entity.Empleador;
import ar.edu.unju.fi.tpfinalgrupo8.entity.OfertaLaboral;
import ar.edu.unju.fi.tpfinalgrupo8.service.IEmpleadorService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {

    @Autowired
    private IEmpleadorService empleadorService;

    private static final Log LOGGER = LogFactory.getLog(EmpleadorController.class);

    @GetMapping("/welcome")
    public ModelAndView welcomePage(@AuthenticationPrincipal User user){
        ModelAndView modelAndView= new ModelAndView("welcomeEmpleador");
        Empleador empleador= empleadorService.buscarPorCuit(Long.parseLong(user.getUsername()));
        LOGGER.info("usuario que hizo login: " + empleador.getEmail());
        /*if(empleador.getOfertasLaborales().isEmpty()){
            modelAndView.addObject("ofertas", new ArrayList<OfertaLaboral>());
            return modelAndView;
        }*/
        modelAndView.addObject("empleador",empleador);
        modelAndView.addObject("ofertas", empleador.getOfertasLaborales());
        return modelAndView;
    }
    //TODO: completar cuando haya avances de entidad ciudadano y curriculum
}
