package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.bean.Cliente;

import model.dao.ClienteDAO;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFEditarCliente extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtPhone;

	private static int id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFEditarCliente frame = new JFEditarCliente(id);
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
	public JFEditarCliente(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 565, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Altera\u00E7\u00E3o de cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		txtName = new JTextField();
		txtName.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF");
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		
		JLabel lblNewLabel_4 = new JLabel("Telefone");
		
		JLabel lblId = new JLabel("id");
		
		lblId.setText(String.valueOf(id));
		
		ClienteDAO dao = new ClienteDAO();
		Cliente c = dao.read(id);
		txtName.setText(c.getNome());
		txtCpf.setText(c.getCpf());
		txtEmail.setText(c.getEmail());
		txtPhone.setText(c.getTelefone());
		
		JButton btnRegister = new JButton("Alterar");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = new Cliente();
				ClienteDAO dao = new ClienteDAO();
				
				c.setName(txtName.getText());
				c.setCpf(txtCpf.getText());
				c.setEmail(txtEmail.getText());
				c.setTelefone(txtPhone.getText());
				c.setId(Integer.parseInt(lblId.getText()));
				
				dao.update(c);
				dispose();
			}
		});
		
		JButton btnClear = new JButton("Limpar");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText("");
				txtCpf.setText("");
				txtEmail.setText("");
				txtPhone.setText("");
			}
		});
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("ID:");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_5)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblId))
						.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(txtEmail, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
						.addComponent(lblNewLabel_3)
						.addComponent(txtCpf, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
						.addComponent(lblNewLabel_2)
						.addComponent(txtName, GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnRegister)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnClear)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnCancel)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(lblId))
					.addGap(27)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegister)
						.addComponent(btnClear)
						.addComponent(btnCancel))
					.addGap(28))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
