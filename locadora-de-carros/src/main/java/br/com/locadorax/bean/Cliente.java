package br.com.locadorax.bean;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name = "CLIENTE")
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//Atributos
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "SEQ_CLI", sequenceName = "SEQ_CLI_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLI")
	private Integer id;
		
	@NotEmpty(message = "O nome do cliente é obrigatorio")
	@Column(name = "NOME_CLIENTE", length = 80, nullable = false)
	private String nomeCliente;
	
	@CPF(message = "Informe um CPF válido")
	@Column(name = "CPF_CLIENTE",length = 14, nullable = false, unique = true)
	private String cpfCliente;
	
	@NotNull(message = "A data de nascimento deve ser informada")
	@Column(name = "DATA_NASC_CLIENTE", nullable = false)
	@Temporal(TemporalType.DATE)
	private Calendar dataNascimentoCliente;
	
	@NotEmpty(message = "Informe um nº de telefone")
	@Column(name = "TEL_CLIENTE", length = 20, nullable = false)
	private String telefoneCliente;
	
	@NotEmpty(message = "Informe um email")
	@Email(message = "Informe um email válido")
	@Column(name = "EMAIL_CLIENTE",length = 40, nullable = false )
	private String emailCliente;
	
	//Construtor
	public Cliente() {
		
	}
	
	//Getters e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public Calendar getDataNascimentoCliente() {
		return dataNascimentoCliente;
	}

	public void setDataNascimentoCliente(Calendar dataNascimentoCliente) {
		this.dataNascimentoCliente = dataNascimentoCliente;
	}

	public String getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(String telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	
	//Hash code e Equals
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
		Cliente other = (Cliente) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	


}
