package interfaces.interacoes.web.java;

import java.time.LocalDateTime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import driver.web.DriverWeb;
import interacoes.web.InteracaoSeleniumJavaWeb;

public interface IEscrever extends IEncontraTipoElementoWeb{
	Log logger = LogFactory.getLog(IEscrever.class);
	
	/**
	 * @Descricao Escrever em algum campo
	 * @param elemento
	 * @param texto
	 */
	default void escrever(By elemento, String texto) {
		try {
			logger.info(" -- Realizar acao de escrever no elemento: " + elemento + " o texto: " + texto);
			DriverWeb.getDriver().findElement(elemento).sendKeys(texto);
		} catch (NoSuchElementException e) {
			logger.warn("-- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}
}