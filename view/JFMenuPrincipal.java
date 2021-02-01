package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Frame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class JFMenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFMenuPrincipal frame = new JFMenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFMenuPrincipal() {
		setTitle("Locadora - Principal ");
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Filme");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Cadastrar Filme...");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadastroFilme screen = new JFCadastroFilme();
				
				screen.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmRemoverFilme = new JMenuItem("Listar Filmes...");
		mntmRemoverFilme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFListarFilme screen = new JFListarFilme();
				
				screen.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmRemoverFilme);
		
		JMenu mnNewMenu_2 = new JMenu("Clientes");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Cadastrar Cliente...");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadastroCliente screen = new JFCadastroCliente();
				screen.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Listar Clientes...");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFListarCliente screen = new JFListarCliente();
				screen.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JPopupMenu popupMenu = new JPopupMenu();
		popupMenu.setBounds(-10008, -10053, 91, 32);
		addPopup(contentPane, popupMenu);
		
		JMenu mnNewMenu_1 = new JMenu("Filme");
		popupMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cadastrar Filme...");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadastroFilme screen = new JFCadastroFilme();
				
				screen.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmRemoverFilme_1 = new JMenuItem("Listar Filmes...");
		mntmRemoverFilme_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFListarFilme screen = new JFListarFilme();
				
				screen.setVisible(true);
				
			}
		});
		mnNewMenu_1.add(mntmRemoverFilme_1);
		setContentPane(contentPane);
		
		JLabel lblLocadoraMassa = new JLabel("Locadora do Leon");
		lblLocadoraMassa.setFont(new Font("JetBrains Mono", Font.PLAIN, 31));
		lblLocadoraMassa.setBounds(44, 43, 351, 177);
		contentPane.add(lblLocadoraMassa);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
