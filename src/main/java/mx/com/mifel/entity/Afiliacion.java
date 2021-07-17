package mx.com.mifel.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
@Table(name = "TD_AFILIACIONES")
public class Afiliacion implements Serializable {

	private static final long serialVersionUID = -9011229861754571233L;
	@Id
	private Long idAfiliacion;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Mexico_City")
	private Date fechaAlta;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Mexico_City")
	private Date fechaAutorizacion;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Mexico_City")
	private Date fechaModificacion;
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd", timezone = "America/Mexico_City")
	private Date fechaSolicitud;
	private String usuario;
	private long idSobreTasa;
	private long idBanco;
	private int idEstatus;
	@OneToMany(mappedBy = "afiliacion")
	private Set<Terminal> terminales;

	public Afiliacion() {
		super();
	}

	public Set<Terminal> getTerminales() {
		return terminales;
	}

	public void setTerminales(Set<Terminal> terminales) {
		this.terminales = terminales;
	}

	public Long getIdAfiliacion() {
		return idAfiliacion;
	}

	public void setIdAfiliacion(Long idAfiliacion) {
		this.idAfiliacion = idAfiliacion;
	}

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaAutorizacion() {
		return fechaAutorizacion;
	}

	public void setFechaAutorizacion(Date fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public long getIdSobreTasa() {
		return idSobreTasa;
	}

	public void setIdSobreTasa(long idSobreTasa) {
		this.idSobreTasa = idSobreTasa;
	}

	public long getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(long idBanco) {
		this.idBanco = idBanco;
	}

	public int getIdEstatus() {
		return idEstatus;
	}

	public void setIdEstatus(int idEstatus) {
		this.idEstatus = idEstatus;
	}

}
