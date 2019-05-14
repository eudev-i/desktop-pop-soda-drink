package br.com.senaijandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.senaijandira.dbutils.Conexao;
import br.com.senaijandira.model.Cliente;

public class ClienteDAO {
	
	// Atributos de outras classes que serão instânciandos
	Cliente cliente;
	ArrayList<Cliente> clientes;
	PreparedStatement statement;
	ResultSet resultSet;
	
	// Método para buscar todos os registros
	public ArrayList<Cliente> SelectAll(){
		
		// Instânciando a classe que retorna uma lista
		clientes = new ArrayList<Cliente>();
		
		// Comando SQL que será executado na classe
		String sql = "SELECT * FROM tbl_pessoa_juridica";
		
		try {
			
			// Variável que abre a conexão e executa a instrução SQL
			statement = Conexao.getConnection().prepareStatement(sql);
			
			// Variável que recebe o retorno da query executada anteriormente 
			resultSet = statement.executeQuery();
			
			// Loop que percorre todos os registros retornados
			while (resultSet.next()) {
				
				// Instânciando o objeto
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
			
			// Fechando a conexão
			Conexao.getConnection().close();
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());
			
		}
		
		// Retornando a lista de clientes
		return clientes;
		
	}

	// Método para buscar um registro específico
	//public Cliente SelectById() {}
	
}
