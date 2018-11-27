package geradordeevidenciaword;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import controladorplanilhadetestes.PlanilhaDeMassaEConfiguracaoDeTestes;
import enums.Retorno;
import geradordeevidenciaword.EscreverNoDocumento;
import geradordeevidenciaword.ObterFeatures;
import geradordeevidenciaword.ObterImagens;
import geradordeevidenciaword.ObterPastas;

public class DocumentoDeEvidencia {
	static ObterPastas obterPastas = new ObterPastas();
	static ObterImagens obterImagens = new ObterImagens();
	static ObterFeatures obterFeatures = new ObterFeatures();
	static List<String> pastas = new ArrayList<>();
	static Map<String, String> imagens = new HashMap<>();
	static List<String> features = new ArrayList<>();
	static PlanilhaDeMassaEConfiguracaoDeTestes busca = new PlanilhaDeMassaEConfiguracaoDeTestes();

	public void gerar_evidencias() {
		obter_massas();
		try {
			gerar_documento_word();
		} catch (InvalidFormatException | IOException | InterruptedException | AWTException e) {
			e.printStackTrace();
		}
	}

	private static void obter_massas() {
		pastas = obterPastas.obterPastas(
				busca.retornarElementoDaPlanilhaDeRequisicoes("CONFIGURACAO1", Retorno.CAMINHODASFEATURESWEBMOBILE)); // arquivoDeConfiguracao.getCaminhoOndeBuscarAsFeaturesParaORelatorio());
		features = obterFeatures.obterFeatures(pastas);
		imagens = obterImagens.obterImagens("src\\test\\resources\\relatorios\\screenshot");
	}

	private static void gerar_documento_word()
			throws InvalidFormatException, IOException, InterruptedException, AWTException {
		EscreverNoDocumento escreverNoDocumento = new EscreverNoDocumento();
		escreverNoDocumento.organizarTextoImagens(features, imagens);

	}
}
