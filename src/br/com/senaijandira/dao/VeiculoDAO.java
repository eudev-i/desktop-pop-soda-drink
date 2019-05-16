package br.com.senaijandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.com.senaijandira.dbutils.Conexao;
import br.com.senaijandira.model.Veiculo;

public class VeiculoDAO {

	// Atributos de outras classes que serão instânciandos
	private Veiculo veiculo;
	private ArrayList<Veiculo> veiculos;
	private PreparedStatement statement;
	private ResultSet resultSet;

	// Método para inserir um registro
	public void Insert(Veiculo veiculo) 
	{
		// Instrução para inserir o registro
		String sql = "INSERT INTO tbl_veiculo (modelo, placa, capac_peso, capac_volume) "
				+ "VALUES (?, ?, ?, ?)";

		try 
		{
			// Prepara a instrução antes que seja executada
			statement = Conexao.getConnection().prepareStatement(sql);

			// Passa os parâmetros da instrunção
			statement.setString(1, veiculo.getModelo());
			statement.setString(2, veiculo.getPlaca());
			statement.setDouble(3, veiculo.getCapac_peso());
			statement.setDouble(4, veiculo.getCapc_volume());

			// Executa a query
			statement.execute();

			// Fecha conexão
			statement.close();

			// Exibe uma mensagem de sucesso
			JOptionPane.showMessageDialog(null, "Veiculo gravado com sucesso!");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	// Método para inserir um registro
	public void Update(Veiculo veiculo, int id) 
	{
		// Instrução para atualizar o registro
		String sql = "UPDATE tbl_veiculo SET modelo = ?, placa = ?, capac_peso = ?, capac_volume = ? WHERE id_veiculo = ?";

		try 
		{
			// Prepara a instrução antes que seja executada
			statement = Conexao.getConnection().prepareStatement(sql);

			// Passa os parâmetros da instrunção
			statement.setString(1, veiculo.getModelo());
			statement.setString(2, veiculo.getPlaca());
			statement.setDouble(3, veiculo.getCapac_peso());
			statement.setDouble(4, veiculo.getCapc_volume());
			statement.setInt(5,  id);

			// Executa a query
			statement.execute();

			// Fecha conexão
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
		// Instrução para deletar o registro
		String sql = "DELETE FROM tbl_veiculo WHERE id_veiculo = ?";

		try 
		{
			// Prepara a instrução antes que seja executada
			statement = Conexao.getConnection().prepareStatement(sql);

			// Passa os parâmetros da instrunção
			statement.setInt(1, id);

			// Executa a query
			statement.execute();

			// Fecha conexão
			statement.close();

			// Exibe uma mensagem de sucesso
			JOptionPane.showMessageDialog(null, "Veiculo deletado com sucesso!");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	// Método para buscar todos os registros
	public ArrayList<Veiculo> SelectAll()
	{
		// Instânciando a classe que retorna uma lista
		veiculos = new ArrayList<Veiculo>();

		// Comando SQL que será executado na classe
		String sql = "SELECT * FROM tbl_veiculo";

		try {

			// Variável que abre a conexão e executa a instrução SQL
			statement = Conexao.getConnection().prepareStatement(sql);

			// Variável que recebe o retorno da query executada anteriormente 
			resultSet = statement.executeQuery();

			// Loop que percorre todos os registros retornados
			while (resultSet.next()) {

				// Instânciando o objeto
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

			// Fechando a conexão
			Conexao.getConnection().close();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		// Retornando a lista de registros
		return veiculos;
	}

	// Método que retorna um registro atráves do id
	public Veiculo SelectById(int id) 
	{
		// Instânciando o objeto
		veiculo = new Veiculo();

		// Comando SQL que será executado na classe
		String sql = "SELECT * FROM tbl_veiculo WHERE id_veiculo = ?";

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
			veiculo.setId(resultSet.getInt("id_veiculo"));
			veiculo.setModelo(resultSet.getString("modelo"));
			veiculo.setPlaca(resultSet.getString("placa"));
			veiculo.setCapac_peso(resultSet.getDouble("capac_peso"));
			veiculo.setCapc_volume(resultSet.getDouble("capac_volume"));
			
			statement.close();

			// Fecha conexão
			Conexao.getConnection().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return veiculo;

	}

}
