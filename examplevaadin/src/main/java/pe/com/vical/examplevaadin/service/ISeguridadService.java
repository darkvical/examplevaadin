package pe.com.vical.examplevaadin.service;

import pe.com.vical.examplevaadin.domain.Usuario;

public interface ISeguridadService {

	Usuario login(String codigo, String password);

}
