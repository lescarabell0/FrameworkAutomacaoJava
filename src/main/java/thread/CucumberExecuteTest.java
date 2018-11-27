package thread;

import org.junit.runner.RunWith;

import annotations.ExtendedCucumberRunner;
import annotations.RodarAntesDosTestes;
import annotations.RodarDepoisDosTestes;
import cucumber.api.CucumberOptions;
import driver.mobile.DriverMobile;
import driver.web.DriverWeb;

/**
 * @version = 1.3
 * @author Paulo Lobo Neto
 * @CucumberExecuteTest = Classe principal, responsavel pelo gerenciamento e
 *                      execucao dos testes.
 * @RunWith = Quando uma classe e anotada com RunWith, JUnit invocara a classe
 *          referenciada para executar os testes.
 * @Features = caminho dos arquivos ".features".
 * @Glue = Caminho das classes de definicao dos passos (steps). Obs.: se nao for
 *       especificado a pasta, ele procura em toda a estrutura.
 * @DryRun = Se "true", verifica se todos os passos definidos nas features estao
 *         implementados.
 * @Strict = Se "true", falha a execucao dos testes caso tenha passos
 *         indefinidos ou pendentes.
 * @Plugin = Define os diversos relatorios que serao gerados.
 * @Tags = manipular tags dos ".features". Exemplo para rodar uma tag
 *       especifica: tags = {"@tag"}. Mais de uma tag: tags = {"@tag1","@tag2"}.
 *       Nao rodar uma tag especifica: tags ={"~@tag"}
 */
@RunWith(ExtendedCucumberRunner.class)
@CucumberOptions(features = "src/test/resources/features", plugin = {
		"json:src/test/resources/relatorios/cucumber-report/Resultado.json",
		"rerun:src/test/resources/relatorios/falhas/rerun.txt" }, glue = { "stespweb" }, monochrome = true, dryRun = false, strict = false)
/**
 * @Importante Por padrao do JUnit, o nome da classe "main" DEVE ser finalizada
 *             com a palavra "Test". e um padrao do JUnit + Cucumber e deve ser
 *             seguido.
 */
public class CucumberExecuteTest {

	/**
	 * @Descricao Metodo que inicializa qualquer configuracao antes do inicio dos
	 *            testes.
	 */
	@RodarAntesDosTestes
	public void metodoInicial() {

	}

	/**
	 * @Descricao Metodo que sera executado apos a finalizacao de todo o processo de
	 *            testes
	 */
	@RodarDepoisDosTestes
	public void metodoFinal() {
		DriverWeb.killDriver();
		DriverMobile.killDriver();
	}
}