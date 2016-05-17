package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CurvaAbc;

public class Curva_AbcDAO {
	private Connection con = Conexao.getConnection();

	public List<CurvaAbc> gerarCurvaAbc() {

		String sql = "Select id_curva, t1.id_material, cv_descricao, cv_classificacao, db_percentual, db_per_acumulado, db_valor_consumido, in_qnt_saida "
				+ "from tb_curva_abc t1 join tb_material t2 on t1.id_material = t2.id_material "
				+ "order by cv_classificacao";
		List<CurvaAbc> lista = new ArrayList<CurvaAbc>();

		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			ResultSet resultado = preparador.executeQuery();
			// Posicionando o cursor no primeiro registro
			while (resultado.next()) {
				CurvaAbc curvaAbc = new CurvaAbc();
				curvaAbc.setIdCurvaAbc(resultado.getInt("id_curva"));
				curvaAbc.setIdMaterial(resultado.getInt("id_material"));
				curvaAbc.setDescricao(resultado.getString("cv_descricao"));
				curvaAbc.setClassificacao(resultado.getString("cv_classificacao"));
				curvaAbc.setPercentual(resultado.getDouble("db_percentual"));
				curvaAbc.setPerAcumulado(resultado.getDouble("db_per_acumulado"));
				curvaAbc.setValorConsumido(resultado.getDouble("db_valor_consumido"));
				curvaAbc.setQntSaida(resultado.getInt("in_qnt_saida"));

				// Adicionando indicador na lista
				lista.add(curvaAbc);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
}
