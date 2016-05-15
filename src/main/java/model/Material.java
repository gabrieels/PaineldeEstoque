package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the tb_material database table.
 * 
 */
@Entity
@Table(name="tb_material")
@NamedQuery(name="Material.findAll", query="SELECT m FROM Material m")
public class Material implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_material")
	private Integer idMaterial;

	@Column(name="cv_descricao")
	private String descricao;
	
	@Column(name="und_material")
	private String unidade;
	
	@Column(name="tp_material")
	private String tipo_material;

	@Column(name="cv_familia")
	private String familia;

	@Column(name="nu_qnt_minima")
	private Integer qnt_minima;
	
	@Column(name="db_preco_medio")
	private double preco_medio;

	public Integer getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getTipoMaterial() {
		return tipo_material;
	}

	public void setTipoMaterial(String tipo_material) {
		this.tipo_material = tipo_material;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public Integer getQntMinima() {
		return qnt_minima;
	}

	public void setQntMinima(Integer qnt_minima) {
		this.qnt_minima = qnt_minima;
	}

	public double getPrecoMedio() {
		return preco_medio;
	}

	public void setPrecoMedio(double preco_medio) {
		this.preco_medio = preco_medio;
	}

	@Override
	public String toString() {
		return "Material [idMaterial=" + idMaterial + ", descricao=" + descricao + ", unidade=" + unidade
				+ ", tipo_material=" + tipo_material + ", familia=" + familia + ", qnt_minima=" + qnt_minima
				+ ", preco_medio=" + preco_medio + "]";
	}

	public Material() {
	}

	//bi-directional many-to-one association to CurvaAbc
	@OneToMany(mappedBy="tbMaterial")
	private List<CurvaAbc> tbCurvaAbcs;

	//bi-directional many-to-one association to Indicador
	@OneToMany(mappedBy="tbMaterial")
	private List<Indicador> tbIndicadors;

	//bi-directional many-to-one association to Relatorio
	@OneToMany(mappedBy="tbMaterial")
	private List<Relatorio> tbRelatorios;

	public List<CurvaAbc> getTbCurvaAbcs() {
		return this.tbCurvaAbcs;
	}

	public void setTbCurvaAbc(List<CurvaAbc> tbCurvaAbcs) {
		this.tbCurvaAbcs = tbCurvaAbcs;
	}

	public CurvaAbc addTbCurvaAbc(CurvaAbc tbCurvaAbc) {
		getTbCurvaAbcs().add(tbCurvaAbc);
		tbCurvaAbc.setTbMaterial(this);

		return tbCurvaAbc;
	}

	public CurvaAbc removeTbCurvaAbc(CurvaAbc tbCurvaAbc) {
		getTbCurvaAbcs().remove(tbCurvaAbc);
		tbCurvaAbc.setTbMaterial(null);

		return tbCurvaAbc;
	}

	public List<Indicador> getTbIndicadors() {
		return this.tbIndicadors;
	}

	public void setTbIndicadors(List<Indicador> tbIndicadors) {
		this.tbIndicadors = tbIndicadors;
	}

	public Indicador addTbIndicador(Indicador tbIndicador) {
		getTbIndicadors().add(tbIndicador);
		tbIndicador.setTbMaterial(this);

		return tbIndicador;
	}

	public Indicador removeTbIndicador(Indicador tbIndicador) {
		getTbIndicadors().remove(tbIndicador);
		tbIndicador.setTbMaterial(null);

		return tbIndicador;
	}

	public List<Relatorio> getTbRelatorios() {
		return this.tbRelatorios;
	}

	public void setTbRelatorios(List<Relatorio> tbRelatorios) {
		this.tbRelatorios = tbRelatorios;
	}

	public Relatorio addTbRelatorio(Relatorio tbRelatorio) {
		getTbRelatorios().add(tbRelatorio);
		tbRelatorio.setTbMaterial(this);

		return tbRelatorio;
	}

	public Relatorio removeTbRelatorio(Relatorio tbRelatorio) {
		getTbRelatorios().remove(tbRelatorio);
		tbRelatorio.setTbMaterial(null);

		return tbRelatorio;
	}

}