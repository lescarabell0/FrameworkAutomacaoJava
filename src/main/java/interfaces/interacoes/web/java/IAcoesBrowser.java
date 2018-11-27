package interfaces.interacoes.web.java;

import java.time.LocalDateTime;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import driver.web.DriverWeb;
import interacoes.web.InteracaoSeleniumJavaWeb;

public interface IAcoesBrowser {
	Log logger = LogFactory.getLog(IAcoesBrowser.class);

	/**
	 * @Descricao Abrir uma nova URL em um novo browser.
	 * @param URL
	 * 
	 */
	default void abrirUrl(String url) {
		DriverWeb.getDriver().get(url);
	}

	/**
	 * @Descricao Nvaegar para outra URL, permanecendo na mesma aba do browser
	 * @param URL
	 */
	default void navegarUrl(String url) {
		DriverWeb.getDriver().navigate().to(url);
	}
	
	/**
	 * @Descricao Trocar de Janela
	 * @param elemento
	 */
	default void trocarJanela(Integer elemento) {
		try {
			Set<String> handles = DriverWeb.getDriver().getWindowHandles();
			Object[] it = handles.toArray();

			DriverWeb.getDriver().switchTo().window((String) it[elemento]);
		} catch (Exception e) {
			String valorError = "Este Indice de Janela não existe!\n\nUse um valor Valido!";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}

	/**
	 * @Descricao Trocar de Janela
	 * @param elemento
	 */
	default void trocarJanela(String elemento) {
		try {
			DriverWeb.getDriver().switchTo().window(elemento);
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. NAO foi possivel localizar o elemento: '"
					+ elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. Tempo excedido para encontrar elemento: '"
					+ elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.Elemento: '" + elemento
					+ "NAO visivel' em tela.");
		}
	}

	/**
	 * @Descricao Mudar de aba do navegador
	 * @param numero da aba. Ex.: 0, 1, 2 ...
	 */
	default void mudarAba(int numero) {
		logger.info(" -- Realizar acao de mudar para a : " + numero + " aba do browser");
		DriverWeb.getDriver().switchTo().window((String) DriverWeb.getDriver().getWindowHandles().toArray()[numero]);
	}
}