package model;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * The persistent class for the tb_indicador database table.
 * 
 */
@Entity
@Table(name = "tb_indicador")
@NamedQuery(name = "Indicador.findAll", query = "SELECT i FROM Indicador i")
public class Indicador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_indicador")
	private Integer idIndicador;

	@Column(name = "id_material")
	private Integer idMaterial;

	@Column(name = "cv_lote")
	private String lote;

	@Column(name = "dt_vencimento")
	private Timestamp vencimento;

	@Column(name = "qnt_estoque")
	private Integer qntEstoque;

	// bi-directional many-to-one association to Material
	@ManyToOne
	@JoinColumn(name = "id_material")
	private Material tbMaterial;

	public Indicador() {
	}

	public Integer getIdIndicador() {
		return idIndicador;
	}

	public void setIdIndicador(Integer idIndicador) {
		this.idIndicador = idIndicador;
	}

	public Integer getIdMaterial() {
		return idMaterial;
	}

	public void setIdMaterial(Integer idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public Timestamp getVencimento() {
		return vencimento;
	}

	public void setVencimento(Timestamp vencimento) {
		this.vencimento = vencimento;
	}

	public Integer getQntEstoque() {
		return qntEstoque;
	}

	public void setQntEstoque(Integer qntEstoque) {
		this.qntEstoque = qntEstoque;
	}

	public Material getTbMaterial() {
		return tbMaterial;
	}

	public void setTbMaterial(Material tbMaterial) {
		this.tbMaterial = tbMaterial;
	}

	@Override
	public String toString() {
		return "Indicador [idIndicador=" + idIndicador + ", idMaterial=" + idMaterial + ", lote=" + lote
				+ ", vencimento=" + vencimento + ", qntEstoque=" + qntEstoque + "]";
	}

}