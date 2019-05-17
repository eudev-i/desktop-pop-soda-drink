package br.com.senaijandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.senaijandira.dbutils.Conexao;
import br.com.senaijandira.model.Perfil;

public class PerfilDAO {

	// Atributos de outras classes que ser�o inst�nciandos
	Perfil perfil;
	ArrayList<Perfil> perfils;
	PreparedStatement statement;
	ResultSet resultSet;

	// M�todo para buscar todos os registros
	public ArrayList<Perfil> SelectAll(){

		// Inst�nciando a classe que retorna uma lista
		perfils = new ArrayList<Perfil>();

		// Comando SQL que ser� executado na classe
		String sql = "SELECT * FROM tbl_perfil WHERE status = 1";

		try {

			// Vari�vel que abre a conex�o e executa a instru��o SQL
			statement = Conexao.getConnection().prepareStatement(sql);

			// Vari�vel que recebe o retorno da query executada anteriormente 
			resultSet = statement.executeQuery();

			// Loop que percorre todos os registros retornados
			while (resultSet.next()) {

				// Inst�nciando o objeto
				perfil = new Perfil();

				// Setando os valores no objeto
				perfil.setId(resultSet.getInt("id_perfil"));
				perfil.setNome(resultSet.getString("perfil"));

				// Adicionando o objeto ao array
				perfils.add(perfil);

			}

			// Fechando a conex�o
			Conexao.getConnection().close();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		// Retornando a lista de registros
		return perfils;

	}

}
