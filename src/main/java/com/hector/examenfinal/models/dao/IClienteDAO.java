package com.hector.examenfinal.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hector.examenfinal.models.entity.Cliente;

public interface IClienteDAO extends CrudRepository<Cliente, Long>{
	
	//Consultas a base de datos (filtrado y búsqueda)
	
	@Query("FROM Cliente WHERE id NOT IN (SELECT cliente.id FROM Usuario)")
    List<Cliente> FindAllSinUsuario();
 
	@Query("FROM Cliente WHERE LOWER(nombre) = LOWER(?1)")
    List<Cliente> FindByNombre(String nombre);
	
}
