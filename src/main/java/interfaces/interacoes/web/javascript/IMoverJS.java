package interfaces.interacoes.web.javascript;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import driver.web.DriverWeb;
import interfaces.interacoes.web.java.IEncontraTipoElementoWeb;

public interface IMoverJS extends IEncontraTipoElementoWeb{
	/**
	 * @Descricao Mover para o elemento
	 * @param elemento
	 */
	default void moverParaOelementoJavascript(String elemento) {
		WebElement element = encontra(elemento);
		JavascriptExecutor executor = (JavascriptExecutor) DriverWeb.getDriver();
		executor.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}