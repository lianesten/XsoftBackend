package co.edu.udea.ingenieriaweb.xsoftbackend.bl;

import co.edu.udea.ingenieriaweb.xsoftbackend.dto.ClienteId;
import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Tipodocumento;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.LogicException;

/**
 * Interface que contiene la logica del negocio que se va a implementar sobre la tabla Clientes 
 * en la Base de Datos
 * @author Equipo de Desarrollo Xsoft
 *
 */
public interface ClienteBl {
	
	/**
	 * Metodo que permite ingresar Un Cliente en la BD, en caso de ocurrir un error es capturado
	 * con la excepción DataBaseException
	 * @param id
	 * @param tipoDocumento
	 * @param nombres
	 * @param apellidos
	 * @param telefonoFijo
	 * @param telefonomovil
	 * @param email
	 * @param direccion
	 * @param usuarioCrea
	 * @throws DataBaseException
	 */
	 public void GuardarCliente(ClienteId id, Tipodocumento tipoDocumento,String nombres,
			 String apellidos, String telefonoFijo, String telefonomovil, String email,
			 String direccion, String usuarioCrea) throws DataBaseException, LogicException;

}
