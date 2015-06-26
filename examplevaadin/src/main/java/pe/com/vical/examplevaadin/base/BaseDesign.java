package pe.com.vical.examplevaadin.base;

import pe.com.vical.examplevaadin.PrincipalUI;

import com.vaadin.ui.Component;
import com.vaadin.ui.UI;

public abstract class BaseDesign extends UI {
	private static final long serialVersionUID = -6644966933618655617L;
	
	public static void setContenido(Component component){
		((PrincipalUI)UI.getCurrent()).setContent(component);
	}

}
