package br.com.zbs.sindicato.domain.dadosEmpresa;

import java.time.Year;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.zbs.sindicato.application.util.StringUtils;
import br.com.zbs.sindicato.domain.dadosEmpresa.ContribuicaoAssociativa.Status;

@Stateless
public class DadosEmpresaRepository {

	@PersistenceContext
	private EntityManager em;
	
	public void store(DadosEmpresa dadosEmpresa) {
		em.persist(dadosEmpresa);
	}
	
	public void update(DadosEmpresa dadosEmpresa) {
		em.merge(dadosEmpresa);
	}
	
	public DadosEmpresa findBycodigoAssociado(String codigoAssociado) {
		return em.find(DadosEmpresa.class, codigoAssociado);
	}
	
	public void delete(String codigoAssociado) {
		DadosEmpresa dadosEmpresa = findBycodigoAssociado(codigoAssociado);
		
		if(dadosEmpresa != null) {
			em.remove(dadosEmpresa);
		}
	}
	
	public String getMaxCodigoAssociadoAno() {
		return em.createQuery("SELECT MAX(a.codigoAssociado) FROM DadosEmpresa a WHERE a.codigoAssociado LIKE :ano", String.class)
		.setParameter("ano", Year.now() + "%")
		.getSingleResult();
	}	
	
	public List<DadosEmpresa> listDadosEmpresas(String codigoAssociado, String cnpj, String razaoSocial, String cpf){
		StringBuilder jpql = new StringBuilder("SELECT e FROM DadosEmpresa e WHERE ");
			if (!StringUtils.isEmpty(codigoAssociado)) {
				jpql.append("e.codigoAssociado = :codigoAssociado AND ");
			}
			
			if (!StringUtils.isEmpty(cnpj)) {
				jpql.append("e.cnpj = :cnpj AND ");
			}
			
			if(!StringUtils.isEmpty(razaoSocial)) {
				jpql.append("e.razaoSocial LIKE :razaoSocial AND ");
			}
			
			if(!StringUtils.isEmpty(cpf)) {
				jpql.append("e.dadosContato.cpf = :cpf AND ");
			}
			
			jpql.append("1 = 1");
			
			TypedQuery<DadosEmpresa> q = em.createQuery(jpql.toString(), DadosEmpresa.class);
			
			if (!StringUtils.isEmpty(codigoAssociado)) {
				q.setParameter("codigoAssociado", codigoAssociado);
			}
			
			if (!StringUtils.isEmpty(cnpj)) {
				q.setParameter("cnpj", cnpj);
			}
			
			if(!StringUtils.isEmpty(razaoSocial)) {
				q.setParameter("razaoSocial", "%" + razaoSocial + "%");
			}
			
			if(!StringUtils.isEmpty(cpf)) {
				q.setParameter("cpf", cpf);
			}
			
			return q.getResultList();
			
	}
	
	public List<DadosEmpresa> listStatusDadosEmpresas(Status status){
		return em.createQuery("SELECT e FROM DadosEmpresa e WHERE e.contribuicaoAssociativa.status = :status ORDER BY e.razaoSocial", DadosEmpresa.class)
				.setParameter("status", status)
				.getResultList();
	}

}
