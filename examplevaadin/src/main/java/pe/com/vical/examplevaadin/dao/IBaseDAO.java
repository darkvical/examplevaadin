package pe.com.vical.examplevaadin.dao;

import java.io.Serializable;
import java.util.List;

import pe.com.vical.examplevaadin.util.Busqueda;

public interface IBaseDAO<Entidad, Id extends Serializable> extends Serializable {

	/**
	 * 
	 * @param entidad
	 * @return
	 */
	Entidad crear(Entidad entidad);
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	Entidad obtener(Id id);
	
	/**
	 * 
	 * @param entidad
	 * @return
	 */
	Entidad modificar(Entidad entidad);
	
	/**
	 * 
	 * @param id
	 */
	void eliminar(Id id);
	
	/**
	 * 
	 * @param busqueda
	 * @return
	 */
	List<Entidad> listar(Busqueda busqueda);
}
