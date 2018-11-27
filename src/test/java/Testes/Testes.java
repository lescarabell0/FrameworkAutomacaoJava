package Testes;

import org.junit.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import controladorplanilhadetestes.PlanilhaDeMassaEConfiguracaoDeTestes;
import enums.Retorno;
import interfaces.api.Requisicao;
import interfaces.log.Log;
import interfaces.log.LogGet;

public class Testes implements Requisicao, Log{

	@Test
	public void testes_planilha() {
		PlanilhaDeMassaEConfiguracaoDeTestes planilha = new PlanilhaDeMassaEConfiguracaoDeTestes();
		System.out.println(planilha.retornarElementoDaPlanilhaDeRequisicoes("CONFIGURACAO1", Retorno.PACOTESTEPS));
		System.out.println(planilha.retornarElementoDaPlanilhaDeRequisicoes("CONFIGURACAO1", Retorno.CAMINHODASFEATURES));
		System.out.println(planilha.retornarElementoDaPlanilhaDeRequisicoes("CONFIGURACAO1", Retorno.CAMINHOARQUIVORELATORIOXML));
		System.out.println(planilha.retornarElementoDaPlanilhaDeRequisicoes("CONFIGURACAO1", Retorno.CAMINHOARQUIVORELATORIOJSON));
		System.out.println(planilha.retornarElementoDaPlanilhaDeRequisicoes("CONFIGURACAO1", Retorno.CAMINHODASFEATURESWEBMOBILE));
		System.out.println(planilha.retornarElementoDaPlanilhaDeRequisicoes("CONFIGURACAO1", Retorno.QUANTIDADEDEEXECUCOESEMPARALELO));
		
		
		
		System.out.println(planilha.retornarElementoDaPlanilhaDeRequisicoes("APARELHO1", Retorno.APPWAITACTIVITY));
		System.out.println(planilha.retornarElementoDaPlanilhaDeRequisicoes("APARELHO1", Retorno.CAMINHOAPK));
		System.out.println(planilha.retornarElementoDaPlanilhaDeRequisicoes("APARELHO1", Retorno.DEVICEID));
		System.out.println(planilha.retornarElementoDaPlanilhaDeRequisicoes("APARELHO1", Retorno.VERSAODOSO));
	}
	
	@Test
	public void testes_log_api() {
		Response r = get("https://google.com", "", ContentType.ANY);
		LogGet.logGet("a", "adfdafasdf", r.getBody().asString());
		
	}
}
