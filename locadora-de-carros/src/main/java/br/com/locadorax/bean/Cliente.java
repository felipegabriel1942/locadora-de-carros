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
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
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
	@Length(max = 80, min = 5, message = "O nome do usuario deve ter entre {min} e {max} caracteres")
	@Column(name = "NOME_CLIENTE", length = 80, nullable = false)
	private String nomeCliente;
	
	@NotEmpty
	@CPF(message = "Informe um CPF válido")
	@Column(name = "CPF_CLIENTE",length = 14, nullable = false, unique = true)
	private String cpfCliente;
	
	
	private Calendar dataNascimentoCliente;
	private String telefoneCliente;
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
	
	
	
	


}
