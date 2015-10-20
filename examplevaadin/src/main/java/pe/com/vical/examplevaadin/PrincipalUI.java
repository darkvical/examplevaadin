package pe.com.vical.examplevaadin;

import pe.com.vical.examplevaadin.base.BaseDesign;
import pe.com.vical.examplevaadin.domain.Usuario;
import pe.com.vical.examplevaadin.ui.presenter.BandejaPresenter;
import pe.com.vical.examplevaadin.ui.presenter.GridPresenter;
import pe.com.vical.examplevaadin.ui.presenter.LoginPresenter;
import pe.com.vical.examplevaadin.util.Inject;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.VerticalLayout;

/**
 * The Application's "main" class
 */
@Theme("example")
@SuppressWarnings("serial")
public class PrincipalUI extends BaseDesign {

	private VerticalLayout mainLayout;
	
    @Override
    protected void init(VaadinRequest request) {
    	Inject.inject(this);
    	buildMainLayout();
    	setContent(mainLayout);
        validarSession();
    }
    
    private void validarSession() {
		Usuario usuario = getUsuarioSession();
		if(usuario !=null){
			mainLayout.addComponent(new BandejaPresenter());
		}else{
			mainLayout.addComponent(new GridPresenter());
//			mainLayout.addComponent(new LoginPresenter());
		}
	}

	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(true);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		// top-level component properties
		setWidth("100.0%");
		setHeight("100%");

		return mainLayout;
	}

}
