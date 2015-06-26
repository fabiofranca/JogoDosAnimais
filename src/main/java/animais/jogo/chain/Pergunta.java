package animais.jogo.chain;

import animais.jogo.io.IO;
import animais.jogo.util.BancoDePerguntas;

public class Pergunta implements Node{
	
	private String enunciado;
	private Boolean respostaAnterior;
	private IO io;
	
	private Caminho caminho;
	
	public Pergunta(String caracteristicaAnimal, Node sim, Node nao) {
		this.caminho = new Caminho(sim, nao);
		montarEnunciado(caracteristicaAnimal);
	}
	
	private void montarEnunciado(String caracteristica){
		this.enunciado = "O animal que você pensou " + caracteristica + "?";
	}
	
	public void executar() {
		BancoDePerguntas.setPerguntaAtual(this, io);
		io.imprimirTexto(enunciado);
		respostaAnterior = io.receberRespostaSimNao();
		
		caminho.definirCaminho(respostaAnterior);
	}
	

	public String getEnunciado() {
		return enunciado;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public void setIO(IO io) {
		this.io = io;
		this.caminho.setIO(io);
	}

	public void novaOpcao(Pergunta novaPergunta) {
		caminho.aumentarCaminho(respostaAnterior, novaPergunta);
	}

}
