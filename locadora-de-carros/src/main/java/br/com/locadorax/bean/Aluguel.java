package br.com.locadorax.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ALUGUEL")
public class Aluguel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "SEQ_ALU", sequenceName = "SEQ_ALU_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ALU")
	private Integer id;
		
	@NotNull(message = "Deve ser dada uma data para o inicio do aluguel")
	@Column(name = "DATA_INICIO_ALGUEL", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataInicioAluguel;
	
	@NotNull(message = "Deve ser dada uma data para o fim do aluguel")
	@Column(name = "DATA_FIM_ALUGUEL", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataFimAluguel;

	@Column(name = "VALOR_A_PAGAR", nullable = false)
	private Double valorTotalAPagar;
	
	@NotNull(message = "O carro deve ser informado")
	@ManyToOne
	@JoinColumn(name = "CARRO", referencedColumnName = "ID", nullable = false)
	private Carro carro;
	
	@NotNull(message = "O cliente deve ser informado")
	@ManyToOne
	@JoinColumn(name = "CLIENTE", referencedColumnName = "ID", nullable = false)
	private Cliente cliente; 
	
	public Aluguel() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Calendar getDataInicioAluguel() {
		return dataInicioAluguel;
	}

	public void setDataInicioAluguel(Calendar dataInicioAluguel) {
		this.dataInicioAluguel = dataInicioAluguel;
	}

	public Calendar getDataFimAluguel() {
		return dataFimAluguel;
	}

	public void setDataFimAluguel(Calendar dataFimAluguel) {
		this.dataFimAluguel = dataFimAluguel;
	}

	public Double getValorTotalAPagar() {
		return valorTotalAPagar;
	}

	public void setValorTotalAPagar(Double valorTotalAPagar) {
		this.valorTotalAPagar = valorTotalAPagar;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Aluguel other = (Aluguel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
