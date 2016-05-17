package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the tb_curva_abc database table.
 * 
 */
@Entity
@Table(name = "tb_curva_abc")
@NamedQuery(name = "CurvaAbc.findAll", query = "SELECT c FROM CurvaAbc c")
public class CurvaAbc implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_curva")
	private Integer idCurvaAbc;

	@Column(name = "id_material")
	private Integer idMaterial;
	
	@Column(name = "cv_descricao")
	private String Descricao;

	@Column(name = "cv_classificacao")
	private String Classificacao;

	@Column(name = "db_percentual")
	private double percentual;

	@Column(name = "db_per_acumulado")
	private double perAcumulado;

	@Column(name = "db_valor_consumido")
	private double valorConsumido;

	@Column(name = "in_qnt_saida")
	private double qntSaida;

	// bi-directional many-to-one association to Material
	@ManyToOne
	@JoinColumn(name = "id_material")
	private Material tbMaterial;

	public CurvaAbc() {
	}

	public Integer getIdCurvaAbc() {
		return idCurvaAbc;
	}

	public void setIdCurvaAbc(Integer idCurvaAbc) {
		this.idCurvaAbc = idCurvaAbc;
	}

	public Integer getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public String getClassificacao() {
		return Classificacao;
	}

	public void setClassificacao(String classificacao) {
		Classificacao = classificacao;
	}

	public double getPercentual() {
		return percentual;
	}

	public void setPercentual(double percentual) {
		this.percentual = percentual;
	}

	public double getPerAcumulado() {
		return perAcumulado;
	}

	public void setPerAcumulado(double perAcumulado) {
		this.perAcumulado = perAcumulado;
	}

	public double getValorConsumido() {
		return valorConsumido;
	}

	public void setValorConsumido(double valorConsumido) {
		this.valorConsumido = valorConsumido;
	}

	public double getQntSaida() {
		return qntSaida;
	}

	public void setQntSaida(double qntSaida) {
		this.qntSaida = qntSaida;
	}

	public Material getTbMaterial() {
		return this.tbMaterial;
	}

	public void setTbMaterial(Material tbMaterial) {
		this.tbMaterial = tbMaterial;
	}

	@Override
	public String toString() {
		return "CurvaAbc [idCurvaAbc=" + idCurvaAbc + ", idMaterial=" + idMaterial + ", Descricao=" + Descricao
				+ ", Classificacao=" + Classificacao + ", percentual=" + percentual + ", perAcumulado=" + perAcumulado
				+ ", valorConsumido=" + valorConsumido + ", qntSaida=" + qntSaida + "]";
	}

}