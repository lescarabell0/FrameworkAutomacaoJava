package thread;

import java.util.ArrayList;
import java.util.List;

import controladorplanilhadetestes.PlanilhaDeMassaEConfiguracaoDeTestes;
import enums.Retorno;

public class ConfigurarThread {
	private List<Thread> th = new ArrayList<>();
	private ConfiguracoesCucumber configuracoesCucumber = new ConfiguracoesCucumber();

	// -------------------------------------------------------------------//
	private PlanilhaDeMassaEConfiguracaoDeTestes planilha = null;
	private String pluginReportJunit = null;// arquivoDeConfiguracao.getCaminhoXMLJunit();
	private String pluginReportJsonCucumber = null;// arquivoDeConfiguracao.getCaminhoJsonCucumber();
	private String caminhoDasFeatures = null;// arquivoDeConfiguracao.getCaminhoDasFeatures();
	private String pacoteSteps = null;// arquivoDeConfiguracao.getPacoteSteps();
	private int quantidadeDeExecucoes = 1;// arquivoDeConfiguracao.getQuantidadeDeExecucoes();
	// ------------------------------------------------------------------//

	/**
	 * @param identificadorConfiguracaoCucumberPlanilhaDeTestes
	 */
	public ConfigurarThread(String identificadorConfiguracaoCucumberPlanilhaDeTestes) {
		planilha = new PlanilhaDeMassaEConfiguracaoDeTestes();
		pacoteSteps = planilha.retornarElementoDaPlanilhaDeRequisicoes(identificadorConfiguracaoCucumberPlanilhaDeTestes, Retorno.PACOTESTEPS);
		caminhoDasFeatures = planilha.retornarElementoDaPlanilhaDeRequisicoes(identificadorConfiguracaoCucumberPlanilhaDeTestes, Retorno.CAMINHODASFEATURES);
		pluginReportJunit = planilha.retornarElementoDaPlanilhaDeRequisicoes(identificadorConfiguracaoCucumberPlanilhaDeTestes, Retorno.CAMINHOARQUIVORELATORIOXML);
		pluginReportJsonCucumber = planilha.retornarElementoDaPlanilhaDeRequisicoes(identificadorConfiguracaoCucumberPlanilhaDeTestes, Retorno.CAMINHOARQUIVORELATORIOJSON);
		quantidadeDeExecucoes = Integer.parseInt(planilha.retornarElementoDaPlanilhaDeRequisicoes(identificadorConfiguracaoCucumberPlanilhaDeTestes, Retorno.QUANTIDADEDEEXECUCOESEMPARALELO));
	}

	/**
	 * @param tags
	 * @throws InterruptedException
	 */
	public void setarConfiguracoes(List<String> tags) throws InterruptedException {
		executor(pluginReportJunit, pluginReportJsonCucumber, tags, caminhoDasFeatures, pacoteSteps, quantidadeDeExecucoes);
	}

	private void executor(String pluginReportJunit, String pluginReportJsonCucumber, List<String> tags,
			String caminhoDasFeatures, String pacoteSteps, int quantidadeDeExecucoes) throws InterruptedException {
		addThread(pluginReportJunit, pluginReportJsonCucumber, tags, caminhoDasFeatures, pacoteSteps, quantidadeDeExecucoes);
		iniciarThread();
	}

	private void iniciarThread() throws InterruptedException {
		Thread a = null;
		for (Thread t : th) {
			a = t;
			t.start();
		}
		while (a.isAlive()) {

		}
	}

	private void addThread(String pluginReportJunit, String pluginReportJsonCucumber, List<String> tags,
			String caminhoDasFeatures, String pacoteSteps, int quantidadeDeExecucoes) {
		for (int i = 1; i <= quantidadeDeExecucoes; i++) {
			th.add(new Thread() {
				public void run() {
					configuracoesCucumber.configurarOpcoes(pluginReportJunit, pluginReportJsonCucumber, tags,
							caminhoDasFeatures, pacoteSteps);
				}
			});
		}
	}
}
