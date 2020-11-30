package aplicacao_swing;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import aplicacao.Programa;

public class TelaPrincipal {

	private JFrame frmIfood;
	private final JLabel lblNewLabel = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmIfood.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	private void initialize() {
		frmIfood = new JFrame();
		frmIfood.setResizable(false);
		frmIfood.setIconImage(Toolkit.getDefaultToolkit().getImage(TelaPrincipal.class.getResource("/imagem/icon.png")));
		frmIfood.setTitle("IFood");
		frmIfood.setBounds(100, 100, 450, 300);
		frmIfood.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIfood.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				try {
					new Programa();

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
			// @Override
			// public void windowClosing(WindowEvent e) {
			// JOptionPane.showMessageDialog(frame, "até breve !");
			// }
		});
		JMenuBar menuBar = new JMenuBar();
		frmIfood.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Pedido");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Criar");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				TelaCriacao window = new TelaCriacao();
				window.getFrame().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Alterar");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				TelaAlteracao window = new TelaAlteracao();
				window.getFrame().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Pagamento");
		mntmNewMenuItem_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				TelaPagamento window = new TelaPagamento();
				window.getFrame().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Cancelamento");
		mntmNewMenuItem_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				TelaCancelamento window = new TelaCancelamento();
				window.getFrmCancelamento().setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);

		JMenu mnNewMenu_1 = new JMenu("Listagem");
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TelaListagem window = new TelaListagem();
				window.getFrmListagem().setVisible(true);
			}
		});
		menuBar.add(mnNewMenu_1);
		frmIfood.getContentPane().setLayout(null);
		lblNewLabel.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/imagem/if.png")));
		lblNewLabel.setBounds(0, 0, 436, 241);
		frmIfood.getContentPane().add(lblNewLabel);
	}
}
