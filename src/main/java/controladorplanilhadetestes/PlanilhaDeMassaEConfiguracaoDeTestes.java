package controladorplanilhadetestes;

import java.util.ArrayList;
import java.util.List;

import enums.Retorno;

public class PlanilhaDeMassaEConfiguracaoDeTestes {
	List<ModelDeDadosDaAbaUm> modelRequisicoes = new ArrayList<>();
	List<ModelDeDadosDaAbaDois> modelDados = new ArrayList<>();
	List<ModelDeDadosDaAbaTres> modelMobile = new ArrayList<>();
	List<ModelDeDadosDaAbaQuatro> modelCucumber = new ArrayList<>();
	LeitorDeDadosExcel leitor = null;
	private String caminhoDoArquivoExcel = "src\\test\\resources\\armazenador\\planilha_de_testes.xls";

	public String retornarElementoDaPlanilhaDeRequisicoes(String identificadorDoElemento, Retorno tipoDoRetorno) {
		leitor = new LeitorDeDadosExcel();
		if (validarTipoDeRetorno(tipoDoRetorno) == 0) {
			injetarDadosRecebidosDaPlanilhaNoObjetoDaAbaUm();
			return retornarDadoDaAbaUm(identificadorDoElemento, tipoDoRetorno);
		} else if (validarTipoDeRetorno(tipoDoRetorno) == 1) {
			injetarDadosRecebidosDaPlanilhaNoObjetoDaAbaDois();
			return retornarDadoDaAbaDois(identificadorDoElemento, tipoDoRetorno);
		} else if (validarTipoDeRetorno(tipoDoRetorno) == 2) {
			injetarDadosRecebidosDaPlanilhaNoObjetoDaAbaTres();
			return retornarDadoDaAbaTres(identificadorDoElemento, tipoDoRetorno);
		} else {
			injetarDadosRecebidosDaPlanilhaNoObjetoDaAbaQuatro();
			return retornarDadoDaAbaQuatro(identificadorDoElemento, tipoDoRetorno);
		}
	}

	private int validarTipoDeRetorno(Retorno tipoDoRetorno) {
		if (tipoDoRetorno == Retorno.URL || tipoDoRetorno == Retorno.CORPO || tipoDoRetorno == Retorno.STATUS) {
			return 0;
		} else if (tipoDoRetorno == Retorno.MASSA) {
			return 1;
		} else if (tipoDoRetorno == Retorno.APPWAITACTIVITY || tipoDoRetorno == Retorno.CAMINHOAPK
				|| tipoDoRetorno == Retorno.DEVICEID || tipoDoRetorno == Retorno.VERSAODOSO) {
			return 2;
		} else {
			return 3;
		}
	}

	@SuppressWarnings("unchecked")
	private void injetarDadosRecebidosDaPlanilhaNoObjetoDaAbaUm() {
		modelRequisicoes = (List<ModelDeDadosDaAbaUm>) leitor.getDadosExcel(ModelDeDadosDaAbaUm.class,
				caminhoDoArquivoExcel, 0);
	}

	private String retornarDadoDaAbaUm(String identificadorDoElemento, Retorno tipoDoRetorno) {
		return procurarElementoAbaUm(modelRequisicoes, identificadorDoElemento, tipoDoRetorno);
	}

	@SuppressWarnings("unchecked")
	private void injetarDadosRecebidosDaPlanilhaNoObjetoDaAbaDois() {
		modelDados = (List<ModelDeDadosDaAbaDois>) leitor.getDadosExcel(ModelDeDadosDaAbaDois.class,
				caminhoDoArquivoExcel, 1);
	}

	private String retornarDadoDaAbaDois(String identificadorDoElemento, Retorno tipoDoRetorno) {
		return procurarElementoAbaDois(modelDados, identificadorDoElemento, tipoDoRetorno);
	}

	@SuppressWarnings("unchecked")
	private void injetarDadosRecebidosDaPlanilhaNoObjetoDaAbaTres() {
		modelMobile = (List<ModelDeDadosDaAbaTres>) leitor.getDadosExcel(ModelDeDadosDaAbaTres.class,
				caminhoDoArquivoExcel, 2);
	}

	private String retornarDadoDaAbaTres(String identificadorDoElemento, Retorno tipoDoRetorno) {
		return procurarElementoAbaTres(modelMobile, identificadorDoElemento, tipoDoRetorno);
	}

	@SuppressWarnings("unchecked")
	private void injetarDadosRecebidosDaPlanilhaNoObjetoDaAbaQuatro() {
		modelCucumber = (List<ModelDeDadosDaAbaQuatro>) leitor.getDadosExcel(ModelDeDadosDaAbaQuatro.class,
				caminhoDoArquivoExcel, 3);
	}

	private String retornarDadoDaAbaQuatro(String identificadorDoElemento, Retorno tipoDoRetorno) {
		return procurarElementoAbaQuatro(modelCucumber, identificadorDoElemento, tipoDoRetorno);
	}

