package co.edu.udea.ingenieriaweb.xsoftbackend.dao.imp;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import co.edu.udea.ingenieriaweb.xsoftbackend.dao.ClienteDAO;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;

public class ClienteDAOImp extends HibernateDaoSupport  implements ClienteDAO {

	@Override
	public void guardarCliente(Cliente cliente) throws DataBaseException {
		Session session = null;
		Logger  log = Logger.getLogger(this.getClass());
		try{
			session = getSession(); 
			Transaction tx = session.beginTransaction();
            session.save(cliente);
            session.flush();
            tx.commit();
		/*catch para caturar algun posible Error*/	
		}catch(HibernateException e){
			log.error("Error guardando Cliente"+ e);
			System.out.println("Error Guardando Cliente"+ e.toString());
			e.printStackTrace();
			throw new DataBaseException(e, "Error almacenando un Cliente en la BD");
			
		}catch(Exception e){
			System.out.println("Error en el ClienteDAOImp");
			e.printStackTrace();
			log.error("Error guardando Cliente"+ e);
		}finally{
			/*Cerramos la sesion creada*/
//			 if (session!=null) {
//					session.close(); 	
//			}
		
		}
		
		
	}
	

	/**
	 * Metodo para obtener un Cliente por medio de su Identificación
	 * @throws DataBaseException 
	 */
	@Override
	public Cliente obtenerCliente(String identificacion) throws DataBaseException {

		Session session = null;
		try{
			
			Cliente cliente = null;
			/*Obtenemos la sesion mediante la cual nos vamos a conectar*/
			session = getSession();
			
			/*Le indicamos que vamos a hacer consultas sobre la clase Cliente*/
			Criteria criteria = session.createCriteria(Cliente.class);
			
			/*Obtenemos la lista de las Ciudades*/
			cliente =(Cliente)session.get(Cliente.class, identificacion);
			
			return cliente;
			
		/*catch para caturar algun posible Error*/	
		}catch(HibernateException e){
			throw new DataBaseException(e);
			
		}finally{
			/*Cerramos la sesion creada*/
			 if (session!=null) {
					session.close(); 	
			}
		}	 
	}

	
}
