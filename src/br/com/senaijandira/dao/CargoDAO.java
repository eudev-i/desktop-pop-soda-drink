package br.com.senaijandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.com.senaijandira.dbutils.Conexao;
import br.com.senaijandira.model.Cargo;

public class CargoDAO {

	// Atributos de outras classes que ser�o inst�nciandos
	Cargo cargo;
	ArrayList<Cargo> cargos;
	PreparedStatement statement;
	ResultSet resultSet;

	// M�todo para buscar todos os registros
	public ArrayList<Cargo> SelectAll(){

		// Inst�nciando a classe que retorna uma lista
		cargos = new ArrayList<Cargo>();

		// Comando SQL que ser� executado na classe
		String sql = "SELECT * FROM tbl_cargo WHERE status = 1";

		try {

			// Vari�vel que abre a conex�o e executa a instru��o SQL
			statement = Conexao.getConnection().prepareStatement(sql);

			// Vari�vel que recebe o retorno da query executada anteriormente 
			resultSet = statement.executeQuery();

			// Loop que percorre todos os registros retornados
			while (resultSet.next()) {

				// Inst�nciando o objeto
				cargo = new Cargo();

				// Setando os valores no objeto
				cargo.setId(resultSet.getInt("id_cargo"));
				cargo.setNome(resultSet.getString("nome"));

				// Adicionando o objeto ao array
				cargos.add(cargo);

			}

			// Fechando a conex�o
			Conexao.getConnection().close();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		// Retornando a lista de registros
		return cargos;

	}

	// M�todo que retorna um registro atr�ves do id
	public Cargo SelectById(int id) 
	{
		// Inst�nciando o objeto
		cargo = new Cargo();

		// Comando SQL que ser� executado na classe
		String sql = "SELECT * FROM tbl_cargo WHERE id_cargo = ?";

		try {

			// Vari�vel que abre a conex�o e executa a instru��o SQL
			statement = Conexao.getConnection().prepareStatement(sql);

			// Passa o valor do id para a query
			statement.setInt(1, id);

			// Vari�vel que recebe o retorno da query executada anteriormente 
			resultSet = statement.executeQuery();

			// Inicia o result set
			resultSet.next();

			// Setando os valores no objeto
			cargo.setId(resultSet.getInt("id_cargo"));
			cargo.setNome(resultSet.getString("nome"));

			statement.close();

			// Fecha conex�o
			Conexao.getConnection().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return cargo;

	}

}
