package mx.com.mifel.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TD_TERMINALES")
public class Terminal implements Serializable {

	private static final long serialVersionUID = -5272158823763079998L;
	@Id
	private Long idTerminal;
	private String marca;
	private String modelo;
	private Integer numServicio;
	@ManyToOne
    @JoinColumn(name="idAfiliacion", nullable=false)
	private Afiliacion afiliacion;

	public Terminal() {
		super();
	}

	public Long getIdTerminal() {
		return idTerminal;
	}

	public void setIdTerminal(Long idTerminal) {
		this.idTerminal = idTerminal;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getNumServicio() {
		return numServicio;
	}

	public void setNumServicio(Integer numServicio) {
		this.numServicio = numServicio;
	}

}
