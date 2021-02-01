package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import model.bean.Cliente;
import model.dao.ClienteDAO;

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
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadastroCliente rm = new JFCadastroCliente();
				rm.setVisible(true);
				readJTable();
			}
		});
		
		btnCadastrar.setBounds(20, 376, 117, 23);
		contentPane.add(btnCadastrar);
		
		btnEditar = new JButton("Editar Cliente");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jtCliente.getSelectedRow();
				
				if(selectedRow != -1) {
					
					int id = (int) jtCliente.getValueAt(selectedRow, 0);
					
					JFEditarCliente af = new JFEditarCliente(id);
					
					af.setVisible(true);
					
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente");
				}
				
				readJTable();	
				
			}
		});
		
		btnEditar.setBounds(147, 376, 97, 23);
		contentPane.add(btnEditar);
		
		btnExcluir = new JButton("Excluir Cliente");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jtCliente.getSelectedRow();
				
				if(selectedRow != -1) {
					
					int id = (int) jtCliente.getValueAt(selectedRow, 0);
					ClienteDAO dao = new ClienteDAO();
					dao.remove(id);
					
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um cliente");
				}
				
				readJTable();	
				
			}
		});
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
