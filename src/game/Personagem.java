package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Personagem{
	int velocidade;
	int x;
	int y;
	int vida;
	int energia;
	int largura;
	int altura;
	boolean tp;
	
	double distancia;
	IA ia;
	
	
	public Personagem() {
		this.vida=4;
		this.energia=4;
		this.largura = x+50;
		this.altura = y+50;
		this.tp = false;
	}
	public Personagem(int largura, int altura) {
		this.vida=4;
		this.energia=4;
		this.largura = x+50;
		this.altura = y+50;
		this.tp = false;
	}
	
	public void colisao() {
			distancia = Math.sqrt( ((ia.x- this.x)* (ia.x- this.x)) +  ((ia.y-this.y) * (ia.y-this.y)) );
			System.out.println("Distancia : "+distancia);
	}
	

	public void pintarDisplay(Graphics g) {
		ImageIcon full = new ImageIcon("src/img/energiaevidafull.png");
		ImageIcon energia1 = new ImageIcon("src/img/energia1.png");
		ImageIcon energia2 = new ImageIcon("src/img/energia2.png");
		ImageIcon energia3 = new ImageIcon("src/img/energia3.png");
		ImageIcon energia4 = new ImageIcon("src/img/energia4.png");
		ImageIcon vida1 = new ImageIcon("src/img/vida1.png");
		ImageIcon vida2 = new ImageIcon("src/img/vida2.png");
		ImageIcon vida3 = new ImageIcon("src/img/vida3.png");
		ImageIcon vida4 = new ImageIcon("src/img/vida4.png");

		if(energia == 4 && vida == 4) {
			g.drawImage(full.getImage(), x - 90 , y, 90, 60, null);
		}
		if(energia == 4 ) {
			g.drawImage(energia4.getImage(), x - 90 , y, 90, 60, null);
		}
		if(energia == 3) {
			g.drawImage(energia3.getImage(), x - 90 , y, 90, 60, null);
		}
		if(energia == 2) {
			g.drawImage(energia2.getImage(), x - 90 , y, 90, 60, null);
		}
		if(energia == 1) {
			g.drawImage(energia1.getImage(), x - 90 , y, 90, 60, null);
		}
		if(vida == 4) {
			g.drawImage(vida4.getImage(),  x - 90 , y, 90, 60, null);
		}
		if(vida == 3) {
			g.drawImage(vida3.getImage(),  x - 90 , y, 90, 60, null);
		}
		if(vida == 2) {
			g.drawImage(vida2.getImage(),  x - 90 , y, 90, 60, null);
		}
		if(vida == 1) {
			g.drawImage(vida1.getImage(),  x - 90 , y, 90, 60, null);
		}
		if(vida <= 0) {
			Menu gameover = new Menu();
			gameover.gameover(g);
		}
	}
	public void displayStatus(Graphics g, String nick) {
		g.setColor(Color.MAGENTA);
		g.setFont(new Font("helvica",Font.BOLD,10));
		g.drawString(nick , x - 80 , y + 10);
	}


	public boolean teletransportar(Personagem jogador, int posicaoX, int posicaoY) {
		if(energia > 0) {
			x = posicaoX;
			y = posicaoY;
			energia--;
			return tp=true;
		}
		return tp=false;
	}

	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
