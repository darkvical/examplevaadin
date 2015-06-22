package pe.com.vical.examplevaadin.dao.hibernate;

import org.springframework.stereotype.Repository;

import pe.com.vical.examplevaadin.dao.ISeguridadDao;
import pe.com.vical.examplevaadin.domain.Usuario;

@Repository
public class SeguridadServiceDaoImpl extends BaseDAOImpl<Usuario, Long> implements ISeguridadDao {
	
	private static final long serialVersionUID = -5441106036610294479L;

	@Override
	protected Class<Usuario> getClase() {
		return Usuario.class;
	}
}
