package interfaces.interacoes.mobile.android;

import java.time.LocalDateTime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import driver.mobile.DriverMobile;
import interacoes.mobile.InteracaoSeleniumJavaMobileAndroid;

public interface IEscrever extends IEncontraTipoElementoAndroid{
	Log logger = LogFactory.getLog(IEscrever.class);
	
	/**
	 * @Descricao Escrever em algum campo
	 * @param elemento
	 * @param texto
	 */
	default void escrever(By elemento, String texto) {
		try {
			logger.info(" -- Realizar acao de escrever no elemento: " + elemento + " o texto: " + texto);
			DriverMobile.getDriverAndroid().findElement(elemento).sendKeys(texto);
		} catch (NoSuchElementException e) {
			logger.warn("-- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '" + InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao
					+ "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}
}