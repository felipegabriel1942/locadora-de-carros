package br.com.locadorax.modelo;

import java.io.Serializable;

import javax.persistence.Query;

import br.com.locadorax.bean.Usuario;
import br.com.locadorax.util.EntityManagerUtil;

public class UsuarioDAO<T> extends GenericDAO<T> implements Serializable {

	private static final long serialVersionUID = 2212757660202808722L;

	public UsuarioDAO() {
		super.setClasse(Usuario.class);
		super.setEm(EntityManagerUtil.getEntityManager());
		super.setFiltro("");
	}

	public boolean login(String usuario, String senha) {
		Query query = super.getEm().createQuery(
				"from Usuario where upper(nomeUsuario) = :usuario" + " and upper(senha) =:senha and ativo = true");
		query.setParameter("usuario", usuario.toUpperCase());
		query.setParameter("senha", senha.toUpperCase());
		
		if(!query.getResultList().isEmpty()) {
			return true;
		} else {
			return false;
		}
		
		
	}

}
