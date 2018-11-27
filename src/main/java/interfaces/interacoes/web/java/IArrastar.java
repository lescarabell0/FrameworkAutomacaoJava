package interfaces.interacoes.web.java;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import driver.web.DriverWeb;

public interface IArrastar extends IEncontraTipoElementoWeb{
	Actions action = new Actions(DriverWeb.getDriver());
	
	default void arrastar(By elemento, By elemento_dois) {
		try {
			action.dragAndDrop(DriverWeb.getDriver().findElement(elemento), DriverWeb.getDriver().findElement(elemento_dois));
			action.perform();
		} catch (Exception e) {
			String valorError = "Não é um elemento de arraste";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}
}