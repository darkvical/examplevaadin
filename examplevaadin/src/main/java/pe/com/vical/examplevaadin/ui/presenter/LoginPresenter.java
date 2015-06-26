package pe.com.vical.examplevaadin.ui.presenter;

import org.springframework.beans.factory.annotation.Autowired;

import pe.com.vical.examplevaadin.PrincipalUI;
import pe.com.vical.examplevaadin.base.BaseDesign;
import pe.com.vical.examplevaadin.service.ISeguridadService;
import pe.com.vical.examplevaadin.ui.desing.LoginDesign;
import pe.com.vical.examplevaadin.util.Inject;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class LoginPresenter extends LoginDesign implements ClickListener {
	
	private static final long serialVersionUID = 7641191264646023033L;
	
	@Autowired
	private ISeguridadService seguridadService;
	
	public LoginPresenter() {
		super();
		Inject.inject(this);
		btnIngresar.addClickListener(this);
	}
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnIngresar)){
			ingresar();
		}
	}
	private void ingresar() {
		String usuario = txtUsuario.getValue();
		String password =txtPassword.getValue();
		String codigo = usuario+password;
		if(seguridadService.existeUsuario(codigo)){
			BaseDesign.setContenido(new BandejaPresenter());
		}
	}

}
