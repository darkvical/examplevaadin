package pe.com.vical.examplevaadin.ui.presenter;

import pe.com.vical.examplevaadin.ui.desing.GridComponentDesign;
import pe.com.vical.examplevaadin.util.Inject;

public class GridPresenter extends GridComponentDesign {
	private static final long serialVersionUID = 1L;
	
	public GridPresenter(){
		super();
		Inject.inject(this);
	}
}
