package pe.com.vical.examplevaadin.ui.presenter;

import org.springframework.beans.factory.annotation.Autowired;

import pe.com.vical.examplevaadin.base.BaseDesign;
import pe.com.vical.examplevaadin.domain.Usuario;
import pe.com.vical.examplevaadin.service.ISeguridadService;
import pe.com.vical.examplevaadin.ui.desing.LoginDesign;
import pe.com.vical.examplevaadin.util.Inject;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutListener;
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
		eventoShorcut();
	}
	
	private void eventoShorcut() {
		lytLogin.addShortcutListener(new ShortcutListener("", KeyCode.ENTER, null) {
			private static final long serialVersionUID = -1522398285652966120L;
			@Override
			public void handleAction(Object sender, Object target) {
				if(target.equals(txtUsuario) || target.equals(txtPassword)){
					btnIngresar.click();
				}
			}
		});
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnIngresar)){
			ingresar();
		}
	}
	
	private void ingresar() {
		String codigo = txtUsuario.getValue().toUpperCase();
		String password =txtPassword.getValue();
		Usuario usuario = seguridadService.login(codigo, password);
		if(usuario != null){
			BaseDesign.setUsuarioSession(usuario);
			BaseDesign.setContenido(new BandejaPresenter());
		}
	}

}
