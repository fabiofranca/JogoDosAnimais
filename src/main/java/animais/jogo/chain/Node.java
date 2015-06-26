package animais.jogo.chain;

import animais.jogo.io.IO;

public interface Node {
	
	public void executar();
	public void setIO(IO io);
}
