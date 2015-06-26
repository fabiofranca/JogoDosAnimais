package animais.jogo.io;

public interface IO {
	
	public Boolean receberRespostaSimNao();
	public String inputTexto();
	public void esperarComandoContinue();
	
	public void imprimirTexto(String texto);
	public void finalizarJogo();
	public Boolean isJogoFinalizado();
}
