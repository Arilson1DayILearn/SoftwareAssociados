package br.com.zbs.sindicato.intefaces.sindicato.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.zbs.sindicato.application.service.DadosSindicatoService;
import br.com.zbs.sindicato.application.util.StringUtils;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosSindicato;


@Named
@RequestScoped
@FacesConfig
public class SindicatoBean implements Serializable{
	
	@EJB
	private DadosSindicatoService dadosSindicatoService;
	
	@Inject
	private FacesContext facesContext;

	private DadosSindicato dadosSindicato = new DadosSindicato();
	
	private String codigoSindicato;
	
	public void setCodigoSindicato(String codigoSindicato) {
		this.codigoSindicato = codigoSindicato;
	}

	private String titulo = "Novo Sindicato";
	
	public void carregar() {
		if (!StringUtils.isEmpty(codigoSindicato)) {
			dadosSindicato = dadosSindicatoService.findByCodigoSindicato(codigoSindicato);
			titulo ="Alterar Sindicato";
		}
		
	
	}
	
	public String gravar() {
		dadosSindicatoService.CreateOrUpdate(dadosSindicato);
		facesContext.addMessage(null, new FacesMessage("Dados gravados com sucesso!"));
		return null;
	}

	public DadosSindicato getDadosSindicato() {
		return dadosSindicato;
	}

	public void setDadosSindicato(DadosSindicato dadosSindicato) {
		this.dadosSindicato = dadosSindicato;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getCodigoSindicato() {
		return codigoSindicato;
	}

	
	
	
	

}
