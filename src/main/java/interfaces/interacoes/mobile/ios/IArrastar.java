package interfaces.interacoes.mobile.ios;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import driver.mobile.DriverMobile;
import io.appium.java_client.TouchAction;

public interface IArrastar extends IEncontraTipoElementoIOS {
	Actions action = new Actions(DriverMobile.getDriverIOS());

	default void arrastar(By elemento, By elemento_dois) {
		try {
			action.dragAndDrop(DriverMobile.getDriverIOS().findElement(elemento), DriverMobile.getDriverIOS().findElement(elemento_dois));
			action.perform();
		} catch (Exception e) {
			String valorError = "Não é um elemento de arraste";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}
	
	default void arrastar(int origemX, int origemY, int destinoX, int destinoY, String movimento) {
	//	logger.info(" -- Navegando para " + movimento);
		TouchAction pressionar = new TouchAction(DriverMobile.getDriverIOS());
		pressionar.longPress(origemX, origemY).moveTo(destinoX, destinoY).release().perform();
	}
}