package game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.Usuario;

import javax.swing.JLabel;
import java.awt.Color;


public class TelaPrincipal extends JFrame {
	
	private JPanel contentPane;
	public static Usuario user;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public TelaPrincipal(){
		
	}
	/**
	 * Create the frame.
	 */
	@SuppressWarnings("serial")
	public TelaPrincipal(Usuario user) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(41, 39, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(41, 64, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(41, 89, 46, 14);
		contentPane.add(lblSenha);
		
		JLabel lblNome_1 = new JLabel(user.getNome());
		lblNome_1.setBounds(101, 39, 123, 14);
		contentPane.add(lblNome_1);
		
		JLabel lblLogin_1 = new JLabel(user.getLogin());
		lblLogin_1.setBounds(101, 64, 123, 14);
		contentPane.add(lblLogin_1);
		
		JLabel label = new JLabel("********");
		label.setBounds(101, 89, 63, 14);
		contentPane.add(label);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(41, 114, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblEmail_1 = new JLabel(user.getEmail());
		lblEmail_1.setBounds(101, 114, 178, 14);
		contentPane.add(lblEmail_1);
		
	
	;
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(41, 139, 46, 14);
		contentPane.add(lblSexo);
		
		JLabel lblSexo_1 = new JLabel(user.getSexo());
		lblSexo_1.setBounds(100, 139, 46, 14);
		contentPane.add(lblSexo_1);

// adicionar um construtor para TelaPrincipal(){} vazio.


		
	}
	
	
	
}
