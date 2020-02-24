package com.hector.examenfinal.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hector.examenfinal.models.dao.IClienteDAO;
import com.hector.examenfinal.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService{

	@Autowired
	private IClienteDAO clienteDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll(){
		
		return (List<Cliente>) clienteDao.findAll();
	}
	
	@Override
	@Transactional
	public List<Cliente> findAllSinUsuario(){
		
		return (List<Cliente>) clienteDao.FindAllSinUsuario();
	}
	
	@Override
	@Transactional
	public Cliente save(Cliente cliente){
		
		return clienteDao.save(cliente);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id){
		
		return clienteDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void delete(Long id){
		clienteDao.deleteById(id);
	}

	@Override
	@Transactional
	public List<Cliente> FindByNombre(String nombre) {
		return clienteDao.FindByNombre(nombre);
	}
	
	
	
}
