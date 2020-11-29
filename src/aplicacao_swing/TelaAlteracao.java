package aplicacao_swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TelaAlteracao {

	private JFrame frmAlterao;
	private JTextField idpedido;
	private JTextField idproduto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAlteracao window = new TelaAlteracao();
					window.frmAlterao.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaAlteracao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAlterao = new JFrame();
		frmAlterao.setTitle("Altera\u00E7\u00E3o");
		frmAlterao.setBounds(100, 100, 450, 300);
		frmAlterao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAlterao.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Altera\u00E7\u00E3o");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(135, 0, 197, 49);
		frmAlterao.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("id do pedido:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(40, 78, 111, 28);
		frmAlterao.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("id do produto:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(40, 143, 143, 28);
		frmAlterao.getContentPane().add(lblNewLabel_1_1);
		
		idpedido = new JTextField();
		idpedido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idpedido.setBounds(169, 84, 163, 19);
		frmAlterao.getContentPane().add(idpedido);
		idpedido.setColumns(10);
		
		idproduto = new JTextField();
		idproduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idproduto.setColumns(10);
		idproduto.setBounds(169, 151, 163, 19);
		frmAlterao.getContentPane().add(idproduto);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(154, 208, 111, 19);
		frmAlterao.getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCancelar.setBounds(292, 208, 111, 19);
		frmAlterao.getContentPane().add(btnCancelar);
	}

	public JFrame getFrame() {
		return frmAlterao;
	}

	public void setFrame(JFrame frame) {
		this.frmAlterao = frame;
	}

}
