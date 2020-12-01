package aplicacao_swing;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import fachada.Fachada;
import modelo.Cliente;
import modelo.Pedido;
import modelo.Produto;

public class TelaListagem {

	private JFrame frmListagem;
	private JTextField textField;

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
		frmListagem.setResizable(false);
		frmListagem
				.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaListagem.class.getResource("/imagem/icon.png")));
		frmListagem.setTitle("Listagem");
		frmListagem.setBounds(100, 100, 575, 446);
		frmListagem.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Listagem");
		lblNewLabel.setBounds(194, 0, 141, 55);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		frmListagem.getContentPane().add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(105, 55, 163, 33);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmListagem.getContentPane().add(textField);
		textField.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 82, 439, 121);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		frmListagem.getContentPane().add(textArea);

		JScrollPane scroll = new JScrollPane(textArea);
		scroll.setBounds(11, 106, 354, 300);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		frmListagem.getContentPane().add(scroll);

		JButton btnNewButton = new JButton("Produtos");
		btnNewButton.setBounds(375, 26, 174, 34);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "";
				for (Produto p : Fachada.listarProdutos("")) {
					str += p.toString() + "\n \n";
					// str += p.toString() + "\n";
				}
				textArea.setText(str);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmListagem.getContentPane().add(btnNewButton);

		JButton btnClientes = new JButton("Clientes");
		btnClientes.setBounds(375, 122, 174, 34);
		btnClientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "";
				for (Cliente c : Fachada.listarClientes()) {
					str += c.toString() + "\n \n";
				}
				textArea.setText(str);
			}
		});
		btnClientes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmListagem.getContentPane().add(btnClientes);

		JButton btnPedidosPagosDo = new JButton("Pedidos pagos do cliente");
		btnPedidosPagosDo.setBounds(375, 257, 174, 34);
		btnPedidosPagosDo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "";
				try {
					for (Pedido p : Fachada.listarPedidos(textField.getText(), 1)) {
						str += p.toString() + "\n \n";
					}
					textArea.setText(str);
				} catch (Exception e1) {
					textArea.setText(e1.getMessage());
				}
			}
		});
		btnPedidosPagosDo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmListagem.getContentPane().add(btnPedidosPagosDo);

		JButton btnPedidosNoPagos = new JButton("Pedidos do cliente nao pagos");
		btnPedidosNoPagos.setBounds(375, 212, 174, 34);
		btnPedidosNoPagos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "";
				try {
					for (Pedido p : Fachada.listarPedidos(textField.getText(), 2)) {
						str += p.toString() + "\n \n";

					}
					textArea.setText(str);
				} catch (Exception e1) {
					textArea.setText(e1.getMessage());
				}
			}
		});
		btnPedidosNoPagos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		frmListagem.getContentPane().add(btnPedidosNoPagos);

		JButton btnPedidos = new JButton("Pedidos");
		btnPedidos.setBounds(375, 76, 176, 34);
		btnPedidos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "";
				for (Pedido p : Fachada.listarPedidos()) {
					str += p.toString() + "\n \n";
				}
				textArea.setText(str);
			}
		});
		btnPedidos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmListagem.getContentPane().add(btnPedidos);

		JButton btnPedidosDoCliente = new JButton("Pedidos do cliente");
		btnPedidosDoCliente.setBounds(375, 167, 174, 34);
		btnPedidosDoCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "";
				try {
					for (Pedido p : Fachada.listarPedidos(textField.getText(), 3)) {
						str += p.toString() + "\n \n";

					}
					textArea.setText(str);
				} catch (Exception e1) {
					textArea.setText(e1.getMessage());
				}
			}
		});
		btnPedidosDoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmListagem.getContentPane().add(btnPedidosDoCliente);

		JButton btnArrecadao = new JButton("Arrecadacao");
		btnArrecadao.setBounds(375, 302, 174, 34);
		btnArrecadao.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int dia = LocalDate.now().getDayOfMonth();
				Double d = Fachada.consultarArrecadacao(dia);
				textArea.setText(d.toString());
			}
		});
		btnArrecadao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmListagem.getContentPane().add(btnArrecadao);

		JButton btnProdutosTop = new JButton("Produtos TOP");
		btnProdutosTop.setBounds(375, 347, 174, 37);
		btnProdutosTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "";
				for (Produto p : Fachada.consultarProdutoTop()) {
					str += p.toString() + "\n \n";
				}
				textArea.setText(str);
			}
		});
		btnProdutosTop.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmListagem.getContentPane().add(btnProdutosTop);

		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		lblNewLabel_2.setBounds(17, 53, 77, 35);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		frmListagem.getContentPane().add(lblNewLabel_2);

	}

	public JFrame getFrmListagem() {
		return frmListagem;
	}

	public void setFrmListagem(JFrame frmListagem) {
		this.frmListagem = frmListagem;
	}
}