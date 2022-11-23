package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.EstadoService;
import com.example.demo.model.Estado;

@RestController
@RequestMapping("/estado/")  
public class EstadoREST {
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping("{id}")
	private List<Estado> findAllbyPais (@PathVariable("id")Long idPais){
		return estadoService.findAllByCountry(idPais);
	
	}
}
