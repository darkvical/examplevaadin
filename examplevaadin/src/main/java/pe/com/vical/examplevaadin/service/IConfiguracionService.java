package pe.com.vical.examplevaadin.service;

import java.util.List;

import pe.com.vical.examplevaadin.domain.Parametro;
import pe.com.vical.examplevaadin.domain.Valor;

public interface IConfiguracionService {
	
	List<Parametro> listarParametros();
	List<Valor> listarValores(String codigoLista);
}
