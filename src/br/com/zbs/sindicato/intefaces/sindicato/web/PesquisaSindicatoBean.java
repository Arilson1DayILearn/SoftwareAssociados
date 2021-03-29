package br.com.zbs.sindicato.intefaces.sindicato.web;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.RequestParameterMap;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.zbs.sindicato.application.service.DadosSindicatoService;
import br.com.zbs.sindicato.application.util.ValidationException;
import br.com.zbs.sindicato.domain.dadosEmpresa.DadosEmpresa;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosSindicato;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosSindicato.Regional;

@Named
@SessionScoped
@FacesConfig
public class PesquisaSindicatoBean implements Serializable{

	@EJB
	private DadosSindicatoService dadosSindicatoService;
	
	@Inject
	private FacesContext facesContext;
	
	private String codigoSindicato;
	
	private String siglaSindicato;
	
	private String nomeSindicato;
	
	private Regional regional;
	
	public Regional getRegional() {
		return regional;
	}

	public void setRegional(Regional regional) {
		this.regional = regional;
	}

	private List<DadosSindicato> dadosSindicatos;	
	
	
	public String pesquisar() {
		
		try {
		dadosSindicatos = dadosSindicatoService.listDadosSindicatos(codigoSindicato, siglaSindicato, nomeSindicato);
			} catch (ValidationException e) {
				facesContext.addMessage(null, new FacesMessage(e.getMessage()));
			}
		return null;
	}
	
	public String excluir(String codigoSindicato) {
		dadosSindicatoService.delete(codigoSindicato);
		return pesquisar();	
	}

	public FacesContext getFacesContext() {
		return facesContext;
	}

	public void setFacesContext(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	public String getCodigoSindicato() {
		return codigoSindicato;
	}

	public void setCodigoSindicato(String codigoSindicato) {
		this.codigoSindicato = codigoSindicato;
	}

	public String getSiglaSindicato() {
		return siglaSindicato;
	}

	public void setSiglaSindicato(String siglaSindicato) {
		this.siglaSindicato = siglaSindicato;
	}

	public String getNomeSindicato() {
		return nomeSindicato;
	}

	public void setNomeSindicato(String nomeSindicato) {
		this.nomeSindicato = nomeSindicato;
	}
	
	public List<DadosSindicato> getDadosSindicatos() {
		return dadosSindicatos;
	}
	
	@Inject
	@RequestParameterMap
	private Map<String, String> requestParamsMap;		
	
	public void check() {
		String clear = requestParamsMap.get("clear");
		
		if(clear != null && Boolean.valueOf(clear)) {
			codigoSindicato = null;
			siglaSindicato = null;
			nomeSindicato = null;	
			dadosSindicatos =null;
		}
	}
	
	
	
}
