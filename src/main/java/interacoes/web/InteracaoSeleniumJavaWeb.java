package interacoes.web;

import org.openqa.selenium.WebDriver;

import interfaces.interacoes.web.java.IAcoesBrowser;
import interfaces.interacoes.web.java.IAlert;
import interfaces.interacoes.web.java.IArrastar;
import interfaces.interacoes.web.java.IClique;
import interfaces.interacoes.web.java.ICombo;
import interfaces.interacoes.web.java.IEncontraTipoElementoWeb;
import interfaces.interacoes.web.java.IEscrever;
import interfaces.interacoes.web.java.IEspera;
import interfaces.interacoes.web.java.IFrame;
import interfaces.interacoes.web.java.ILimpar;
import interfaces.interacoes.web.java.IMover;
import interfaces.interacoes.web.java.IObter;
import interfaces.interacoes.web.java.IProcurar;
import interfaces.interacoes.web.java.IValidacoesWeb;
import interfaces.interacoes.web.javascript.ICliqueJS;
import interfaces.interacoes.web.javascript.IEscreverJS;
import interfaces.interacoes.web.javascript.IMoverJS;
import interfaces.interacoes.web.javascript.IObterJS;
import interfaces.interacoes.web.javascript.IRolarJS;

/**
 * @author Paulo Lobo Neto
 * @Descricao Classe responsável por conter comandos que executam interações com
 *            a página da web. Os métodos contidos na classe são todos públicos
 *            e para utilizá-la, é necessário passar o WebDriver como parâmetro
 */
public class InteracaoSeleniumJavaWeb implements IAlert, IAcoesBrowser, IArrastar, IClique, ICliqueJS, ICombo,
		IEscrever, IEscreverJS, IEspera, IFrame, ILimpar, IMover, IMoverJS, IObter, IObterJS, IProcurar, IRolarJS,
		IEncontraTipoElementoWeb, IValidacoesWeb {

	public static String nomePlataformaDeExecucao;

	public InteracaoSeleniumJavaWeb(WebDriver webDriver) {

	}
}