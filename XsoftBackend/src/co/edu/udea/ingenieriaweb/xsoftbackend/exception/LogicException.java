package co.edu.udea.ingenieriaweb.xsoftbackend.exception;


/**
 * Clase que permite controlar las excepciones de datos faltantes producidas por el Usuario
 * @author JoaquinD
 *
 */
public class LogicException extends Exception {
	
	public LogicException(String mensaje) {
		super(mensaje);
	}

}
