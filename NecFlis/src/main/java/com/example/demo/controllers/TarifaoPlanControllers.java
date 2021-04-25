package com.example.demo.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.TarifaoPlan;
import com.example.demo.reposities.TarifaoPlanRepository;

@RestController
@RequestMapping(value = "/tarifas")
public class TarifaoPlanControllers {
	
		
	@Autowired
	TarifaoPlanRepository repository;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<TarifaoPlan> getListaTarifas(){
		Iterable<TarifaoPlan> listaTarifas = repository.findAll();
		
		return (Collection<TarifaoPlan>) listaTarifas;
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public TarifaoPlan getTarifa(@PathVariable (name = "id") Long id) {
		Optional<TarifaoPlan> tarifa = repository.findById(id);
		TarifaoPlan result =null;
		if(tarifa.isPresent()) {
			result = tarifa.get();
		}
		return result;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public TarifaoPlan createTarifa(@RequestBody TarifaoPlan tarifa) {
		
		TarifaoPlan nuevaTarifa =repository.save(tarifa);
		return nuevaTarifa;
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void deleteTarifa(@PathVariable(name = "id") Long id) {
	repository.deleteById(id);
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public TarifaoPlan updateTarif(@PathVariable(name = "id") Long id, @RequestBody TarifaoPlan tarifa) {
			Optional<TarifaoPlan> oTarifa = repository.findById(id);
			if (oTarifa.isPresent()) {
				TarifaoPlan actual = oTarifa.get();
				actual.setId(id);
				actual.setNombreTarifa(tarifa.getNombreTarifa());
				actual.setDescripcionTarifa(tarifa.getDescripcionTarifa());
				actual.setMontoTarifa(tarifa.getMontoTarifa());
				actual.setFechaCreacion(tarifa.getFechaCreacion());
				TarifaoPlan updateTarif = repository.save(actual);
				return updateTarif;
			}
			return null;
		}
			
	

}

