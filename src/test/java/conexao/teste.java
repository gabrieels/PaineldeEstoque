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

	public static void main(String[] args) {
		//testGerarIndicador();
		//testGerarRelatorio();
		testGerarCurvaAbc();
		//testBuscarTodos();

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
			System.out.println(r);
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
}
