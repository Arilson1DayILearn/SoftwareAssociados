package br.com.zbs.sindicato.domain.dadosEmpresa;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable

public class DadosContato implements Serializable{
	@Column(name = "NOME_CONTATO", nullable = false, length = 64)	
	private String nomeContato;
	
	
	@Column(name = "CPF", nullable = false, length = 14)
	private String cpf;	
	
	@Embedded
	private RG rg = new RG();	
	
	@Column(name = "FUNCAO_CONTATO", nullable = false, length = 30)
	private String funcaoContato;
	
	@Column(name = "DATA_NASCIMENTO", nullable = false)
	private LocalDate dataNascimento;
	
	@Embedded
	private TelefoneCelular telefoneCelular = new TelefoneCelular();
	
	@Column(name = "EMAIL", nullable = true, length = 64)
	private String email;
	
	public String getNomeContato() {
		return nomeContato;
	}
	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}	
	
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public RG getRg() {
		return rg;
	}
	public void setRg(RG rg) {
		this.rg = rg;
	}
	public String getFuncaoContato() {
		return funcaoContato;
	}
	public void setFuncaoContato(String funcaoContato) {
		this.funcaoContato = funcaoContato;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public TelefoneCelular getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(TelefoneCelular telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "DadosContato [nomeContato=" + nomeContato + ", cpf=" + cpf + ", rg=" + rg + ", funcaoContato="
				+ funcaoContato + ", dataNascimento=" + dataNascimento + ", telefoneCelular=" + telefoneCelular
				+ ", email=" + email + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		DadosContato other = (DadosContato) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	

}
