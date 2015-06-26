package animais.jogo.io;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class IOParaTeste implements IO {
	
	private String texto;
	private List<Object> listaRespostas = new ArrayList<Object>();
	private Boolean finalizarJogo = Boolean.FALSE;
	private Map<String, String> textos = new LinkedHashMap<String, String>();

	public Boolean receberRespostaSimNao() {
		
		Boolean resposta = getRespostaSimNaoFromLista();
		
		textos.put(texto, resposta.toString());
		return resposta;
	}

	private Boolean getRespostaSimNaoFromLista() {
		if(listaRespostas.isEmpty()) return null;
		
		Boolean resposta = null;
		for (Object respostaLista : listaRespostas) {
			if(respostaLista instanceof Boolean){
				resposta = (Boolean) respostaLista;
				break;
			}
		}
		listaRespostas.remove(listaRespostas.indexOf(resposta));
		return resposta;
	}
	
	private String getRespostaStringFromLista(){
		if(listaRespostas.isEmpty()) return null;
		
		String resposta = null;
		for (Object respostaLista : listaRespostas) {
			if(respostaLista instanceof String){
				resposta = (String) respostaLista;
				break;
			}
		}
		listaRespostas.remove(listaRespostas.indexOf(resposta));
		return resposta;
	}

	public String inputTexto() {
		return getRespostaStringFromLista();
	}
	
	public void esperarComandoContinue() {}

	public void imprimirTexto(String texto) {
		textos.put(texto, null);
		this.texto = texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void finalizarJogo() {
		this.finalizarJogo = Boolean.TRUE;
	}

	public Boolean isJogoFinalizado() {
		return this.finalizarJogo;
	}

	public void adicionarResposta(Object resposta) {
		this.listaRespostas.add(resposta);
	}
	
	public Map<String, String> getPerguntasRespondidas(){
		return this.textos;
	}

}
