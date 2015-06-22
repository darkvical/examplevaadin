package pe.com.vical.examplevaadin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.com.vical.examplevaadin.service.ISeguridadService;

@Service
public class SeguridadServiceImpl implements ISeguridadService {

	@Override
	public boolean existeUsuario(String codigo) {
		List<String> codigos = new ArrayList<String>();
		codigos.add("vical001");
		codigos.add("sakura001");
		codigos.add("sasuke001");
		codigos.add("naruto001");
		int index = codigos.indexOf(codigo);
		if(index != -1){
			return true;
		}
		return false;
	}

}
