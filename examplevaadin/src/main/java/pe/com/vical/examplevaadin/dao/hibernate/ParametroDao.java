package pe.com.vical.examplevaadin.dao.hibernate;

import org.springframework.stereotype.Repository;

import pe.com.vical.examplevaadin.dao.IParametroDao;
import pe.com.vical.examplevaadin.domain.Parametro;

@Repository
public class ParametroDao extends BaseDAOImpl<Parametro, Long> implements IParametroDao {

	private static final long serialVersionUID = -6997610036225453638L;

	@Override
	protected Class<Parametro> getClase() {
		return Parametro.class;
	}

}
