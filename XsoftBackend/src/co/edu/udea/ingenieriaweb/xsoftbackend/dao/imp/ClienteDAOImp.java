package co.edu.udea.ingenieriaweb.xsoftbackend.dao.imp;

import org.apache.log4j.Logger;
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
			throw new DataBaseException(e, "Error almacenando un Cliente en la BD");
			
		}finally{
			/*Cerramos la sesion creada*/
//			 if (session!=null) {
//					session.close(); 	
//			}
		
		}
		
		
	}

	
}
