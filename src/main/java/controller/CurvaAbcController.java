package controller;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.PieChartModel;

import dao.Curva_AbcDAO;
import model.CurvaAbc;

@ManagedBean
public class CurvaAbcController implements Serializable {

	final int A = 80;
	final int B = 15;
	final int C = 5;
	private static final long serialVersionUID = 1L;
	private PieChartModel pieModel;

	private Curva_AbcDAO curva_AbcDAO = new Curva_AbcDAO();
	private List<CurvaAbc> selectedCurvaAbc = new ArrayList<CurvaAbc>();

	public List<CurvaAbc> listener(ItemSelectEvent e) {
		// Reseta a lista
		List<CurvaAbc> lista = curva_AbcDAO.gerarCurvaAbc();
		this.selectedCurvaAbc = new ArrayList<CurvaAbc>();

		// Categoria A foi selecionada
		if (e.getItemIndex() == 0) {

			for (CurvaAbc r : lista) {
				CurvaAbc curvaAbc = new CurvaAbc();
				if (r.getClassificacao().equals("A")) {
					curvaAbc.setClassificacao(r.getClassificacao());
					double x = casas2(r.getPercentual());
					curvaAbc.setPercentual(x);
					curvaAbc.setDescricao(r.getDescricao());
					
					this.selectedCurvaAbc.add(curvaAbc);
				}
			}
		}

		// Categoria B foi selecionada
		else if (e.getItemIndex() == 1) {

			for (CurvaAbc r : lista) {
				CurvaAbc curvaAbc = new CurvaAbc();
				if (r.getClassificacao().equals("B")) {
					curvaAbc.setClassificacao(r.getClassificacao());
					double x = casas2(r.getPercentual());
					curvaAbc.setPercentual(x);
					curvaAbc.setDescricao(r.getDescricao());
					
					this.selectedCurvaAbc.add(curvaAbc);
				}
			}
		}

		// Categoria C foi selecionada
		else if (e.getItemIndex() == 2) {

			for (CurvaAbc r : lista) {
				CurvaAbc curvaAbc = new CurvaAbc();
				if (r.getClassificacao().equals("C")) {
					curvaAbc.setClassificacao(r.getClassificacao());
					double x = casas2(r.getPercentual());
					curvaAbc.setPercentual(x);
					curvaAbc.setDescricao(r.getDescricao());
					
					this.selectedCurvaAbc.add(curvaAbc);
				}
			}
		}

		return selectedCurvaAbc;
	}

	public List<CurvaAbc> getSelectedCurvaAbc() {
		return selectedCurvaAbc;
	}

	public void setSelectedCurvaAbc(List<CurvaAbc> selectedCurvaAbc) {
		this.selectedCurvaAbc = selectedCurvaAbc;
	}

	@PostConstruct
	public void init() {
		createPieModels();
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	private void createPieModels() {
		createPieModel();
	}

	private void createPieModel() {
		pieModel = new PieChartModel();

		pieModel = new PieChartModel();

		pieModel.set("Classe A", A);
		pieModel.set("Classe B", B);
		pieModel.set("Classe C", C);
		pieModel.setSeriesColors("66cc66,E7E658,cc6666");
		// pieModel1.setTitle("Curva ABC");
		pieModel.setLegendPosition("S");
	}

	// Metodo para limitar o numero de casas decimais de um double
	public double casas2(double v1) {
		v1 = v1 * 100;
		int v2 = (int) v1; // Pega parte antes da virgula
		double v3 = v1 - v2; // Pega parte apos a virgula
		int v4 = (int) (v3 * 100); // obtem as primeiras duas casa decimais
		double v5 = (v2 + ((double) v4 / 100)); // Agrupa novamente
		
		return v5;
	}
}
