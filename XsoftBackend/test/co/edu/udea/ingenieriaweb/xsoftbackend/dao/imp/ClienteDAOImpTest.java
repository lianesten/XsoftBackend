package co.edu.udea.ingenieriaweb.xsoftbackend.dao.imp;

import static org.junit.Assert.*;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.edu.udea.ingenieriaweb.xsoftbackend.dao.ClienteDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Usuario;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;

/**
 * 
 * @author Equipo de Desarrollo Xsoft 
 *
 */



/*Le especificamos que correremos la prueba con el Junit de Spring*/
@RunWith (SpringJUnit4ClassRunner.class)

/*Le decimos cual es el archivo de configuraciones del Spring*/
@ContextConfiguration (locations = "classpath:springConfig.xml")

/*Le decimos a Spring que en esta clase pueden haber cosas que deba inyectar*/
@Component
public class ClienteDAOImpTest {

/*Inyectamos Un objeto de la clase ClienteDAO*/
	
	@Autowired
	ClienteDAO clienteDao;
	
	
	
	@Test
	public void testObtenerCliente() {
		Cliente cliente = null;
		/**
		 * Identificacion del Uusario en la base de datos con nombre Pablo Andres
		 */
		final String identificacion = "120365485";
		try{
			ClienteDAO clienteDao = new ClienteDAOImp();
			cliente = clienteDao.obtenerCliente(identificacion);
			assertTrue(cliente.getId().equals("120365485"));
			Logger  log = Logger.getLogger(this.getClass());
			log.info(cliente.getNombres());
			log.info("Nombre del cliente");
		}catch(DataBaseException e){
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}
	
	
	/**
	 * 
	 * prueba de integración  para ingresar un Cliente en la DB
	 *  
	 */
	//@Test
//	public void testGuardarCliente() {
//		
//		
//		/**
//		 * Creamos el objeto de la clase Cliente
//		 */
//		Cliente cliente = new Cliente();
//		/**
//		 * Es necesario definir un objeto de la Clase ClienteId
//		 */
//		ClienteId idCliente = new ClienteId();
//		idCliente.setTipoId(0);
//		idCliente.setNumeroId("145312654");
//		/**
//		 * Es necesario definir un objeto de la Clase Usuario para indicar quien lo creo
//		 */
//		Usuario usuarioCrea = new Usuario(); 
//		usuarioCrea.setNumeroId("1038481420");
//		
//		/**
//		 * Es necesario crear un objeto de la clase tipoDocumento
//		 */
//		Tipodocumento tipoDocumento = new Tipodocumento();
//		tipoDocumento.setAbreviatura("c.c");
//		tipoDocumento.setNombre("Cedula de Ciudadania");
//		tipoDocumento.setIdTipoDocumento(1);
//		
//		/**
//		 * Llenamos los datos del Cliente
//		 */
//		cliente.setNombres("Pablo Andres");
//		cliente.setApellidos("Diaz");
//		cliente.setDireccion("Sur de Medellin");
//		cliente.setEmail("pandigo@gmail.com");
//		cliente.setFechaCreacion(new Date());
//		cliente.setId(idCliente);
//		cliente.setTelefonoFijo("5236324");
//		cliente.setTelefonoMovil("3211254785");
//		cliente.setUsuarioCrea(usuarioCrea);
//		cliente.setTipodocumento(tipoDocumento);
//		System.out.println("Cliente: " + cliente);
//		
//		try{
//			clienteDao.guardarCliente(cliente);
//			assertTrue(cliente!=null);
//		}catch(DataBaseException e){
//			e.printStackTrace();
//			System.out.println("Problema"+ e.toString());
//			fail("Not yet implemented");
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}
//		
//	}

}
