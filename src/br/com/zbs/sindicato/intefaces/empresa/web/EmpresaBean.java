package br.com.zbs.sindicato.intefaces.empresa.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.zbs.sindicato.application.service.DadosEmpresaService;
import br.com.zbs.sindicato.application.service.DadosSindicatoService;
import br.com.zbs.sindicato.application.util.StringUtils;
import br.com.zbs.sindicato.domain.dadosEmpresa.DadosEmpresa;


@Named
@RequestScoped
@FacesConfig
public class EmpresaBean implements Serializable{

	@EJB
	private DadosEmpresaService dadosEmpresaService;
	
	@EJB
	private DadosSindicatoService dadosSindicatoaService;
	
	@Inject
	private FacesContext facesContext;
	
	private DadosEmpresa dadosEmpresa = new DadosEmpresa();
	
	private String codigoAssociado;
	
	private String titulo = "Novo Associado";
	
	public void carregar() {
		if (!StringUtils.isEmpty(codigoAssociado)) {
			dadosEmpresa = dadosEmpresaService.findByCodigoAssociado(codigoAssociado);
			titulo = "Alterar Associado";
		}
	}
	
	
	public DadosEmpresa getDadosEmpresa() {
		return dadosEmpresa;
	}
	public void setDadosEmpresa(DadosEmpresa dadosEmpresa) {
		this.dadosEmpresa = dadosEmpresa;
	}
	
	public String gravar() {		
		dadosEmpresaService.createOrUpdate(dadosEmpresa);
		facesContext.addMessage(null, new FacesMessage("Dados gravados com sucesso!"));
		return null;		
	}
	
	public String getCodigoAssociado() {
		return codigoAssociado;
	}
	
	public void setCodigoAssociado(String codigoAssociado) {
		this.codigoAssociado = codigoAssociado;
	}
	
	public String getTitulo() {
		return titulo;
	}
}
