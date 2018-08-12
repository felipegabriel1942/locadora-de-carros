package br.com.locadorax.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

@SuppressWarnings("rawtypes")
public class GenericDAO<T> implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	//Atributos
	private Class classe;
	private EntityManager em;
	private String filtro = "";
	
	
	//Metodos
	public void iniciarTransacao() {
		if (em.getTransaction().isActive() == false) {
			em.getTransaction().begin();
		}
	}

	public void rollbackTransacao() {
		iniciarTransacao();
		em.getTransaction().rollback();
	}

	public void commitTransacao() {
		iniciarTransacao();
		em.getTransaction().commit();
	}

	public boolean persist(T objeto) {
		try {
			iniciarTransacao();
			em.persist(objeto);
			commitTransacao();
			// Espaço da mensagem de sucesso
			return true;
		} catch (Exception e) {
			rollbackTransacao();
			// Espaço da mensagem de erro
			return false;
		}
	}

	public boolean merge(T objeto) {
		try {
			iniciarTransacao();
			em.merge(objeto);
			commitTransacao();
			// Espaço da mensagem de sucesso
			return true;
		} catch (Exception e) {
			rollbackTransacao();
			// Espaço da mensagem de erro
			return false;
		}
	}

	public boolean remove(T objeto) {
		try {
			iniciarTransacao();
			em.remove(objeto);
			commitTransacao();
			// Espaço da mensagem de sucesso
			return true;
		}catch (Exception e) {
			rollbackTransacao();
			// Espaço da mensagem de erro
			return false;
		}
	}
	
	public String protegeFiltro(String filtro) {
		filtro = filtro.replaceAll("[';-]","");
		return filtro;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<T> listar(){
		String jpql = "from " + classe.getSimpleName();
		return em.createQuery(protegeFiltro(jpql)).getResultList();
		
	}
	
	//Getters e Setters
	public Class getClasse() {
		return classe;
	}

	public void setClasse(Class classe) {
		this.classe = classe;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	
	
}
