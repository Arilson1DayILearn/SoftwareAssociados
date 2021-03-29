package br.com.zbs.sindicato.application.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.zbs.sindicato.domain.dadosEmpresa.Estado;
import br.com.zbs.sindicato.domain.dadosEmpresa.EstadoRepository;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosSindicato;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosSindicato.Regional;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosSindicatoRepository;
import br.com.zbs.sindicato.domain.dadosEmpresa.ContribuicaoAssociativa.Status;
import br.com.zbs.sindicato.domain.dadosEmpresa.DadosEmpresa.TipoEstabelecimento;
import br.com.zbs.sindicato.domain.dadosEmpresa.DadosEmpresa.naturezaJuridica;

@Stateless
public class DataService {
	
	@EJB
	private EstadoRepository estadoRepository;
	
	@EJB
	private DadosSindicatoRepository dadosSindicatoRepository;
	
	public List<Estado> listEstados(){
		return estadoRepository.listEstados();
	}
		
	
	public naturezaJuridica[] getNaturezasJuridicas() {
		return naturezaJuridica.values();
	}
	
	public TipoEstabelecimento[] getTiposEstabelecimentos() {
		return TipoEstabelecimento.values();
	}
	
	public Status[] getStatus() {
		return Status.values();
	}	
	
	public Regional[] getRegional() {
		return Regional.values();
	}
	
	public List<DadosSindicato> listDadosSindicatos(){
		return dadosSindicatoRepository.listDadosSindicatos();
	}
}
