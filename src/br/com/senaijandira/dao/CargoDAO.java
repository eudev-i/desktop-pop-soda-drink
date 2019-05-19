package br.com.senaijandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.senaijandira.dbutils.Conexao;
import br.com.senaijandira.model.Cargo;

public class CargoDAO {

	// Atributos de outras classes que serão instânciandos
	Cargo cargo;
	ArrayList<Cargo> cargos;
	PreparedStatement statement;
	ResultSet resultSet;

	// Método para buscar todos os registros
	public ArrayList<Cargo> SelectAll(){

		// Instânciando a classe que retorna uma lista
		cargos = new ArrayList<Cargo>();

		// Comando SQL que será executado na classe
		String sql = "SELECT * FROM tbl_cargo WHERE status = 1";

		try {

			// Variável que abre a conexão e executa a instrução SQL
			statement = Conexao.getConnection().prepareStatement(sql);

			// Variável que recebe o retorno da query executada anteriormente 
			resultSet = statement.executeQuery();

			// Loop que percorre todos os registros retornados
			while (resultSet.next()) {

				// Instânciando o objeto
				cargo = new Cargo();

				// Setando os valores no objeto
				cargo.setId(resultSet.getInt("id_cargo"));
				cargo.setNome(resultSet.getString("nome"));

				// Adicionando o objeto ao array
				cargos.add(cargo);

			}

			// Fechando a conexão
			Conexao.getConnection().close();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		// Retornando a lista de registros
		return cargos;

	}

	// Método que retorna um registro atráves do id
	public Cargo SelectById(int id) 
	{
		// Instânciando o objeto
		cargo = new Cargo();

		// Comando SQL que será executado na classe
		String sql = "SELECT * FROM tbl_cargo WHERE id_cargo = ?";

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
			cargo.setId(resultSet.getInt("id_cargo"));
			cargo.setNome(resultSet.getString("nome"));

			statement.close();

			// Fecha conexão
			Conexao.getConnection().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cargo;

	}

}
