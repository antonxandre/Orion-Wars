package game;

import java.util.Random;

public class IA extends Personagem{
	private Personagem personagem;
	private Personagem jogador;
	private int velocidade;
	private Random gerarvalor1 = new Random();
	double distancia;
	
	public IA(Personagem personagem, int velocidade) {
		this.personagem = personagem; 
		this.velocidade = velocidade;
	}

	public IA(Personagem personagem) {
		this.personagem = personagem;
	}
	public IA() {
		
	}
	
	
	
	public void mover(int x, int y, Personagem jogador) {
		
		if( (jogador.getX() == x && jogador.getY() == y) )
		{
			jogador.setX(20);
			jogador.setY(520);
			jogador.vida--;
			jogador.energia = 4;
		}

		if(x > jogador.getX()) {
			velocidade = gerarvalor1.nextInt(5);
			this.personagem.setX(personagem.getX()-velocidade);
			// if posicao jogador x e também y 			
		}
		if(x < jogador.getX()) {
			velocidade = gerarvalor1.nextInt(5);
			this.personagem.setX(personagem.getX()+velocidade);

		}
		if(y < jogador.getY()) {
			velocidade = gerarvalor1.nextInt(5);
			this.personagem.setY(personagem.getY()+velocidade);

		}
		if(y > jogador.getY()) {
			velocidade = gerarvalor1.nextInt(5);
			this.personagem.setY(personagem.getY()-velocidade);
		}
	}


	public Personagem getPersonagem() {
		return personagem;
	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}


	public Personagem getJogador() {
		return jogador;
	}


	public void setJogador(Personagem jogador) {
		this.jogador = jogador;
	}

}
