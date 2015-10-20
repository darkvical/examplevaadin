package pe.com.vical.examplevaadin.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Auditor implements Serializable{
	
	private static final long serialVersionUID = -8086422054278789488L;
	
	@ManyToOne
	@JoinColumn(name="CREADOR")
	private Usuario creador;
	private Date creacion;
	@ManyToOne
	@JoinColumn(name="EDITOR")
	private Usuario editor;
	private Date edicion;
	
	public Usuario getCreador() {
		return creador;
	}
	public void setCreador(Usuario creador) {
		this.creador = creador;
	}
	public Date getCreacion() {
		return creacion;
	}
	public void setCreacion(Date creacion) {
		this.creacion = creacion;
	}
	public Usuario getEditor() {
		return editor;
	}
	public void setEditor(Usuario editor) {
		this.editor = editor;
	}
	public Date getEdicion() {
		return edicion;
	}
	public void setEdicion(Date edicion) {
		this.edicion = edicion;
	}
}
