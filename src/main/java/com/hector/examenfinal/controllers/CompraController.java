package com.hector.examenfinal.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.hector.examenfinal.models.entity.Cliente;
import com.hector.examenfinal.models.entity.Producto;
import com.hector.examenfinal.models.entity.ProductosClientes;
import com.hector.examenfinal.models.entity.ProductosClientesId;
import com.hector.examenfinal.models.services.IClienteService;
import com.hector.examenfinal.models.services.IProductoService;
import com.hector.examenfinal.models.services.IProductosClientesService;

//Controlador de compras

@Controller
@RequestMapping("/compras")
public class CompraController {

	//Declaración de servicios
	
		@Autowired
		private IProductoService servicioProducto;
	
	    @Autowired
	    private IProductosClientesService servicioProductosClientes;
	 
	    @Autowired
	    private IClienteService servicioCliente;
	   
	    //Método de obtención de todas las compras

	    @GetMapping("/")
		public String listarCompras(Model model){
			
			 List<ProductosClientes> listaProductosClientes = servicioProductosClientes.findAll();
		     
		    model.addAttribute("compras", listaProductosClientes);
		        
			 return "compras";
		}

	    //Método de llamada al formulario de compras
	   
	    @RequestMapping(path = {"/comprar"})
	    public String nuevoProductoCliente(Model model)
	    {

	    	 List<Cliente> listaClientes = servicioCliente.findAll();
	         List<Producto> listaProductos = servicioProducto.findAll();
	  
	         model.addAttribute("clientes", listaClientes);
	         model.addAttribute("productos", listaProductos);
	        
	      
	             model.addAttribute("productosClientesId", new ProductosClientesId());
	         
	         return "detallescompra";
	       }
	    
	    //Método de borrado de una compra
	    
	    @RequestMapping(path = "/borrar/{clienteId}/{productoId}/{fecha}")
	    public String borrarProductoCliente(Model model, @PathVariable("clienteId") long clienteId,@PathVariable("productoId")  long productoId,@PathVariable("fecha") String fecha) throws ParseException
	    {
	    	ProductosClientesId p = new ProductosClientesId();
	    	
			p.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
			p.setClienteId(clienteId);
			p.setProductoId(productoId);
	    	servicioProductosClientes.delete(p);
	        return "redirect:/compras/";
	    }

	    //Método para editar una compra
	    
	    @RequestMapping(path = { "/editar/{clienteId}/{productoId}/{fecha}"})
	    public String editarProductoCliente(Model model, @PathVariable("clienteId") long clienteId,@PathVariable("productoId")  long productoId,@PathVariable("fecha") String fecha) throws ParseException
	    {

	        List<Cliente> listaClientes = servicioCliente.findAll();
	        List<Producto> listaProductos = servicioProducto.findAll();
	 
	        model.addAttribute("clientes", listaClientes);
	        model.addAttribute("productos", listaProductos);
		    ProductosClientesId p = new ProductosClientesId();
	    	
			p.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(fecha));
			p.setClienteId(clienteId);
			p.setProductoId(productoId);
			
	        model.addAttribute("productosClientesId", p);

	        return "detallescompra";
	    }
	 
	    //Metodo de compra de producto
	    
	    @RequestMapping(path = "/crear", method = RequestMethod.POST)
	    public String comprar(ProductosClientesId productosClientesId) throws ParseException 
	    {
			
	    	Cliente clienteActual = servicioCliente.findById(productosClientesId.getClienteId());
			Producto productoActual = servicioProducto.findById(productosClientesId.getProductoId());
					
			ProductosClientesId p = new ProductosClientesId();
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			String date = simpleDateFormat.format(new Date());
			p.setFecha(new SimpleDateFormat("yyyy-MM-dd").parse(date));
			p.setClienteId(productosClientesId.getClienteId());
			p.setProductoId(productosClientesId.getProductoId());
				
		
		      ProductosClientes productosClientes = new ProductosClientes();
				productosClientes.setId(p);
				productosClientes.setCliente(clienteActual);
				productosClientes.setProducto(productoActual);
				
				servicioProductosClientes.save(productosClientes);
						
	        return "redirect:/compras/";
	    }
}
