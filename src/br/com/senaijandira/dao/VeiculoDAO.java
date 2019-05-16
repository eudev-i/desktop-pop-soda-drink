package br.com.senaijandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.com.senaijandira.dbutils.Conexao;
import br.com.senaijandira.model.Veiculo;

public class VeiculoDAO {

	// Atributos de outras classes que ser�o inst�nciandos
	private Veiculo veiculo;
	private ArrayList<Veiculo> veiculos;
	private PreparedStatement statement;
	private ResultSet resultSet;

	// M�todo para inserir um registro
	public void Insert(Veiculo veiculo) 
	{
		// Instru��o para inserir o registro
		String sql = "INSERT INTO tbl_veiculo (modelo, placa, capac_peso, capac_volume) "
				+ "VALUES (?, ?, ?, ?)";

		try 
		{
			// Prepara a instru��o antes que seja executada
			statement = Conexao.getConnection().prepareStatement(sql);

			// Passa os par�metros da instrun��o
			statement.setString(1, veiculo.getModelo());
			statement.setString(2, veiculo.getPlaca());
			statement.setDouble(3, veiculo.getCapac_peso());
			statement.setDouble(4, veiculo.getCapc_volume());

			// Executa a query
			statement.execute();

			// Fecha conex�o
			statement.close();

			// Exibe uma mensagem de sucesso
			JOptionPane.showMessageDialog(null, "Veiculo gravado com sucesso!");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	// M�todo para inserir um registro
	public void Update(Veiculo veiculo, int id) 
	{
		// Instru��o para atualizar o registro
		String sql = "UPDATE tbl_veiculo SET modelo = ?, placa = ?, capac_peso = ?, capac_volume = ? WHERE id_veiculo = ?";

		try 
		{
			// Prepara a instru��o antes que seja executada
			statement = Conexao.getConnection().prepareStatement(sql);

			// Passa os par�metros da instrun��o
			statement.setString(1, veiculo.getModelo());
			statement.setString(2, veiculo.getPlaca());
			statement.setDouble(3, veiculo.getCapac_peso());
			statement.setDouble(4, veiculo.getCapc_volume());
			statement.setInt(5,  id);

			// Executa a query
			statement.execute();

			// Fecha conex�o
			statement.close();

			// Exibe uma mensagem de sucesso
			JOptionPane.showMessageDialog(null, "Veiculo atualizado com sucesso!");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public void Delete(int id) 
	{
		// Instru��o para deletar o registro
		String sql = "DELETE FROM tbl_veiculo WHERE id_veiculo = ?";

		try 
		{
			// Prepara a instru��o antes que seja executada
			statement = Conexao.getConnection().prepareStatement(sql);

			// Passa os par�metros da instrun��o
			statement.setInt(1, id);

			// Executa a query
			statement.execute();

			// Fecha conex�o
			statement.close();

			// Exibe uma mensagem de sucesso
			JOptionPane.showMessageDialog(null, "Veiculo deletado com sucesso!");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	// M�todo para buscar todos os registros
	public ArrayList<Veiculo> SelectAll()
	{
		// Inst�nciando a classe que retorna uma lista
		veiculos = new ArrayList<Veiculo>();

		// Comando SQL que ser� executado na classe
		String sql = "SELECT * FROM tbl_veiculo";

		try {

			// Vari�vel que abre a conex�o e executa a instru��o SQL
			statement = Conexao.getConnection().prepareStatement(sql);

			// Vari�vel que recebe o retorno da query executada anteriormente 
			resultSet = statement.executeQuery();

			// Loop que percorre todos os registros retornados
			while (resultSet.next()) {

				// Inst�nciando o objeto
				veiculo = new Veiculo();

				// Setando os valores no objeto
				veiculo.setId(resultSet.getInt("id_veiculo"));
				veiculo.setModelo(resultSet.getString("modelo"));
				veiculo.setPlaca(resultSet.getString("placa"));
				veiculo.setCapac_peso(resultSet.getDouble("capac_peso"));
				veiculo.setCapc_volume(resultSet.getDouble("capac_volume"));

				// Adicionando o objeto ao array
				veiculos.add(veiculo);

			}

			// Fechando a conex�o
			Conexao.getConnection().close();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		// Retornando a lista de registros
		return veiculos;
	}

	// M�todo que retorna um registro atr�ves do id
	public Veiculo SelectById(int id) 
	{
		// Inst�nciando o objeto
		veiculo = new Veiculo();

		// Comando SQL que ser� executado na classe
		String sql = "SELECT * FROM tbl_veiculo WHERE id_veiculo = ?";

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
			veiculo.setId(resultSet.getInt("id_veiculo"));
			veiculo.setModelo(resultSet.getString("modelo"));
			veiculo.setPlaca(resultSet.getString("placa"));
			veiculo.setCapac_peso(resultSet.getDouble("capac_peso"));
			veiculo.setCapc_volume(resultSet.getDouble("capac_volume"));
			
			statement.close();

			// Fecha conex�o
			Conexao.getConnection().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return veiculo;

	}

}
