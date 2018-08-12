package br.com.locadorax.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	// Atributos
	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "SEQ_USU", sequenceName = "SEQ_USU_ID", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USU")
	private Integer id;

	@NotEmpty(message = "O nome do usuario é obrigatorio")
	@Length(max = 30, min = 5, message = "O nome do usuario deve ter entre {min} e {max} caracteres")
	@Column(name = "NOME_USUARIO", length = 30, nullable = false)
	private String nomeUsuario;

	@NotEmpty(message = "A senha é obrigatoria")
	@Length(max = 10, message = "A senha é obrigatoria e deve ter no máximo {max} caracteres")
	@Column(name = "SENHA_USUARIO", length = 10, nullable = false)
	private String senha;

	@NotNull(message = "Escolha permissão do usuario")
	@Column(name = "PERMISSAO", length = 15, nullable = false)
	private String permissao;
	
	@Column(name = "ATIVO", nullable = false)
	private Boolean ativo;
	
	// Construtor vazio
	public Usuario() {

	}

	// Getters e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	
	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	// Equals e HashCode
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
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
