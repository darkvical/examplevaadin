package pe.com.vical.examplevaadin.ui.desing;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

/** 
 * !! DO NOT EDIT THIS FILE !!
 * 
 * This class is generated by Vaadin Designer and will be overwritten.
 * 
 * Please make a subclass with logic and additional interfaces as needed,
 * e.g class LoginView extends LoginDesign implements View { … }
 */
@DesignRoot
@AutoGenerated
@SuppressWarnings("serial")
public class ConfirmDesign extends CssLayout {
	protected VerticalLayout lytContenedor;
	protected Label lblMensaje;
	protected HorizontalLayout lytAccion;
	protected Button btnAceptar;
	protected Button btnCancelar;

	public ConfirmDesign() {
		Design.read(this);
	}
}
