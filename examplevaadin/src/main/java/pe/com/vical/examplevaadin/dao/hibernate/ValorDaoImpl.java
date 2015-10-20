package pe.com.vical.examplevaadin.dao.hibernate;

import org.springframework.stereotype.Repository;

import pe.com.vical.examplevaadin.dao.IValorDao;
import pe.com.vical.examplevaadin.domain.Valor;

@Repository
public class ValorDaoImpl extends BaseDAOImpl<Valor, Integer> implements IValorDao {
	private static final long serialVersionUID = 4954710448103512219L;

	@Override
	protected Class<Valor> getClase() {
		return Valor.class;
	}
}
