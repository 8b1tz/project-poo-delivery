package aplicacao_swing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fachada.Fachada;

public class TelaCancelamento {

	private JFrame frmCancelamento;
	private JTextField idpedido;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCancelamento window = new TelaCancelamento();
					window.frmCancelamento.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCancelamento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCancelamento = new JFrame();
		frmCancelamento.setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaCancelamento.class.getResource("/imagem/icon.png")));
		frmCancelamento.setTitle("Cancelamento");
		frmCancelamento.setBounds(100, 100, 450, 300);
		frmCancelamento.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Cancelamento");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(102, 0, 228, 43);
		frmCancelamento.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("idpedido:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(60, 116, 106, 28);
		frmCancelamento.getContentPane().add(lblNewLabel_1);

		idpedido = new JTextField();
		idpedido.setBounds(175, 124, 118, 19);
		frmCancelamento.getContentPane().add(idpedido);
		idpedido.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(22, 227, 343, 26);
		frmCancelamento.getContentPane().add(lblNewLabel_2);
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Fachada.cancelarPedido(Integer.parseInt(idpedido.getText()));
					lblNewLabel_2.setText("Pedido: " + idpedido + " cancelado!");
				} catch (Exception e1) {
					lblNewLabel_2.setText(e1.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(264, 182, 112, 28);
		frmCancelamento.getContentPane().add(btnNewButton);

	}

	public JFrame getFrmCancelamento() {
		return frmCancelamento;
	}

	public void setFrmCancelamento(JFrame frmCancelamento) {
		this.frmCancelamento = frmCancelamento;
	}

}
