package br.com.senaijandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.com.senaijandira.dbutils.Conexao;
import br.com.senaijandira.model.Funcionario;

public class FuncionarioDAO {

	// Atributos de outras classes que serão instânciandos
	private Funcionario funcionario;
	private ArrayList<Funcionario> funcionarios;
	private PreparedStatement statement;
	private ResultSet resultSet;

	// Método para inserir um registro
	public void Insert(Funcionario funcionario) 
	{
		// Instrução para inserir o registro
		String sql = "INSERT INTO tbl_funcionario (id_cargo, nome, email, telefone, "
				+ "celular, dt_admissao, usuario, senha, status, data_nascimento, id_perfil) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try 
		{
			// Prepara a instrução antes que seja executada
			statement = Conexao.getConnection().prepareStatement(sql);

			// Passa os parâmetros da instrunção
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

			// Fecha conexão
			statement.close();

			// Exibe uma mensagem de sucesso
			JOptionPane.showMessageDialog(null, "Funcionário gravado com sucesso!");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	// Método para inserir um registro
	public void Update(Funcionario funcionario, int id) 
	{
		// Instrução para atualizar o registro
		String sql = "UPDATE tbl_funcionario SET id_cargo = ?, nome = ?, email = ?, telefone = ?, "
				+ "celular = ?, dt_admissao = ?, usuario = ?, senha = ?, data_nascimento = ?, id_perfil = ? "
				+ "WHERE matricula = ?";

		try 
		{
			// Prepara a instrução antes que seja executada
			statement = Conexao.getConnection().prepareStatement(sql);

			// Passa os parâmetros da instrunção
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

			// Fecha conexão
			statement.close();

			// Exibe uma mensagem de sucesso
			JOptionPane.showMessageDialog(null, "Funcionário atualizado com sucesso!");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	public void Delete(int matricula) 
	{
		// Instrução para deletar o registro
		String sql = "DELETE FROM tbl_funcionario WHERE matricula = ?";

		try 
		{
			// Prepara a instrução antes que seja executada
			statement = Conexao.getConnection().prepareStatement(sql);

			// Passa os parâmetros da instrunção
			statement.setInt(1, matricula);

			// Executa a query
			statement.execute();

			// Fecha conexão
			statement.close();

			// Exibe uma mensagem de sucesso
			JOptionPane.showMessageDialog(null, "Funcionário deletado com sucesso!");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	// Método para buscar todos os registros
	public ArrayList<Funcionario> SelectAll()
	{
		// Instânciando a classe que retorna uma lista
		 funcionarios = new ArrayList<Funcionario>();

		// Comando SQL que será executado na classe
		String sql = "SELECT * FROM tbl_funcionario";

		try {

			// Variável que abre a conexão e executa a instrução SQL
			statement = Conexao.getConnection().prepareStatement(sql);

			// Variável que recebe o retorno da query executada anteriormente 
			resultSet = statement.executeQuery();

			// Loop que percorre todos os registros retornados
			while (resultSet.next()) {

				// Instânciando o objeto
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

			// Fechando a conexão
			Conexao.getConnection().close();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		// Retornando a lista de registros
		return funcionarios;
	}

	// Método que retorna um registro atráves do id
	public Funcionario SelectById(int matricula) 
	{
		// Instânciando o objeto
		funcionario = new Funcionario();

		// Comando SQL que será executado na classe
		String sql = "SELECT * FROM tbl_funcionario WHERE matricula = ?";

		try {

			// Variável que abre a conexão e executa a instrução SQL
			statement = Conexao.getConnection().prepareStatement(sql);

			// Passa o valor do id para a query
			statement.setInt(1, matricula);

			// Variável que recebe o retorno da query executada anteriormente 
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

			// Fecha conexão
			Conexao.getConnection().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return funcionario;

	}

}
