package animais.jogo.chain;

import animais.jogo.io.IO;


public class Caminho {
	
	private Node sim;
	private Node nao;
	
	public Caminho(Node sim, Node nao){
		this.sim = sim;
		this.nao = nao;
	}
	
	public void definirCaminho(Boolean resposta){
		if(resposta) sim.executar();
		else nao.executar();
	}
	
	public void aumentarCaminho(Boolean caminhoAntigo, Node novoCaminho){
		if(caminhoAntigo) sim = novoCaminho;
		else nao = novoCaminho;
	}
	
	public void setIO(IO io) {
		this.sim.setIO(io);
		this.nao.setIO(io);
	}

}
