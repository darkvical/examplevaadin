package pe.com.vical.examplevaadin.ui.listener;

import com.vaadin.ui.Button;
import com.vaadin.ui.Window;

public interface IConfirm {
	public void aceptar(Button event, Window window);
	public void cancelar(Button event, Window window);
}
