package mx.com.mifel.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.com.mifel.entity.Afiliacion;
import mx.com.mifel.service.AfiliacionesService;

@RestController
@RequestMapping("api")
public class AfiliacionesController {

	@Autowired
	private AfiliacionesService service;

	@GetMapping("afiliaciones")
	public ResponseEntity<Object> getAfiliaciones() {
		return new ResponseEntity<Object>(service.getAfilicaciones(), HttpStatus.OK);
	}
	@GetMapping("afiliaciones/get/paginacion")
	public ResponseEntity<Object> getAfiliacionesPag() {
		return new ResponseEntity<Object>(service.getAfilicacionesPag(), HttpStatus.OK);
	}
	@GetMapping("afiliaciones/{id}")
	public ResponseEntity<Object> getAfiliaciones(@PathVariable("id") long idAfiliacion) {
		return new ResponseEntity<Object>(service.getAfilicacionesById(idAfiliacion), HttpStatus.OK);
	}
	@PostMapping("afiliaciones")
	public ResponseEntity<Object> findAfiliaciones(@RequestBody Afiliacion afiliacion) {
		return new ResponseEntity<Object>(service.findAfilicaciones(afiliacion), HttpStatus.OK);
	}
	
}
