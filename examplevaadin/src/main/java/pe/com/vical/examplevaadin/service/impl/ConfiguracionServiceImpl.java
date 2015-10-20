package pe.com.vical.examplevaadin.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.DateType;
import org.hibernate.type.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.com.vical.examplevaadin.dao.IParametroDao;
import pe.com.vical.examplevaadin.dao.IValorDao;
import pe.com.vical.examplevaadin.domain.Parametro;
import pe.com.vical.examplevaadin.domain.Usuario;
import pe.com.vical.examplevaadin.domain.Valor;
import pe.com.vical.examplevaadin.service.IConfiguracionService;
import pe.com.vical.examplevaadin.util.Busqueda;

@Service
public class ConfiguracionServiceImpl implements IConfiguracionService {

	@Autowired
	private IParametroDao parametroDao;
	@Autowired
	private IValorDao valorDao;
	
	public List<Parametro> listarParametros() {
		Busqueda busqueda = Busqueda.forClass(Parametro.class);
		return parametroDao.listar(busqueda);
	}

	@Override
	public List<Valor> listarValores(String codigoLista) {
		Busqueda busqueda = Busqueda.forClass(Valor.class);
		busqueda.createAlias("lista", "lis");
		busqueda.add(Restrictions.eq("lis.codigo", codigoLista));
		return valorDao.listar(busqueda);
	}

	@Override
	@Transactional
	public void grabarParametro(Parametro parametro, Usuario auditor) {
		if(parametro.getId() != null){
			parametro.setEditor(auditor);
			parametro.setEdicion(new Date());
			parametroDao.modificar(parametro);
		}else{
			parametro.setCreador(auditor);
			parametro.setCreacion(new Date());
			parametroDao.crear(parametro);
		}
	}

	@Override
	@Transactional
	public void eliminar(Parametro parametro) {
		parametroDao.eliminar(parametro.getId());
	}
	
	public List<Parametro> parametroTop(Integer cantidad){
		List<Parametro> parametros = new ArrayList<Parametro>();
		Busqueda busqueda = Busqueda.forClass(Parametro.class);
		ProjectionList projection = Projections.projectionList();
		projection.add(Projections.property("id"));
		projection.add(Projections.sqlProjection("case when edicion is not null then (edicion) else (creacion) end as fechaFiltro", new String[]{"fechaFiltro"}, new Type[]{DateType.INSTANCE}), "fechaFiltro");
		busqueda.setProjection(projection);
		busqueda.addOrder(Order.desc("fechaFiltro"));
		List<Object> resultados = parametroDao.proyectar(busqueda);
		List<Long> ids = new ArrayList<Long>();		
		for (Object object : resultados) {
			Object[] resultado = (Object[]) object;
			ids.add((Long) resultado[0]);
		}
		if(!ids.isEmpty()){
			Busqueda busParametro = Busqueda.forClass(Parametro.class);
			busParametro.add(Restrictions.in("id", ids));
			parametros = parametroDao.listar(busParametro);
		}
		return parametros;
	}

}
