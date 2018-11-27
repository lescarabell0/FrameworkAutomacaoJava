package driver.web;

import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import enums.EnumDrivers;
import interacoes.web.InteracaoSeleniumJavaWeb;

/**
 * @author Paulo Lobo Neto
 * @Descricao Classe responsável pela manipulação do driver.
 */
public class DriverWeb {

	private static WebDriver driver;
	private static String browserSetadoViaPrompt = System.getProperties().getProperty("browser");
	private static String browserSemInterface = System.getProperties().getProperty("headless");
	private static FirefoxOptions firefoxOptions = new FirefoxOptions();
	private static ChromeOptions chromeOptions = new ChromeOptions();
	private static InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
	private static String nomeDriver = null;
	private static String sistemaOperacional = System.getProperty("os.name").toLowerCase();
	private static String caminhoDriverChromeW = "src/main/resources/drivers/chromedriver.exe";
	private static String caminhoDriverFirefoxW = "src/main/resources/drivers/geckodriver.exe";
	private static String caminhoDriverExplorerW = "src/main/resources/drivers/explorer.exe";
	private static String caminhoDriverChromeL = "src/main/resources/drivers/chromedriver";
	private static String caminhoDriverFirefoxL = "src/main/resources/drivers/geckodriver";
	private static String caminhoDriverExplorerL = "src/main/resources/drivers/explorer";
	private static String navegador = EnumDrivers.CHROME.toString();
	private static boolean maximizarJanela = true;
	private static boolean executarSemInterface = false;

	/**
	 * @Descricao Método que deve ser chamado para iniciar o webdriver e todas as
	 *            suas configurações. Sempre que quiser receber o webdriver em algum
	 *            lugar, esse é o método chamado.
	 * @return retorna o driver pronto com todas as configurações realizadas.
	 */
	public static WebDriver getDriver() {
		if (driver == null) {
			setarConfiguracoesDoDriver();
		}
		return driver;
	}

	/**
	 * @Descricao Método que deve ser chamado para iniciar o webdriver e todas as
	 *            suas configurações. Sempre que quiser receber o webdriver em algum
	 *            lugar, esse é o método chamado.
	 * @return retorna o driver pronto com todas as configurações realizadas.
	 */
	public static WebDriver getDriver(EnumDrivers navegadorDeExecucao, boolean maximizarJanelaDoNavegador,
			boolean executarSemInterfaceGrafica) {
		definirPropriedadesIniciais(navegadorDeExecucao, maximizarJanelaDoNavegador, executarSemInterfaceGrafica);
		if (driver == null) {
			setarConfiguracoesDoDriver();
		}
		InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao = navegador;
		return driver;
	}

	private static void definirPropriedadesIniciais(Object navegadorDeExecucao, boolean maximizarJanelaDoNavegador,
			boolean executarSemInterfaceGrafica) {
		navegador = navegadorDeExecucao.toString();
		maximizarJanela = maximizarJanelaDoNavegador;
		executarSemInterface = executarSemInterfaceGrafica;
	}

	/**
	 * @Descricao Verifica qual o browser será executa e chama o método específico à
	 *            cada navegador. Caso nenhum navegador seja informado via "cmd"
	 */
	private static void setarConfiguracoesDoDriver() {
		if (browserSetadoViaPrompt != null) {
			navegador = browserSetadoViaPrompt;
			if (browserSetadoViaPrompt.contains("CHROME") || browserSetadoViaPrompt.contains("FIREFOX")
					|| browserSetadoViaPrompt.contains("EXPLORER")) {
				configs();
				setNomeDriver(browserSetadoViaPrompt);
			}
		} else {
			if (navegador.contains("CHROME") || navegador.contains("FIREFOX") || navegador.contains("EXPLORER")) {
				configs();
				setNomeDriver(navegador);
			}
		}
		/**
		 * A linha abaixo define que todos os comandos do webdriver terão um timeout de
		 * X segundos (Por padrão está setado como 30). Caso o comando seja realizado
		 * antes dos X segundos, ele passa para o próximo.
		 */
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * @param navegador
	 */
	private static void configs() {
		obterDriverEsetarNaPath();
		configHeadless();
		iniciarNavegador();
	}

	/**
	 * @param navegador
	 */
	private static void obterDriverEsetarNaPath() {
		if (sistemaOperacional.contains("mac")) {
			setarDriverMac();
		} else if (sistemaOperacional.contains("windows")) {
			setarDriverWindows();
		} else {
			setarDriverLinux();
		}
	}

	private static void setarDriverMac() {
		if (navegador.contains("EXPLORER")) {
			System.setProperty("webdriver.ie.driver", "");
		} else if (navegador.contains("CHROME")) {
			System.setProperty("webdriver.chrome.driver", "");
		} else if (navegador.contains("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", "");
		}
	}

	private static void setarDriverWindows() {
		if (navegador.contains("EXPLORER")) {
			System.setProperty("webdriver.ie.driver", caminhoDriverExplorerW);
		} else if (navegador.contains("CHROME")) {
			System.setProperty("webdriver.chrome.driver", caminhoDriverChromeW);
		} else if (navegador.contains("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", caminhoDriverFirefoxW);
		}
	}

	private static void setarDriverLinux() {
		if (navegador.contains("EXPLORER")) {
			System.setProperty("webdriver.ie.driver", caminhoDriverExplorerL);
		} else if (navegador.contains("CHROME")) {
			System.setProperty("webdriver.chrome.driver", caminhoDriverChromeL);
		} else if (navegador.contains("FIREFOX")) {
			System.setProperty("webdriver.gecko.driver", caminhoDriverFirefoxL);
		}
	}

	/**
	 * @param navegador
	 */
	private static void iniciarNavegador() {
		if (navegador.contains("EXPLORER")) {
			iniciarExplorer();
		} else if (navegador.contains("CHROME")) {
			iniciarChrome();
		} else if (navegador.contains("FIREFOX")) {
			iniciarFirefox();
		}
		maximizarJanela();
	}

	private static void iniciarExplorer() {
		if (internetExplorerOptions != null) {
			driver = new InternetExplorerDriver(internetExplorerOptions);
		} else {
			driver = new InternetExplorerDriver();
		}
	}

	private static void iniciarChrome() {
		if (chromeOptions != null) {
			driver = new ChromeDriver(chromeOptions);
		} else {
			driver = new ChromeDriver();
		}
	}

	private static void iniciarFirefox() {
		if (firefoxOptions != null) {
			driver = new FirefoxDriver(firefoxOptions);
		} else {
			driver = new FirefoxDriver();
		}
	
	}

	private static void maximizarJanela() {
		if (maximizarJanela) {
			driver.manage().window().maximize();
		}
	}
	/**
	 * @param navegador
	 */
	private static void configHeadless() {
		if (executarSemInterface == true || browserSemInterface == "true") {
			if (navegador.contains("FIREFOX")) {
				firefoxOptions.setHeadless(true);
			} else if (navegador.contains("CHROME")) {
				chromeOptions.setHeadless(true);
			} else if (navegador.contains("EXPLORER")) {
				fail("O navegador Internet Explorer não suporta o modo headless");
			}
		}
	}

	/**
	 * Mata o processo do driver instanciado.
	 */
	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

	public static String getNomeDriver() {
		return nomeDriver;
	}

	private static void setNomeDriver(String nomeDriver) {
		DriverWeb.nomeDriver = nomeDriver;
	}
}