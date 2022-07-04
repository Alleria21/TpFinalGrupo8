package ar.edu.unju.fi.tpfinalgrupo8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

//Metodo para mostrar la vista
//de la pagina de inicio de la plataforma
@Controller
public class IndexController {
		@GetMapping("/inicio")
		public String getIndexController(Model model) {
			return "index";
		}
}
