package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Indicador;

public class IndicadorDAO {
	private Connection con = Conexao.getConnection();

	public List<Indicador> gerarIndicador() {

		String sql = "Select * from tb_indicador";
		List<Indicador> lista = new ArrayList<Indicador>();
		
		try (PreparedStatement preparador = con.prepareStatement(sql)) {

			ResultSet resultado = preparador.executeQuery();
			// Posicionando o cursor no primeiro registro
			while (resultado.next()) {
				Indicador indicador = new Indicador();
				indicador.setIdIndicador(resultado.getInt("id_indicador"));
				indicador.setIdMaterial(resultado.getInt("id_material"));
				indicador.setLote(resultado.getString("cv_lote"));
				indicador.setVencimento(resultado.getTimestamp("dt_vencimento"));
				indicador.setQntEstoque(resultado.getInt("qnt_estoque"));
				
				// Adicionando indicador na lista
				lista.add(indicador);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
}
