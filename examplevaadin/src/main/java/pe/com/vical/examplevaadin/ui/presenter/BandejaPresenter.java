package pe.com.vical.examplevaadin.ui.presenter;

import pe.com.vical.examplevaadin.base.BaseDesign;
import pe.com.vical.examplevaadin.ui.desing.BandejaDesign;
import pe.com.vical.examplevaadin.ui.listener.IConfirm;
import pe.com.vical.examplevaadin.util.Inject;

import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

public class BandejaPresenter extends BandejaDesign implements ClickListener {
	private static final long serialVersionUID = 7537717385258067659L;

	public BandejaPresenter() {
		super();
		Inject.inject(this);
		cargarFormulario();
	}
	
	private void cargarFormulario() {
		btnSalir.addClickListener(this);
		cssContenido.addComponent(new GridPresenter());
//		cssContenido.addComponent(new ParametroPresenter());
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnSalir)){
			salir();
		}
	}

	private void salir() {
		IConfirm confirm = new IConfirm() {			
			@Override
			public void cancelar(Button event, Window window) {
				window.close();
			}
			
			@Override
			public void aceptar(Button event, Window window) {				
				window.close();
				UI.getCurrent().getPage().setLocation(BaseDesign.getStartLocation());
				getSession().close();
			}
		};
		BaseDesign.mostrarConfirmacion(confirm, "¿Seguro que desea cerrar sesión?");
	}

}
