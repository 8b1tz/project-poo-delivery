package aplicacao_swing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import fachada.Fachada;
import modelo.Pedido;

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
		frmCriao.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Criacao");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(154, 0, 116, 37);
		frmCriao.getContentPane().add(lblNewLabel);

		telefone = new JTextField();
		telefone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		telefone.setBounds(146, 87, 124, 19);
		frmCriao.getContentPane().add(telefone);
		telefone.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Telefone:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(61, 86, 75, 18);
		frmCriao.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Tipo de pedido:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(61, 116, 154, 19);
		frmCriao.getContentPane().add(lblNewLabel_1_1);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Pedido Normal");
		rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnNewRadioButton.setBounds(154, 141, 154, 19);
		frmCriao.getContentPane().add(rdbtnNewRadioButton);

		JRadioButton rdbtnPedidoExpress = new JRadioButton("Pedido Express");
		rdbtnPedidoExpress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rdbtnPedidoExpress.setBounds(154, 176, 154, 19);
		frmCriao.getContentPane().add(rdbtnPedidoExpress);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(26, 215, 373, 38);
		frmCriao.getContentPane().add(lblNewLabel_2);
		if (rdbtnPedidoExpress.isSelected() == true) {
			lblNewLabel_2.setText("Nao pode marcar os dois ao mesmo tempo!");
		}
		JButton btnNewButton = new JButton("Criar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnNewRadioButton.isSelected() == true && rdbtnPedidoExpress.isSelected() == false) {
					try {
						Pedido id = Fachada.criarPedido(telefone.getText());
						lblNewLabel_2.setText("Criado! id do pedido: " + id.getId());
					} catch (Exception e1) {
						lblNewLabel_2.setText(e1.getMessage());
					}
				}
				if (rdbtnPedidoExpress.isSelected() == true && rdbtnNewRadioButton.isSelected() == false) {
					try {
						Pedido id = Fachada.criarPedido((telefone.getText()).toString(), 0.0);
						lblNewLabel_2.setText("Criado! id do pedido: " + id.getId());
					} catch (Exception e1) {
						lblNewLabel_2.setText(e1.getMessage());
					}
				}
				if (rdbtnPedidoExpress.isSelected() == true && rdbtnNewRadioButton.isSelected() == true) {
					lblNewLabel_2.setText("Nao pode marcar 2 tipos ao mesmo tempo!");
					
				}
			}

		});

		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(314, 208, 85, 21);
		rdbtnPedidoExpress.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnPedidoExpress.isSelected() == true && rdbtnNewRadioButton.isSelected() == true) {
                    btnNewButton.setEnabled(false);
                }
                else {
                    btnNewButton.setEnabled(true);
                }
            }});
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnPedidoExpress.isSelected() == true && rdbtnNewRadioButton.isSelected() == true) {
                    btnNewButton.setEnabled(false);
                }
                else {
                    btnNewButton.setEnabled(true);
                }
            }});
		frmCriao.getContentPane().add(btnNewButton);

	}

	JFrame getFrame() {
		return frmCriao;
	}

	public void setFrame(JFrame frame) {
		this.frmCriao = frame;
		frmCriao.setResizable(false);
		frmCriao.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCriacao.class.getResource("/imagem/icon.png")));
		frmCriao.setTitle("Criacao");
	}
}
