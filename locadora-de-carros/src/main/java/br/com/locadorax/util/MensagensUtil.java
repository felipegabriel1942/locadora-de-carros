package br.com.locadorax.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensagensUtil {

	public static void mensagemErro(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", mensagem));
	}
	
	public static void mensagemSucesso(String mensagem) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", mensagem));
	}
}
