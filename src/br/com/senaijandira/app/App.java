package br.com.senaijandira.app;

import java.util.ArrayList;

import br.com.senaijandira.dao.ClienteDAO;
import br.com.senaijandira.model.Cliente;

public class App {

	public static void main(String[] args) {
		
		ClienteDAO clienteDAO = new ClienteDAO();
		ArrayList<Cliente> clientes = new ArrayList<>();
		
		clientes = clienteDAO.SelectAll();
		
		for(Cliente cliente : clientes) {
			
			System.out.println(cliente.getNome_fantasia());
			
		}
		
	}

}
