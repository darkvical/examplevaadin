package pe.com.vical.examplevaadin.ui.desing;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
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
public class ParametroDesign extends CssLayout {
	protected HorizontalLayout lytContenido;
	protected Grid grdParametro;
	protected VerticalLayout lytDatos;
	protected TextField txtNombre;
	protected TextArea txtDescripcion;
	protected TextField txtValor;
	protected ComboBox cmbEstado;
	protected HorizontalLayout lytAccion;
	protected Button btnGuardar;
	protected Button btnEliminar;

	public ParametroDesign() {
		Design.read(this);
	}
}