package animais.jogo.io;

import java.util.Scanner;

import animais.jogo.Jogo;

public class JogoConsole implements IO{
	
	private final Scanner teclado = new Scanner(System.in);
	private Jogo jogo;
	private Boolean jogoFinalizado;
	
	public void iniciar() {
		System.out.println("–––– Jogo dos animais ––––");
		jogoFinalizado = Boolean.FALSE;
		jogo = new Jogo(this);
		jogo.jogar();
	}

	public Boolean receberRespostaSimNao() {
		imprimirTexto("1 = sim / 2 = não");
		return inputTexto().equals("1");
	}

	public String inputTexto() {
		return teclado.nextLine();
	}

	public void esperarComandoContinue() {
		teclado.nextLine();
	}

	public void imprimirTexto(String texto) {
		System.out.println(texto);
	}

	public void finalizarJogo() {
		jogoFinalizado = Boolean.TRUE;
	}

	public Boolean isJogoFinalizado() {
		return jogoFinalizado;
	}
	
}
