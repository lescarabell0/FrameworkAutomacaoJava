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

public interface IProcurar extends IEncontraTipoElementoWeb{
	Log logger = LogFactory.getLog(IProcurar.class);

//
//	/**
//	 * @author jessica.alauk
//	 * @Descricao Localiza uma lista de elementos através do xpath
//	 * @param name
//	 * @return lista de elementos
//	 */
//	default List<WebElement> procurarElementos(String name) {
//		List<WebElement> elemento = encontraElementos(name);
//		return elemento;
//	}
//
//	/**
//	 * @author jessica.alauk
//	 * @param elemento
//	 * @return
//	 */
//	default int retornaTamanhoListElementos(String elemento) {
//		List<WebElement> listaElementos = encontraElementos(elemento);
//		return listaElementos.size();
//	}
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
			retorno = DriverWeb.getDriver().findElement(elemento) != null;
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
		return retorno;
	}
}