	private String procurarElementoAbaUm(List<ModelDeDadosDaAbaUm> objetoModelo, String identificadorDoElemento,
			Retorno tipoDoRetorno) {
		List<ModelDeDadosDaAbaUm> objetos = new ArrayList<>();
		objetos = objetoModelo;
		String retorno = null;

		for (ModelDeDadosDaAbaUm objeto : objetos) {
			if (objeto.identificador != null) {
				if (retorno == null) {
					if (objeto.identificador.equals(identificadorDoElemento)) {
						if (tipoDoRetorno == Retorno.CORPO) {
							if (objeto.corpo != null) {
								retorno = objeto.corpo;
							}
						} else if (tipoDoRetorno == Retorno.URL) {
							if (objeto.url != null) {
								retorno = objeto.url;
							}
						} else if (tipoDoRetorno == Retorno.STATUS) {
							if (objeto.status != null) {
								retorno = objeto.status;
							}
						}
					}
				}
			}
		}
		return retorno;
	}

	private String procurarElementoAbaDois(List<ModelDeDadosDaAbaDois> modelDados, String identificadorDoElemento,
			Retorno tipoDoRetorno) {
		List<ModelDeDadosDaAbaDois> objetos = new ArrayList<>();
		objetos = modelDados;
		String retorno = null;

		for (ModelDeDadosDaAbaDois objeto : objetos) {
			if (objeto.identificador != null && objeto.massa != null) {
				if (retorno == null) {
					if (objeto.identificador.equals(identificadorDoElemento)) {
						retorno = objeto.massa;
					}
				}
			}
		}
		return retorno;
	}

	private String procurarElementoAbaTres(List<ModelDeDadosDaAbaTres> modelDados, String identificadorDoElemento,
			Retorno tipoDoRetorno) {
		List<ModelDeDadosDaAbaTres> objetos = new ArrayList<>();
		objetos = modelDados;
		String retorno = null;

		for (ModelDeDadosDaAbaTres objeto : objetos) {
			if (objeto.identificador != null) {
				if (retorno == null) {
					if (objeto.identificador.equals(identificadorDoElemento)) {
						if (tipoDoRetorno == Retorno.APPWAITACTIVITY) {
							if (objeto.appwaitactivity != null) {
								retorno = objeto.appwaitactivity;
							}
						} else if (tipoDoRetorno == Retorno.CAMINHOAPK) {
							if (objeto.caminhoapk != null) {
								retorno = objeto.caminhoapk;
							}
						} else if (tipoDoRetorno == Retorno.DEVICEID) {
							if (objeto.versaodoandroid != null) {
								retorno = objeto.deviceid;
							}
						} else if (tipoDoRetorno == Retorno.VERSAODOSO) {
							if (objeto.versaodoandroid != null) {
								retorno = objeto.versaodoandroid;
							}
						}
					}
				}
			}
		}
		return retorno;
	}

	private String procurarElementoAbaQuatro(List<ModelDeDadosDaAbaQuatro> modelDados, String identificadorDoElemento,
			Retorno tipoDoRetorno) {
		List<ModelDeDadosDaAbaQuatro> objetos = new ArrayList<>();
		objetos = modelDados;
		String retorno = null;

		for (ModelDeDadosDaAbaQuatro objeto : objetos) {
			if (objeto.identificador != null) {
				if (retorno == null) {
					if (objeto.identificador.equals(identificadorDoElemento)) {
						if (tipoDoRetorno == Retorno.CAMINHODASFEATURES) {
							if (objeto.caminhodasfeatures != null) {
								retorno = objeto.caminhodasfeatures;
							}
						} else if (tipoDoRetorno == Retorno.CAMINHOARQUIVORELATORIOJSON) {
							if (objeto.caminhoarquivorelatoriojson != null) {
								retorno = objeto.caminhoarquivorelatoriojson;
							}
						} else if (tipoDoRetorno == Retorno.CAMINHOARQUIVORELATORIOXML) {
							if (objeto.caminhoarquivorelatorioxml != null) {
								retorno = objeto.caminhoarquivorelatorioxml;
							}
						} else if (tipoDoRetorno == Retorno.CAMINHODASFEATURESWEBMOBILE) {
							if (objeto.caminhodasfeatureswebmobile != null) {
								retorno = objeto.caminhodasfeatureswebmobile;
							}
						} else if (tipoDoRetorno == Retorno.PACOTESTEPS) {
							if (objeto.pacotesteps != null) {
								retorno = objeto.pacotesteps;
							}
						} else if (tipoDoRetorno == Retorno.QUANTIDADEDEEXECUCOESEMPARALELO) {
							if (objeto.quantidadedeexecucoesemparalelo != null) {
								retorno = objeto.quantidadedeexecucoesemparalelo;
							}
						}
					}
				}
			}
		}
		return retorno;
	}
}