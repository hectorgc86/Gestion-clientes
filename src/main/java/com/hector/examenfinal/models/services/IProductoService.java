package com.hector.examenfinal.models.services;

import java.util.List;

import com.hector.examenfinal.models.entity.Producto;

public interface IProductoService {

	public List<Producto> findAll();
	
	public Producto save(Producto producto);
	
	public Producto findById(Long id);
	
	public void delete(Long id);
}
