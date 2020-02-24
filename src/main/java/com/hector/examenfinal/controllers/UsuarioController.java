package com.hector.examenfinal.controllers;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hector.examenfinal.models.entity.Mail;
import com.hector.examenfinal.models.entity.ProductosClientes;
import com.hector.examenfinal.models.entity.Usuario;
import com.hector.examenfinal.models.services.IMailService;
import com.hector.examenfinal.models.services.IProductosClientesService;
import com.hector.examenfinal.models.services.IUsuarioService;

//Controlador de usuarios

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	//Declaración de servicios
	
	@Autowired
	private IUsuarioService servicioUsuario;
	
	@Autowired
	private IProductosClientesService servicioProductosClientes;
	
	@Autowired
	private IMailService servicioMail;
	
	//Método de obtención de todos los usuarios
	
	@GetMapping("/")
	public String listarUsuarios(Model model) {
		List<Usuario> listaUsuarios = servicioUsuario.findAll();
		model.addAttribute("usuarios", listaUsuarios);
		return "usuarios";
	}
	
	//Método de obtención de todas las compras de un usuario
	
	@RequestMapping(path = "/vercompras/{id}")
	public String listarCompras(Model model, @PathVariable("id") Long id) {
	
		List<ProductosClientes> productosCliente = servicioProductosClientes.findByUsuario(id);
		List<Usuario> listaUsuarios = servicioUsuario.findAll();
		model.addAttribute("usuarios", listaUsuarios);
		if (productosCliente.size() > 0) {
			model.addAttribute("compras", productosCliente);
		}
		return "usuarios";
	}
	
	//Método de creación de nuevo usuario
	
	 @RequestMapping(path = "/crear", method = RequestMethod.POST)
	    public String crearUsuario(@Valid Usuario usuario, BindingResult bindingResult) 
	    {
		 if (bindingResult.hasErrors()) {
				return "detallesusuario";
			}
		 
		 Usuario us = new Usuario();
		 us.setId(usuario.getId());
		 us.setUser(usuario.getUser());
		 us.setPassword(usuario.getPassword());
		 us.setCliente(usuario.getCliente());
		 servicioUsuario.save(us);

		for(Mail mail: usuario.getMails()){
			mail.setUsuario(us);
			servicioMail.save(mail);
		}
		
	        return "redirect:/usuarios/";
	    }
	
	   //Método de borrado de un usuario
	 
	    @RequestMapping(path = "/borrar/{id}")
	    public String borrarUsuario(Model model, @PathVariable("id") Long id)
	    {
	    	servicioUsuario.delete(id);
	        return "redirect:/usuarios/";
	    }
	  
	   //Método para editar un usuario
	
	    @RequestMapping(path = {"/editar", "/editar/{id}"})
	    public String editarUsuario(Model model, @PathVariable("id") Optional<Long> id)
	    {
	        if (id.isPresent()) {
	            Usuario usuario = servicioUsuario.findById(id.get());
	            
	            model.addAttribute("usuario", usuario);

	        } else {
	            model.addAttribute("usuario", new Usuario());
	        }
	        
	        return "detallesusuario";
	    }
	
	
}
