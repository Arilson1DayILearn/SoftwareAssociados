package br.com.zbs.sindicato.domain.dadosSindicato;

import java.io.Serializable;
import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.zbs.sindicato.application.util.StringUtils;
import br.com.zbs.sindicato.domain.dadosEmpresa.TelefoneCelular;

@Entity
@Table(name = "DADOS_FUNCIONARIO")
public class DadosFuncionario implements Serializable {

	@Id
	@Column(name = "CODIGO_FUNCIONARIO", nullable = false)
	private String codigoFuncionario;

	@Column(name = "NOME_FUNCIONARIO", nullable = false, length = 64)
	private String nomeFuncionario;

	@Column(name = "CARGO_FUNCIONARIO", nullable = false, length = 32)
	private String cargoFuncionario;

	@Embedded
	private TelefoneCelular telefoneCelular = new TelefoneCelular();

	@Column(name = "FOTO_FUNCIONARIO", nullable = true, length = 80)
	private String fotoFuncionario;

	@ManyToOne
	@JoinColumn(name = "CODIGO_SINDICATO", nullable = false)
	private DadosSindicato dadosSindicato = new DadosSindicato();

	public String getFotoFuncionario() {
		return fotoFuncionario;
	}

	public void setFotoFuncionario(String fotoFuncionario) {
		this.fotoFuncionario = fotoFuncionario;
	}

	public String getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(String codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public String getCargoFuncionario() {
		return cargoFuncionario;
	}

	public void setCargoFuncionario(String cargoFuncionario) {
		this.cargoFuncionario = cargoFuncionario;
	}

	public TelefoneCelular getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(TelefoneCelular telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public DadosSindicato getDadosSindicato() {
		return dadosSindicato;
	}

	public void setDadosSindicato(DadosSindicato dadosSindicato) {
		this.dadosSindicato = dadosSindicato;
	}
	
	public void gerarCodigoFuncionario(String maxCodigoFuncionario) {
		Year year = Year.now();
		
		if (maxCodigoFuncionario == null) {
			maxCodigoFuncionario = year + StringUtils.leftZeroes(0, 4);
		}
		
		int sequential = Integer.parseInt(maxCodigoFuncionario.substring(4));
		sequential++;
		
		this.codigoFuncionario = year + StringUtils.leftZeroes(sequential, 4);
		
	}

	@Override
	public String toString() {
		return "DadosFuncionario [codigoFuncionario=" + codigoFuncionario + ", nomeFuncionario=" + nomeFuncionario
				+ ", cargoFuncionario=" + cargoFuncionario + ", telefoneCelular=" + telefoneCelular
				+ ", fotoFuncionario=" + fotoFuncionario + ", dadosSindicato=" + dadosSindicato + "]";
	}

}
