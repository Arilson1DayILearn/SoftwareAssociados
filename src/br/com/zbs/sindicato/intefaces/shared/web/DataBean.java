package br.com.zbs.sindicato.intefaces.shared.web;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import br.com.zbs.sindicato.application.service.DataService;
import br.com.zbs.sindicato.domain.dadosEmpresa.ContribuicaoAssociativa.Status;
import br.com.zbs.sindicato.domain.dadosEmpresa.DadosEmpresa.TipoEstabelecimento;
import br.com.zbs.sindicato.domain.dadosEmpresa.DadosEmpresa.naturezaJuridica;
import br.com.zbs.sindicato.domain.dadosEmpresa.Estado;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosSindicato;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosSindicato.Regional;


@Named
@ApplicationScoped
public class DataBean implements Serializable{
	
	@EJB
	private DataService dataService;

	public naturezaJuridica[] getNaturezasJuridicas() {
		return dataService.getNaturezasJuridicas();
	}
	
	public TipoEstabelecimento[] getTiposEstabelecimentos() {
		return dataService.getTiposEstabelecimentos();
	}
	
	public Status[] getStatus() {
		return dataService.getStatus();
	}
	
	public Regional[] getRegionais() {
		return Regional.values();
	}
	
	public List<Estado> getEstados(){		
		return dataService.listEstados();
	}
	
	public String formatTelefone(Integer ddd, Integer numero) {
		if (ddd == null || numero == null) {
			return "";
		}
		return "(" + ddd + ") " + numero;
	}
	
	public List<DadosSindicato> getDadosSindicatos(){
		return dataService.listDadosSindicatos();
	}
	
	public String getMaskCNPJ(String cnpj) {
		return cnpj.substring(0, 2)+"."+cnpj.substring(2, 5)+"."+cnpj.substring(5, 8)+"/"+cnpj.substring(8,12)+"-"+cnpj.substring(12);
	}
	
	public String getMaskCPF(String cpf) {
		return cpf.substring(0, 3)+"."+cpf.substring(3, 6)+"."+cpf.substring(6, 9)+"-"+cpf.substring(9);
	}
	
	public static String formatMoney(BigInteger vlr){
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		return nf.format(vlr);
	}
	
	
	
	
}



