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
import br.com.zbs.sindicato.application.service.DadosSindicatoService;
import br.com.zbs.sindicato.domain.dadosEmpresa.ContribuicaoAssociativa.Status;
import br.com.zbs.sindicato.domain.dadosEmpresa.DadosEmpresa;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosSindicato;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosSindicato.Regional;

@Named
@SessionScoped
@FacesConfig
public class PesquisaRegionalBean implements Serializable {
	
	@EJB
	private DadosSindicatoService dadosSindicatoService;
	
	@Inject
	@RequestParameterMap
	private Map<String,String> requestParamsMap;
	
	private Regional regional;
	
	private List<DadosSindicato> dadosSindicatos;
	
	public void check() {
		String clear = requestParamsMap.get("clear");
		
		if(clear != null && Boolean.valueOf(clear)) {
			regional = null;
			dadosSindicatos = null;
		}
	}
	
	public String gerarRelatorio() {
		dadosSindicatos = dadosSindicatoService.listRegionaisDadosSindicatos(regional);
		return null;
	}

	public Regional getRegional() {
		return regional;
	}

	public void setRegional(Regional regional) {
		this.regional = regional;
	}

	public List<DadosSindicato> getDadosSindicatos() {
		return dadosSindicatos;
	}

	public void setDadosSindicatos(List<DadosSindicato> dadosSindicatos) {
		this.dadosSindicatos = dadosSindicatos;
	}

		
	
	
	
	

}
