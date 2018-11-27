package interfaces.interacoes.web.java;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import driver.web.DriverWeb;

public interface IEncontraTipoElementoWeb {

	default WebElement encontra(String name) {
		WebElement elemento = null;

		try {
			elemento = DriverWeb.getDriver().findElement(By.id(name));
		} catch (Exception e) {
			try {
				elemento = DriverWeb.getDriver().findElement(By.name(name));
			} catch (Exception e1) {
				try {
					elemento = DriverWeb.getDriver().findElement(By.xpath(name));
				} catch (Exception e2) {
					try {
						elemento = DriverWeb.getDriver().findElement(By.cssSelector(name));
					} catch (Exception e3) {
						try {
							elemento = DriverWeb.getDriver().findElement(By.linkText(name));
						} catch (Exception e4) {
							try {
								elemento = DriverWeb.getDriver().findElement(By.partialLinkText(name));
							} catch (Exception e5) {
								try {
									elemento = DriverWeb.getDriver().findElement(By.tagName(name));
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
	
	default List<WebElement> encontraElementos(String name) {
		List<WebElement> elemento = null;

		try {
			elemento = DriverWeb.getDriver().findElements(By.id(name));
		} catch (Exception e) {
			try {
				elemento = DriverWeb.getDriver().findElements(By.name(name));
			} catch (Exception e1) {
				try {
					elemento = DriverWeb.getDriver().findElements(By.xpath(name));
				} catch (Exception e2) {
					try {
						elemento = DriverWeb.getDriver().findElements(By.cssSelector(name));
					} catch (Exception e3) {
						try {
							elemento = DriverWeb.getDriver().findElements(By.linkText(name));
						} catch (Exception e4) {
							try {
								elemento = DriverWeb.getDriver().findElements(By.partialLinkText(name));
							} catch (Exception e5) {
								try {
									elemento = DriverWeb.getDriver().findElements(By.tagName(name));
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