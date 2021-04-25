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

import com.example.demo.entities.Clientes;
import com.example.demo.reposities.ClientesRepository;




@RestController
@RequestMapping(value = "/clientes")
public class ClientesControllers {
	
	@Autowired
	ClientesRepository repository;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public Collection<Clientes> getListaClientes(){
		Iterable<Clientes> listaClientes = repository.findAll();
		
		return (Collection<Clientes>) listaClientes;
	}
	
	@GetMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public Clientes getCliente(@PathVariable (name = "id") Long id) {
		Optional<Clientes> cliente = repository.findById(id);
		Clientes result =null;
		if(cliente.isPresent()) {
			result = cliente.get();
		}
		return result;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Clientes createCliente(@RequestBody Clientes cliente) {
		
		Clientes nuevoCliente =repository.save(cliente);
		return nuevoCliente;
	}
	
	@DeleteMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public void deleteCliente(@PathVariable(name = "id") Long id) {
	repository.deleteById(id);
	}
	
	@PutMapping(value = "/{id}")
	@ResponseStatus(code = HttpStatus.ACCEPTED)
	public Clientes updateClientes(@PathVariable(name = "id") Long id, @RequestBody Clientes cliente) {
		Optional<Clientes> oCliente = repository.findById(id);
		if (oCliente.isPresent()) {
			Clientes actual = oCliente.get();
			actual.setId(id);
			actual.setNombre(cliente.getNombre());
			actual.setEdad(cliente.getEdad());
			actual.setPais(cliente.getPais());
			actual.setFecha(cliente.getFecha());
			Clientes updateClient = repository.save(actual);
			return updateClient;
		}
		return null;
	}
		
}
