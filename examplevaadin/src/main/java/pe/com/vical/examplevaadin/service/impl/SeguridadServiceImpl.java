package pe.com.vical.examplevaadin.service.impl;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.vical.examplevaadin.dao.ISeguridadDao;
import pe.com.vical.examplevaadin.domain.Usuario;
import pe.com.vical.examplevaadin.service.ISeguridadService;
import pe.com.vical.examplevaadin.util.Busqueda;

@Service
public class SeguridadServiceImpl implements ISeguridadService {
	
	@Autowired
	private ISeguridadDao seguridadDao;
	
	@Override
	public Usuario login(String codigo, String password) {
		Busqueda busqueda = Busqueda.forClass(Usuario.class);
		busqueda.add(Restrictions.eq("codigo", codigo));
		busqueda.add(Restrictions.eq("password", password));
		List<Usuario> usuarios = seguridadDao.listar(busqueda);
		Usuario usuario =null;
		if(usuarios != null && usuarios.size() > 0){
			usuario = usuarios.get(0);
		}
		return usuario;
	}
}
