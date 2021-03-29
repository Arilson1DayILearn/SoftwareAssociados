package br.com.zbs.sindicato.domain.dadosEmpresa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Telefone implements Serializable {
	
	@Column (name = "TELEFONE_DDD", nullable = true, length = 2)
	private Integer telefoneDDD;
	
	@Column (name = "TELEFONE_NUMERO", nullable = false, length = 8)
	private Integer telefoneNumero;

	public Integer getTelefoneDDD() {
		return telefoneDDD;
	}

	public void setTelefoneDDD(Integer telefoneDDD) {
		this.telefoneDDD = telefoneDDD;
	}

	public Integer getTelefoneNumero() {
		return telefoneNumero;
	}

	public void setTelefoneNumero(Integer telefoneNumero) {
		this.telefoneNumero = telefoneNumero;
	}

	@Override
	public String toString() {
		return "Telefone [telefoneDDD=" + telefoneDDD + ", telefoneNumero=" + telefoneNumero + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((telefoneDDD == null) ? 0 : telefoneDDD.hashCode());
		result = prime * result + ((telefoneNumero == null) ? 0 : telefoneNumero.hashCode());
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
		Telefone other = (Telefone) obj;
		if (telefoneDDD == null) {
			if (other.telefoneDDD != null)
				return false;
		} else if (!telefoneDDD.equals(other.telefoneDDD))
			return false;
		if (telefoneNumero == null) {
			if (other.telefoneNumero != null)
				return false;
		} else if (!telefoneNumero.equals(other.telefoneNumero))
			return false;
		return true;
	}	

}
