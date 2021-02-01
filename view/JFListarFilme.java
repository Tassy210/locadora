package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JFListarFilme extends JFrame {

	private JPanel contentPane;
	private JTable jtFilme;
	private JButton btnCadastrar;
	private JButton btnAlterar;
	private JButton btnExcluir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFListarFilme frame = new JFListarFilme();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public JFListarFilme() {
		setTitle("Listagem de filmes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Listagem de filmes:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 11, 282, 37);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 59, 521, 320);
		contentPane.add(scrollPane);
		
		jtFilme = new JTable();
		jtFilme.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"idFilme", "Titulo ", "Categoria", "Tempo"
			}
		));
		jtFilme.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(jtFilme);
		
		btnCadastrar = new JButton("Adicionar Filme");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFCadastroFilme rm = new JFCadastroFilme();
				rm.setVisible(true);
				readJTable();
			}
		});
		btnCadastrar.setBounds(30, 385, 122, 23);
		contentPane.add(btnCadastrar);
		
		btnAlterar = new JButton("Editar Filme");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int selectedRow = jtFilme.getSelectedRow();
				
				if(selectedRow != -1) {
					
					int id = (int) jtFilme.getValueAt(selectedRow, 0);
					
					JFEditarFilme af = new JFEditarFilme();
					
					af.setVisible(true);
					
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um filme");
				}
				
				readJTable();
				
			}
		});
		btnAlterar.setBounds(162, 385, 89, 23);
		contentPane.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir Filme");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = jtFilme.getSelectedRow();
				FilmeDAO dao = new FilmeDAO();
				if(selectedRow != -1) {
					
					int id = (int) jtFilme.getValueAt(selectedRow, 0);
					dao.remove(id);
					
				} else {
					JOptionPane.showMessageDialog(null, "Selecione um filme");
				}
				
				readJTable();
			}
		});
		btnExcluir.setBounds(261, 385, 105, 23);
		contentPane.add(btnExcluir);
		
		readJTable();
	}
	
	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) jtFilme.getModel();
		modelo.setNumRows(0);
		FilmeDAO dao = new FilmeDAO();
		
		for(Filme f : dao.read()) {
			modelo.addRow(new Object[] {
					f.getIdFilme(),
					f.getTitulo(),
					f.getCategoria(),
					f.getTempo()
			});
		}}
	
}
