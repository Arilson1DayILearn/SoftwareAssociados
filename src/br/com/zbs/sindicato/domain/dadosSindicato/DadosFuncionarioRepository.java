package br.com.zbs.sindicato.domain.dadosSindicato;

import java.time.Year;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.zbs.sindicato.application.util.StringUtils;

@Stateless
public class DadosFuncionarioRepository {

	@PersistenceContext
	private EntityManager em;

	public void store(DadosFuncionario dadosFuncionario) {
		em.persist(dadosFuncionario);
	}

	public void update(DadosFuncionario dadosFuncionario) {
		em.merge(dadosFuncionario);
	}

	public DadosFuncionario findByCodigoFuncionario(String codigoFuncionario) {
		return em.find(DadosFuncionario.class, codigoFuncionario);
	}

	public void delete(String codigoFuncionario) {
		DadosFuncionario dadosFuncionario = findByCodigoFuncionario(codigoFuncionario);
		if (dadosFuncionario != null) {
			em.remove(dadosFuncionario);
		}
	}

	public List<DadosFuncionario> listDadosFuncionario() {
		TypedQuery<DadosFuncionario> q = em.createQuery("SELECT f FROM DadosFuncionario f ORDER BY s.nomeFuncionario",
				DadosFuncionario.class);
		return q.getResultList();
	}

	public String getMaxCodigoFuncionarioAno() {
		return em.createQuery(
				"SELECT MAX(f.codigoFuncionario) FROM DadosFuncionario f WHERE f.codigoFuncionario LIKE :ano",
				String.class).setParameter("ano", Year.now() + "%").getSingleResult();
	}

	public List<DadosFuncionario> listDadosFuncionarios(String codigoFuncionario, String siglaSindicato,
			String nomeFuncionario) {
		StringBuilder jpql = new StringBuilder("SELECT f FROM DadosSindicato f WHERE ");

		if (!StringUtils.isEmpty(codigoFuncionario)) {
			jpql.append("f.codigoFuncionario = :codigoFuncionario AND ");
		}
		if (!StringUtils.isEmpty(siglaSindicato)) {
			jpql.append("s.siglaSindicato = :siglaSindicato AND ");
		}
		if (!StringUtils.isEmpty(nomeFuncionario)) {
			jpql.append("s.nomeFuncionario LIKE :nomeFuncionario AND ");
		}

		jpql.append("1=1");
		TypedQuery<DadosFuncionario> q = em.createQuery(jpql.toString(), DadosFuncionario.class);

		if (!StringUtils.isEmpty(codigoFuncionario)) {
			q.setParameter("codigoSindicato", codigoFuncionario);
		}
		if (!StringUtils.isEmpty(siglaSindicato)) {
			q.setParameter("siglaSindicato", siglaSindicato);
		}
		if (!StringUtils.isEmpty(nomeFuncionario)) {
			q.setParameter("nomeSindicato", "%" + nomeFuncionario + "%");
		}

		return q.getResultList();
	}

}
