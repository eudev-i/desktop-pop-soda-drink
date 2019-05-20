package br.com.senaijandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import br.com.senaijandira.dbutils.Conexao;
import br.com.senaijandira.model.Pedido;

public class PedidoDAO {

	// Atributos de outras classes que serão instânciandos
	private  Pedido pedido;
	private ArrayList<Pedido> pedidos;
	private PreparedStatement statement;
	private ResultSet resultSet;


	// Método para inserir um registro
	public void Update(Pedido pedido, int id) 
	{
		// Instrução para atualizar o registro
		String sql = "UPDATE tbl_compra_produto SET status_pedido ? WHERE id_c_produto = ?";

		try 
		{
			// Prepara a instrução��o antes que seja executada
			statement = Conexao.getConnection().prepareStatement(sql);

			// Passa os parâmetros da instrução
			statement.setString(1, pedido.getStatusPedido());
			statement.setInt(2, id);

			// Executa a query
			statement.execute();

			// Fecha conexão
			statement.close();

			// Exibe uma mensagem de sucesso
			JOptionPane.showMessageDialog(null, "Status do pedido atualizado com sucesso!");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	// Método de buscar os registros
	public ArrayList<Pedido> SelectAll()
	{
		// Instânciando a classe que retorna uma lista
		 pedidos = new ArrayList<Pedido>();

		// Comando SQL que será executado na classe
		String sql = "SELECT pedido.*, pj.razao_social "
				+ "FROM tbl_compra_produto AS pedido "
				+ "INNER JOIN tbl_pessoa_juridica AS pj ON pedido.cnpj = pj.cnpj";

		try {

			// Variável que abre a conex�o e executa a instrução SQL
			statement = Conexao.getConnection().prepareStatement(sql);

			// Variável que recebe o retorno da query executada anteriormente 
			resultSet = statement.executeQuery();

			// Loop que percorre todos os registros retornados
			while (resultSet.next()) {

				// Instânciando o objeto
				pedido = new Pedido();

				// Setando os valores no objeto
				pedido.setId(id);
				pedido.setCnpj(cnpj);
				pedido.setValorTotal(valorTotal);
				pedido.setPesoTotal(pesoTotal);
				pedido.setVolumeTotal(volumeTotal);
				pedido.setLogradouro(logradouro);
				pedido.setCidade(cidade);
				pedido.setUf(uf);
				pedido.setDtCompra(dtCompra);
				pedido.setStatusPedido(statusPedido);
				pedido.setStatusPedido(statusPedido);

				// Adicionando o objeto ao array
				pedidos.add(pedido);

			}

			// Fechando a conex�o
			Conexao.getConnection().close();

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}

		// Retornando a lista de registros
		return pedidos;
	}

	// Método que retorna um registro através do ID
	public Pedido SelectById(int id) 
	{
		// Instânciando o objeto
		pedido = new Pedido();
		
		// Comando SQL que ser� executado na classe
		String sql = "";

		try {

			// Variável que abre a conexão e executa a instrução SQL
			statement = Conexao.getConnection().prepareStatement(sql);

			// Passa o valor do id para a query

			// Variável que recebe o retorno da query executada anteriormente 
			resultSet = statement.executeQuery();

			// Inicia o result set
			resultSet.next();

			// Setando os valores no objeto
			pedido.setId(id);
			pedido.setCnpj(cnpj);
			pedido.setValorTotal(valorTotal);
			pedido.setPesoTotal(pesoTotal);
			pedido.setVolumeTotal(volumeTotal);
			pedido.setLogradouro(logradouro);
			pedido.setCidade(cidade);
			pedido.setUf(uf);
			pedido.setDtCompra(dtCompra);
			pedido.setStatusPedido(statusPedido);
			pedido.setStatusPedido(statusPedido);

			statement.close();

			// Fecha conexão
			Conexao.getConnection().close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pedido;

	}

}
