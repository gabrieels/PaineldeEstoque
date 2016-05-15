package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the tb_relatorio database table.
 * 
 */
@Entity
@Table(name = "tb_relatorio")
@NamedQuery(name = "Relatorio.findAll", query = "SELECT r FROM Relatorio r")
public class Relatorio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_relatorio")
	private Integer idRelatorio;

	@Column(name = "id_material")
	private Integer idMaterial;
	
	@Column(name = "in_qnt_saida")
	private Integer qnt_saida;

	@Column(name = "db_preco_medio")
	private Double precoMedio;

	@Column(name = "cv_descricao")
	private String descricao;

	@Column(name = "dt_mes_saida")
	private String mes_saida;

	@Column(name = "db_valor_consumido")
	private Double valor_consumido;
	
	@Column(name = "dt_saida")
	private Timestamp dtSaida;
	
	// bi-directional many-to-one association to Material
	@ManyToOne
	@JoinColumn(name = "id_material")
	private Material tbMaterial;	
	
	public Relatorio() {
	}
	
	public String getMes_saida() {
		return mes_saida;
	}

	public void setMes_saida(String mes_saida) {
		this.mes_saida = mes_saida;
	}

	public Double getValor_consumido() {
		return valor_consumido;
	}

	public void setValor_consumido(Double valor_consumido) {
		this.valor_consumido = valor_consumido;
	}

	public Integer getIdRelatorio() {
		return this.idRelatorio;
	}

	public void setIdRelatorio(Integer idRelatorio) {
		this.idRelatorio = idRelatorio;
	}

	public Integer getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
	}

	public Timestamp getDtSaida() {
		return dtSaida;
	}

	public void setDtSaida(Timestamp dtSaida) {
		this.dtSaida = dtSaida;
	}

	public Integer getQnt_saida() {
		return qnt_saida;
	}

	public void setQnt_saida(Integer qnt_saida) {
		this.qnt_saida = qnt_saida;
	}

	public Double getPrecoMedio() {
		return precoMedio;
	}

	public void setPrecoMedio(Double precoMedio) {
		this.precoMedio = precoMedio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Material getTbMaterial() {
		return this.tbMaterial;
	}

	public void setTbMaterial(Material tbMaterial) {
		this.tbMaterial = tbMaterial;
	}

	@Override
	public String toString() {
		return "Relatorio [idRelatorio=" + idRelatorio + ", idMaterial=" + idMaterial + ", dtSaida=" + dtSaida
				+ ", qnt_saida=" + qnt_saida + ", precoMedio=" + precoMedio + ", descricao=" + descricao
				+ ", mes_saida=" + mes_saida + ", valor_consumido=" + valor_consumido + ", tbMaterial=" + tbMaterial
				+ "]";
	}

}