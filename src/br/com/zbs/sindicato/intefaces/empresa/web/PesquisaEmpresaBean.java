package br.com.zbs.sindicato.intefaces.empresa.web;

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

import br.com.zbs.sindicato.application.service.DadosEmpresaService;
import br.com.zbs.sindicato.application.util.ValidationException;
import br.com.zbs.sindicato.domain.dadosEmpresa.DadosEmpresa;

@Named 
@SessionScoped
@FacesConfig
public class PesquisaEmpresaBean implements Serializable {
	
	@EJB
	private DadosEmpresaService dadosEmpresaService;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	@RequestParameterMap
	private Map<String, String> requestParamsMap;
	
	private String codigoAssociado;
	private String cnpj;
	private String razaoSocial;
	private String cpf;
	
	private List<DadosEmpresa> dadosEmpresas;
	
	public void check() {
		String clear = requestParamsMap.get("clear");
		
		if(clear != null && Boolean.valueOf(clear)) {
			codigoAssociado = null;
			cnpj = null;
			razaoSocial = null;
			cpf = null;
			dadosEmpresas = null;
		}
	}
	
	public String pesquisar() {
		try {
			dadosEmpresas = dadosEmpresaService.listDadosEmpresa(codigoAssociado, cnpj, razaoSocial, cpf);
		} catch (ValidationException e) {
			facesContext.addMessage(null, new FacesMessage(e.getMessage()));
		}
		return null;
	}
	
	public void setDadosEmpresas(List<DadosEmpresa> dadosEmpresas) {
		this.dadosEmpresas = dadosEmpresas;
	}

	public String excluir(String codigoAssociado) {
		dadosEmpresaService.delete(codigoAssociado);
		return pesquisar();
		
	}

	public String getCodigoAssociado() {
		return codigoAssociado;
	}

	public void setCodigoAssociado(String codigoAssociado) {
		this.codigoAssociado = codigoAssociado;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public List<DadosEmpresa> getDadosEmpresas() {
		return dadosEmpresas;
	}
	
	
	

	

}
