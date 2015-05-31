package co.edu.udea.ingenieriaweb.xsoftbackend.dao.imp;

import java.util.ArrayList;
import java.util.List;

import javassist.bytecode.Descriptor.Iterator;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.ingenieriaweb.xsoftbackend.dao.UsuarioDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;

public class UsuarioDAOImp extends HibernateDaoSupport implements UsuarioDAO{
	private Session session = null;
	private Logger log;
	
	/**
	 * Implementacion del metodo definido en la interface UsuarioDAO
	 */
	@Override
	public void guardarUsuario(Usuario usuario) throws DataBaseException {
		
		log = Logger.getLogger(this.getClass());
		try{
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.save(usuario);
			session.flush();
			tx.commit();
		}catch(HibernateException e){
			log.error("Error guardando Cliente "+e);
			System.out.println("Error guardando Cliente "+e.toString());
			e.printStackTrace();
			throw new DataBaseException(e, "Error almacenando un Usuario en la BD");
		}catch(Exception e){
			System.out.println("Error en el UsuarioImp");
			e.printStackTrace();
			log.error("Error guardando Usuario"+e);
		}finally{
			/*Cerramos la sesion creada*/
			 if (session!=null) {
					session.close(); 	
			}
		}
	}
	
	/**
	 * Implementacion del metodo obtener usuario definido en la interface UsuarioDAO
	 */
	@Override
	public Usuario obtenerUsuario(String numeroId) throws DataBaseException {
		log = Logger.getLogger(this.getClass());
		Usuario usuario=null;
		try{
			//user = (Usuario) session.createQuery("SELECT usuario FROM Usuario WHERE numeroId="+numeroId).uniqueResult();
			/*Obtenemos la sesion mediante la cual nos vamos a conectar*/
			session = getSession();
			
			/*Le indicamos que vamos a hacer consultas sobre la clase Usuario*/
			Criteria criteria = session.createCriteria(Usuario.class);
			
			/*Obtenemos el usuario*/
			usuario =(Usuario)session.get(Usuario.class, numeroId);
			
			
			
			
		}catch(HibernateException e){
			log.error("Error obteniendo Usuario"+e);
			System.out.println("Error obteniendo "+e.toString());
			e.printStackTrace();
			throw new DataBaseException(e, "Error obtendiendo un Usuario en la BD");
		}catch(Exception e){
			System.out.println("Error en el UsuarioImp");
			e.printStackTrace();
			log.error("Error obteniendo Usuario"+e);
		}finally{
			/*Cerramos la sesion creada*/
			 if (session!=null) {
					session.close(); 	
			}
		}
		return usuario;
		
	}
	
	/**
	 * Implementacion del metodo definido en la interface UsuarioDAO, en este metodo 
	 * se hace uso de hibernate para hacer la respectiva transacciond de actualizacion en 
	 * la BD
	 */
	@Override
	public void actualizarUsuario(Usuario usuario) throws DataBaseException {
		log = Logger.getLogger(this.getClass());
		try{
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.merge(usuario);
			//session.flush();
			tx.commit();
		}catch(HibernateException e){
			log.error("Error guardando Cliente "+e);
			System.out.println("Error guardando Cliente "+e.toString());
			e.printStackTrace();
			throw new DataBaseException(e, "Error actualizando un Usuario en la BD");
		}catch(Exception e){
			System.out.println("Error en el UsuarioImp");
			e.printStackTrace();
			log.error("Error actualizando Usuario"+e);
		}finally{
			/*Cerramos la sesion creada*/
			 if (session!=null) {
					session.close(); 	
			}
		}
	}
	
	/**
	 * Implementaciond el metodo obtenerUsuarios definido en la interface UsuarioDAO.
	 * retorna una lista con todos los usuarios almacenados en la bd
	 */
	@Override
	public List<Usuario> obtenerUsuarios() throws DataBaseException {
		List<Usuario> listaUsuarios = null;
		try{
			
			Transaction tx = session.beginTransaction();
			listaUsuarios = (List<Usuario>) session.createQuery("from Usuario").list();
			tx.commit();
			
		}catch(HibernateException e){
			log.error("Error guardando Cliente "+e);
			System.out.println("Error guardando Cliente "+e.toString());
			e.printStackTrace();
			throw new DataBaseException(e, "Error almacenando un Usuario en la BD");
		}catch(Exception e){
			System.out.println("Error en el UsuarioImp");
			e.printStackTrace();
			log.error("Error guardando Usuario"+e);
		}finally{
			/*Cerramos la sesion creada*/
			 if (session!=null) {
					session.close(); 	
			}
		}
		
		return listaUsuarios;
	}
	
	/**
	 * Implementacion del metodo definido en UsuarioDAO. Permite eliminar un usuario en la bd dado su numeroid
	 */
	@Override
	public void eliminarUsuario(String numeroId) throws DataBaseException {
		log = Logger.getLogger(this.getClass());
		try{
			session = getSession();
			Transaction tx = session.beginTransaction();
			session.delete(this.obtenerUsuario(numeroId));
			//session.flush();
			tx.commit();
		}catch(HibernateException e){
			log.error("Error guardando Cliente "+e);
			System.out.println("Error guardando Cliente "+e.toString());
			e.printStackTrace();
			throw new DataBaseException(e, "Error actualizando un Usuario en la BD");
		}catch(Exception e){
			System.out.println("Error en el UsuarioImp");
			e.printStackTrace();
			log.error("Error actualizando Usuario"+e);
		}finally{
			/*Cerramos la sesion creada*/
			 if (session!=null) {
					session.close(); 	
			}
		}
		
	}

}
