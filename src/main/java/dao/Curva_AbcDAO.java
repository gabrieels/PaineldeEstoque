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

		String sql = "Select * from tb_curva_abc";
		List<CurvaAbc> lista = new ArrayList<CurvaAbc>();
		
		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			ResultSet resultado = preparador.executeQuery();
			// Posicionando o cursor no primeiro registro
			while (resultado.next()) {
				CurvaAbc curvaAbc = new CurvaAbc();
				curvaAbc.setIdCurvaAbc(resultado.getInt("id_curva"));
				curvaAbc.setIdMaterial(resultado.getInt("id_material"));
				curvaAbc.setClassificacao(resultado.getString("cv_classificacao"));
				curvaAbc.setDbCustoAnual(resultado.getDouble("db_custo_anual"));
				curvaAbc.setPerAnual(resultado.getDouble("per_anual"));
				curvaAbc.setDbAcumulado(resultado.getDouble("db_acumulado"));
				curvaAbc.setPerAcumulado(resultado.getDouble("per_acumulado"));
				
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
