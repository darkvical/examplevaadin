package pe.com.vical.examplevaadin.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.vical.examplevaadin.dao.IParametroDao;
import pe.com.vical.examplevaadin.dao.IValorDao;
import pe.com.vical.examplevaadin.domain.Parametro;
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

}
