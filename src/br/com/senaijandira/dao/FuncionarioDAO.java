package br.com.senaijandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.com.senaijandira.dbutils.Conexao;
import br.com.senaijandira.model.Funcionario;

public class FuncionarioDAO {

	// Atributos de outras classes que ser�o inst�nciandos
	private Funcionario funcionario;
	private ArrayList<Funcionario> funcionarios;
	private PreparedStatement statement;
	private ResultSet resultSet;

	// M�todo para inserir um registro
	public void Insert(Funcionario funcionario) 
	{
		// Instru��o para inserir o registro
		String sql = "INSERT INTO tbl_funcionario (id_cargo, nome, email, telefone, "
				+ "celular, dt_admissao, usuario, senha, status, data_nascimento, id_perfil) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try 
		{
			// Prepara a instru��o antes que seja executada
			statement = Conexao.getConnection().prepareStatement(sql);

			// Passa os par�metros da instrun��o
			statement.setInt(1, funcionario.getIdCargo());
			statement.setString(2, funcionario.getNome());
			statement.setString(3, funcionario.getEmail());
			statement.setString(4, funcionario.getTelefone());
			statement.setString(5, funcionario.getCelular());
			statement.setDate(6, funcionario.getDtAdmissao());
			statement.setString(7, funcionario.getUsuario());
			statement.setString(8, funcionario.getSenha());
			statement.setInt(9, 1);
			statement.setDate(10, funcionario.getDtNasc());
			statement.setInt(11, funcionario.getIdPerfil());

			// Executa a query
			statement.execute();

			// Fecha conex�o
			statement.close();

			// Exibe uma mensagem de sucesso
			JOptionPane.showMessageDialog(null, "Funcion�rio gravado com sucesso!");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	// M�todo para inserir um registro
	public void Update(Funcionario funcionario, int id) 
	{
		// Instru��o para atualizar o registro
		String sql = "UPDATE tbl_funcionario SET id_cargo = ?, nome = ?, email = ?, telefone = ?, "
				+ "celular = ?, dt_admissao = ?, usuario = ?, senha = ?, data_nascimento = ?, id_perfil = ? "
				+ "WHERE matricula = ?";

		try 
		{
			// Prepara a instru��o antes que seja executada
			statement = Conexao.getConnection().prepareStatement(sql);

			// Passa os par�metros da instrun��o
			statement.setInt(1, funcionario.getIdCargo());
			statement.setString(2, funcionario.getNome());
			statement.setString(3, funcionario.getEmail());
			statement.setString(4, funcionario.getTelefone());
			statement.setString(5, funcionario.getCelular());
			statement.setDate(6, funcionario.getDtAdmissao());
			statement.setString(7, funcionario.getUsuario());
			statement.setString(8, funcionario.getSenha());
			statement.setDate(9, funcionario.getDtNasc());
			statement.setInt(10, funcionario.getIdPerfil());
			statement.setInt(11, id);

			// Executa a query
			statement.execute();

			// Fecha conex�o
			statement.close();

			// Exibe uma mensagem de sucesso
			JOptionPane.showMessageDialog(null, "Funcion�rio atualizado com sucesso!");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public void Delete(int matricula) 
	{
		// Instru��o para deletar o registro
		String sql = "DELETE FROM tbl_funcionario WHERE matricula = ?";

		try 
		{
			// Prepara a instru��o antes que seja executada
			statement = Conexao.getConnection().prepareStatement(sql);

			// Passa os par�metros da instrun��o
			statement.setInt(1, matricula);

			// Executa a query
			statement.execute();

			// Fecha conex�o
			statement.close();

			// Exibe uma mensagem de sucesso
			JOptionPane.showMessageDialog(null, "Funcion�rio deletado com sucesso!");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	// M�todo para buscar todos os registros
	public ArrayList<Funcionario> SelectAll()
	{
		// Inst�nciando a classe que retorna uma lista
		 funcionarios = new ArrayList<Funcionario>();

		// Comando SQL que ser� executado na classe
		String sql = "SELECT * FROM tbl_funcionario";

		try {

			// Vari�vel que abre a conex�o e executa a instru��o SQL
			statement = Conexao.getConnection().prepareStatement(sql);

			// Vari�vel que recebe o retorno da query executada anteriormente 
			resultSet = statement.executeQuery();

			// Loop que percorre todos os registros retornados
			while (resultSet.next()) {

				// Inst�nciando o objeto
				funcionario = new Funcionario();

				// Setando os valores no objeto
				funcionario.setMatricula(resultSet.getInt("matricula"));
				funcionario.setIdCargo(resultSet.getInt("id_cargo"));
				funcionario.setNome(resultSet.getString("nome"));
				funcionario.setEmail(resultSet.getString("email"));
				funcionario.setTelefone(resultSet.getString("telefone"));
				funcionario.setCelular(resultSet.getString("celular"));
				funcionario.setDtAdmissao(resultSet.getDate("dt_admissao"));
				funcionario.setUsuario(resultSet.getString("usuario"));
				funcionario.setSenha(resultSet.getString("senha"));
				funcionario.setDtNasc(resultSet.getDate("data_nascimento"));
				funcionario.setIdPerfil(resultSet.getInt("id_perfil"));

				// Adicionando o objeto ao array
				funcionarios.add(funcionario);

			}

			// Fechando a conex�o
			Conexao.getConnection().close();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		// Retornando a lista de registros
		return funcionarios;
	}

	// M�todo que retorna um registro atr�ves do id
	public Funcionario SelectById(int matricula) 
	{
		// Inst�nciando o objeto
		funcionario = new Funcionario();

		// Comando SQL que ser� executado na classe
		String sql = "SELECT * FROM tbl_funcionario WHERE matricula = ?";

		try {

			// Vari�vel que abre a conex�o e executa a instru��o SQL
			statement = Conexao.getConnection().prepareStatement(sql);

			// Passa o valor do id para a query
			statement.setInt(1, matricula);

			// Vari�vel que recebe o retorno da query executada anteriormente 
			resultSet = statement.executeQuery();

			// Inicia o result set
			resultSet.next();

			// Setando os valores no objeto
			funcionario.setMatricula(resultSet.getInt("matricula"));
			funcionario.setIdCargo(resultSet.getInt("id_cargo"));
			funcionario.setNome(resultSet.getString("nome"));
			funcionario.setEmail(resultSet.getString("email"));
			funcionario.setTelefone(resultSet.getString("telefone"));
			funcionario.setCelular(resultSet.getString("celular"));
			funcionario.setDtAdmissao(resultSet.getDate("dt_admissao"));
			funcionario.setUsuario(resultSet.getString("usuario"));
			funcionario.setSenha(resultSet.getString("senha"));
			funcionario.setDtNasc(resultSet.getDate("data_nascimento"));
			funcionario.setIdPerfil(resultSet.getInt("id_perfil"));

			statement.close();

			// Fecha conex�o
			Conexao.getConnection().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return funcionario;

	}

}
