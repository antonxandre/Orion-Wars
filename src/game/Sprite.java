package game;

import javax.swing.ImageIcon;

public class Sprite extends Personagem{
	
	ImageIcon cenas[];	
	int cena = 0;
	int controlaVelocidade = 0;
	int velocidade = 6;
	

	// animação definindo o lugar
	public Sprite(int numeroDeCenas, int x, int y){
		cenas = new ImageIcon[numeroDeCenas];
		this.x = x;
		this.y = y;
	}
	
	// artficios
	public Sprite (int numeroDeCenas) {
		cenas = new ImageIcon[numeroDeCenas];
	}
	
	
	//imagens 
	public Sprite() {
		
	}
	
	
	public void animar(){
		cena += 1;
		if(cena == cenas.length){ cena = 0; }
	}
	
	

	
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	

	
}
