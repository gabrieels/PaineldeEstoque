package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Relatorio;

public class RelatorioDAO {
	private Connection con = Conexao.getConnection();

	public List<Relatorio> gerarRelatorio() {

		String sql = "Select id_relatorio,t1.id_material,cv_descricao,db_preco_medio,dt_saida,in_qnt_saida,db_valor_consumido "
				+ "from tb_relatorio t1 join tb_material t2 " + "on t1.id_material = t2.id_material "
				+ "order by dt_saida";
		List<Relatorio> lista = new ArrayList<Relatorio>();

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			ResultSet resultado = preparador.executeQuery();
			// Posicionando o cursor no primeiro registro
			while (resultado.next()) {
				Relatorio relatorio = new Relatorio();
				relatorio.setIdRelatorio(resultado.getInt("id_relatorio"));
				relatorio.setIdMaterial(resultado.getInt("id_material"));
				relatorio.setDescricao(resultado.getString("cv_descricao"));
				relatorio.setPrecoMedio(resultado.getDouble("db_preco_medio"));
				relatorio.setDtSaida(resultado.getTimestamp("dt_saida"));
				relatorio.setQnt_saida(resultado.getInt("in_qnt_saida"));
				relatorio.setValor_consumido(resultado.getDouble("db_valor_consumido"));

				// Adicionando relatorio na lista
				lista.add(relatorio);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return lista;
	}

	public List<Relatorio> gerarRelatorioporMes() {

		String sql = "select "+
				"case "+
				"when date_part('month', dt_saida) = 1 then 'Janeiro' "+
				"when date_part('month', dt_saida) = 2 then 'Fevereiro' "+
				"when date_part('month', dt_saida) = 3 then 'Março' "+
				"when date_part('month', dt_saida) = 4 then 'Abril' "+
				"when date_part('month', dt_saida) = 5 then 'Maio' "+
				"when date_part('month', dt_saida) = 6 then 'Junho' "+
				"when date_part('month', dt_saida) = 7 then 'Julho' "+
				"when date_part('month', dt_saida) = 8 then 'Agosto' "+
				"when date_part('month', dt_saida) = 9 then 'Setembro' "+
				"when date_part('month', dt_saida) = 10 then 'Outubro' "+
				"when date_part('month', dt_saida) = 11 then 'Novembro' "+
				"when date_part('month', dt_saida) = 12 then 'Dezembro' "+
				"end, "+
				"SUM(db_valor_consumido) "+
				"from tb_relatorio "+ 
				"group by date_part('month', dt_saida) "+
				"order by date_part('month', dt_saida);";

		List<Relatorio> lista = new ArrayList<Relatorio>();
		
		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			ResultSet resultado = preparador.executeQuery();
			// Posicionando o cursor no primeiro registro
			while (resultado.next()) {
				Relatorio relatorio = new Relatorio();
				relatorio.setMes_saida(resultado.getString("case"));
				relatorio.setValor_consumido(resultado.getDouble("sum"));

				// Adicionando relatorio na lista
				lista.add(relatorio);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lista;
	}

}
