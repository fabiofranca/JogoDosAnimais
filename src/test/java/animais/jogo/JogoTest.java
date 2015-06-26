package animais.jogo;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import animais.jogo.Jogo;
import animais.jogo.io.IOParaTeste;

public class JogoTest{
	
	private Jogo jogo;
	private IOParaTeste io;
	
	
	@Before
	public void setup(){
		io = new IOParaTeste();
		jogo = new Jogo(io);
	}
	
	
	@Test
	public void adivinharAnimalDefault(){
		io.adicionarResposta(Boolean.TRUE);
		io.adicionarResposta(Boolean.TRUE);
		
		jogo.jogar();
		Map<String, String> perguntasRespondidas = io.getPerguntasRespondidas();
		List<Entry<String,String>> entryList = new ArrayList<Entry<String, String>>(perguntasRespondidas.entrySet());
		
		String pergunta1 = entryList.get(2).getKey();
		String pergunta2 = entryList.get(3).getKey();
		String acertei = entryList.get(4).getKey();
		
		assertTrue("O animal que você pensou vive na água?".equals(pergunta1));
		assertTrue("O animal que você pensou é Tubarão?".equals(pergunta2));
		assertTrue("Acertei de novo!".equals(acertei));
	}
	
	@Test
	public void negarAnimalEAfimarOutro(){
		io.adicionarResposta(Boolean.FALSE);
		io.adicionarResposta(Boolean.TRUE);
		
		jogo.jogar();
		Map<String, String> perguntasRespondidas = io.getPerguntasRespondidas();
		List<Entry<String,String>> entryList = new ArrayList<Entry<String, String>>(perguntasRespondidas.entrySet());
		
		String pergunta1 = entryList.get(2).getKey();
		String pergunta2 = entryList.get(3).getKey();
		String acertei = entryList.get(4).getKey();
		
		assertTrue("O animal que você pensou vive na água?".equals(pergunta1));
		assertTrue("O animal que você pensou é Macaco?".equals(pergunta2));
		assertTrue("Acertei de novo!".equals(acertei));
	}
	
	@Test
	public void adicionarNovoAnimalEResponderNovamente(){
		io.adicionarResposta(Boolean.FALSE);
		io.adicionarResposta(Boolean.FALSE);
		io.adicionarResposta("Cachorro");
		io.adicionarResposta("late");
		
		io.adicionarResposta(Boolean.FALSE);
		io.adicionarResposta(Boolean.TRUE);
		io.adicionarResposta(Boolean.TRUE);
		
		jogo.jogar();
		Map<String, String> perguntasRespondidas = io.getPerguntasRespondidas();
		List<Entry<String,String>> entryList = new ArrayList<Entry<String, String>>(perguntasRespondidas.entrySet());
		
		String pergunta1 = entryList.get(2).getKey();
		String pergunta2 = entryList.get(3).getKey();
		String pergunta3 = entryList.get(4).getKey();
		String pergunta4 = entryList.get(5).getKey();
		String pergunta5 = entryList.get(8).getKey();
		String pergunta6 = entryList.get(9).getKey();
		String acertei = entryList.get(10).getKey();
		
		assertTrue("O animal que você pensou vive na água?".equals(pergunta1));
		assertTrue("O animal que você pensou é Macaco?".equals(pergunta2));
		assertTrue("Desisto, qual animal você pensou?".equals(pergunta3));
		assertTrue("Informe uma característica do Cachorro".equals(pergunta4));
		assertTrue("O animal que você pensou late?".equals(pergunta5));
		assertTrue("O animal que você pensou é Cachorro?".equals(pergunta6));
		assertTrue("Acertei de novo!".equals(acertei));
	}


}
