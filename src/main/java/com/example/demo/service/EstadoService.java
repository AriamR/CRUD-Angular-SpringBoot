package com.example.demo.service;

import java.util.ArrayList;
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

import com.example.demo.model.Estado;
import com.example.demo.repository.EstadoRepository;

@Service
public class EstadoService{
	
	@Autowired
	private EstadoRepository estadoRepository;

	public List<Estado> findAll() {
		return estadoRepository.findAll();
	}
	
	public List<Estado> findAllByCountry(Long id) {
		List<Estado> estadoRepuesta = new ArrayList<>();
		List<Estado> estados = estadoRepository.findAll();
		for (int i=0; i<estados.size(); i++){
			if(estados.get(i).getPais().getId()==id){  
				estadoRepuesta.add(estados.get(i));
			}
		}
		
		return estadoRepuesta;
	}


	
}
