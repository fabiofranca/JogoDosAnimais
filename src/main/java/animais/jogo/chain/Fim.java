package animais.jogo.chain;

import animais.jogo.io.IO;

public class Fim implements Node {
	
	private IO io;
	
	public Fim(IO io) {
		this.io = io;
	}

	public void executar() {
		io.imprimirTexto("Acertei de novo!");
		io.finalizarJogo();
	}

	/**
	 * @deprecated método declarado em razão da interface {@code IO}.
	 * Neste ponto não é necessário implementar
	 */
	@Deprecated
	public void setIO(IO io) {}

}
