package br.com.locadorax.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.primefaces.model.StreamedContent;

@Entity
@Table(name = "CARRO")
public class Carro implements Serializable {

	private static final long serialVersionUID = 1L;

	//Atributos
	@Id
	@Column(name = "ID")
	@GeneratedValue
	private Integer id;

	@NotEmpty(message = "Informe o modelo do carro")
	@Column(name = "MODELO", length = 40, nullable = false)
	private String modeloCarro;
	
	@NotEmpty(message = "Informe o ano do carro")
	@Column(name = "ANO", length = 9, nullable = false)
	private String anoCarro;
		
	@NotEmpty(message = "Informe o fabricante do carro")
	@Column(name = "FABRICANTE", length = 50, nullable = false)
	private String fabricanteCarro;
	
	@NotEmpty(message = "Informe a placa do carro")
	@Column(name = "PLACA", length = 10, nullable = false , unique = true)
	private String placaCarro;
	
	@Column(name = "FOTO")
	@Lob
	private byte[] imagemCarro;
	
	@NotNull(message = "Informe o valor da diária do carro")
	@Column(name = "PRECO", nullable = false, columnDefinition = "numeric(10,2)")
	private Double precoDiariaCarro;

	@Transient
	private StreamedContent imagemTela;
	
	public Carro() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModeloCarro() {
		return modeloCarro;
	}

	public void setModeloCarro(String modeloCarro) {
		this.modeloCarro = modeloCarro;
	}

	public String getAnoCarro() {
		return anoCarro;
	}

	public void setAnoCarro(String anoCarro) {
		this.anoCarro = anoCarro;
	}

	public String getFabricanteCarro() {
		return fabricanteCarro;
	}

	public void setFabricanteCarro(String fabricanteCarro) {
		this.fabricanteCarro = fabricanteCarro;
	}

	public String getPlacaCarro() {
		return placaCarro;
	}

	public void setPlacaCarro(String placaCarro) {
		this.placaCarro = placaCarro;
	}

	public byte[] getImagemCarro() {
		return imagemCarro;
	}

	public void setImagemCarro(byte[] imagemCarro) {
		this.imagemCarro = imagemCarro;
	}

	public Double getPrecoDiariaCarro() {
		return precoDiariaCarro;
	}

	public void setPrecoDiariaCarro(Double precoDiariaCarro) {
		this.precoDiariaCarro = precoDiariaCarro;
	}

	public StreamedContent getImagemTela() {
		return imagemTela;
	}

	public void setImagemTela(StreamedContent imagemTela) {
		this.imagemTela = imagemTela;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carro other = (Carro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
