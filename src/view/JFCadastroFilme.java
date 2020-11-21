package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Filme;
import model.dao.FilmeDAO;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class JFCadastroFilme extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCategoria;
	private JTextField txtSinopse;
	private JSpinner spinnerTempo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFCadastroFilme frame = new JFCadastroFilme();
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
	public JFCadastroFilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cadastrar Filme");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 11));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(10, 30, 109, 36);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setText("Nome do filme");
		txtNome.setBounds(10, 77, 98, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JRadioButton rdbtn3D = new JRadioButton("Imagem 3D");
		rdbtn3D.setBounds(10, 146, 109, 23);
		contentPane.add(rdbtn3D);
		
		JRadioButton rdbtnDub = new JRadioButton("Dublado");
		rdbtnDub.setBounds(10, 172, 109, 23);
		contentPane.add(rdbtnDub);
		
		txtCategoria = new JTextField();
		txtCategoria.setText("Categoria");
		txtCategoria.setBounds(232, 77, 86, 20);
		contentPane.add(txtCategoria);
		txtCategoria.setColumns(10);
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Filme f = new Filme();
				FilmeDAO dao = new FilmeDAO();
				f.setTitulo(txtNome.getText());
				f.setCategoria(txtCategoria.getText());
				f.setSinopse(txtSinopse.getText());
				
				if(rdbtn3D.isSelected()) {
					f.setImagem3d(true);
				} else {
					f.setImagem3d(false);
				}
				
				if(rdbtnDub.isSelected()) {
					f.setDublado(true);
				} else {
					f.setDublado(false);
				}
				
				dao.create(f);
			}
		});
		btnNewButton.setBounds(165, 208, 89, 23);
		contentPane.add(btnNewButton);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(236, 154, 53, -26);
		contentPane.add(layeredPane);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(230, 108, 165, 68);
		contentPane.add(layeredPane_1);
		
		txtSinopse = new JTextField();
		txtSinopse.setText("Sinopse");
		txtSinopse.setBounds(0, 0, 165, 68);
		layeredPane_1.add(txtSinopse);
		txtSinopse.setColumns(10);
		
		JSpinner spinnerTempo = new JSpinner();
		spinnerTempo.setBounds(79, 108, 29, 20);
		contentPane.add(spinnerTempo);
		
		JLabel lblNewLabel_1 = new JLabel("Dura\u00E7\u00E3o");
		lblNewLabel_1.setBounds(10, 108, 59, 20);
		contentPane.add(lblNewLabel_1);
	}
}
