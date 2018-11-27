package interfaces.interacoes.mobile.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.mobile.DriverMobile;

public interface IEncontraTipoElementoAndroid {

	default WebElement encontra(String name) {
		WebElement elemento = null;

		try {
			elemento = DriverMobile.getDriverAndroid().findElement(By.id(name));
		} catch (Exception e) {
			try {
				elemento = DriverMobile.getDriverAndroid().findElement(By.name(name));
			} catch (Exception e1) {
				try {
					elemento = DriverMobile.getDriverAndroid().findElement(By.xpath(name));
				} catch (Exception e2) {
					try {
						elemento = DriverMobile.getDriverAndroid().findElement(By.cssSelector(name));
					} catch (Exception e3) {
						try {
							elemento = DriverMobile.getDriverAndroid().findElement(By.linkText(name));
						} catch (Exception e4) {
							try {
								elemento = DriverMobile.getDriverAndroid().findElement(By.partialLinkText(name));
							} catch (Exception e5) {
								try {
									elemento = DriverMobile.getDriverAndroid().findElement(By.tagName(name));
								} catch (Exception e6) {
									String valorError = "Nenhum elemento foi identificado!";
									System.out.println(valorError);
									throw new java.lang.Error(valorError);
								}
							}
						}
					}
				}
			}
		}
		return elemento;
	}
}