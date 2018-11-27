package interfaces.interacoes.mobile.android;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;

import driver.mobile.DriverMobile;

public interface IAcoesDevice {

	default void rotacionarAparelho(DeviceRotation rotacaoDoAparelho) {
		DriverMobile.getDriverAndroid().rotate(rotacaoDoAparelho);
	}

	default void rotacionarTela(ScreenOrientation orientacaoDaTela) {
		DriverMobile.getDriverAndroid().rotate(orientacaoDaTela);
	}

	default void esconderTeclado() {
		if (DriverMobile.getDriverAndroid().isKeyboardShown()) {
			DriverMobile.getDriverAndroid().hideKeyboard();
		}
	}

}