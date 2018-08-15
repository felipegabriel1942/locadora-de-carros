package br.com.locadorax.controle;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;

import br.com.locadorax.bean.Carro;
import br.com.locadorax.modelo.CarroDAO;
import br.com.locadorax.util.MensagensUtil;

@ManagedBean(name = "controleCarro")
@SessionScoped
public class ControleCarro implements Serializable {

	private static final long serialVersionUID = 1L;

	private Carro carro;
	private CarroDAO<Carro> carroDAO;

	public ControleCarro() {
		carroDAO = new CarroDAO<Carro>();
	}

	public String novoCarro() {
		carro = new Carro();
		return "/privado/carro/cadastro?faces-redirect=true";
	}
	
	public void cadastrarCarro() {
		if(carroDAO.persist(carro)) {
			MensagensUtil.mensagemSucesso("Carro cadastrado com sucesso");
			carro = new Carro();
		} else {
			MensagensUtil.mensagemErro("Erro ao cadastrar carro");
			carro = new Carro();
		}
	}

	public void enviarFoto(FileUploadEvent event) {
		try {
			byte[] foto = IOUtils.toByteArray(event.getFile().getInputstream());
			carro.setImagemCarro(foto);
			MensagensUtil.mensagemSucesso("Arquivo enviado com sucesso " + event.getFile().getFileName());
			System.out.println(carro.getImagemCarro());
		} catch (Exception e) {
			MensagensUtil.mensagemErro("Erro ao enviar arquivo " + e);
		}
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public CarroDAO<Carro> getCarroDAO() {
		return carroDAO;
	}

	public void setCarroDAO(CarroDAO<Carro> carroDAO) {
		this.carroDAO = carroDAO;
	}

}
