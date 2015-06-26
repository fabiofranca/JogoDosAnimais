package animais.jogo.util;

import animais.jogo.chain.Animal;
import animais.jogo.chain.Node;
import animais.jogo.chain.Pergunta;
import animais.jogo.io.IO;

public class BancoDePerguntas {
	
	private static Pergunta perguntaAtual;
	private static Pergunta perguntaRoot;
	
	static{
		perguntaRoot = new Pergunta("vive na água", new Animal("Tubarão"), new Animal("Macaco"));
	}
	
	public static void setPerguntaAtual(Pergunta pergunta, IO io){
		perguntaAtual = pergunta;
		perguntaAtual.setIO(io);
	}
	
	public static Node primeiraPergunta(IO io){
		perguntaRoot.setIO(io);
		return perguntaRoot;
	}
	
	public static void novaPergunta(Pergunta pergunta){
		perguntaAtual.novaOpcao(pergunta);
	}
	
	
}
