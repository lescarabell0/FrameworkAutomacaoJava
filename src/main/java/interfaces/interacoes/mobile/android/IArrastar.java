package interfaces.interacoes.mobile.android;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import driver.mobile.DriverMobile;
import io.appium.java_client.TouchAction;

public interface IArrastar extends IEncontraTipoElementoAndroid {
	Actions action = new Actions(DriverMobile.getDriverAndroid());

	default void arrastar(By elemento, By elemento_dois) {
		try {
			action.dragAndDrop(DriverMobile.getDriverAndroid().findElement(elemento), DriverMobile.getDriverAndroid().findElement(elemento_dois));
			action.perform();
		} catch (Exception e) {
			String valorError = "Não é um elemento de arraste";
			System.out.println(valorError);
			throw new java.lang.Error(valorError);
		}
	}
	
	default void arrastar(int origemX, int origemY, int destinoX, int destinoY, String movimento) {
	//	logger.info(" -- Navegando para " + movimento);
		TouchAction pressionar = new TouchAction(DriverMobile.getDriverAndroid());
		pressionar.longPress(origemX, origemY).moveTo(destinoX, destinoY).release().perform();
	}
}