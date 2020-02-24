package com.hector.examenfinal.models.services;

import java.util.List;

import com.hector.examenfinal.models.entity.Cliente;

public interface IClienteService {

	public List<Cliente> findAll();
	
	public List<Cliente>findAllSinUsuario();
	
    public List<Cliente> FindByNombre(String nombre);

	
	public Cliente save(Cliente cliente);
	
	public Cliente findById(Long id);
	
	public void delete(Long id);
}
