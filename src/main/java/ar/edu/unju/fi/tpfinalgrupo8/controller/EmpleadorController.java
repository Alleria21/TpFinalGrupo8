package ar.edu.unju.fi.tpfinalgrupo8.controller;


import ar.edu.unju.fi.tpfinalgrupo8.entity.Ciudadano;
import ar.edu.unju.fi.tpfinalgrupo8.entity.Empleador;
import ar.edu.unju.fi.tpfinalgrupo8.service.ICiudadanoService;
import ar.edu.unju.fi.tpfinalgrupo8.service.IEmpleadorService;
import ar.edu.unju.fi.tpfinalgrupo8.service.IOfertaLaboralService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/empleador")
public class EmpleadorController {

    @Autowired
    private IEmpleadorService empleadorService;
    @Autowired
    private IOfertaLaboralService ofertaLaboralService;
    @Autowired
    private ICiudadanoService ciudadanoService;

    private static final Log LOGGER = LogFactory.getLog(EmpleadorController.class);

    @GetMapping("/welcome")
    public ModelAndView welcomePage(@AuthenticationPrincipal User user){
        ModelAndView modelAndView= new ModelAndView("welcomeEmpleador");
        Empleador empleador= empleadorService.buscarPorCuit(Long.parseLong(user.getUsername()));
        LOGGER.info("usuario que hizo login: " + empleador.getEmail());
        modelAndView.addObject("empleador",empleador);
        modelAndView.addObject("ofertas", empleador.getOfertasLaborales());
        return modelAndView;
    }
    @GetMapping("{id}/postulantes")
    public ModelAndView postulantes(@PathVariable(value = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("postulantes");
        List<Ciudadano> postulantes = ciudadanoService.findByOferta(ofertaLaboralService.findById(id));
        modelAndView.addObject("postulantes",postulantes);
        return modelAndView;
    }
    @GetMapping("/postulante/{id}")
    public ModelAndView postulante(@PathVariable(value = "id") Long id){
        ModelAndView modelAndView = new ModelAndView("curriculum_completo");
        Ciudadano ciudadano= ciudadanoService.findById(id);
        modelAndView.addObject("curriculumVitae", ciudadano.getCurriculum());
        return modelAndView;
    }
}
