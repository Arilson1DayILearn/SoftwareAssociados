package br.com.zbs.sindicato.intefaces.sindicato.web;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.zbs.sindicato.application.service.DadosEmpresaService;
import br.com.zbs.sindicato.application.service.DadosFuncionarioService;
import br.com.zbs.sindicato.application.service.DadosSindicatoService;
import br.com.zbs.sindicato.application.util.StringUtils;
import br.com.zbs.sindicato.domain.dadosEmpresa.DadosEmpresa;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosFuncionario;

@Named
@RequestScoped
@FacesConfig
public class FuncionarioBean implements Serializable {

	@EJB	
	private DadosFuncionarioService dadosFuncionarioService;

	@EJB
	private DadosSindicatoService dadosSindicatoaService;

	@Inject
	private FacesContext facesContext;

	private DadosFuncionario dadosFuncionario = new DadosFuncionario();

	private String codigoFuncionario;

	private String titulo = "Novo Funcionario";

	public void carregar() {
		if (!StringUtils.isEmpty(codigoFuncionario)) {
			dadosFuncionario = dadosFuncionarioService.findByCodigoFuncionario(codigoFuncionario);
			titulo = "Alterar Funcionario";
		}
	}

	public DadosFuncionario getDadosFuncionario() {
		return dadosFuncionario;
	}

	public void setDadosFuncionario(DadosFuncionario dadosFuncionario) {
		this.dadosFuncionario = dadosFuncionario;
	}

	public String gravar() {
		dadosFuncionarioService.CreateOrUpdate(dadosFuncionario);
		facesContext.addMessage(null, new FacesMessage("Dados gravados com sucesso!"));
		return null;
	}

	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	public String getTitulo() {
		return titulo;
	}
}
