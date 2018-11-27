package interfaces.interacoes.mobile.ios;

import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.ScreenOrientation;

import driver.mobile.DriverMobile;

public interface IAcoesDevice {
	default void esconderTeclado() {
	//	logger.info(" -- Minimizando o teclado no dispositivo: '" + nomePlataformaDeExecucao + "'.");
		DriverMobile.getDriverIOS().hideKeyboard();
}
	default void rotacionarAparelho(DeviceRotation rotacaoDoAparelho) {
		DriverMobile.getDriverIOS().rotate(rotacaoDoAparelho);
	}
	
	default void rotacionarTela(ScreenOrientation orientacaoDaTela) {
		DriverMobile.getDriverIOS().rotate(orientacaoDaTela);
	}
}