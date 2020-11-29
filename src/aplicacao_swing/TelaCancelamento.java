package aplicacao_swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

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
		frmCancelamento.setTitle("Cancelamento");
		frmCancelamento.setBounds(100, 100, 450, 300);
		frmCancelamento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(264, 189, 103, 21);
		frmCancelamento.getContentPane().add(btnNewButton);
	}

	public JFrame getFrmCancelamento() {
		return frmCancelamento;
	}

	public void setFrmCancelamento(JFrame frmCancelamento) {
		this.frmCancelamento = frmCancelamento;
	}

}
