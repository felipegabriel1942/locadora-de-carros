package br.com.locadorax.modelo;

import java.io.Serializable;

import br.com.locadorax.bean.Carro;
import br.com.locadorax.util.EntityManagerUtil;

public class CarroDAO<T> extends GenericDAO<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public CarroDAO() {
		super.setClasse(Carro.class);
		super.setEm(EntityManagerUtil.getEntityManager());
		super.setFiltro("");
	}

}
