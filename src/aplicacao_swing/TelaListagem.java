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
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(105, 55, 163, 33);
		frmListagem.getContentPane().add(textField);
		textField.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(17, 99, 348, 285);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
		frmListagem.getContentPane().add(textArea);

		JButton btnNewButton = new JButton("Produtos");
		btnNewButton.setBounds(375, 26, 174, 34);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String str = "";
				for (Produto p : Fachada.listarProdutos("")) {
					str += p.getId() + " - " + p.getNome().toString() + " - " + p.getPedidosIds() + "\n";
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
					str += c.getNome().toString() + " - " + c.getTelefone() + " - " + c.getPedidosIds() + "\n";
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
						str += p.getId() + p.getCliente().getNome().toString() + " - " + p.getCliente().getTelefone()
								+ " - " + p.getProdutosIds() + "\n";
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
						str += p.getId() + p.getCliente().getNome().toString() + " - " + p.getCliente().getTelefone()
								+ " - " + p.getProdutosIds() + "\n";

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
					str += p.getId() + p.getCliente().getNome().toString() + " - " + p.getCliente().getTelefone()
							+ " - " + p.getProdutosIds() + "\n";
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
						str += p.getId() + p.getCliente().getNome().toString() + " - " + p.getCliente().getTelefone()
								+ " - " + p.getProdutosIds() + "\n";

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
					str += p.getId() + " - " + p.getNome().toString() + " - " + p.getPedidosIds() + "\n";
				}
				textArea.setText(str);
			}
		});
		btnProdutosTop.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmListagem.getContentPane().add(btnProdutosTop);

		JLabel lblNewLabel_2 = new JLabel("Telefone:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(17, 53, 77, 35);
		frmListagem.getContentPane().add(lblNewLabel_2);

	}

	public JFrame getFrmListagem() {
		return frmListagem;
	}

	public void setFrmListagem(JFrame frmListagem) {
		this.frmListagem = frmListagem;
	}
}