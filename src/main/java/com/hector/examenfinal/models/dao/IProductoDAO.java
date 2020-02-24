package com.hector.examenfinal.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.hector.examenfinal.models.entity.Producto;

public interface IProductoDAO extends CrudRepository<Producto, Long>{
	
}
