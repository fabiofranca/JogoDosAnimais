package animais.jogo;

import animais.jogo.chain.Node;
import animais.jogo.io.IO;
import animais.jogo.util.BancoDePerguntas;

public class Jogo {
	
	private IO io;
	
	public Jogo(IO io){
		this.io = io;
		
	}
	
	public void jogar(){
		while(!io.isJogoFinalizado()){
			io.imprimirTexto("Pense em um animal...");
			io.imprimirTexto("(aperte ENTER quando estiver pronto)");
			io.esperarComandoContinue();
			
			Node node = BancoDePerguntas.primeiraPergunta(io);
			node.executar();
		}
	}
	
}
