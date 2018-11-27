package interacoes.mobile;

import interfaces.interacoes.mobile.ios.IAcoesAPP;
import interfaces.interacoes.mobile.ios.IAcoesDevice;
import interfaces.interacoes.mobile.ios.IArrastar;
import interfaces.interacoes.mobile.ios.IClique;
import interfaces.interacoes.mobile.ios.ICombo;
import interfaces.interacoes.mobile.ios.IEncontraTipoElementoIOS;
import interfaces.interacoes.mobile.ios.IEscrever;
import interfaces.interacoes.mobile.ios.IEspera;
import interfaces.interacoes.mobile.ios.ILimpar;
import interfaces.interacoes.mobile.ios.IMover;
import interfaces.interacoes.mobile.ios.IObter;
import interfaces.interacoes.mobile.ios.IProcurar;
import interfaces.interacoes.mobile.ios.IValidacoesIOS;
import io.appium.java_client.ios.IOSDriver;

/**
 * @author Paulo Lobo Neto
 * @Descricao Classe responsável por conter comandos que executam interações com
 *            a página da web. Os métodos contidos na classe são todos públicos
 *            e para utilizá-la, é necessário passar o WebDriver como parâmetro
 */
public class InteracaoSeleniumJavaMobileIOS implements IAcoesAPP, IAcoesDevice, IArrastar, IClique, ICombo,
		IEscrever, IEspera, ILimpar, IMover, IObter, IProcurar, IEncontraTipoElementoIOS, IValidacoesIOS {

	public static String nomePlataformaDeExecucao;

	/**
	 * @Descricao Método construtor, define que sempre que a classe for instanciada,
	 *            é necessário passar o driver como parâmetro
	 * @param WebDriver
	 */
	public InteracaoSeleniumJavaMobileIOS(IOSDriver<?> driver) {
	}
}