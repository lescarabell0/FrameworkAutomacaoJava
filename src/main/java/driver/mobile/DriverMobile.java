/**
 * Companhia Brasileira de Solucoes e Servicos - Todos os Direitos Reservados � - Alelo 2018.
 * F2A Mobile =)
 * Criado por: Lucas Benn
 * Alterado por: Paulo Lobo
 * Data de criacao:  02/06/2018 
 * Ultima alteracao: 26/10/2018 
 * 
 * Classe responsavel por instanciar as sessoes solicitadas nos aparelhos indicados (de acordo com os parametros identificados em planilha)
 */
package driver.mobile;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import controladorplanilhadetestes.PlanilhaDeMassaEConfiguracaoDeTestes;
import enums.Retorno;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class DriverMobile {

	private static AndroidDriver<?> driverAndroid = null;
	private static IOSDriver<?> driverIOS = null;
	PlanilhaDeMassaEConfiguracaoDeTestes planilha = new PlanilhaDeMassaEConfiguracaoDeTestes();
	DesiredCapabilities cap = null;
	
	@SuppressWarnings("rawtypes")
	public void definirCapabilitiesAndroid(String identificadorSetadoNaPlanilhaDeTestes) {
		cap = new DesiredCapabilities();
		cap.setCapability("platformName", "ANDROID");
		cap.setCapability("app", planilha.retornarElementoDaPlanilhaDeRequisicoes(identificadorSetadoNaPlanilhaDeTestes, Retorno.CAMINHOAPK));
		cap.setCapability("deviceName", planilha.retornarElementoDaPlanilhaDeRequisicoes(identificadorSetadoNaPlanilhaDeTestes, Retorno.DEVICEID));
		cap.setCapability("platformVersion", planilha.retornarElementoDaPlanilhaDeRequisicoes(identificadorSetadoNaPlanilhaDeTestes, Retorno.VERSAODOSO));
		cap.setCapability("appWaitActivity", planilha.retornarElementoDaPlanilhaDeRequisicoes(identificadorSetadoNaPlanilhaDeTestes, Retorno.APPWAITACTIVITY));
		try {
			driverAndroid = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public void definirCapabilitesIOS(String idAparelho, String modeloAparelho) {

	}

	public static IOSDriver<?> getDriverIOS() {
		return driverIOS;
	}

	public static AndroidDriver<?> getDriverAndroid() {
		return driverAndroid;
	}

	/**
	 * Mata o processo do driver instanciado.
	 */
	public static void killDriver() {
		if (driverAndroid != null) {
			driverAndroid.quit();
			driverAndroid = null;
		}
		if (driverIOS != null) {
			driverIOS.quit();
			driverIOS = null;
		}
	}
}