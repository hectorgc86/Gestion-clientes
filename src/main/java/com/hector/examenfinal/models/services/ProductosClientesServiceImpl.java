package com.hector.examenfinal.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hector.examenfinal.models.dao.IProductosClientesDAO;
import com.hector.examenfinal.models.entity.ProductosClientes;
import com.hector.examenfinal.models.entity.ProductosClientesId;

@Service
public class ProductosClientesServiceImpl implements IProductosClientesService{

	@Autowired
	private IProductosClientesDAO productosClientesDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<ProductosClientes> findAll(){
		
		return (List<ProductosClientes>) productosClientesDAO.findAll();
	}
	
	@Override
	@Transactional
	public List<ProductosClientes> findByUsuario(Long id){
		
		return (List<ProductosClientes>) productosClientesDAO.FindByUsuario(id);
	}
	
	@Override
	@Transactional
	public ProductosClientes save(ProductosClientes productosClientes){
		
		return productosClientesDAO.save(productosClientes);
	}
	
	@Override
	@Transactional(readOnly = true)
	public ProductosClientes findById(ProductosClientesId id){
		
		return productosClientesDAO.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void delete(ProductosClientesId id){
		productosClientesDAO.deleteById(id);
	}
	
}
