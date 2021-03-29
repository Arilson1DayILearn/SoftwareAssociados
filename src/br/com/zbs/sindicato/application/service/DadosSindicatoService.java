package br.com.zbs.sindicato.application.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.zbs.sindicato.application.util.StringUtils;
import br.com.zbs.sindicato.application.util.Validation;
import br.com.zbs.sindicato.application.util.ValidationException;
import br.com.zbs.sindicato.domain.dadosEmpresa.DadosEmpresa;
import br.com.zbs.sindicato.domain.dadosEmpresa.ContribuicaoAssociativa.Status;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosSindicato;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosSindicato.Regional;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosSindicatoRepository;

@Stateless
public class DadosSindicatoService {
	
	@EJB
	private DadosSindicatoRepository dadosSindicatoRepository;

	public void CreateOrUpdate(DadosSindicato dadosSindicato) {
		if(StringUtils.isEmpty(dadosSindicato.getCodigoSindicato())) {
		create(dadosSindicato);		
		}else {
			update(dadosSindicato);
		}	
	}
	
	private void create(DadosSindicato dadosSindicato) {
		Validation.assertNotEmpty(dadosSindicato);
		String maxCodigoSindicato = dadosSindicatoRepository.getMaxCodigoSindicatoAno();
		dadosSindicato.gerarCodigoSindicato(maxCodigoSindicato);
		dadosSindicatoRepository.store(dadosSindicato);
	}
	
	public void delete(String codigoSindicato) {
		dadosSindicatoRepository.delete(codigoSindicato);
	}
	
	private void update(DadosSindicato dadosSindicato) {
		Validation.assertNotEmpty(dadosSindicato);
		Validation.assertNotEmpty(dadosSindicato.getCodigoSindicato());
		dadosSindicatoRepository.update(dadosSindicato);
	}

	public DadosSindicato findByCodigoSindicato(String codigoSindicato) {
		
		return dadosSindicatoRepository.findByCodigoSindicato(codigoSindicato);
	}	
	
	public List<DadosSindicato> listDadosSindicatos(String codigoSindicato, String siglaSindicato, String nomeSindicato){
		if(StringUtils.isEmpty(codigoSindicato) && StringUtils.isEmpty(siglaSindicato) && StringUtils.isEmpty(nomeSindicato)) {
			throw new ValidationException("Pelo menos um critério de pesquisa deve ser fornecido.");
		}		
		return dadosSindicatoRepository.listDadosSindicatos(codigoSindicato, siglaSindicato, nomeSindicato);
	}
	
	public List<DadosSindicato> listRegionaisDadosSindicatos(Regional regional){
		Validation.assertNotEmpty(regional);
		return dadosSindicatoRepository.listRegionaisDadosSindicatos(regional);
	}
}
