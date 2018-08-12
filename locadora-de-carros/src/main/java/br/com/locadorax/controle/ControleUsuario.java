package br.com.locadorax.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.locadorax.bean.Usuario;
import br.com.locadorax.modelo.UsuarioDAO;
import br.com.locadorax.util.MensagensUtil;

@ManagedBean(name = "controleUsuario")
@SessionScoped
public class ControleUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario;
	private UsuarioDAO<Usuario> usuarioDAO;
	private String usuarioTela;
	private String senhaTela;

	public ControleUsuario() {
		usuarioDAO = new UsuarioDAO<Usuario>();
	}

	// Metodos
	public String efetuarLogin() {
		if (usuarioDAO.login(this.usuarioTela, this.senhaTela)) {
			return "/privado/index?faces-redirect=true";
		} else {
			MensagensUtil.mensagemErro("Login não foi realizado" + " Usuario ou senha invalidos!");
			return "/login";
		}
	}
	
	public void limparCampos() {
		this.usuarioTela = "";
		this.senhaTela = "";
	}

	// Getters e Setters
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDAO<Usuario> getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO<Usuario> usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	public String getUsuarioTela() {
		return usuarioTela;
	}

	public void setUsuarioTela(String usuarioTela) {
		this.usuarioTela = usuarioTela;
	}

	public String getSenhaTela() {
		return senhaTela;
	}

	public void setSenhaTela(String senhaTela) {
		this.senhaTela = senhaTela;
	}
	
	

}
