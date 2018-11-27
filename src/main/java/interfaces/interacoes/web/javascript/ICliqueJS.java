package interfaces.interacoes.web.javascript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import driver.web.DriverWeb;
import interfaces.interacoes.web.java.IEncontraTipoElementoWeb;

public interface ICliqueJS extends IEncontraTipoElementoWeb{
	/**
	 * @Descricao Clicar no elemento
	 * @param elemento
	 */
	default void clicarJavascript(String elemento) {
		WebElement element = encontra(elemento);
		JavascriptExecutor executor = (JavascriptExecutor) DriverWeb.getDriver();
		executor.executeScript("arguments[0].click();", element);
	}

}