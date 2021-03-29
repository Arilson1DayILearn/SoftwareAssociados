package br.com.zbs.sindicato.application.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.zbs.sindicato.application.util.StringUtils;
import br.com.zbs.sindicato.application.util.Validation;
import br.com.zbs.sindicato.application.util.ValidationException;
import br.com.zbs.sindicato.domain.dadosEmpresa.ContribuicaoAssociativa.Status;
import br.com.zbs.sindicato.domain.dadosEmpresa.DadosEmpresa;
import br.com.zbs.sindicato.domain.dadosEmpresa.DadosEmpresaRepository;

@Stateless
public class DadosEmpresaService {
	
	@EJB
	private DadosEmpresaRepository dadosEmpresaRepository;

	public void createOrUpdate(DadosEmpresa dadosEmpresa) {
		if(StringUtils.isEmpty(dadosEmpresa.getCodigoAssociado())){
			create(dadosEmpresa);
		}
		else {
			update(dadosEmpresa);
		}
						
	}
	
	private void create(DadosEmpresa dadosEmpresa) {
		Validation.assertNotEmpty(dadosEmpresa);
		String maxCodigoAssociado = dadosEmpresaRepository.getMaxCodigoAssociadoAno();
		dadosEmpresa.gerarCodigoAssociado(maxCodigoAssociado);		
		dadosEmpresaRepository.store(dadosEmpresa);				
	}
	
	public void delete(String codigoAssociado) {
		dadosEmpresaRepository.delete(codigoAssociado);
		
	}
	
	
	private void update(DadosEmpresa dadosEmpresa) {
		Validation.assertNotEmpty(dadosEmpresa);
		Validation.assertNotEmpty(dadosEmpresa.getCodigoAssociado());
		dadosEmpresaRepository.update(dadosEmpresa);		
	}
	
	public DadosEmpresa findByCodigoAssociado(String codigoAssociado) {
		return dadosEmpresaRepository.findBycodigoAssociado(codigoAssociado);
	}
	
	public List<DadosEmpresa> listDadosEmpresa(String codigoAssociado, String cnpj,  String razaoSocial, String cpf ){
		
		if(StringUtils.isEmpty(codigoAssociado) && StringUtils.isEmpty(cnpj) && StringUtils.isEmpty(razaoSocial) && StringUtils.isEmpty(cpf)) {
			throw new ValidationException("Pelo menos um critério de pesquisa deve ser informado");
		}
		
		return dadosEmpresaRepository.listDadosEmpresas(codigoAssociado, cnpj, razaoSocial, cpf);
		
	}
	
	public List<DadosEmpresa> listStatusDadosEmpresa(Status status){
		Validation.assertNotEmpty(status);
		return dadosEmpresaRepository.listStatusDadosEmpresas(status);
	}

}
