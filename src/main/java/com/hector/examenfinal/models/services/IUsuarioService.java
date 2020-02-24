package com.hector.examenfinal.models.services;

import java.util.List;

import com.hector.examenfinal.models.entity.Usuario;

public interface IUsuarioService {

	public List<Usuario> findAll();
	
	public Usuario save(Usuario usuario);
	
	public Usuario findById(Long id);
	
	public void delete(Long id);
}
