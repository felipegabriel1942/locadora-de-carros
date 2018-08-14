package br.com.locadorax.modelo;

import java.io.Serializable;

import br.com.locadorax.bean.Cliente;
import br.com.locadorax.util.EntityManagerUtil;

public class ClienteDAO<T> extends GenericDAO<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public ClienteDAO() {
		super.setClasse(Cliente.class);
		super.setEm(EntityManagerUtil.getEntityManager());
		super.setFiltro("");
	}

}
