package br.com.zbs.sindicato.intefaces.usuario.web;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named
@RequestScoped
@FacesConfig
public class LoginBean implements Serializable{

	private String login;
	private String senha;
	
	public String doEfetuarLogin() {
		//Poderia ser uma autenticação no banco de dados.
	    if("aalmada@fiemg.com.br".equals(getLogin())
	            && "Ari@2906".equals(getSenha())) {
	      return "bemVindo.xhtml";
	    } else {
	      /* Cria uma mensagem. */
	      FacesMessage msg = new FacesMessage("Usuário ou senha inválido!");
	      /* Obtém a instancia atual do FacesContext e adiciona a mensagem de erro nele. */
	      FacesContext.getCurrentInstance().addMessage("erro", msg);
	      return null;
	    }
	  }
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
