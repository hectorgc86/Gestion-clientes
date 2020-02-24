package com.hector.examenfinal.models.entity;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Entidad Producto

@Entity
@Table(name="productos"
    ,schema="public"
)
public class Producto  implements java.io.Serializable {

	//Atributos
	
	 private static final long serialVersionUID = 1L;
	
	 private Long productoId = (Long)System.currentTimeMillis();
     private String descripcion;
     private Integer precio;
     private Date fechaAlta;
     private Boolean disponibilidad;
     private Set<ProductosClientes> productosClientes = new HashSet<ProductosClientes>(0);

     //Constructores
     
    public Producto() {
    }

    public Producto(Long productoId) {
        this.productoId = productoId;
    }
    public Producto(Long productoId, String descripcion, Integer precio, Date fechaAlta, Boolean disponibilidad, Set<ProductosClientes> productosClientes) {
       this.productoId = productoId;
       this.descripcion = descripcion;
       this.precio = precio;
       this.fechaAlta = fechaAlta;
       this.disponibilidad = disponibilidad;
       this.productosClientes = productosClientes;
    }
   
    //Propiedades
    
    @Id 
 	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="producto_id", unique=true, nullable=false)
    public Long getProductoId() {
        return this.productoId;
    }
    
    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    @Valid
	@Size(max=100, message="El tamaño no puede superar los 100 caracteres")
    @Column(name="descripcion", length=100)
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    @Column(name="precio")
    public Integer getPrecio() {
        return this.precio;
    }
    
    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="fecha_alta", length=13)
    public Date getFechaAlta() {
        return this.fechaAlta;
    }
    
    public void setFechaAlta(Date date) {
        this.fechaAlta = date;
    }

    
    @Column(name="disponibilidad")
    public Boolean getDisponibilidad() {
        return this.disponibilidad;
    }
    
    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY, mappedBy="producto")
    public Set<ProductosClientes> getProductosClientes() {
        return this.productosClientes;
    }
    
    public void setProductosClientes(Set<ProductosClientes> productosClientes) {
        this.productosClientes = productosClientes;
    }




}


