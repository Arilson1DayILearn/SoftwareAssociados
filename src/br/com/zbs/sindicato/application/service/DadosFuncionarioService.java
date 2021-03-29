package br.com.zbs.sindicato.application.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.com.zbs.sindicato.application.util.StringUtils;
import br.com.zbs.sindicato.application.util.Validation;
import br.com.zbs.sindicato.application.util.ValidationException;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosFuncionario;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosFuncionarioRepository;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosSindicato;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosSindicato.Regional;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosSindicatoRepository;

@Stateless
public class DadosFuncionarioService {
	
	@EJB
	private DadosSindicatoRepository dadosSindicatoRepository;
	
	@EJB
	private DadosFuncionarioRepository dadosFuncionarioRepository;
	
	

	public void CreateOrUpdate(DadosFuncionario dadosFuncionario) {
		if(StringUtils.isEmpty(dadosFuncionario.getCodigoFuncionario())) {
		create(dadosFuncionario);		
		}else {
			update(dadosFuncionario);
		}	
	}
	
	private void create(DadosFuncionario dadosFuncionario) {
		Validation.assertNotEmpty(dadosFuncionario);
		String maxCodigoFuncionario = dadosFuncionarioRepository.getMaxCodigoFuncionarioAno();
		dadosFuncionario.gerarCodigoFuncionario(maxCodigoFuncionario);
		dadosFuncionarioRepository.store(dadosFuncionario);
	}
	
	public void delete(String codigoFuncionario) {
		dadosFuncionarioRepository.delete(codigoFuncionario);
	}
	
	private void update(DadosFuncionario dadosFuncionario) {
		Validation.assertNotEmpty(dadosFuncionario);
		Validation.assertNotEmpty(dadosFuncionario.getCodigoFuncionario());
		dadosFuncionarioRepository.update(dadosFuncionario);
	}

	public DadosFuncionario findByCodigoFuncionario(String codigoFuncionario) {
		
		return dadosFuncionarioRepository.findByCodigoFuncionario(codigoFuncionario);
	}	
	
	public List<DadosFuncionario> listDadosFuncionarios(String codigoFuncionario, String siglaSindicato, String nomeFuncionario){
		if(StringUtils.isEmpty(codigoFuncionario) &&  StringUtils.isEmpty(nomeFuncionario)) {
			throw new ValidationException("Pelo menos um critério de pesquisa deve ser fornecido.");
		}		
		return dadosFuncionarioRepository.listDadosFuncionarios(codigoFuncionario, siglaSindicato, nomeFuncionario);
	}
	
	
}
