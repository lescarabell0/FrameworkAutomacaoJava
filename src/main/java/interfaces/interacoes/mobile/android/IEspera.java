package interfaces.interacoes.mobile.android;

import java.time.LocalDateTime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.mobile.DriverMobile;
import interacoes.mobile.InteracaoSeleniumJavaMobileAndroid;

public interface IEspera extends IEncontraTipoElementoAndroid {
	Log logger = LogFactory.getLog(IEspera.class);
	
	/**
	 * @param       elemento.
	 * @param tempo limite de espera
	 */
	default void esperarSerClicavel(By elemento, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverMobile.getDriverAndroid(), time);
			wait.until(ExpectedConditions.elementToBeClickable(DriverMobile.getDriverAndroid().findElement(elemento)));
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao
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
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}

	/**
	 * @Descricao
	 * @param elemento
	 * @param tempoLimiteDeEspera
	 */
	default void esperarSerSelecionavel(By elemento, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverMobile.getDriverAndroid(), time);
			wait.until(ExpectedConditions.elementToBeSelected(DriverMobile.getDriverAndroid().findElement(elemento)));
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao
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
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}

	/**
	 * @Descricao Esperar a página estar na URL passada via parâmetro
	 * @param URL
	 * @param tempoLimiteDeEspera
	 */
	default void esperarUrlSerCarregada(String url, int tempoLimiteDeEspera) {
		WebDriverWait wait = new WebDriverWait(DriverMobile.getDriverAndroid(), tempoLimiteDeEspera);
		wait.until(ExpectedConditions.urlToBe(url));
	}

	/**
	 * @Descricao Esperar elemento ser clicável, clicar e escrever
	 * @param elemento
	 * @param texto
	 * @param tempoLimiteDeEspera
	 */
	default void esperarSerClicavelClicarEscrever(By elemento, String valor, int tempoLimiteDeEspera) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverMobile.getDriverAndroid(), tempoLimiteDeEspera);
			wait.until(ExpectedConditions.elementToBeClickable(DriverMobile.getDriverAndroid().findElement(elemento))).clear();
			wait.until(ExpectedConditions.elementToBeClickable(DriverMobile.getDriverAndroid().findElement(elemento))).click();
			wait.until(ExpectedConditions.elementToBeClickable(DriverMobile.getDriverAndroid().findElement(elemento))).sendKeys(valor);
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao
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
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}
	
	/**
	 * @param elemento
	 * @param tempo    limite de espera
	 */
	default void esperarElemento(By elemento, int time) {
		try {
			logger.info(
					" -- Realizar acao de esperar o elemento: " + elemento + " pelo tempo de:" + time + " segundos.");

			WebDriverWait wait = new WebDriverWait(DriverMobile.getDriverAndroid(), time);
			wait.until(ExpectedConditions.visibilityOf(DriverMobile.getDriverAndroid().findElement(elemento)));
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao
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
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}

	/**
	 * @Descricao Esperar visibilidade do elemento
	 * @param elemento
	 * @param tempoLimiteDeEspera
	 */
	default void esperarVisibilidadeDoElemento(By elemento, int tempoLimiteDeEspera) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverMobile.getDriverAndroid(), tempoLimiteDeEspera);
			wait.until(ExpectedConditions.visibilityOf(DriverMobile.getDriverAndroid().findElement(elemento)));
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao
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
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}

	/**
	 * @Descricao Esperar elemento ser visível
	 * @param elemento
	 * @param tempoLimiteDeEspera
	 */
	default void esperarElementoSerVisivel(By elemento, int tempoLimiteDeEspera) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverMobile.getDriverAndroid(), tempoLimiteDeEspera);
			wait.until(ExpectedConditions.visibilityOf(DriverMobile.getDriverAndroid().findElement(elemento)));
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao
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
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '" + InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao + "'.Elemento: '"
					+ elemento + "NAO visivel' em tela.");
		}
	}

	/**
	 * @Descricao Esperar elemento ser clicável, após, limpar o campo
	 * @param elemento
	 * @param tempoLimiteDeEspera
	 */
	default void esperarElementoSerClicavelLimparCampo(By elemento, int tempoLimiteDeEspera) {
		try {
			WebDriverWait wait = new WebDriverWait(DriverMobile.getDriverAndroid(), tempoLimiteDeEspera);
			WebElement input = wait.until(ExpectedConditions.elementToBeClickable(DriverMobile.getDriverAndroid().findElement(elemento)));
			while (input.getAttribute("value").length() > 0) {
				input.sendKeys(Keys.BACK_SPACE);
			}
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '" + InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao
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
	
	default void esperarPadrao(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}