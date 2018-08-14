package br.com.locadorax.testes;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.locadorax.bean.Cliente;
import br.com.locadorax.util.EntityManagerUtil;

public class InserirCliente {
	
	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Cliente c = new Cliente();
		c.setCpfCliente("02972064356");
		c.setDataNascimentoCliente(Calendar.getInstance());
		c.setEmailCliente("pinheiro_felipeg@yahoo.com.br");
		c.setNomeCliente("Felipe Gabriel Pinheiro");
		c.setTelefoneCliente("9563251145");
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}
}
