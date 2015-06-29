package pe.com.vical.examplevaadin.ui.presenter;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid.HeaderCell;
import com.vaadin.ui.Grid.HeaderRow;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;

import pe.com.vical.examplevaadin.base.BaseDesign;
import pe.com.vical.examplevaadin.domain.Parametro;
import pe.com.vical.examplevaadin.domain.Valor;
import pe.com.vical.examplevaadin.service.IConfiguracionService;
import pe.com.vical.examplevaadin.ui.desing.ParametroDesign;
import pe.com.vical.examplevaadin.ui.listener.IConfirm;
import pe.com.vical.examplevaadin.util.Constantes;
import pe.com.vical.examplevaadin.util.Inject;

public class ParametroPresenter extends ParametroDesign implements ClickListener{
	private static final long serialVersionUID = -8457629230237857845L;
	
	@Autowired
	private IConfiguracionService configuracionService;
	private final static String CAPTION_GUARDAR = "Guardar";
	private final static String CAPTION_MODIFICAR = "Modificar";
	
	public ParametroPresenter() {
		super();
		Inject.inject(this);
		cargarFormulario();
	}

	private void cargarFormulario() {
		btnGuardar.addClickListener(this);
		btnEliminar.addClickListener(this);
		btnEliminar.setVisible(false);
		cmbEstado.setInputPrompt("Estado");
		cargarTabla();
		cargarCombo();
	}

	private void cargarTabla() {
		List<Parametro> parametros = configuracionService.listarParametros();
		BeanItemContainer<Parametro> container = new BeanItemContainer<Parametro>(Parametro.class, parametros);
		grdParametro.removeAllColumns();
		grdParametro.setContainerDataSource(container);
		grdParametro.setColumnOrder("nombre","codigo");
		grdParametro.addItemClickListener(new ItemClickListener() {
			private static final long serialVersionUID = 6225406373312224270L;
			@Override
			public void itemClick(ItemClickEvent event) {
				Parametro parametro = (Parametro)event.getItemId();
				if(grdParametro.isSelected(event.getItemId())){
					limpiar();
				}else{
					txtNombre.setValue(parametro.getNombre());
					txtDescripcion.setValue(parametro.getDescripcion());
					txtValor.setValue(parametro.getValor());
					cmbEstado.setValue(parametro.getEstado());
					btnGuardar.setCaption(CAPTION_MODIFICAR);
					btnEliminar.setVisible(true);
				}
			}
		});
		
		HeaderRow filterRow = grdParametro.appendHeaderRow();
		for (Object parametro : grdParametro.getContainerDataSource().getContainerPropertyIds()){
			HeaderCell celda = filterRow.getCell(parametro);
			TextField txtFiltro = new TextField();
//		    txtFiltro.setColumns(8);
		    txtFiltro.addTextChangeListener(new TextChangeListener() {
				private static final long serialVersionUID = -7507499760009908119L;
				@Override
				public void textChange(TextChangeEvent event) {
					// TODO Auto-generated method stub
					
				}
			});
		    celda.setComponent(txtFiltro);
		}
	}

	protected void limpiar() {
		txtNombre.setValue(StringUtils.EMPTY);
		txtDescripcion.setValue(StringUtils.EMPTY);
		txtValor.setValue(StringUtils.EMPTY);
		cmbEstado.select(null);
		btnGuardar.setCaption(CAPTION_GUARDAR);
		btnEliminar.setVisible(false);
	}

	private void cargarCombo() {
		List<Valor> estados = configuracionService.listarValores(Constantes.LISTA.ESTADO);
		BeanItemContainer<Valor> container = new BeanItemContainer<Valor>(Valor.class, estados);
		cmbEstado.setContainerDataSource(container);
		cmbEstado.setItemCaptionPropertyId("nombre");
	}

	@Override
	public void buttonClick(ClickEvent event) {
		if(event.getButton().equals(btnGuardar)){
			guardar();
		}else if(event.getButton().equals(btnEliminar)){
			eliminar();
		}
	}

	private void guardar() {
		// TODO Auto-generated method stub
		
	}

	private void eliminar() {
		IConfirm confirm = new IConfirm() {			
			@Override
			public void cancelar(Button event, Window window) {
				window.close();
			}			
			@Override
			public void aceptar(Button event, Window window) {
				window.close();
			}
		};
		BaseDesign.mostrarConfirmacion(confirm, "¿Seguro que desea eliminar el registro?");
	}
}
