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

	@Column(name = "cv_classificacao")
	private String Classificacao;

	@Column(name = "db_custo_anual")
	private double dbCustoAnual;

	@Column(name = "per_anual")
	private double perAnual;

	@Column(name = "db_acumulado")
	private double dbAcumulado;

	@Column(name = "per_acumulado")
	private double perAcumulado;

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

	public String getClassificacao() {
		return Classificacao;
	}

	public void setClassificacao(String classificacao) {
		Classificacao = classificacao;
	}

	public double getDbCustoAnual() {
		return dbCustoAnual;
	}

	public void setDbCustoAnual(double dbCustoAnual) {
		this.dbCustoAnual = dbCustoAnual;
	}

	public double getPerAnual() {
		return perAnual;
	}

	public void setPerAnual(double perAnual) {
		this.perAnual = perAnual;
	}

	public double getDbAcumulado() {
		return dbAcumulado;
	}

	public void setDbAcumulado(double dbAcumulado) {
		this.dbAcumulado = dbAcumulado;
	}

	public double getPerAcumulado() {
		return perAcumulado;
	}

	public void setPerAcumulado(double perAcumulado) {
		this.perAcumulado = perAcumulado;
	}

	public Material getTbMaterial() {
		return this.tbMaterial;
	}

	public void setTbMaterial(Material tbMaterial) {
		this.tbMaterial = tbMaterial;
	}

	@Override
	public String toString() {
		return "CurvaAbc [idCurvaAbc=" + idCurvaAbc + ", idMaterial=" + idMaterial + ", Classificacao=" + Classificacao
				+ ", dbCustoAnual=" + dbCustoAnual + ", perAnual=" + perAnual + ", dbAcumulado=" + dbAcumulado
				+ ", perAcumulado=" + perAcumulado + "]";
	}

}