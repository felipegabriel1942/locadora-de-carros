package br.com.locadorax.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


import br.com.locadorax.bean.Cliente;
import br.com.locadorax.modelo.ClienteDAO;
import br.com.locadorax.util.MensagensUtil;
import br.com.locadorax.util.MetodosUtil;

@ManagedBean(name = "controleCliente")
@SessionScoped
public class ControleCliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	private ClienteDAO<Cliente> clienteDAO;
	private MetodosUtil utilidades;

	public ControleCliente() {
		clienteDAO = new ClienteDAO<Cliente>();

	}

	// metodos
	public String novoCliente() {
		cliente = new Cliente();
		return "/privado/cliente/cadastro?faces-redirect=true";
	}

	public void cadastrarCliente() {
		if (clienteDAO.persist(cliente)) {
			MensagensUtil.mensagemSucesso("Cliente cadastrado com sucesso");
			cliente = new Cliente();
		} else {
			MensagensUtil.mensagemErro("Erro ao cadastrar cliente");
			cliente = new Cliente();
		}
	}
	
	public String listarCliente() {
		return "/privado/cliente/listar?faces-redirect=true";
	}
	
	public String novaPagina() {
		return null;
	}
	


	// Getters e Setters
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ClienteDAO<Cliente> getClienteDAO() {
		return clienteDAO;
	}

	public void setClienteDAO(ClienteDAO<Cliente> clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	public MetodosUtil getUtilidades() {
		return utilidades;
	}

	public void setUtilidades(MetodosUtil utilidades) {
		this.utilidades = utilidades;
	}
	
	

}
