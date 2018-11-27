package interfaces.interacoes.mobile.ios;

import driver.mobile.DriverMobile;

public interface IAcoesAPP {

	default void fecharApp() {
		DriverMobile.getDriverIOS().closeApp();
	}

	default void removerApp(String bundleId) {
		DriverMobile.getDriverIOS().removeApp(bundleId);
	}

	default void resetarApp() {
		DriverMobile.getDriverIOS().resetApp();
	}
}