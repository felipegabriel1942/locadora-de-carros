package br.com.locadorax.testes;

import javax.persistence.EntityManager;

import br.com.locadorax.bean.Usuario;
import br.com.locadorax.util.EntityManagerUtil;

public class InserirUsuario {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Usuario u = new Usuario();
		u.setAtivo(true);
		u.setNomeUsuario("Felipe Gabriel");
		u.setSenha("123456");
		u.setPermissao("Administrador");
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();

	}

}
