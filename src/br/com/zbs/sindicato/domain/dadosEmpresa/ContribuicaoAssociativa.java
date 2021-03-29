package br.com.zbs.sindicato.domain.dadosEmpresa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class ContribuicaoAssociativa implements Serializable {

	public enum Status {
		Adimplente, Inadimplente, Inativo;
	}

	@Column(name = "DATA_ASSOCIACAO", nullable = false)
	private LocalDate dataAssociacao;

	@Column(name = "VALOR_MENSALIDADE", nullable = false, length = 6)
	private BigDecimal valorMensalidade;

	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", nullable = false, length = 16)
	private Status status;

	public LocalDate getDataAssociacao() {
		return dataAssociacao;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setDataAssociacao(LocalDate dataAssociacao) {
		this.dataAssociacao = dataAssociacao;
	}

	public BigDecimal getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(BigDecimal valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}

	@Override
	public String toString() {
		return "ContribuicaoAssociativa [dataAssociacao=" + dataAssociacao + ", valorMensalidade=" + valorMensalidade
				+ ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAssociacao == null) ? 0 : dataAssociacao.hashCode());
		result = prime * result + ((valorMensalidade == null) ? 0 : valorMensalidade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContribuicaoAssociativa other = (ContribuicaoAssociativa) obj;
		if (dataAssociacao == null) {
			if (other.dataAssociacao != null)
				return false;
		} else if (!dataAssociacao.equals(other.dataAssociacao))
			return false;
		if (valorMensalidade == null) {
			if (other.valorMensalidade != null)
				return false;
		} else if (!valorMensalidade.equals(other.valorMensalidade))
			return false;
		return true;
	}

}
