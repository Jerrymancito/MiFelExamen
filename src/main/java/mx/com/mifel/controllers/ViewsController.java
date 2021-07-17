package mx.com.mifel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import mx.com.mifel.service.AfiliacionesService;

/**
 * Controlador de vistas MVC
 * 
 * @author Jerry
 *
 */
@Controller
public class ViewsController {
	@Autowired
	private AfiliacionesService service;

	@GetMapping("")
	public String getIndex(Model model) {
		model.addAttribute("titulo", "Banco - Inicio");
		return "index";
	}

	@GetMapping("afiliaciones")
	public String getAfiliaciones(Model model) {
		model.addAttribute("titulo", "Banco - Afiliaciones");
		model.addAttribute("afiliaciones", service.getAfilicaciones());
		return "afiliaciones";
	}

	@GetMapping("buscar-afiliacion") 
	public String findAfiliacion(Model model) {
		model.addAttribute("titulo", "Banco - Buscar Afiliación");
		model.addAttribute("afiliaciones", service.getAfilicaciones());
		return "buscar-afiliacion";
	}
}
