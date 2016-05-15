package controller;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

import model.Relatorio;
import dao.RelatorioDAO;

@ManagedBean
public class RelatorioController implements Serializable {

	private static final long serialVersionUID = 1L;
	private Date date;
	private LineChartModel lineModel;

	@PostConstruct
	public void init() {
		createLineModels();
	}

	public LineChartModel getLineModel() {
		return lineModel;
	}

	private void createLineModels() {
		lineModel = initLinearModel();

		Axis yAxis = lineModel.getAxis(AxisType.Y);

		lineModel.setTitle(obterAno());
		lineModel.setLegendPosition("e");
		lineModel.setShowPointLabels(true);
		lineModel.getAxes().put(AxisType.X, new CategoryAxis("Meses"));

		yAxis = lineModel.getAxis(AxisType.Y);
		yAxis.setLabel("Consumo");
		yAxis.setMin(0);
		yAxis.setMax(1000);
	}

	private LineChartModel initLinearModel() {
		LineChartModel model = new LineChartModel();

		LineChartSeries series = new LineChartSeries();
		series.setLabel("Consumo");
		
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		List<Relatorio> lista = relatorioDAO.gerarRelatorio();
		for (Relatorio r : lista) {
			series.set(r.getMes_saida(), r.getValor_consumido());
		}

		model.addSeries(series);
		return model;
	}

	// retorna o ano atual do sistema
	public String obterAno() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		date = new Date();
		String ano = sdf.format(date);
		return ano;
	}
}
