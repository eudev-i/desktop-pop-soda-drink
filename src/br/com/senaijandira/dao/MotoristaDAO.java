package br.com.senaijandira.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.senaijandira.dbutils.Conexao;
import br.com.senaijandira.model.Motorista;

public class MotoristaDAO {
	private Motorista motorista;
	private PreparedStatement stmt; //comando sql
	private ResultSet rs = null; //retorno do db
	
	public void setFornecedor(Motorista motorista) {
		this.motorista = motorista;
	}
	
	//retorna todos os registros inseridos no banco
		public ArrayList<Motorista> selectAll(){
			ArrayList<Motorista> motoristas = new ArrayList<Motorista>();
			String sql = "SELECT * FROM tbl_motorista ORDER BY nome";
			
			try {
				stmt = Conexao.getConnection().prepareStatement(sql);
				
				rs = stmt.executeQuery();
				
				//enquanto os dados forem retornados
				while (rs.next()) {
					Motorista motorista = new Motorista();
					
					motorista.setIdMotorista(rs.getInt("id_motorista"));
					motorista.setIdVeiculo(rs.getInt("id_veiculo"));
					motorista.setNome(rs.getString("nome"));
					motorista.setCpf(rs.getString("cpf"));
					
					motorista.setHabilitacao(rs.getString("habilitacao"));
					motorista.setCategoria(rs.getString("categoria"));
					motorista.setValidade(rs.getDate("validade"));
					motorista.setStatus(rs.getInt("status"));
					
					motoristas.add(motorista);
				}
				
			
				
				
			} catch (Exception erro) {
				System.out.println(erro.getMessage());

				JOptionPane.showMessageDialog(null,
						"Não foi " + "possível fazer a consulta. Por Favor," + "tente novamente mais tarde. ", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			
			
			return motoristas;
		}
		
		public Motorista selectById(int idMotorista) {
			String sql = "SELECT * FROM tbl_motorista WHERE id_motorista=?";
			Motorista motorista = new Motorista();
			
			try {
				stmt = Conexao.getConnection().prepareStatement(sql);
				stmt.setInt(1, idMotorista);
				rs = stmt.executeQuery();
				
				rs.next();
				//enquanto os dados forem retornados
			
				motorista.setIdMotorista(rs.getInt("id_motorista"));
				
				motorista.setIdVeiculo(rs.getInt("id_veiculo"));
				motorista.setNome(rs.getString("nome"));
				motorista.setCpf(rs.getString("cpf"));
				motorista.setHabilitacao(rs.getString("habilitacao"));
				motorista.setCategoria(rs.getString("categoria"));
				motorista.setValidade(rs.getDate("validade"));
				motorista.setStatus(rs.getInt("status"));
				
			} catch (Exception erro) {
				System.out.println(erro.getMessage());

				JOptionPane.showMessageDialog(null,
						"Não foi " + "possível fazer a consulta. Por Favor," + "tente novamente mais tarde. ", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			return motorista;
		}
		
		//----PAREI AQUI-------------------
		public void insert(Motorista motorista) {
			// Instrução para inserir o registro
			String sql = "INSERT INTO `db_popsoda`.`tbl_motorista`" + 
					"(" + 
					"`nome`," + 
					"`cpf`," + 
					"`habilitacao`," + 
					"`categoria`," + 
					"`validade`," + 
					"`status`,"
					+ "`id_veiculo`)" + 
					" "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?)";

			try 
			{
				
				// Prepara a instrução antes que seja executada
				stmt = Conexao.getConnection().prepareStatement(sql);
				
				
				stmt.setString(1, motorista.getNome());
				stmt.setString(2, motorista.getCpf());
				stmt.setString(3, motorista.getHabilitacao());
				stmt.setString(4, motorista.getCategoria());
				stmt.setString(5, motorista.getValidade().toString());
				stmt.setInt(6, motorista.getStatus());
				stmt.setInt(7, 1); //TODOS ESTÃO INDO NO MSM VEICULO

				// Executa a query
				stmt.execute();

				// Fecha conexão
				stmt.close();

				// Exibe uma mensagem de sucesso
				JOptionPane.showMessageDialog(null, "Fornecedor gravado com sucesso!");
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		public void update(Motorista motorista, int idMotorista) {
			// Instrução para inserir o registro
			String sql = "UPDATE `db_popsoda`.`tbl_motorista`" + 
					"SET" + 
					"`nome` = ?," + 
					"`cpf` = ?," + 
					"`habilitacao` = ?," + 
					"`categoria` = ?," + 
					"`validade` = ?," + 
					"`status` = ?" + 
					" WHERE `id_motorista` = ?";

			try 
			{
				
				// Prepara a instrução antes que seja executada
				stmt = Conexao.getConnection().prepareStatement(sql);

				// Prepara a instrução antes que seja executada
				stmt = Conexao.getConnection().prepareStatement(sql);
				
				stmt.setString(1, motorista.getNome());
				stmt.setString(2, motorista.getCpf());
				stmt.setString(3, motorista.getHabilitacao());
				stmt.setString(4, motorista.getCategoria());
				stmt.setString(5, motorista.getValidade().toString());
				stmt.setInt(6, motorista.getStatus());
				stmt.setInt(7, idMotorista);
				
				
				// Executa a query
				stmt.execute();

				// Fecha conexão
				stmt.close();

				// Exibe uma mensagem de sucesso
				JOptionPane.showMessageDialog(null, "Motorista atualizado com sucesso!");
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		
		public void delete(int idMotorista) 
		{
			// Instrução para deletar o registro
			String sql = "DELETE FROM tbl_motorista WHERE id_motorista = ?";

			try 
			{
				// Prepara a instrução antes que seja executada
				stmt = Conexao.getConnection().prepareStatement(sql);

				// Passa os parâmetros da instrunção
				stmt.setInt(1, idMotorista);

				// Executa a query
				stmt.execute();

				// Fecha conexão
				stmt.close();

				// Exibe uma mensagem de sucesso
				JOptionPane.showMessageDialog(null, "Motorista excluído com sucesso!");
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
}
