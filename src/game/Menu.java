package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;


import javax.swing.ImageIcon;

import dao.BancoDeDados;
import dao.Usuario;


public class Menu{
	private boolean ativo;
	private boolean teclou;
	Sprite menu = new Sprite(3,0,0);
	int selecao;
	int proxima;
	public Menu(){
		inicializar();
		ativo = false;
		selecao = 1;
		proxima=0;
		teclou = false;
	}
	public void controlarMenu(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			selecao -= 1;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			selecao += 1;
		}
		if (selecao > menu.cenas.length) {
			selecao = 1;
		}
		if (selecao < 1) {
			selecao = menu.cenas.length;
		}
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			teclou = true;
		}
	}
	public void inicializar() {
		menu.cenas[0] = new ImageIcon("src/game/menusprite/menujogar.png");
		menu.cenas[1] = new ImageIcon("src/game/menusprite/menuopcoes.png");
		menu.cenas[2] = new ImageIcon("src/game/menusprite/menusair.png");
	}
	public void pausar (Graphics bbg){	
		if(selecao == 1) {
			ativo = true;
			teclou = false; 
			bbg.drawImage(menu.cenas[0].getImage(), 0, 0, null);
			if(teclou) {	
				ativo = false;
			}
		}
		if(selecao == 2) {
			bbg.drawImage(menu.cenas[1].getImage(), 0, 0, null);
			if(teclou)
			{
				BancoDeDados bd = new BancoDeDados();
				Usuario user;
				user = bd.getUsuario();
				TelaPrincipal opcoes = new TelaPrincipal(user);
				opcoes.setVisible(true);
				ativo = false;
			}
		}
		if(selecao == 3) {
			bbg.drawImage(menu.cenas[2].getImage(), 0, 0, null);
			if(teclou) {
				System.exit(0);
			}
		}
	}
	public void gameover(Graphics g) {
		ImageIcon gameover = new ImageIcon("src/img/gameover.png");
		g.drawImage(gameover.getImage(), 0, 0, null);
		Thread.interrupted();
	}
	public void win(Graphics g ) {
		ImageIcon gameover = new ImageIcon("src/img/win.jpg");
		g.drawImage(gameover.getImage(), 0, 0, null);
	}
	public boolean isTeclou() {
		return teclou;
	}

	public void setTeclou(boolean teclou) {
		this.teclou = teclou;
	}

	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
