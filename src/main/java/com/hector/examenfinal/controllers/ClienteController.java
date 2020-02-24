package com.hector.examenfinal.controllers;


import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;

import com.hector.examenfinal.models.entity.Cliente;
import com.hector.examenfinal.models.entity.Mail;
import com.hector.examenfinal.models.entity.Usuario;
import com.hector.examenfinal.models.services.IClienteService;

//Controlador de Clientes

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	//Declaración de servicios
	
	@Autowired
	private IClienteService servicioCliente;
		

	//Método obtención de todos los clientes
	
	@GetMapping("/")
	public String listarClientes(Model model) {
		List<Cliente> listaClientes = servicioCliente.findAll();
		model.addAttribute("clientes", listaClientes);
		return "clientes";
	}
	
	//Método de filtrado de clientes que no son usuarios
	
	@RequestMapping(path = {"filtrarclientes"})
    public String filtrarClientes(Model model)
    {
		List<Cliente> listaClientes = servicioCliente.findAllSinUsuario();	
		model.addAttribute("clientes", listaClientes);
		return "clientes";
    }
	
	//Método de buscador de clientes
	
	@RequestMapping(path = "buscar", method = RequestMethod.POST)
    public String buscar(Model model ,@RequestParam(value = "nombre") String nombre)
    {
		List<Cliente> listaClientes = servicioCliente.FindByNombre(nombre);	
		model.addAttribute("clientes", listaClientes);
		return "clientes";
    }
	
	//Método de creación de un cliente nuevo y validado
	
	@RequestMapping(path = "crear", method = RequestMethod.POST)
    public String crearCliente(@Valid Cliente cliente, BindingResult bindingResult) 
    {
		 if (bindingResult.hasErrors()) {
				return "detallescliente";
			}
		cliente.setFechaAlta(new Date());
        servicioCliente.save(cliente);
        return "redirect:/clientes/";
    }
	
	//Método de borrado de un cliente existente

	@RequestMapping(path = "borrar/{id}")
    public String borrarCliente(Model model, @PathVariable("id") Long id)
    {
        servicioCliente.delete(id);
        return "redirect:/clientes/";
    }

	//Método para editar cliente

	 @RequestMapping(path = {"editar", "editar/{id}"})
	    public String editarCliente(Model model, @PathVariable("id") Optional<Long> id)
	    {
	        if (id.isPresent()) {
	            Cliente cliente = servicioCliente.findById(id.get());
	            model.addAttribute("cliente", cliente);
	        } else {
	            model.addAttribute("cliente", new Cliente());
	        }
	        return "detallescliente";
	    }
	    
		//Método que añade un usuario nuevo
	    
	 @RequestMapping(path = {"anyadirusuario/{id}"})
	    public String anyadirUsuario(Model model, @PathVariable("id") Optional<Long> id)
	    {
	            Cliente cliente = servicioCliente.findById(id.get());
	           
	            Usuario us = new Usuario();
	            List<Mail> mail = new ArrayList<Mail>(1);
	            Mail m = new Mail();
	     
	            m.setUsuario(us);
	            mail.add(m);
	           
	            us.setMails(mail);
	            us.setCliente(cliente);
	    		model.addAttribute("usuario", us);
	    		
	        return "detallesusuario";
	    }
	     
	    
	    
	    

	

}
