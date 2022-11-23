package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.example.demo.model.Persona;
import com.example.demo.repository.PersonaRepository;


@Service
public class PersonaService {
	@Autowired
	private PersonaRepository personaRepository;


	public List<Persona> findAll() {
		return personaRepository.findAll();
	}
	
	public Optional<Persona> findById(Long id){
		return personaRepository.findById(id);
	}

	public <S extends Persona> S save(S entity) {

		return personaRepository.save(entity);
	}

	public void deleteById(Long id){
		personaRepository.deleteById(id);
	}
}
