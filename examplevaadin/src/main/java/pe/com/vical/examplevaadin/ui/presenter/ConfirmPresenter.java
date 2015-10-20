package pe.com.vical.examplevaadin.ui.presenter;

import com.vaadin.event.ShortcutAction;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.event.ShortcutListener;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Window;

import pe.com.vical.examplevaadin.ui.desing.ConfirmDesign;
import pe.com.vical.examplevaadin.ui.listener.IConfirm;

public class ConfirmPresenter extends ConfirmDesign implements ClickListener{
	private static final long serialVersionUID = -1795279386120075140L;
	
	private IConfirm iConfirm;
	private static Boolean IS_ACEPTAR_FOCUS = true;
	
	public ConfirmPresenter(IConfirm iConfirm){
		super();
		this.iConfirm = iConfirm;
		btnAceptar.addClickListener(this);
		btnCancelar.addClickListener(this);
		btnAceptar.focus();
		eventos();
	}
	
	public void setMensaje(String mensaje){
		lblMensaje.setValue(mensaje);
	}
	
	private void eventos() {
		lytContenedor.addShortcutListener(new ShortcutListener("", KeyCode.TAB, null) {
			private static final long serialVersionUID = 2470908562763366865L;
			@Override
			public void handleAction(Object sender, Object target) {
				if(IS_ACEPTAR_FOCUS){
					btnCancelar.focus();
					IS_ACEPTAR_FOCUS = false;
				}else{
					btnAceptar.focus();
					IS_ACEPTAR_FOCUS = true;
				}
			}
		});
		
		lytContenedor.addShortcutListener(new ShortcutListener("", KeyCode.TAB, new int[]{ShortcutAction.ModifierKey.SHIFT}) {
			private static final long serialVersionUID = -4398716072125128918L;
			@Override
			public void handleAction(Object sender, Object target) {
				if(IS_ACEPTAR_FOCUS){
					btnCancelar.focus();
					IS_ACEPTAR_FOCUS = false;
				}else{
					btnAceptar.focus();
					IS_ACEPTAR_FOCUS = true;
				}
			}
		});
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnAceptar)){
			iConfirm.aceptar(btnAceptar, (Window)this.getParent().getParent());
		}else if(event.getButton().equals(btnCancelar)){
			iConfirm.cancelar(btnCancelar, (Window)this.getParent().getParent());
		}
	}

}
