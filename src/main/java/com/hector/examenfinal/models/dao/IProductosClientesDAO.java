package com.hector.examenfinal.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.hector.examenfinal.models.entity.ProductosClientes;
import com.hector.examenfinal.models.entity.ProductosClientesId;

public interface IProductosClientesDAO extends CrudRepository<ProductosClientes, ProductosClientesId>{
	
	//Consulta a BBDD de compras de un usuario
	
	@Query("FROM ProductosClientes WHERE id.clienteId = ?1")
    List<ProductosClientes> FindByUsuario(Long id);
}
