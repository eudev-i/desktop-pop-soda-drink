package br.com.senaijandira.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import br.com.senaijandira.dao.VeiculoDAO;
import br.com.senaijandira.model.Veiculo;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmVeiculoFormularrio {

	private JFrame frame;
	private JTextPane txt_modelo;
	private JTextPane txt_placa;
	private JTextPane txt_peso;
	private JTextPane txt_volume;
	private FrmVeiculo frmVeiculo;
	private int id;

	public void setModelo(String modelo) {
		this.txt_modelo.setText(modelo);
	}

	public void setPlaca(String placa) {
		this.txt_placa.setText(placa);
	}

	public void setPeso(String peso) {
		this.txt_peso.setText(peso);
	}

	public void setVolume(String volume) {
		this.txt_volume.setText(volume);
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	public FrmVeiculoFormularrio(String modo) {
	
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);

		JPanel painel_principal = new JPanel();
		painel_principal.setBackground(new Color(21, 35, 58));
		frame.getContentPane().add(painel_principal, BorderLayout.CENTER);
		painel_principal.setLayout(null);

		JLabel lbl_titulo = new JLabel();
		lbl_titulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_titulo.setFont(new Font("Arial Black", Font.BOLD, 18));
		lbl_titulo.setBounds(10, 11, 414, 56);
		lbl_titulo.setForeground(Color.WHITE);
		painel_principal.add(lbl_titulo);
		
		if (modo.equals("NOVO")) {
			lbl_titulo.setText("NOVO VEICULO");
		}else if (modo.equals("EDITAR")) {
			lbl_titulo.setText("EDITAR VEICULO");
		}else if (modo.equals("EXCLUIR")) {
			lbl_titulo.setText("EXCLUIR VEICULO");
		}

		txt_modelo = new JTextPane();
		txt_modelo.setFont(new Font("Arial", Font.PLAIN, 12));
		txt_modelo.setBounds(60, 87, 111, 20);
		painel_principal.add(txt_modelo);

		txt_placa = new JTextPane();
		txt_placa.setFont(new Font("Arial", Font.PLAIN, 12));
		txt_placa.setBounds(60, 141, 111, 20);
		painel_principal.add(txt_placa);

		txt_peso = new JTextPane();
		txt_peso.setFont(new Font("Arial", Font.PLAIN, 12));
		txt_peso.setBounds(231, 87, 111, 20);
		painel_principal.add(txt_peso);

		txt_volume = new JTextPane();
		txt_volume.setFont(new Font("Arial", Font.PLAIN, 12));
		txt_volume.setBounds(231, 141, 111, 20);
		painel_principal.add(txt_volume);

		JLabel lbl_modelo = new JLabel("Modelo:");
		lbl_modelo.setForeground(Color.WHITE);
		lbl_modelo.setFont(new Font("Arial Black", Font.BOLD, 11));
		lbl_modelo.setBounds(60, 67, 111, 14);
		painel_principal.add(lbl_modelo);

		JLabel lbl_peso = new JLabel("Peso M\u00E1ximo:");
		lbl_peso.setForeground(Color.WHITE);
		lbl_peso.setFont(new Font("Arial Black", Font.BOLD, 11));
		lbl_peso.setBounds(231, 67, 131, 14);
		painel_principal.add(lbl_peso);

		JLabel lbl_placa = new JLabel("Placa:");
		lbl_placa.setForeground(Color.WHITE);
		lbl_placa.setFont(new Font("Arial Black", Font.BOLD, 11));
		lbl_placa.setBounds(60, 121, 111, 14);
		painel_principal.add(lbl_placa);

		JLabel lblVolumeMximo = new JLabel("Volume M\u00E1ximo:");
		lblVolumeMximo.setForeground(Color.WHITE);
		lblVolumeMximo.setFont(new Font("Arial Black", Font.BOLD, 11));
		lblVolumeMximo.setBounds(231, 121, 131, 14);
		painel_principal.add(lblVolumeMximo);

		JButton btnSalvar = new JButton();
		
		if (modo.equals("EXCLUIR")) {
			btnSalvar.setText("EXCLUIR");
			
			txt_modelo.setEnabled(false);
			txt_placa.setEnabled(false);
			txt_peso.setEnabled(false);
			txt_volume.setEnabled(false);
			
		}else {
			btnSalvar.setText("SALVAR");
		}
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Veiculo veiculo = new Veiculo();

				veiculo.setModelo(txt_modelo.getText());
				veiculo.setPlaca(txt_placa.getText());
				veiculo.setCapac_peso(Double.parseDouble(txt_peso.getText()));
				veiculo.setCapc_volume(Double.parseDouble(txt_volume.getText()));

				VeiculoDAO veiculoDAO = new VeiculoDAO();

				if (modo.equals("NOVO")) {
					veiculoDAO.Insert(veiculo);
				}else if (modo.equals("EDITAR")) {
					veiculoDAO.Update(veiculo, id);
				}else if (modo.equals("EXCLUIR")) {
					int resposta = JOptionPane.showConfirmDialog(null,
							"Tem certeza que deseja excluir " + veiculo.getModelo() + "?", "Atenção",
							JOptionPane.YES_NO_OPTION);
					
					if (resposta == 0) {
						veiculoDAO.Delete(id);
					}

				}

				frmVeiculo.atualizarTabela();
				frame.dispose();

			}
		});
		btnSalvar.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnSalvar.setBounds(143, 197, 120, 40);
		painel_principal.add(btnSalvar);

	}

	public void criarFormulario(FrmVeiculo frmVeiculo) 
	{
		this.frmVeiculo = frmVeiculo;
		frame.setVisible(true);
	}
}
