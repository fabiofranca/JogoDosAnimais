package animais.jogo.chain;

import animais.jogo.io.IO;

public class Animal implements Node{

	private String nome;
	private IO io;

	public Animal(String nome) {
		this.nome = nome;
	}

	public void executar() {
		io.imprimirTexto("O animal que você pensou é "+ nome +"?");
		Boolean resposta = io.receberRespostaSimNao();
		
		//acertou? acabou. Perdeu, crie mais perguntas
		new Caminho(new Fim(io), new CriadorDePerguntas(this)).definirCaminho(resposta);
	}
	
	public IO getIO(){
		return this.io;
	}

	public void setIO(IO io) {
		this.io = io;
	}
	
	public String getNome(){
		return this.nome;
	}
	
}
