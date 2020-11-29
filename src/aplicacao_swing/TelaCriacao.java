package aplicacao_swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class TelaCriacao {

	private JFrame frmCriao;
	private JTextField telefone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCriacao window = new TelaCriacao();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCriacao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 300);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCriao.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cria\u00E7\u00E3o");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(154, 0, 116, 37);
		frmCriao.getContentPane().add(lblNewLabel);
		
		telefone = new JTextField();
		telefone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		telefone.setBounds(146, 87, 124, 19);
		frmCriao.getContentPane().add(telefone);
		telefone.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Telefone:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(61, 86, 75, 18);
		frmCriao.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo de pedido:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(61, 148, 154, 19);
		frmCriao.getContentPane().add(lblNewLabel_1_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Pedido Normal");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnNewRadioButton.setBounds(154, 186, 154, 19);
		frmCriao.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnPedidoExpress = new JRadioButton("Pedido Express");
		rdbtnPedidoExpress.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnPedidoExpress.setBounds(154, 218, 154, 19);
		frmCriao.getContentPane().add(rdbtnPedidoExpress);
		
		JButton btnNewButton = new JButton("Criar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(326, 232, 85, 21);
		frmCriao.getContentPane().add(btnNewButton);
	}

	JFrame getFrame() {
		return frmCriao;
	}

	public void setFrame(JFrame frame) {
		this.frmCriao = frame;
		frmCriao.setTitle("Cria\u00E7\u00E3o");
	}
}
