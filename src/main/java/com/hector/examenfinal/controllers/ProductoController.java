package com.hector.examenfinal.controllers;

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
import com.hector.examenfinal.models.entity.Producto;
import com.hector.examenfinal.models.services.IProductoService;

//Controlador de productos

@Controller
@RequestMapping("/productos")
public class ProductoController {

	//Declaración de servicios
	
	@Autowired
	private IProductoService servicioProducto;
	
	//Meétodo de obtención de todos los productos
	
	@GetMapping("/")
	public String listarProductos(Model model) {
		List<Producto> listaProductos = servicioProducto.findAll();
		model.addAttribute("productos", listaProductos);
		return "productos";
	}
	
	//Método de creación de nuevo producto y validado
	
	  @RequestMapping(path = "crear", method = RequestMethod.POST)
	    public String crearProducto(@Valid Producto producto, BindingResult bindingResult ) 
	    {
		  if (bindingResult.hasErrors()) {
				return "detallesproducto";
			}
			producto.setFechaAlta(new Date());
			servicioProducto.save(producto);
	        return "redirect:/productos/";
	    }
	  
	  //Método de borrado de un producto
	
	  @RequestMapping(path = "borrar/{id}")
	    public String borrarProducto(Model model, @PathVariable("id") Long id)
	    {
	    	servicioProducto.delete(id);
	        return "redirect:/productos/";
	    }
	  
	  //Método para editar un producto
	  
	 @RequestMapping(path = {"editar", "/editar/{id}"})
	    public String editarProducto(Model model, @PathVariable("id") Optional<Long> id)
	    {
	        if (id.isPresent()) {
	            Producto producto = servicioProducto.findById(id.get());
	            model.addAttribute("producto", producto);
	        } else {
	            model.addAttribute("producto", new Producto());
	        }
	        return "detallesproducto";
	    }
	     
	   
	 

	
}
