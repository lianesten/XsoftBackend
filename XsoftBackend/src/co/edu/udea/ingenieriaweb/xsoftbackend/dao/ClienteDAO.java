package co.edu.udea.ingenieriaweb.xsoftbackend.dao;

import co.edu.udea.ingenieriaweb.xsoftbackend.dto.Cliente;
import co.edu.udea.ingenieriaweb.xsoftbackend.exception.DataBaseException;


/**
 * 
 * @author Equipo Desarrollo Xsoft 
 * Interfaces que contienelos metodo que permiten hacer operaciones de el DTO Cliente en la DB
 *
 */
public interface ClienteDAO {
	
	public void guardarCliente(Cliente cliente) throws DataBaseException;

}
