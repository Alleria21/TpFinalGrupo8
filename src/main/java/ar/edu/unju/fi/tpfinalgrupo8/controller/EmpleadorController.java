package ar.edu.unju.fi.tpfinalgrupo8.controller;


import ar.edu.unju.fi.tpfinalgrupo8.service.IEmpleadorService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empleador")
public class EmpleadorController {

    @Autowired
    private IEmpleadorService empleadorService;

    private static final Log LOGGER = LogFactory.getLog(EmpleadorController.class);

    //TODO: completar cuando haya avances de entidad ciudadano y curriculum
}
