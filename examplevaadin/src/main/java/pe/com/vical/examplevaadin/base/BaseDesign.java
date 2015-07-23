package pe.com.vical.examplevaadin.base;

import pe.com.vical.examplevaadin.PrincipalUI;
import pe.com.vical.examplevaadin.domain.Usuario;
import pe.com.vical.examplevaadin.ui.listener.IConfirm;
import pe.com.vical.examplevaadin.ui.presenter.ConfirmPresenter;
import pe.com.vical.examplevaadin.util.Constantes;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public abstract class BaseDesign extends UI {
	private static final long serialVersionUID = -6644966933618655617L;
	
	public static void setContenido(Component component){
		((PrincipalUI)UI.getCurrent()).setContent(component);
	}
	
	public static void mostrarConfirmacion(IConfirm iconfirm, String mensaje){
		ConfirmPresenter confirmar = new ConfirmPresenter(iconfirm);
		confirmar.setMensaje(mensaje);
		mostrarModal("CONFIRMACION00", confirmar, "150px", "300px", "Confirmación");
	}

	public static void mostrarModal(String codigoModal, Component component, String alto, String ancho,String titulo) {
		Window window = new Window();
		VerticalLayout layout = new VerticalLayout();
		window.setId(codigoModal);
		window.setStyleName("titulo-bold");
		window.setModal(true);
		window.setResizable(false);
		window.setDraggable(false);
		window.setCloseShortcut(KeyCode.ESCAPE, null);
		window.setCaption(titulo);
		layout.addComponent(component);
		layout.setMargin(false);
		window.setContent(layout);
		window.setHeight(alto);
		window.setWidth(ancho);
		UI.getCurrent().addWindow(window);
	}
	
	public static void setUsuarioSession(Usuario usuario){
		try{
			VaadinSession.getCurrent().getLockInstance().lock();
			VaadinSession.getCurrent().setAttribute(Constantes.SESSION.USER, usuario);
		}finally{
			VaadinSession.getCurrent().getLockInstance().unlock();
		}
	}
	
	public static Usuario getUsuarioSession(){
		Usuario usuario = (Usuario)VaadinSession.getCurrent().getAttribute(Constantes.SESSION.USER);
		return usuario;
	}
	
	public static String getStartLocation() {
		final Page page = Page.getCurrent();
		final StringBuilder sbuf = new StringBuilder();
		sbuf.append(getServerLocation(page));
		sbuf.append(VaadinServlet.getCurrent().getServletContext().getContextPath());
		return sbuf.toString();
	}
	
	public static String getServerLocation(final Page page) {
        final StringBuilder sbuf = new StringBuilder();
        sbuf.append(page.getLocation().getScheme());
        
        sbuf.append("://");
        sbuf.append(page.getLocation().getHost());
        
        sbuf.append(":");
        sbuf.append(page.getLocation().getPort());
        
        return sbuf.toString();
    }	
}
