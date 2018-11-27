package interfaces.interacoes.web.java;

import java.time.LocalDateTime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

import driver.web.DriverWeb;
import interacoes.web.InteracaoSeleniumJavaWeb;

public interface IAlert {
	Log logger = LogFactory.getLog(IAlert.class);
	
	/**
	 * @Descricao Aceitar o alerta
	 */
	default void aceitarAlerta() {
		Alert alert = DriverWeb.getDriver().switchTo().alert();
		alert.accept();
	}

	/**
	 * @Descricao Obter texto do alerta
	 * @return String
	 */
	default String obterTextoDoAlerta() {
		Alert alert = DriverWeb.getDriver().switchTo().alert();
		String texto = alert.getText();
		return texto;
	}

	/**
	 * @Descricao Negar Alerta
	 */
	default void negarAlerta() {
		Alert alert = DriverWeb.getDriver().switchTo().alert();
		alert.dismiss();
	}

	/**
	 * @Descricao Escrever no Alerta
	 * @param elemento
	 */
	default void escreverNoAlerta(String elemento) {
		try {
			Alert alert = DriverWeb.getDriver().switchTo().alert();
			alert.sendKeys(elemento);
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
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
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}

}