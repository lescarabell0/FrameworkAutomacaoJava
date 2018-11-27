package interfaces.interacoes.web.javascript;

import org.openqa.selenium.JavascriptExecutor;

import driver.web.DriverWeb;

public interface IObterJS {

	/**
	 * @Descricao Pegar valor do CSS. O parâmetro esperar receber o ID do elemento.
	 *            VocÊ DEVE passa o parâmetro como um tipo String
	 * @param idDoElemento
	 * @return String: valor do css
	 */
	default String obterValorCssJavascriptPorId(String idDoElemento) {
		JavascriptExecutor jse = (JavascriptExecutor) DriverWeb.getDriver();
		String value = (String) jse.executeScript(
				"" + "if (document.getElementById('" + idDoElemento + "').style.display == 'none'){   }");
		return value;
	}

}