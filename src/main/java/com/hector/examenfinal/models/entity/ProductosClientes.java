package com.hector.examenfinal.models.entity;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//Entidad Compra

@Entity
@Table(name="productos_clientes"
    ,schema="public"
)
public class ProductosClientes  implements java.io.Serializable {

  //Atributos
	
	 private static final long serialVersionUID = 1L;
	 
	 private ProductosClientesId id;
     private Cliente cliente;
     private Producto producto;

  //Constructores
     
    public ProductosClientes() {
    }

    public ProductosClientes(ProductosClientesId id, Cliente cliente, Producto producto) {
       this.id = id;
       this.cliente = cliente;
       this.producto = producto;
    }
   
    //Propiedades
    
    @EmbeddedId
    @AttributeOverrides( {
        @AttributeOverride(name="clienteId", column=@Column(name="cliente_id", nullable=false) ), 
        @AttributeOverride(name="productoId", column=@Column(name="producto_id", nullable=false) ), 
        @AttributeOverride(name="fecha", column=@Column(name="fecha", nullable=false, length=13) ) } )
    public ProductosClientesId getId() {
        return this.id;
    }
    
    public void setId(ProductosClientesId id) {
        this.id = id;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cliente_id", nullable=false, insertable=false, updatable=false)
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="producto_id", nullable=false, insertable=false, updatable=false)
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }




}