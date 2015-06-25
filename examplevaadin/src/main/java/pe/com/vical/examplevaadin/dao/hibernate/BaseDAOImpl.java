package pe.com.vical.examplevaadin.dao.hibernate;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import pe.com.vical.examplevaadin.dao.IBaseDAO;
import pe.com.vical.examplevaadin.util.Busqueda;

public abstract class BaseDAOImpl<Entidad extends Serializable, Id extends Serializable> extends HibernateDaoSupport implements IBaseDAO<Entidad, Id> {

	private static final long serialVersionUID = -843202252066514168L;
	
	protected Class<Entidad> clase;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public BaseDAOImpl() {
		super();
		this.clase = getClase();
	}
	
	@PostConstruct
	private void postConstruct(){
		super.setSessionFactory(sessionFactory);
	}
	
	protected abstract Class<Entidad> getClase();
	
	@Override
	public Entidad crear(Entidad entidad) {
		getHibernateTemplate().persist(entidad);
		return entidad;
	}

	@Override
	public Entidad obtener(Id id) {
		return getHibernateTemplate().get(getClase(), id);
	}

	@Override
	public Entidad modificar(Entidad entidad) {
		getHibernateTemplate().update(entidad);
		getHibernateTemplate().flush();
		return entidad;		
	}

	@Override
	public void eliminar(Id id) {
		getHibernateTemplate().delete(obtener(id));
		getHibernateTemplate().flush();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Entidad> listar(final Busqueda busqueda){
		return (List<Entidad>) this.getHibernateTemplate().executeWithNativeSession(
				new HibernateCallback<List<Entidad>>() {
					public List<Entidad> doInHibernate(Session session){
						Criteria criteria = busqueda.getExecutableCriteria(session);
	                    criteria.setFirstResult(busqueda.getFirstResult());
	                    if (busqueda.getMaxResults() > 0) {
	                    	criteria.setMaxResults(busqueda.getMaxResults());
	                    }
	                    return (List<Entidad>) criteria.list();
	                }
				});
	}

}