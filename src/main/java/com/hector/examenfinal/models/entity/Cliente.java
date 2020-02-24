package com.hector.examenfinal.models.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

//Entidad Cliente

@Entity
@Table(name="clientes"
    ,schema="public"
)
@SequenceGenerator(name="seqClientes", initialValue=10, allocationSize=100)
public class Cliente  implements java.io.Serializable {

	//Atributos
	
	 private static final long serialVersionUID = 1L;
	
	 private Long id;
     private String nombre;
     private String apellido;
     private Set<Usuario> usuarios = new HashSet<Usuario>(0);

     private Date fechaAlta;
     private Set<ProductosClientes> productosClientes = new HashSet<ProductosClientes>(0);

     
   //Constructores
     
    public Cliente() {
    }

    public Cliente(Long id) {
        this.id = id;
    }
    public Cliente(Long id, String nombre, String apellido, Date date, Set<Usuario> usuarios, Set<ProductosClientes> productosClientes) {
       this.id = id;
       this.nombre = nombre;
       this.apellido = apellido;
       this.fechaAlta = date;
       this.productosClientes = productosClientes;
       this.usuarios = usuarios;

    }
    
    //Propiedades
    
    @Id 
 	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator="seqClientes")
    @Column(unique=true, nullable=false)
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Valid
    @NotEmpty(message="No puede estar vacío")
	@Column(nullable=false)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Column(name="apellido")
    public String getApellido() {
        return this.apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    @Temporal(TemporalType.DATE)
    @Column(name="create_at", length=13)
    public Date getFechaAlta() {
        return this.fechaAlta;
    }
    
    public void setFechaAlta(Date date) {
        this.fechaAlta = date;
    }
    
    @OneToMany(fetch=FetchType.LAZY, mappedBy="cliente",cascade=CascadeType.ALL)
    public Set<Usuario> getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @JsonIgnore
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="cliente")
    public Set<ProductosClientes> getProductosClientes() {
        return this.productosClientes;
    }
    
    public void setProductosClientes(Set<ProductosClientes> productosClientes) {
        this.productosClientes = productosClientes;
    }

    public void addProductosClientes(ProductosClientes productosClientes) {
        this.productosClientes.add(productosClientes);
    }
    
    


}
