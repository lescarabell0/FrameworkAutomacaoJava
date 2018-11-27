package interfaces.interacoes.mobile.ios;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;

import driver.mobile.DriverMobile;
import interacoes.mobile.InteracaoSeleniumJavaMobileIOS;

public interface IValidacoesIOS extends IObter {
	Log logger = LogFactory.getLog(InteracaoSeleniumJavaMobileIOS.class);
	Actions action = new Actions(DriverMobile.getDriverIOS());

	default void validarMensagem(String textoOriginal, By elemento) {
		try {
			String textoDeComparacao = obterTexto(elemento);

			if (textoOriginal.equals(textoDeComparacao)) {
				System.out.println("Teste realizado com sucesso.");
			} else {
				Assert.fail();
			}
		} catch (Exception e) {
			Assert.fail();
			System.out.println(e);
		}
	}

	default void validarSeElementoEstaVisivel(By elemento) {
		assertEquals(true, DriverMobile.getDriverIOS().findElement(elemento).isDisplayed());
	}

	default void validarSeElementoEstaHabilitado(By elemento) {
		assertEquals(true, DriverMobile.getDriverIOS().findElement(elemento).isEnabled());
	}

	/**
	 * @Descricao Verificar se o Radio Button está selecionado
	 * @param elemento
	 * @return boolean
	 */
	default boolean validarSeElementoEstaSelecionado(By elemento) {
		boolean retorno = false;
		try {
			logger.info(" -- Realizar acao de verificar se radio do elemento: " + elemento + " esta marcado.");
			retorno = DriverMobile.getDriverIOS().findElement(elemento).isSelected();
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '"
					+ InteracaoSeleniumJavaMobileIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaMobileIOS.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoSeleniumJavaMobileIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaMobileIOS.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '"
					+ InteracaoSeleniumJavaMobileIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaMobileIOS.nomePlataformaDeExecucao + "'.Elemento: '" + elemento
					+ "NAO visivel' em tela.");
		}
		return retorno;
	}

	/**
	 * @Descricao Verificar se o check box está marcado
	 * @param elemento
	 * @return boolean
	 */
	default boolean validarSeOcheckBoxEstaMarcado(By elemento) {
		boolean retorno = false;
		try {
			retorno = DriverMobile.getDriverIOS().findElement(elemento).isSelected();
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '"
					+ InteracaoSeleniumJavaMobileIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaMobileIOS.nomePlataformaDeExecucao
					+ "'. NAO foi possivel localizar o elemento: '" + elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoSeleniumJavaMobileIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaMobileIOS.nomePlataformaDeExecucao
					+ "'. Tempo excedido para encontrar elemento: '" + elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '"
					+ InteracaoSeleniumJavaMobileIOS.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaMobileIOS.nomePlataformaDeExecucao + "'.Elemento: '" + elemento
					+ "NAO visivel' em tela.");
		}
		return retorno;
	}

	default String verificarOrientacaoDaTela() {
		return DriverMobile.getDriverIOS().getOrientation().toString();
	}

	default String obterTempoAparelho() {
		return DriverMobile.getDriverIOS().getDeviceTime();
	}
}