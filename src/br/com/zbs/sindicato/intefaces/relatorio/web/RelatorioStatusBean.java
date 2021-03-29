package br.com.zbs.sindicato.intefaces.relatorio.web;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.annotation.RequestParameterMap;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.zbs.sindicato.application.service.DadosEmpresaService;
import br.com.zbs.sindicato.domain.dadosEmpresa.ContribuicaoAssociativa.Status;
import br.com.zbs.sindicato.domain.dadosEmpresa.DadosEmpresa;

@Named
@SessionScoped
@FacesConfig
public class RelatorioStatusBean implements Serializable {
	
	@EJB
	private DadosEmpresaService dadosEmpresaService;
	
	@Inject
	@RequestParameterMap
	private Map<String,String> requestParamsMap;
	
	private Status status;
	
	private List<DadosEmpresa> dadosEmpresa;
	
	public void check() {
		String clear = requestParamsMap.get("clear");
		
		if(clear != null && Boolean.valueOf(clear)) {
			status = null;
			dadosEmpresa = null;
		}
	}
	
	public String gerarRelatorio() {
		dadosEmpresa = dadosEmpresaService.listStatusDadosEmpresa(status);
		return null;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<DadosEmpresa> getDadosEmpresa() {
		return dadosEmpresa;
	}

	public void setDadosEmpresa(List<DadosEmpresa> dadosEmpresa) {
		this.dadosEmpresa = dadosEmpresa;
	}
	
	

}
