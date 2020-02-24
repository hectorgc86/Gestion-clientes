package com.hector.examenfinal.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hector.examenfinal.models.dao.IUsuarioDAO;
import com.hector.examenfinal.models.entity.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private IUsuarioDAO usuarioDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Usuario> findAll(){
		
		return (List<Usuario>) usuarioDao.findAll();
	}
	
	@Override
	@Transactional
	public Usuario save(Usuario usuario){
		
		return usuarioDao.save(usuario);
	}
	
	@Override
	@Transactional(readOnly = true)
	public Usuario findById(Long id){
		
		return usuarioDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public void delete(Long id){
		usuarioDao.deleteById(id);
	}
	
}
