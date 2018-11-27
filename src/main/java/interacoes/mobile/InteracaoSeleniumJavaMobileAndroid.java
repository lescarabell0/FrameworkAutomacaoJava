package interacoes.mobile;

import interfaces.interacoes.mobile.android.IAcoesAPP;
import interfaces.interacoes.mobile.android.IAcoesDevice;
import interfaces.interacoes.mobile.android.IArrastar;
import interfaces.interacoes.mobile.android.IClique;
import interfaces.interacoes.mobile.android.ICombo;
import interfaces.interacoes.mobile.android.IEncontraTipoElementoAndroid;
import interfaces.interacoes.mobile.android.IEscrever;
import interfaces.interacoes.mobile.android.IEspera;
import interfaces.interacoes.mobile.android.ILimpar;
import interfaces.interacoes.mobile.android.IMover;
import interfaces.interacoes.mobile.android.IObter;
import interfaces.interacoes.mobile.android.IProcurar;
import interfaces.interacoes.mobile.android.IValidacoesAndroid;
import io.appium.java_client.android.AndroidDriver;

/**
 * @author Paulo Lobo Neto
 * @Descricao Classe responsável por conter comandos que executam interações com
 *            a página da web. Os métodos contidos na classe são todos públicos
 *            e para utilizá-la, é necessário passar o WebDriver como parâmetro
 */
public class InteracaoSeleniumJavaMobileAndroid implements IAcoesAPP, IAcoesDevice, IArrastar, IClique, ICombo,
IEscrever, IEspera, ILimpar, IMover, IObter, IProcurar, IEncontraTipoElementoAndroid, IValidacoesAndroid {

	public static String nomePlataformaDeExecucao;

	/**
	 * @Descricao Método construtor, define que sempre que a classe for instanciada,
	 *            é necessário passar o driver como parâmetro
	 * @param WebDriver
	 */
	public InteracaoSeleniumJavaMobileAndroid(AndroidDriver<?> driver) {
	}
}