package aplicacao_swing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class TelaListagem {

	private JFrame frmListagem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListagem window = new TelaListagem();
					window.frmListagem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaListagem() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListagem = new JFrame();
		frmListagem.setTitle("Listagem");
		frmListagem.setBounds(100, 100, 575, 348);
		frmListagem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmListagem.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listagem");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(207, 0, 141, 55);
		frmListagem.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Produtos");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 59, 126, 25);
		frmListagem.getContentPane().add(btnNewButton);
		
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnClientes.setBounds(10, 94, 126, 25);
		frmListagem.getContentPane().add(btnClientes);
		
		JButton btnPedidosPagosDo = new JButton("Pedidos pagos");
		btnPedidosPagosDo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPedidosPagosDo.setBounds(281, 59, 126, 25);
		frmListagem.getContentPane().add(btnPedidosPagosDo);
		
		JButton btnPedidosNoPagos = new JButton("Pedidos n\u00E3o pagos");
		btnPedidosNoPagos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnPedidosNoPagos.setBounds(281, 94, 126, 25);
		frmListagem.getContentPane().add(btnPedidosNoPagos);
		
		JButton btnPedidos = new JButton("Pedidos");
		btnPedidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPedidos.setBounds(147, 59, 126, 25);
		frmListagem.getContentPane().add(btnPedidos);
		
		JButton btnPedidosDoCliente = new JButton("Pedidos do cliente");
		btnPedidosDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnPedidosDoCliente.setBounds(147, 94, 126, 25);
		frmListagem.getContentPane().add(btnPedidosDoCliente);
		
		JButton btnArrecadao = new JButton("Arrecada\u00E7\u00E3o");
		btnArrecadao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnArrecadao.setBounds(412, 59, 126, 25);
		frmListagem.getContentPane().add(btnArrecadao);
		
		JButton btnProdutosTop = new JButton("Produtos TOP");
		btnProdutosTop.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnProdutosTop.setBounds(412, 94, 126, 25);
		frmListagem.getContentPane().add(btnProdutosTop);
		
		JLabel lblNewLabel_1 = new JLabel("Saida:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(10, 148, 65, 20);
		frmListagem.getContentPane().add(lblNewLabel_1);
		
		JLabel saidalb = new JLabel("Aqui \u00E9 a saida");
		saidalb.setFont(new Font("Tahoma", Font.PLAIN, 16));
		saidalb.setBounds(10, 178, 541, 123);
		frmListagem.getContentPane().add(saidalb);
	}

	public JFrame getFrmListagem() {
		return frmListagem;
	}

	public void setFrmListagem(JFrame frmListagem) {
		this.frmListagem = frmListagem;
	}

}
