package aplicacao_swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

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
		frmPagamento.setTitle("Pagamento");
		frmPagamento.setBounds(100, 100, 450, 300);
		frmPagamento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JButton btnNewButton = new JButton("Pagar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(265, 194, 115, 30);
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
