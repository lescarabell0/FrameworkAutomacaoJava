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

public interface IProcurar extends IEncontraTipoElementoAndroid {
	Log logger = LogFactory.getLog(IProcurar.class);

	/**
	 * @Descricao Procurar um elemento específico na página. Para utiliza-lo é
	 *            necessário informar um localizador (id, className, cssSelector,
	 *            Xpath, etc) afim de identificá-lo na página
	 * @param elemento
	 */
	default boolean procurarElemento(By elemento) {
		boolean retorno = false;
		try {
			logger.info(" -- Realizar acao de procurar o elemento: " + elemento);
			retorno = DriverMobile.getDriverAndroid().findElement(elemento) != null;
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '"
					+ InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '"
					+ InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaMobileAndroid.nomePlataformaDeExecucao + "'.Elemento: '" + elemento
					+ "NAO visivel' em tela.");
		}
		return retorno;
	}
}