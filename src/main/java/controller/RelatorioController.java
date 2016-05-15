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
	private RelatorioDAO relatorioDAO = new RelatorioDAO();

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
		lineModel.getAxes().put(AxisType.X, new CategoryAxis(""));

		yAxis = lineModel.getAxis(AxisType.Y);
		yAxis.setLabel("Consumo");
		yAxis.setMin(0);
		yAxis.setMax(truncaMax((int)getMaxMes()));
	}

	private LineChartModel initLinearModel() {
		LineChartModel model = new LineChartModel();

		LineChartSeries series = new LineChartSeries();
		series.setLabel("Consumo");

		List<Relatorio> lista = getListaRelatorio();
		for (Relatorio r : lista) {
			series.set(r.getMes_saida(), r.getValor_consumido());
		}

		model.addSeries(series);
		return model;
	}

	public List<Relatorio> getListaRelatorio() {

		List<Relatorio> lista = relatorioDAO.gerarRelatorioporMes();
		return lista;
	}

	public double getMaxMes() {
		List<Relatorio> lista = relatorioDAO.gerarRelatorioporMes();
		double temp_max = 0;

		for (Relatorio temp : lista) {
			if (temp.getValor_consumido() > temp_max)
				temp_max = temp.getValor_consumido();
		}
		return temp_max;
	}

	public static int truncaMax(int num) {
		int cont = 0;
		int num_2 = num;
		//Pega a quant de digitos
		while (num_2 != 0) {
			num_2 = num_2 / 10;
			cont++;
		}
		//Subtrai a quantidade total por 2
		cont -= 2;
		num_2 = num;
		
		//Pega somente os dois primeiros digitos
		for (int i = 0; i < cont; i++) {
			num_2 = num_2 / 10;
		}
		//Soma mais dois para alinhar no grafico
		num_2 += 2;
		//Devolve as casas que foram removidas
		for (int i = 0; i < cont; i++) {
			num_2 = num_2 * 10;
		}
		return num_2;
	}

	// retorna o ano atual do sistema
	public String obterAno() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		date = new Date();
		String ano = sdf.format(date);
		return ano;
	}
}
