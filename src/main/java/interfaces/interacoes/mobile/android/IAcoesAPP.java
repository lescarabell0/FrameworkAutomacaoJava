package interfaces.interacoes.mobile.android;

import driver.mobile.DriverMobile;

public interface IAcoesAPP {

	default void fecharApp() {
		DriverMobile.getDriverAndroid().closeApp();
	}

	default void removerApp(String bundleId) {
		DriverMobile.getDriverAndroid().removeApp(bundleId);
	}

	default void resetarApp() {
		DriverMobile.getDriverAndroid().resetApp();
	}
}