package br.com.zbs.sindicato.domain.dadosSindicato;

import java.time.Year;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.zbs.sindicato.application.util.StringUtils;
import br.com.zbs.sindicato.domain.dadosEmpresa.DadosEmpresa;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosSindicato.Regional;
import br.com.zbs.sindicato.domain.dadosEmpresa.ContribuicaoAssociativa.Status;




@Stateless
public class DadosSindicatoRepository {

	
	
	@PersistenceContext
	private EntityManager em;
	
	public void store(DadosSindicato dadosSindicato) {
		em.persist(dadosSindicato);
	}
	
	public void update(DadosSindicato dadosSindicato) {
		em.merge(dadosSindicato);
	}
	
	public DadosSindicato findByCodigoSindicato(String codigoSindicato ) {
		return em.find(DadosSindicato.class, codigoSindicato);
	}
	
	public void delete(String codigoSindicato) {
		DadosSindicato dadosSindicato = findByCodigoSindicato(codigoSindicato);		
		if(dadosSindicato != null) {
			em.remove(dadosSindicato);
		}
	}
	
	public List<DadosSindicato> listDadosSindicatos(){
		TypedQuery<DadosSindicato> q= em.createQuery("SELECT s FROM DadosSindicato s ORDER BY s.nomeSindicato", DadosSindicato.class);
		return q.getResultList();
	}
		
	public String getMaxCodigoSindicatoAno() {
		return em.createQuery("SELECT MAX(s.codigoSindicato) FROM DadosSindicato s WHERE s.codigoSindicato LIKE :ano", String.class)
		.setParameter("ano", Year.now() + "%")
		.getSingleResult();
	}
	
	public List<DadosSindicato> listDadosSindicatos(String codigoSindicato, String siglaSindicato, String nomeSindicato){
		StringBuilder jpql = new StringBuilder("SELECT s FROM DadosSindicato s WHERE ");
	
		
		
		if(!StringUtils.isEmpty(codigoSindicato)) {
			jpql.append("s.codigoSindicato = :codigoSindicato AND ");
		}	
		if(!StringUtils.isEmpty(siglaSindicato)) {
				jpql.append("s.siglaSindicato = :siglaSindicato AND ");
		}
		if(!StringUtils.isEmpty(nomeSindicato)) {
			jpql.append("s.nomeSindicato LIKE :nomeSindicato AND ");			
		}
			
		jpql.append("1=1");		
		TypedQuery<DadosSindicato> q = em.createQuery(jpql.toString(),DadosSindicato.class);
		
		if(!StringUtils.isEmpty(codigoSindicato)) {
			q.setParameter("codigoSindicato", codigoSindicato);
		}	
		if(!StringUtils.isEmpty(siglaSindicato)) {
			q.setParameter("siglaSindicato", siglaSindicato);
		}
		if(!StringUtils.isEmpty(nomeSindicato)) {
			q.setParameter("nomeSindicato", "%" + nomeSindicato + "%");		
		}
			
		return q.getResultList();		
	}
	
	public List<DadosSindicato> listRegionaisDadosSindicatos(Regional regional){
		return em.createQuery("SELECT e FROM DadosSindicato e WHERE e.regional = :regional ORDER BY e.nomeSindicato", DadosSindicato.class)
				.setParameter("regional", regional)
				.getResultList();
		
	}
	
}
