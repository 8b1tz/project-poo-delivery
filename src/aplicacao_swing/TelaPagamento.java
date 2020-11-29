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

public class TelaPagamento {

	private JFrame frmPagamento;
	private JTextField idpedido;
	private JTextField entregador;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPagamento window = new TelaPagamento();
					window.frmPagamento.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrame() {
		return frmPagamento;
	}

	public void setFrame(JFrame frame) {
		this.frmPagamento = frame;
	}

	/**
	 * Create the application.
	 */
	public TelaPagamento() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPagamento = new JFrame();
		frmPagamento.setResizable(false);
		frmPagamento.setIconImage(
				Toolkit.getDefaultToolkit().getImage(TelaPagamento.class.getResource("/imagem/icon.png")));
		frmPagamento.setTitle("Pagamento");
		frmPagamento.setBounds(100, 100, 450, 300);
		frmPagamento.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Pagamento");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(141, 10, 202, 46);
		frmPagamento.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("idpedido:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1.setBounds(58, 86, 115, 30);
		frmPagamento.getContentPane().add(lblNewLabel_1);

		idpedido = new JTextField();
		idpedido.setFont(new Font("Tahoma", Font.PLAIN, 16));
		idpedido.setBounds(168, 93, 137, 19);
		frmPagamento.getContentPane().add(idpedido);
		idpedido.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(32, 207, 351, 46);
		frmPagamento.getContentPane().add(lblNewLabel_2);
		JButton btnNewButton = new JButton("Pagar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Fachada.pagarPedido(Integer.parseInt(idpedido.getText()), entregador.getText().toString());
					lblNewLabel_2.setText("Pago com sucesso o pedido: " + idpedido.getText() + " do entregador " + entregador.getText());
				} catch (Exception e1) {
					lblNewLabel_2.setText(e1.getMessage());
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(293, 172, 115, 30);
		frmPagamento.getContentPane().add(btnNewButton);

		entregador = new JTextField();
		entregador.setFont(new Font("Tahoma", Font.PLAIN, 16));
		entregador.setColumns(10);
		entregador.setBounds(168, 143, 137, 19);
		frmPagamento.getContentPane().add(entregador);

		JLabel lblNewLabel_1_1 = new JLabel("entregador:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel_1_1.setBounds(58, 132, 115, 30);
		frmPagamento.getContentPane().add(lblNewLabel_1_1);

	}

}
