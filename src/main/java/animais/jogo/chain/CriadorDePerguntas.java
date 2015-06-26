package animais.jogo.chain;

import animais.jogo.io.IO;
import animais.jogo.util.BancoDePerguntas;

public class CriadorDePerguntas implements Node {
	
	private IO io;
	private Animal animalAtual;
	
	public CriadorDePerguntas(Animal animalAtual){
		this.animalAtual = animalAtual;
		this.io = animalAtual.getIO();
	}
	
	public void executar() {
		io.imprimirTexto("Desisto, qual animal você pensou?");
		String nomeNovoAnimal = io.inputTexto();
		io.imprimirTexto("Informe uma característica do "+nomeNovoAnimal);
		String caracteristicaNovoAnimal =  io.inputTexto();
		
		Pergunta novaPergunta = new Pergunta(caracteristicaNovoAnimal, new Animal(nomeNovoAnimal), animalAtual);
		BancoDePerguntas.novaPergunta(novaPergunta);

		io.imprimirTexto("Ok, vamos jogar de novo!");
		io.imprimirTexto("---------------------");
	}
	

	/**
	 * Não é preciso chamar pois a classe aproveita
	 * a instancia de {@code IO} do {@code animalAtual} passado no construtor
	 */
	@Deprecated
	public void setIO(IO io) {}

}
