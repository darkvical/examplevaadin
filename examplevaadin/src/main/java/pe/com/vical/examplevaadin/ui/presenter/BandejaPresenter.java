package pe.com.vical.examplevaadin.ui.presenter;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import pe.com.vical.examplevaadin.ui.desing.BandejaDesign;
import pe.com.vical.examplevaadin.util.Inject;

public class BandejaPresenter extends BandejaDesign implements ClickListener{
	private static final long serialVersionUID = -557554551244197757L;
	
	public BandejaPresenter() {
		Inject.inject(this);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
	}

}
