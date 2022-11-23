package com.example.demo.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Persona;
import com.example.demo.service.PersonaService;

@RestController
@RequestMapping("/persona/")  
public class PersonaREST {


	@Autowired
	private PersonaService personaService;
	
	@GetMapping
	private List<Persona> findAll(){
		return personaService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Persona> getPersonaById(@PathVariable ("id") Long id){
		Persona persona = personaService.findById(id)
			.orElseThrow();
			return ResponseEntity.ok(persona);
		
	}
	

	
	@PostMapping
	private ResponseEntity<Persona> savePersona(@RequestBody Persona persona){
		
		try{
			Persona personaSaved = personaService.save(persona);
			return ResponseEntity.created(new URI("/persona/"+personaSaved.getId())).body(personaSaved);
		} catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	
	}
	
	
	@PutMapping(value = "update/{id}")
	public ResponseEntity<Persona> updatePersona(@PathVariable ("id") Long id, @RequestBody Persona persona){
		Optional<Persona> personaFind = personaService.findById(id);
	    
		if(personaFind.isPresent())
		{
			Persona _persona = personaFind.get();
			_persona.setNombre(persona.getNombre());
			_persona.setApellido(persona.getApellido());
			_persona.setEdad(persona.getEdad());
			_persona.setPais(persona.getPais());
			_persona.setEstado(persona.getEstado());
			
			return new ResponseEntity<>(personaService.save(_persona), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@DeleteMapping (value = "delete/{id}")
	private ResponseEntity<Boolean> deletePersona(@PathVariable ("id") Long id){
		personaService.deleteById(id);
		return ResponseEntity.ok((personaService.findById(id)!=null));
	}
	
	
}
