package br.com.zbs.sindicato.domain.dadosEmpresa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RG implements Serializable{

	@Column (name = "RG_NUMERO", nullable = false, length = 16)
	private String rgNumero;
	
	@Column (name = "RG_ORGAO", nullable = false, length = 16)
	private String rgOrgao;
	
	@Column (name = "RG_NATURALIDADE", nullable = false, length = 16)
	private String rgNaturalidade;

	public String getRgNumero() {
		return rgNumero;
	}

	public void setRgNumero(String rgNumero) {
		this.rgNumero = rgNumero;
	}

	public String getRgOrgao() {
		return rgOrgao;
	}

	public void setRgOrgao(String rgOrgao) {
		this.rgOrgao = rgOrgao;
	}

	public String getRgNaturalidade() {
		return rgNaturalidade;
	}

	public void setRgNaturalidade(String rgNaturalidade) {
		this.rgNaturalidade = rgNaturalidade;
	}

	@Override
	public String toString() {
		return "RG [rgNumero=" + rgNumero + ", rgOrgao=" + rgOrgao + ", rgNaturalidade=" + rgNaturalidade + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rgNaturalidade == null) ? 0 : rgNaturalidade.hashCode());
		result = prime * result + ((rgNumero == null) ? 0 : rgNumero.hashCode());
		result = prime * result + ((rgOrgao == null) ? 0 : rgOrgao.hashCode());
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
		RG other = (RG) obj;
		if (rgNaturalidade == null) {
			if (other.rgNaturalidade != null)
				return false;
		} else if (!rgNaturalidade.equals(other.rgNaturalidade))
			return false;
		if (rgNumero == null) {
			if (other.rgNumero != null)
				return false;
		} else if (!rgNumero.equals(other.rgNumero))
			return false;
		if (rgOrgao == null) {
			if (other.rgOrgao != null)
				return false;
		} else if (!rgOrgao.equals(other.rgOrgao))
			return false;
		return true;
	}
	
	

}
