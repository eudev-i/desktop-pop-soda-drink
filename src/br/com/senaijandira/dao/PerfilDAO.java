package br.com.senaijandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.senaijandira.dbutils.Conexao;
import br.com.senaijandira.model.Perfil;

public class PerfilDAO {

	// Atributos de outras classes que serão instânciandos
	Perfil perfil;
	ArrayList<Perfil> perfils;
	PreparedStatement statement;
	ResultSet resultSet;

	// Método para buscar todos os registros
	public ArrayList<Perfil> SelectAll(){

		// Instânciando a classe que retorna uma lista
		perfils = new ArrayList<Perfil>();

		// Comando SQL que será executado na classe
		String sql = "SELECT * FROM tbl_perfil WHERE status = 1";

		try {

			// Variável que abre a conexão e executa a instrução SQL
			statement = Conexao.getConnection().prepareStatement(sql);

			// Variável que recebe o retorno da query executada anteriormente 
			resultSet = statement.executeQuery();

			// Loop que percorre todos os registros retornados
			while (resultSet.next()) {

				// Instânciando o objeto
				perfil = new Perfil();

				// Setando os valores no objeto
				perfil.setId(resultSet.getInt("id_perfil"));
				perfil.setNome(resultSet.getString("perfil"));

				// Adicionando o objeto ao array
				perfils.add(perfil);

			}

			// Fechando a conexão
			Conexao.getConnection().close();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		// Retornando a lista de registros
		return perfils;

	}

	// Método que retorna um registro atráves do id
	public Perfil SelectById(int id) 
	{
		// Instânciando o objeto
		perfil = new Perfil();

		// Comando SQL que será executado na classe
		String sql = "SELECT * FROM tbl_perfil WHERE id_perfil = ?";

		try {

			// Variável que abre a conexão e executa a instrução SQL
			statement = Conexao.getConnection().prepareStatement(sql);

			// Passa o valor do id para a query
			statement.setInt(1, id);

			// Variável que recebe o retorno da query executada anteriormente 
			resultSet = statement.executeQuery();

			// Inicia o result set
			resultSet.next();

			// Setando os valores no objeto
			perfil.setId(resultSet.getInt("id_perfil"));
			perfil.setNome(resultSet.getString("perfil"));

			statement.close();

			// Fecha conexão
			Conexao.getConnection().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return perfil;

	}

}
