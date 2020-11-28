package aplicacao_swing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fachada.Fachada;

public class TelaAlteracao extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
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
					window.frame.setVisible(true);
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
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alterar");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(174, 10, 103, 47);
		getContentPane().add(lblNewLabel);
		
		idpedido = new JTextField();
		idpedido.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idpedido.setBounds(161, 90, 120, 26);
		getContentPane().add(idpedido);
		idpedido.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("id pedido:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(40, 90, 109, 25);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("id produto:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(40, 123, 109, 26);
		getContentPane().add(lblNewLabel_1_1);
		
		idproduto = new JTextField();
		idproduto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		idproduto.setColumns(10);
		idproduto.setBounds(161, 126, 120, 26);
		getContentPane().add(idproduto);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Fachada.adicionarProdutoPedido(Integer.parseInt(idpedido.getText()),Integer.parseInt(idproduto.getText()));
					
				} catch (Exception e1) {
					
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(40, 174, 109, 26);
		getContentPane().add(btnNewButton);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRemover.setBounds(168, 174, 113, 26);
		getContentPane().add(btnRemover);
		
		JLabel exceplb = new JLabel("");
		exceplb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		exceplb.setBounds(40, 210, 330, 26);
		getContentPane().add(exceplb);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
