package pe.com.vical.examplevaadin;

import pe.com.vical.examplevaadin.ui.presenter.LoginPresenter;
import pe.com.vical.examplevaadin.util.Inject;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * The Application's "main" class
 */
@Theme("example")
@SuppressWarnings("serial")
public class PrincipalUI extends UI{

	private VerticalLayout mainLayout;
	
    @Override
    protected void init(VaadinRequest request) {
    	Inject.inject(this);
    	buildMainLayout();
    	mainLayout.addComponent(new LoginPresenter());
        setContent(mainLayout);
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
