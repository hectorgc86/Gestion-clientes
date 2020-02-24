package com.hector.examenfinal.models.services;

import java.util.List;

import com.hector.examenfinal.models.entity.ProductosClientes;
import com.hector.examenfinal.models.entity.ProductosClientesId;

public interface IProductosClientesService {

	public List<ProductosClientes> findAll();
	
	public List<ProductosClientes> findByUsuario(Long id);
	
	public ProductosClientes save(ProductosClientes productosClientes);
	
	public ProductosClientes findById(ProductosClientesId id);
	
	public void delete(ProductosClientesId id);
}
