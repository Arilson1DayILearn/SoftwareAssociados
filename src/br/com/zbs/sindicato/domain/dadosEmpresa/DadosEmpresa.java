package br.com.zbs.sindicato.domain.dadosEmpresa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Year;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.zbs.sindicato.application.util.StringUtils;
import br.com.zbs.sindicato.domain.dadosSindicato.DadosSindicato;


@Entity
@Table(name = "DADOS_EMPRESA")
public class DadosEmpresa implements Serializable {	
	
	@ManyToOne
	@JoinColumn(name = "CODIGO_SINDICATO", nullable = false)
	private DadosSindicato dadosSindicato = new DadosSindicato();

	public DadosSindicato getDadosSindicato() {
		return dadosSindicato;
	}

	public void setDadosSindicato(DadosSindicato dadosSindicato) {
		this.dadosSindicato = dadosSindicato;
	}

	public enum naturezaJuridica{
		SA, LTDA, Individual, Outra;
	}
	
	public enum TipoEstabelecimento{
		Único, Principal, Flial, Outro;
	}
	
	@Id	
	@Column(name="ID", nullable=false, length=8)
	private String codigoAssociado;
	
	public String getCodigoAssociado() {
		return codigoAssociado;
	}

	public void setCodigoAssociado(String codigoAssociado) {
		this.codigoAssociado = codigoAssociado;
	}
	
	@Column(name = "RAZAO_SOCIAL", nullable = false, length = 64)
	private String razaoSocial;
	
	@Column(name = "NOME_FANTASIA", nullable = false, length = 64)
	private String nomeFantasia;	
	
	@Column(name = "CNPJ", nullable = false, length = 19)
	private String cnpj;		
	
	@Column(name = "ATIVIDADE_ECONOMICA", nullable = false, length = 14)
	private String codigoAtividade;
	
	@Column(name = "DESCRICAO", nullable = false, length = 128)
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "NATUREZA_JURIDICA", nullable = false, length = 16)
	private naturezaJuridica naturezaJuridica;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_ESTABELECIMENTO", nullable = false, length = 16)
	private TipoEstabelecimento tipoEstabelecimento;
	
	@Column(name = "CAPITAL_SOCIAL", nullable = false, length = 12)
	private BigDecimal capitalSocial;	
	
	@Column(name = "NUMERO_FUNCIONARIOS", nullable = false, length = 5)
	private Integer numeroFuncionarios;	
	
	@Embedded
	private Endereco endereco = new Endereco();
	
	@Embedded
	private Telefone telefone = new Telefone();
	
	@Embedded
	private ContribuicaoAssociativa contribuicaoAssociativa = new ContribuicaoAssociativa();
	
	@Embedded
	private DadosContato dadosContato = new DadosContato();
	
	public void gerarCodigoAssociado(String maxCodigoAssociado) {
		Year year = Year.now();
		
		if (maxCodigoAssociado == null) {
			maxCodigoAssociado = year + StringUtils.leftZeroes(0, 4);
		}
		
		int sequential = Integer.parseInt(maxCodigoAssociado.substring(4));
		sequential++;
		
		this.codigoAssociado = year + StringUtils.leftZeroes(sequential, 4);
		
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCodigoAtividade() {
		return codigoAtividade;
	}

	public void setCodigoAtividade(String codigoAtividade) {
		this.codigoAtividade = codigoAtividade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public naturezaJuridica getnaturezaJuridica() {
		return naturezaJuridica;
	}

	public void setnaturezaJuridica(naturezaJuridica naturezaJuridica) {
		this.naturezaJuridica = naturezaJuridica;
	}

	public TipoEstabelecimento getTipoEstabelecimento() {
		return tipoEstabelecimento;
	}

	public void setTipoEstabelecimento(TipoEstabelecimento tipoEstabelecimento) {
		this.tipoEstabelecimento = tipoEstabelecimento;
	}

	public BigDecimal getCapitalSocial() {
		return capitalSocial;
	}

	public void setCapitalSocial(BigDecimal capitalSocial) {
		this.capitalSocial = capitalSocial;
	}

	public Integer getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(Integer numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
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

	public ContribuicaoAssociativa getContribuicaoAssociativa() {
		return contribuicaoAssociativa;
	}

	public void setContribuicaoAssociativa(ContribuicaoAssociativa contribuicaoAssociativa) {
		this.contribuicaoAssociativa = contribuicaoAssociativa;
	}

	public DadosContato getDadosContato() {
		return dadosContato;
	}

	public void setDadosContato(DadosContato dadosContato) {
		this.dadosContato = dadosContato;
	}

	@Override
	public String toString() {
		return "DadosEmpresa [dadosSindicato=" + dadosSindicato + ", codigoAssociado=" + codigoAssociado
				+ ", razaoSocial=" + razaoSocial + ", nomeFantasia=" + nomeFantasia + ", cnpj=" + cnpj
				+ ", codigoAtividade=" + codigoAtividade + ", descricao=" + descricao + ", naturezaJuridica="
				+ naturezaJuridica + ", tipoEstabelecimento=" + tipoEstabelecimento + ", capitalSocial=" + capitalSocial
				+ ", numeroFuncionarios=" + numeroFuncionarios + ", endereco=" + endereco + ", telefone=" + telefone
				+ ", contribuicaoAssociativa=" + contribuicaoAssociativa + ", dadosContato=" + dadosContato + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoAssociado == null) ? 0 : codigoAssociado.hashCode());
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
		DadosEmpresa other = (DadosEmpresa) obj;
		if (codigoAssociado == null) {
			if (other.codigoAssociado != null)
				return false;
		} else if (!codigoAssociado.equals(other.codigoAssociado))
			return false;
		return true;
	}	
	
}	