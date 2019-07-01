package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.CadastroBD;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField cadastroLogin;
	private JPasswordField cadastroSenha;
	private JTextField cadastroNome;
	private JTextField cadastroEmail;
	private char cadastroSexo = 0;
	private boolean cadastroApto = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	
	
	public TelaCadastro() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 450);
		setLocationRelativeTo(null);
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu navmenu = new JMenu("Menu");
		
		menuBar.add(navmenu);
		
		JMenuItem mntmTermosDePrivacidade = new JMenuItem("Termos de privacidade");
		navmenu.add(mntmTermosDePrivacidade);
		
		JMenuItem navMenuSair = new JMenuItem("Sair");
		navmenu.add(navMenuSair);
		
			navMenuSair.addActionListener(new ActionListener() {

			
				public void actionPerformed(ActionEvent e) {
					dispose();
					Login login = new Login();
					login.show();
					
				
				}
				
				
			});
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVenhaFazerParte = new JLabel("Venha fazer parte da nossa fam\u00EDlia");
		lblVenhaFazerParte.setFont(new Font("Georgia", Font.PLAIN, 14));
		lblVenhaFazerParte.setBackground(Color.RED);
		lblVenhaFazerParte.setBounds(126, 11, 230, 23);
		contentPane.add(lblVenhaFazerParte);
		
		
		
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(89, 92, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(89, 117, 46, 14);
		contentPane.add(lblSenha);
		
		JLabel lblDigiteSeusDados = new JLabel("Digite seus dados:");
		lblDigiteSeusDados.setBounds(89, 64, 168, 14);
		contentPane.add(lblDigiteSeusDados);
		
		cadastroLogin = new JTextField();
		cadastroLogin.setBounds(196, 89, 86, 20);
		contentPane.add(cadastroLogin);
		cadastroLogin.setColumns(10);
		
		cadastroSenha = new JPasswordField();
		cadastroSenha.setBounds(196, 114, 86, 20);
		contentPane.add(cadastroSenha);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(89, 144, 46, 14);
		contentPane.add(lblNome);
		
		cadastroNome = new JTextField();
		cadastroNome.setBounds(196, 141, 86, 20);
		contentPane.add(cadastroNome);
		cadastroNome.setColumns(10);
		
		
		
		
		// BOTAO CADASTRAR
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.BLACK);
		btnCadastrar.setBackground(Color.GREEN);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroBD cadastro = new CadastroBD();
				cadastro.cadastrarUsuario(cadastroLogin.getText(), cadastroSenha.getText(), cadastroNome.getText(),
						cadastroEmail.getText() , cadastroSexo
						
						);
				
					if(cadastroApto==true) {
							if(cadastro.getCadastrado() == 1) {
									JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
									dispose();
									Login login = new Login();
									login.setVisible(true);
									//Game jogar = new Game();
									//jogar.run();
							}else {
									JOptionPane.showMessageDialog(null, "Não foi possível criar a conta.");
								}
					}else {
						JOptionPane.showMessageDialog(null, "Por favor, aceite os termos de serviço.");
					}	
			}
		});
		
		
		// END BOTAO CADASTRAR
		btnCadastrar.setFont(new Font("Century Gothic", Font.BOLD, 11));
		btnCadastrar.setBounds(354, 307, 89, 45);
		contentPane.add(btnCadastrar);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(89, 169, 46, 14);
		contentPane.add(lblEmail);
		
		cadastroEmail = new JTextField();
		cadastroEmail.setBounds(196, 166, 152, 20);
		contentPane.add(cadastroEmail);
		cadastroEmail.setColumns(10);
		
		
		
		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setBounds(196, 193, 41, 23);
		contentPane.add(rdbtnM);
		
		
		
		
		JRadioButton rdbtnF = new JRadioButton("F");
		rdbtnF.setBounds(239, 193, 109, 23);
		contentPane.add(rdbtnF);
		
		rdbtnF.addActionListener(new ActionListener() {
			boolean selecionado = false;
			public void actionPerformed(ActionEvent e) {
				selecionado = true;
				if(selecionado == true) {
					cadastroSexo = 'F' ;
					rdbtnM.setSelected(false);
				}
			}
			
			
		});
		
		rdbtnM.addActionListener(new ActionListener() {
			boolean selecionado = false;
			public void actionPerformed(ActionEvent e) {
				selecionado = true;
				if(selecionado == true) {
					cadastroSexo = 'M';
					rdbtnF.setSelected(false);
				}
			}
			
			
		});
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(89, 197, 46, 14);
		contentPane.add(lblSexo);
		
		JCheckBox cadastroCheckBox = new JCheckBox("Eu aceito os termos de servi\u00E7o");
		
		cadastroCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 9));
		cadastroCheckBox.setBounds(89, 219, 193, 29);
		contentPane.add(cadastroCheckBox);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(453, 11, -443, -4);
		contentPane.add(separator);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login login = new Login();
				login.setVisible(true);
				login.setJanelaCadastro(true);
				dispose();
			}
		});
		btnVoltar.setBounds(23, 319, 89, 23);
		contentPane.add(btnVoltar);
		
		
		cadastroCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastroApto = true;
			}
			
		});
		
	}
}
