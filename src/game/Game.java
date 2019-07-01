package game;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends JFrame implements KeyListener, MouseListener, MouseMotionListener{
	private static final long serialVersionUID = 1L;
	private BufferedImage backBuffer;
	int FPS = 60;
	int janelaW = 1280;
	int janelaH = 720;
	int xMira; 
	int yMira;
	int contador = 0;
	double pontos=0;
	double fase1Pontos= 1500;
	boolean clicouParaAtirar = false;
	Personagem personagem = new Personagem(80,80);
	Sprite personagemVermelho = new Sprite (1 , 20, 520);
	Sprite personagemVermelhoTrans = new Sprite (3, personagemVermelho.getX(), personagemVermelho.getY());
	Sprite personagemBranco = new Sprite (1 , 20, 20);
	Sprite personagemAzul = new Sprite (1 , 1200, 20);
	Sprite personagemVerde = new Sprite (1 , 1200, 520);
	Sprite pontosCentral = new Sprite (9, 260,170);
	IA personagemIAazul;
	IA personagemIAbranco;
	IA personagemIAverde;
	Sprite ninja = new Sprite(4, 20, 500);
	Sprite mira = new Sprite(3);
	ImageIcon fundo = new ImageIcon("src/img/fundo.png");
	JFrame janela;
	static Login login = new Login();
	boolean logado = login.bd.acesso;
	Sprite buracoNegro = new Sprite (20, 350, 60);
	Menu menu = new Menu();
	boolean podeAndar = true;

	


	public void isLogado(Boolean logado) {
		this.logado = logado;
	}

	
	public void loader() {	
		setTitle("The Orion");
		setSize(janelaW, janelaH);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/view/perfilnotna.jpg")));
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setLocationRelativeTo(null);
		setVisible(true);

		backBuffer = new BufferedImage(janelaW, janelaH, BufferedImage.TYPE_INT_RGB);
	}

	public void personagem() {
		personagem = personagemVermelho;
		
		if(personagem.x <= 0) {
			personagem.x = 0;
		}
		else if(personagem.x >= janelaW - 40 ) {
			personagem.setX(janelaW-40);
		}
		else if(personagem.y <= 0 ) {
			personagem.y = 0;
		}
		else if(personagem.y >= janelaH - 40 ) {
			personagem.y = janelaH -40;
		}
	}
	public void CarregarSprites() {
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		personagemVermelho.cenas[0] = new ImageIcon("src/img/estrelavermelha.png");
		personagemBranco.cenas[0] = new ImageIcon("src/img/estrelabranca.png");
		personagemAzul.cenas[0] = new ImageIcon("src/img/estrelaazul.png");
		personagemVerde.cenas[0] = new ImageIcon("src/img/estrelaverde.png");
		pontosCentral.cenas[0] = new ImageIcon("src/img/c1.png");
		pontosCentral.cenas[1] = new ImageIcon("src/img/c2.png");
		pontosCentral.cenas[2] = new ImageIcon("src/img/c3.png");
		pontosCentral.cenas[3] = new ImageIcon("src/img/c4.png");
		pontosCentral.cenas[4] = new ImageIcon("src/img/c5.png");
		pontosCentral.cenas[5] = new ImageIcon("src/img/c6.png");
		pontosCentral.cenas[6] = new ImageIcon("src/img/c7.png");
		pontosCentral.cenas[7] = new ImageIcon("src/img/c8.png");
		pontosCentral.cenas[8] = new ImageIcon("src/img/c9.png");
		mira.cenas[0] = new ImageIcon("src/img/teletransportar1.png");
		mira.cenas[1] = new ImageIcon("src/img/teletransportar2.png");
		mira.cenas[2] = new ImageIcon("src/img/teletransportar3.png");
	}
	public void GerenciadorMapa(){
		if(pontos < fase1Pontos) {
			pontos++;
		}
	}
	public void desenhar() {
		personagem = personagemVermelho;
		String userNome = login.bd.getUsuarioNome();
		Graphics g = getGraphics();	
		Graphics bbg = backBuffer.getGraphics();
		//Personagens
		personagem();			 
		bbg.drawImage(fundo.getImage(),0,0,1280,720,this);
		bbg.drawImage(personagemVermelho.cenas[0].getImage(), personagemVermelho.getX(),
				personagemVermelho.y,this);
		bbg.drawImage(personagemBranco.cenas[0].getImage(), personagemBranco.getX(),
				personagemBranco.y,this);
		bbg.drawImage(personagemAzul.cenas[0].getImage(), personagemAzul.getX(),
				personagemAzul.y,this);
		bbg.drawImage(personagemVerde.cenas[0].getImage(), personagemVerde.getX(),
				personagemVerde.y,this);
		if( (personagem.getX()+50 >= 250 && personagem.getX()-50 <= 1030) &&
				(personagem.getY()+50>= 160 && personagem.getY() -50 <= 550) ) {
			bbg.drawImage(pontosCentral.cenas[pontosCentral.cena].getImage(), pontosCentral.x, pontosCentral.y, this);
			pontosCentral.animar();
			bbg.setColor(Color.WHITE);
			bbg.setFont(new Font("Arial",Font.BOLD,30));
			GerenciadorMapa();
			bbg.drawString("Pontos: "+pontos, 550, 390);
		}
		personagem.pintarDisplay(bbg);
		personagem.displayStatus(bbg, userNome);
		// IA
		
		personagemIAazul = new IA(personagemAzul, 3);
		personagemIAbranco = new IA(personagemBranco, 3);
		personagemIAverde = new IA(personagemVerde,  3);
		

		personagemIAazul.mover(personagemAzul.getX(), personagemAzul.getY(), personagem);
		personagemIAbranco.mover(personagemBranco.getX(), personagemBranco.getY(), personagem);
		personagemIAverde.mover(personagemVerde.getX(), personagemVerde.getY(), personagem);
		personagem.ia = personagemIAverde;
		
		if(pontos==2000) {
			menu.win(bbg);
		}

		if(clicouParaAtirar == true) {
			
			bbg.setColor(Color.WHITE);
			bbg.drawImage(mira.cenas[mira.cena].getImage(), xMira, yMira, this);
			mira.animar();
		}
		else {
			bbg.finalize();
		}

		if(menu.isAtivo()) {
			menu.pausar(bbg);
			podeAndar=false;	
		}
		else {
			podeAndar = true;
		}

		//==================================================================================	
		g.drawImage(backBuffer, 0, 0, this);

	}
	public void run() {
		while(login.logado==false) {
			if(login.isJanelaCadastro() == false) {
				login.setVisible(true);
			}
			if(login.logado==true) {
				login.setVisible(false);
				loader();
				CarregarSprites();
				break;
			}
		}

		while (true) {
			desenhar();
			try {
				Thread.sleep(1000/FPS);
			} catch (Exception e) {
				System.out.println("Thread FPS interrompida!");
			}
		}
	}
	public static void main(String[] args) {
		Game game = new Game();
		game.run();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//AQUI X e Y DA MIRA RECEBE AS COORDENADAS DO CURSOR
		if(clicouParaAtirar == true) {
			xMira =  e.getX();
			yMira =  e.getY();
		}
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
	}
	@Override
	public void mouseClicked(MouseEvent m) {	

	}
	@Override
	public void mouseEntered(MouseEvent m) {

	}
	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent m) {
		xMira = m.getX();
		yMira = m.getY();
		if (contador %2 == 0) {
			clicouParaAtirar = true;		
			System.out.println(contador);
			contador++;
		}
		else {
			clicouParaAtirar = false;
			contador = m.getClickCount();
			contador++;
		}
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {

	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	public void keyPressed(KeyEvent a) {
		personagem = personagemVermelho;
		if(podeAndar == true) {
			if(a.getKeyCode() == KeyEvent.VK_LEFT){
				personagem.setX(personagem.getX() - 5);
			}
			if(a.getKeyCode() == KeyEvent.VK_A){
				personagem.setX(personagem.getX() - 5);
			}
			if(a.getKeyCode() == KeyEvent.VK_RIGHT) {
				personagem.setX(personagem.getX() + 5);
			}
			if(a.getKeyCode() == KeyEvent.VK_D) {
				personagem.setX(personagem.getX() + 5);
			}
			if(a.getKeyCode() == KeyEvent.VK_UP) {
				personagem.setY(personagem.getY() - 5);
			}
			if(a.getKeyCode() == KeyEvent.VK_W) {
				personagem.setY(personagem.getY() - 5);
			}
			if(a.getKeyCode() == KeyEvent.VK_DOWN) {
				personagem.setY(personagem.getY() + 5);
			}
			if(a.getKeyCode() == KeyEvent.VK_S) {
				personagem.setY(personagem.getY() + 5);
			}
			if(a.getKeyCode() == KeyEvent.VK_T) {		
				personagem.teletransportar(personagem, xMira, yMira);
				clicouParaAtirar = false;
			}
		}
		if(a.getKeyChar() == KeyEvent.VK_ESCAPE) {
			menu.setAtivo(true);
		}
		menu.controlarMenu(a);
	}
}