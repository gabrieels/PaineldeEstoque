package conexao;

import java.util.List;

import dao.MaterialDAO;
import dao.RelatorioDAO;
import dao.IndicadorDAO;
import dao.Curva_AbcDAO;
import model.Material;
import model.Relatorio;
import model.Indicador;
import model.CurvaAbc;

public class teste {
	private static int x = 1300;

	public static void main(String[] args) {
		// testGerarIndicador();
		 testGerarRelatorio();
		// testGerarCurvaAbc();
		// testBuscarTodos();
		//gerarRelatorioporMes();
		//System.out.println(truncaMax(x));

	}

	private static void testBuscarTodos() {
		MaterialDAO materialDAO = new MaterialDAO();
		List<Material> lista = materialDAO.buscarTodos();
		for (Material m : lista) {
			System.out.println(m);
		}
	}

	private static void testGerarRelatorio() {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		List<Relatorio> lista = relatorioDAO.gerarRelatorio();
		for (Relatorio r : lista) {
			System.out.println(r.getDtSaida() + " " + r.getValor_consumido());
		}
	}

	private static void testGerarIndicador() {
		IndicadorDAO indicadorDAO = new IndicadorDAO();
		List<Indicador> lista = indicadorDAO.gerarIndicador();
		for (Indicador i : lista) {
			System.out.println(i);
		}
	}

	private static void testGerarCurvaAbc() {
		Curva_AbcDAO curvaAbcDAO = new Curva_AbcDAO();
		List<CurvaAbc> lista = curvaAbcDAO.gerarCurvaAbc();
		for (CurvaAbc c : lista) {
			System.out.println(c);
		}
	}

	private static void gerarRelatorioporMes() {
		RelatorioDAO relatorioDAO = new RelatorioDAO();
		List<Relatorio> lista = relatorioDAO.gerarRelatorioporMes();
		for (Relatorio r : lista) {
			System.out.println(r.getMes_saida() + " " + r.getValor_consumido());
		}
	}

	public static int truncaMax(int num) {
		int cont = 0;
		int num_2 = num;
		
		while (num_2 != 0) {
			num_2 = num_2 / 10;
			cont++;
		}
		cont -= 2;
		num_2 = num;
		
		for (int i = 0; i < cont; i++) {
			num_2 = num_2 / 10;
		}
		num_2 += 1;

		for (int i = 0; i < cont; i++) {
			num_2 = num_2 * 10;
		}
		return num_2;
	}
}
