package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.bean.Filme;
import model.dao.ClienteDAO;
import model.dao.FilmeDAO;

import java.awt.Color;
import javax.swing.JButton;

public class JFListarCliente extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JTable jtCliente;
	private JButton btnCadastrar;
	private JButton btnEditar;
	private JButton btnExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarCliente frame = new JFListarCliente();
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
	public JFListarCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 582, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("Listagem de Clientes:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 11, 235, 30);
		contentPane.add(lblNewLabel);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 546, 293);
		contentPane.add(scrollPane);
		
		jtCliente = new JTable();
		jtCliente.setBackground(Color.LIGHT_GRAY);
		jtCliente.setForeground(Color.BLACK);
		jtCliente.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Id", "Nome", "Email", "CPF", "Telefone"
			}
		));
		scrollPane.setViewportView(jtCliente);
		
		btnCadastrar = new JButton("Cadastrar Cliente");
		btnCadastrar.setBounds(20, 376, 117, 23);
		contentPane.add(btnCadastrar);
		
		btnEditar = new JButton("Editar Cliente");
		btnEditar.setBounds(147, 376, 97, 23);
		contentPane.add(btnEditar);
		
		btnExcluir = new JButton("Excluir Cliente");
		btnExcluir.setBounds(254, 376, 107, 23);
		contentPane.add(btnExcluir);
		
		readJTable();
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jtCliente.getModel();
		modelo.setNumRows(0);
		ClienteDAO dao = new ClienteDAO();
		
		for(Cliente f : dao.read()) {
			modelo.addRow(new Object[] {
					f.getId(),
					f.getNome(),
					f.getEmail(),
					f.getCpf(), 
					f.getTelefone()
			});
		}}
}
