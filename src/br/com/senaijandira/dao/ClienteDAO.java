package br.com.senaijandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.senaijandira.dbutils.Conexao;
import br.com.senaijandira.model.Cliente;

public class ClienteDAO {
	
	// Atributos de outras classes que ser�o inst�nciandos
	Cliente cliente;
	ArrayList<Cliente> clientes;
	PreparedStatement statement;
	ResultSet resultSet;
	
	// M�todo para buscar todos os registros
	public ArrayList<Cliente> SelectAll(){
		
		// Inst�nciando a classe que retorna uma lista
		clientes = new ArrayList<Cliente>();
		
		// Comando SQL que ser� executado na classe
		String sql = "SELECT * FROM tbl_pessoa_juridica";
		
		try {
			
			// Vari�vel que abre a conex�o e executa a instru��o SQL
			statement = Conexao.getConnection().prepareStatement(sql);
			
			// Vari�vel que recebe o retorno da query executada anteriormente 
			resultSet = statement.executeQuery();
			
			// Loop que percorre todos os registros retornados
			while (resultSet.next()) {
				
				// Inst�nciando o objeto
				cliente = new Cliente();
				
				// Setando os valores no objeto
				cliente.setCnpj(resultSet.getString("cnpj"));
				cliente.setResponsavel(resultSet.getString("responsavel"));
				cliente.setEmail(resultSet.getString("email"));
				cliente.setTelefone(resultSet.getString("telefone"));
				cliente.setCelular(resultSet.getString("celular"));
				cliente.setUsuario(resultSet.getString("usuario"));
				cliente.setRazao_social(resultSet.getString("razao_social"));
				cliente.setNome_fantasia(resultSet.getString("nome_fantasia"));
				
				// Adicionando o objeto ao array
				clientes.add(cliente);
				
			}
			
			// Fechando a conex�o
			Conexao.getConnection().close();
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			
		}
		
		// Retornando a lista de clientes
		return clientes;
		
	}

	// M�todo para buscar um registro espec�fico
	//public Cliente SelectById() {}
	
}
