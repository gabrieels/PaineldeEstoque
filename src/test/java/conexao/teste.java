package conexao;

import java.util.List;

import controller.RelatorioController;
import dao.MaterialDAO;
import dao.RelatorioDAO;
import model.Material;
import model.Relatorio;

public class teste {

	public static void main(String[] args) {
		//RelatorioController relatorioController = new RelatorioController();
		//relatorioController.initCategoryModel();
		testGerarRelatorio();
		// testBuscarTodos();

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
		for (Relatorio m : lista) {
			System.out.println(m);
		}
	}
}
