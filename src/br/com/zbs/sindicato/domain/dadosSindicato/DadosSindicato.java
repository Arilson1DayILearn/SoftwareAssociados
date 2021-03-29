package br.com.zbs.sindicato.domain.dadosSindicato;

import java.io.Serializable;
import java.time.Year;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.zbs.sindicato.application.util.StringUtils;
import br.com.zbs.sindicato.domain.dadosEmpresa.Endereco;
import br.com.zbs.sindicato.domain.dadosEmpresa.RG;
import br.com.zbs.sindicato.domain.dadosEmpresa.Telefone;

@Entity
@Table(name = "DADOS_SINDICATO")
public class DadosSindicato implements Serializable {

	public enum Regional {
		Alto_Paranaiba("Alto Paranaíba"), Centro_Oeste("Centro Oeste"), Norte("Norte"),
		Pontal_Do_Triangulo("Pontal do Triangulo"), Rio_Doce("Rio Doce"), Sul("Sul"), Sede("Sede"),
		Vale_Do_Aco("Vale do Aço"), Vale_Do_Jequitinhonha("Vale do Jequitinhonha"),
		Vale_Do_Parnaiba("Vale do Parnaíba"), Vale_Do_Rio_Grande("Vale do Rio Grande"), Zona_Da_Mata("Zona da Mata");

		private String displayName;

		private Regional(String displayName) {
			this.displayName = displayName;
		}

		public String displayName() {
			return this.displayName;
		}

		@Override
		public String toString() {
			return this.displayName;
		}
	}

	@Id
	@Column(name = "ID_SINDICATO", nullable = false, length = 8)
	private String codigoSindicato;

	@Column(name = "NOME_DO_SINDICATO", nullable = false, length = 128)
	private String nomeSindicato;

	@Column(name = "SIGLA_SINDICATO", nullable = false, length = 64)
	private String siglaSindicato;

	@Column(name = "CNPJ", nullable = false, length = 18)
	private String cnpj;

	@Column(name = "CODIGO_ARRECADACAO", nullable = false, length = 19)
	private String codigoArrecadacao;

	@Enumerated(EnumType.STRING)
	@Column(name = "REGIONAL", nullable = false, length = 32)
	private Regional regional;

	@Column(name = "SETOR", nullable = false, length = 64)
	private String setor;

	@Embedded
	private Endereco endereco = new Endereco();

	@Embedded
	private Telefone telefone = new Telefone();

	@Column(name = "EMAIL", nullable = true, length = 64)
	private String email;

	@Column(name = "HOME_PAGE", nullable = true, length = 64)
	private String homePage;

	@Column(name = "LINKEDIN", nullable = true, length = 64)
	private String linkedin;

	@Column(name = "INSTAGRAM", nullable = true, length = 64)
	private String instagram;

	@Column(name = "FACEBOOK", nullable = true, length = 64)
	private String facebook;

	@Column(name = "YOUTUBE", nullable = true, length = 64)
	private String youtube;

	@Column(name = "TWITTER", nullable = true, length = 64)
	private String twitter;

	@Embedded
	private Mandato mandato = new Mandato();

	public void gerarCodigoSindicato(String maxCodigoSindicato) {

		Year year = Year.now();

		if (maxCodigoSindicato == null) {
			maxCodigoSindicato = year + StringUtils.leftZeroes(0, 4);
		}

		int sequential = Integer.parseInt(maxCodigoSindicato.substring(4));
		sequential++;

		this.codigoSindicato = year + StringUtils.leftZeroes(sequential, 4);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoSindicato == null) ? 0 : codigoSindicato.hashCode());
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
		DadosSindicato other = (DadosSindicato) obj;
		if (codigoSindicato == null) {
			if (other.codigoSindicato != null)
				return false;
		} else if (!codigoSindicato.equals(other.codigoSindicato))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DadosSindicato [codigoSindicato=" + codigoSindicato + ", nomeSindicato=" + nomeSindicato
				+ ", siglaSindicato=" + siglaSindicato + ", cnpj=" + cnpj + ", codigoArrecadacao=" + codigoArrecadacao
				+ ", regional=" + regional + ", setor=" + setor + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", email=" + email + ", homePage=" + homePage + ", linkedin=" + linkedin + ", instagram=" + instagram
				+ ", facebook=" + facebook + ", youtube=" + youtube + ", twitter=" + twitter + ", mandato=" + mandato
				+ "]";
	}

	public String getCodigoSindicato() {
		return codigoSindicato;
	}

	public void setCodigoSindicato(String codigoSindicato) {
		this.codigoSindicato = codigoSindicato;
	}

	public String getNomeSindicato() {
		return nomeSindicato;
	}

	public void setNomeSindicato(String nomeSindicato) {
		this.nomeSindicato = nomeSindicato;
	}

	public String getSiglaSindicato() {
		return siglaSindicato;
	}

	public void setSigla(String siglaSindicato) {
		this.siglaSindicato = siglaSindicato;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCodigoArrecadacao() {
		return codigoArrecadacao;
	}

	public void setCodigoArrecadacao(String codigoArrecadacao) {
		this.codigoArrecadacao = codigoArrecadacao;
	}

	public Regional getRegional() {
		return regional;
	}

	public void setRegional(Regional regional) {
		this.regional = regional;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public void setSiglaSindicato(String siglaSindicato) {
		this.siglaSindicato = siglaSindicato;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public Mandato getMandato() {
		return mandato;
	}

	public void setMandato(Mandato mandato) {
		this.mandato = mandato;
	}

}
