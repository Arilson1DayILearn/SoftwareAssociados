package br.com.zbs.sindicato.domain.dadosEmpresa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TelefoneCelular implements Serializable {
	
	@Column (name = "TELEFONE_CELULAR_DDD", nullable = false, length = 2)
	private Integer telefoneCelularDDD;
	
	@Column (name = "TELEFONE_CELULAR_NUMERO", nullable = true, length = 9)
	private Integer telefoneCelularNumero;

	public Integer getTelefoneCelularDDD() {
		return telefoneCelularDDD;
	}

	public void setTelefoneCelularDDD(Integer telefoneCelularDDD) {
		this.telefoneCelularDDD = telefoneCelularDDD;
	}

	public Integer getTelefoneCelularNumero() {
		return telefoneCelularNumero;
	}

	public void setTelefoneCelularNumero(Integer telefoneCelularNumero) {
		this.telefoneCelularNumero = telefoneCelularNumero;
	}

	@Override
	public String toString() {
		return "TelefoneCelular [telefoneCelularDDD=" + telefoneCelularDDD + ", telefoneCelularNumero="
				+ telefoneCelularNumero + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((telefoneCelularDDD == null) ? 0 : telefoneCelularDDD.hashCode());
		result = prime * result + ((telefoneCelularNumero == null) ? 0 : telefoneCelularNumero.hashCode());
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
		TelefoneCelular other = (TelefoneCelular) obj;
		if (telefoneCelularDDD == null) {
			if (other.telefoneCelularDDD != null)
				return false;
		} else if (!telefoneCelularDDD.equals(other.telefoneCelularDDD))
			return false;
		if (telefoneCelularNumero == null) {
			if (other.telefoneCelularNumero != null)
				return false;
		} else if (!telefoneCelularNumero.equals(other.telefoneCelularNumero))
			return false;
		return true;
	}	

}
