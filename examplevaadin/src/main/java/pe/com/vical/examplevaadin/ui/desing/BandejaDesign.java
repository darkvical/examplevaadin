package pe.com.vical.examplevaadin.ui.desing;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.MenuBar;
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
public class BandejaDesign extends CssLayout {
	protected VerticalLayout lytPadre;
	protected HorizontalLayout lytCabecera;
	protected Image imgLogo;
	protected HorizontalLayout lytMenu;
	protected MenuBar mnuOpcion;
	protected Button btnSalir;
	protected CssLayout cssContenido;

	public BandejaDesign() {
		Design.read(this);
	}
}
