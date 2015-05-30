package co.edu.udea.ingenieriaweb.xsoftbackend.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



/**
 * 
 * @author Equipo Desarrollo Xsoft
 * DTO de la tabla Cliente en la Base de datos
 */
public class Cliente  implements java.io.Serializable {


    private String numeroId;
    private Usuario usuarioCrea;
    private String nombres;
    private String apellidos;
    private String telefonoFijo;
    private String telefonoMovil;
    private String email;
    private String direccion;
    private Date fechaCreacion;
    private Set ventas = new HashSet(0);
     

     /**
      * Constructor vacio de la Clase
      */
    public Cliente() {
    }

    /**
     * Contructor que permite ingresar un 
     * @param id
     * @param tipodocumento
     * @param nombres
     * @param apellidos
     * @param telefonoFijo
     * @param telefonoMovil
     * @param email
     * @param direccion
     */
    public Cliente(String id, String nombres, String apellidos, String telefonoFijo, String telefonoMovil, String email, String direccion) {
       this.numeroId = id;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.telefonoFijo = telefonoFijo;
       this.telefonoMovil = telefonoMovil;
       this.email = email;
       this.direccion = direccion;
    }
    
    public Cliente(String numeroId, Usuario usuario, String nombres, String apellidos, String telefonoFijo, String telefonoMovil, String email, String direccion, Date fechaCreacion, Set ventas) {
        this.numeroId = numeroId;
        this.usuarioCrea = usuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefonoFijo = telefonoFijo;
        this.telefonoMovil = telefonoMovil;
        this.email = email;
        this.direccion = direccion;
        this.fechaCreacion = fechaCreacion;
        this.ventas = ventas;
     }
   
    /**
     * Metodo que permite obtener el id de un cliente
     * @return id
     */
    public String getId() {
        return this.numeroId;
    }
    /**
     * Metodo que permite ingresar el id de un Cliente
     * @param id
     */
    public void setId(String id) {
        this.numeroId = id;
    }
    
    /**
     * Permite obtener los nombres de un cliente
     * @return nombres
     */
    public String getNombres() {
        return this.nombres;
    }
    /**
     * Permite almacer los nombres de los clientes en el objeto Cliente
     * @param nombres
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    /**
     * Permite obtener los apellidos de un Cliente
     * @return apellidos
     */
    public String getApellidos() {
        return this.apellidos;
    }
    /**
     * Permite almacenar los apellidos de un cliente
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    /**
     * Metodo que permite obtener el número telefonico de un Cliente
     * @return telefonoFijo
     */
    public String getTelefonoFijo() {
        return this.telefonoFijo;
    }
    /**
     * Metodo que permite almacenar el número telefonico de un Cliente
     * @param telefonoFijo
     */
    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }
    /**
     * Metodo que devuelve un String que contiene el número del telefono movil de un cliente
     * @return telefonoMovil
     */
    public String getTelefonoMovil() {
        return this.telefonoMovil;
    }
    /**
     * Metodo para ingresar el telefono movil de un Cliente
     * @param telefonoMovil
     */
    public void setTelefonoMovil(String telefonoMovil) {
        this.telefonoMovil = telefonoMovil;
    }
    /**
     * Metodo que permite obtener un String con el Email del Cliente
     * @return email
     */
    public String getEmail() {
        return this.email;
    }
    /**
     * Metodo que permite almacenar el email de un Cliente
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Metodo que permite obtener un String con la dirección de un Cliente
     * @return direccion
     */
    public String getDireccion() {
        return this.direccion;
    }
    /**
     * Metodo para almacenar la dirección de un Cliente
     * @param direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

	public Usuario getUsuarioCrea() {
		return usuarioCrea;
	}

	public void setUsuarioCrea(Usuario usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getNumeroId() {
		return numeroId;
	}

	public void setNumeroId(String numeroId) {
		this.numeroId = numeroId;
	}

	public Set getVentas() {
		return ventas;
	}

	public void setVentas(Set ventas) {
		this.ventas = ventas;
	}

    



}


