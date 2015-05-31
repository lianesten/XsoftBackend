package co.edu.udea.ingenieriaweb.xsoftbackend.bl.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import co.edu.udea.ingenieriaweb.xsoftbackend.bl.UsuarioBl;
import co.edu.udea.ingenieriaweb.xsoftbackend.dao.UsuarioDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;
/**
 * Clase que implementa todos los metodos definidos en la interface UsuarioBl
 * @author Xsoft developers Team
 *
 */
public class UsuarioBLImp implements UsuarioBl{
	
	UsuarioDAO usuarioDAO;
	private Usuario usuario;
	
	public UsuarioDAO get(){
		return usuarioDAO;
	}
	
	public void set(UsuarioDAO usuarioDAO){
		this.usuarioDAO = usuarioDAO;
	}
	/**
	 * Metodo para almacenar un nuevo usuario en la Base de datos
	 */
	@Override
	public void guardarUsuario(String numeroId, String nombres,
			String apellidos, int privilegio, String username, String password,
			String email) throws DataBaseException, LogicException {
			
		if(numeroId==null|| "".equals(numeroId)){
			throw new LogicException("La cedula no puede ser vacia ni Nula");
		}
		/*Hacer todas las demas validaciones correspondientes a las reglas del necogio*/
		
		usuario = new Usuario();
		usuario.setNumeroId(numeroId);
		usuario.setNombres(nombres);
		usuario.setApellidos(apellidos);
		usuario.setPrivilegio(privilegio);
		usuario.setUsername(username);
		usuario.setPassword(password);
		usuario.setEmail(email);
		try{
			usuarioDAO.guardarUsuario(usuario);
		}catch(DataBaseException e){
			Logger  log = Logger.getLogger(this.getClass());
			log.error("Error en el almacenamiento de Cliente: " +e);
			
		}
		
	}
	/**
	 * Metodo para obtener un usuari oen la Bd dado su numeroId
	 */
	@Override
	public Usuario obtenerUsuario(String numeroId) throws DataBaseException,
			LogicException {
		if(numeroId==null || "".equals(numeroId)){
			throw new LogicException("Se debe digitar la identificacion del usuario a obtener");
		}
		
		try{
		usuario = usuarioDAO.obtenerUsuario(numeroId);
		}catch(DataBaseException e){
			Logger  log = Logger.getLogger(this.getClass());
			log.error("Error en el almacenamiento de Cliente: " +e);
			
		}
		return usuario;
	}
	/**
	 * Implementaci�n del metodo actualizrUsuario definido en la interface, este metodo hace uso del 
	 * POJO Usuario para enviarlo al DAO y hacer la respectiva operacion de UPDATe en la BD
	 */
	@Override
	public void actualizarUsuario(String numeroId,String nombres,String apellidos,
			int privilegio,String username,String password,String email) throws DataBaseException,
			LogicException {
		
		usuario = new Usuario();
		usuario.setNumeroId(numeroId);
		usuario.setNombres(nombres);
		usuario.setApellidos(apellidos);
		usuario.setPrivilegio(privilegio);
		usuario.setUsername(username);
		usuario.setPassword(password);
		usuario.setEmail(email);
		
		try{
			 usuarioDAO.actualizarUsuario(usuario);
		}catch(DataBaseException e){
			Logger  log = Logger.getLogger(this.getClass());
			log.error("Error actualizando usuario: " +e);
			
		}
		
		
		
	}
	/**
	 * Implementacion del metodo definido en la interface que permite obtener en un array de tipo Usurio
	 * todos los usuarios registrdos
	 * previamente en la base de datos 
	 */
	@Override
	public List<Usuario> obtenerUsuarios() throws DataBaseException,
			LogicException {
		List<Usuario> listaUsuarios= new ArrayList<Usuario>();
		listaUsuarios = usuarioDAO.obtenerUsuarios();
		return listaUsuarios;
	}
	/**
	 * Implementacion del metodo definido en la interface que permite eliminar un usuario dado su numeroId 
	 * y registrado previamente en la base de datos.
	 */
	@Override
	public void eliminarUsuario(String numeroId) throws DataBaseException,
			LogicException {
		if(numeroId==null || "".equals(numeroId)){
			throw new LogicException("Se debe digitar la identificacion del usuario a eliminar");
		}
		
		try{
			usuarioDAO.eliminarUsuario(numeroId);
		}catch(DataBaseException e){
			Logger  log = Logger.getLogger(this.getClass());
			log.error("Error eliminando usuario: " +e);
			
		}
		
	}

	

}
