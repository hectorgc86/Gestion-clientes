package com.hector.examenfinal.models.dao;
import org.springframework.data.repository.CrudRepository;
import com.hector.examenfinal.models.entity.Usuario;

public interface IUsuarioDAO extends CrudRepository<Usuario, Long>{
	
	
}
