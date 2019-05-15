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
	public void Insert() 
	{
		// Instru��o para inserir o registro
		String sql = "INSERT INTO tbl_veiculo (modelo, placa, capac_peso, capac_volume) "
				+ "VALUES (?, ?, ?, ?)";
		
		// Vari�vel inicia nula para n�o haver conflitos
		statement = null;
		
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

}
