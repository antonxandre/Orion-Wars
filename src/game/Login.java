package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.BancoDeDados;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.Canvas;
import javax.swing.JTable;
import javax.swing.JProgressBar;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	BancoDeDados bd = new BancoDeDados();
	private boolean loga;
	private boolean janelaCadastro;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
			
					Login frame = new Login();
					
					
					frame.setVisible(true);
					
					frame.setTitle("Notna");
					frame.setSize(600, 400);
					frame.setLocationRelativeTo(null);
	}

	boolean logado = false;
	
	public Login() {
		setSize(600, 400);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/view/perfilnotna.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 0));
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(284, 155, 47, 31);
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Century Gothic", Font.BOLD, 18));
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(281, 239, 62, 23);
		contentPane.add(lblSenha);

		txtLogin = new JTextField();
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setForeground(Color.WHITE);
		txtLogin.setBackground(Color.BLACK);
		txtLogin.setBounds(210, 197, 183, 37);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setForeground(Color.WHITE);
		txtSenha.setBackground(Color.BLACK);
		txtSenha.setBounds(210, 273, 183, 37);
		contentPane.add(txtSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBackground(Color.BLACK);
		btnEntrar.setFont(new Font("Century Gothic", Font.BOLD, 14));
		btnEntrar.setForeground(Color.MAGENTA);
		btnEntrar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				bd.acessarBD(txtLogin.getText(), txtSenha.getText());
				if (bd.acesso == true) {
					
					logado = true;
					dispose();
					
				}
				
				if (bd.acesso == false) {
					txtLogin.setText("");
					txtSenha.setText("");
					txtLogin.requestFocus();
				}
				bd.acesso = false;

			}
		});

		btnEntrar.setBounds(257, 334, 97, 31);
		contentPane.add(btnEntrar);

		JButton btnCancelar = new JButton("Sair");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setForeground(Color.RED);
		btnCancelar.setBackground(Color.BLACK);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);

			}
		});
		btnCancelar.setBounds(461, 350, 129, 31);
		contentPane.add(btnCancelar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.GREEN);
		btnCadastrar.setBackground(Color.BLACK);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastro telacadastro = new TelaCadastro();
				janelaCadastro = true;
				dispose();
				telacadastro.setVisible(true);
				
			}
		});
		btnCadastrar.setBounds(20, 350, 129, 31);
		contentPane.add(btnCadastrar);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/view/telalogin.jpg")));
		lblNewLabel.setBounds(0, 0 , 600, 400);
		contentPane.add(lblNewLabel);

	}

	public boolean isLoga() {
		return loga;
	}

	public void setLoga(boolean loga) {
		this.loga = loga;
	}

	public boolean isJanelaCadastro() {
		return janelaCadastro;
	}

	public void setJanelaCadastro(boolean janelaCadastro) {
		this.janelaCadastro = janelaCadastro;
	}

	

	}

