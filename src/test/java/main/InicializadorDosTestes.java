package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import geradordeevidenciaword.DocumentoDeEvidencia;
import geradordeplanilhagherkin.PlanilhaDeTestesGherkin;
import thread.ConfigurarThread;

public class InicializadorDosTestes {

	@Test
	public void iniciar() throws InterruptedException, InvalidFormatException, IOException {
		ConfigurarThread configurarThread = new ConfigurarThread("CONFIGURACAO1");
		adicionarTags();
		configurarThread.setarConfiguracoes(adicionarTags());
		gerarEvidenciaWord(false);
		gerarPlanilhaExcelComGherkin(false);
	}

	public List<String> adicionarTags() {
		List<String> tags = new ArrayList<String>();
		tags.add("@api");
		return tags;
	}

	private void gerarEvidenciaWord(boolean gerar) {
		DocumentoDeEvidencia documentoDeEvidencia = new DocumentoDeEvidencia();
		if (gerar) {
			documentoDeEvidencia.gerar_evidencias();
		}
	}

	private void gerarPlanilhaExcelComGherkin(boolean gerar)
			throws InvalidFormatException, IOException, InterruptedException {
		PlanilhaDeTestesGherkin planilhaDeTestesGherkin = new PlanilhaDeTestesGherkin();
		if (gerar) {
			planilhaDeTestesGherkin.gerar();
		}
	}
}