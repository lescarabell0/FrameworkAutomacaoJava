package geradordeevidenciaword;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTJc;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STJc;

import util.Utils;


public class EscreverNoDocumento {
	private XWPFDocument document = null;
	private XWPFTable table = null;
	private XWPFParagraph paragraph = null;
	private XWPFRun run = null;
	private File filefeature = null;
	private FileOutputStream out;
	private List<XWPFRun> runs;
	private BufferedReader ler_feature;
	private BufferedReader ler_feature_pra_comparacao;
	private XWPFTableRow linhaTabela;

	public void organizarTextoImagens(List<String> lista_de_features, Map<String, String> lista_de_imagens)
			throws InvalidFormatException, IOException, InterruptedException, AWTException {

		// Inicia a grava��o no documento
		for (String feature : lista_de_features) {
			filefeature = new File(feature);
			document = obter_template_padrao(document);
			escreverPrimeiraPagina(filefeature.getName());
			organizar(feature, lista_de_imagens);
			salvar_documento_e_fechar(out, filefeature, document);
		}
	}

	private void escreverPrimeiraPagina(String feature) {
		for (XWPFParagraph p : document.getParagraphs()) {
			runs = p.getRuns();
			if (runs != null) {
				for (XWPFRun r : runs) {
					String text = r.getText(0);
					if (text != null && text.contains("funcionalidadexxx")) {
						text = text.replace("funcionalidadexxx", obter_nome_da_feature_sem_a_extensao(feature));
						r.setText(text, 0);
					}
				}
			}
		}
	}

	private void organizar(String feature, Map<String, String> lista_de_imagens)
			throws IOException, InvalidFormatException, AWTException {
		int contador_para_verificar_o_proximo_cenario = 0;
		filefeature = new File(feature);
		String linha = null;
		String linha_dois = null;
		String cenario_corrente = null;
		InputStreamReader ler = null;
		InputStreamReader ler_dois = null;
		
		ler = new InputStreamReader(new FileInputStream(filefeature), "UTF-8");
		ler_dois = new InputStreamReader(new FileInputStream(filefeature), "UTF-8");

		ler_feature = new BufferedReader(ler);
		ler_feature_pra_comparacao = new BufferedReader(ler_dois);

		// Percorre o txt. Usa dois leitores. O linha dois � pra verificar se h� um
		// pr�ximo cen�rio. Se a pr�xima linha for um segundo cen�rio, � printado as
		// imagens relativas ao cen�rio.
		// Depois do while, tbm � printado as imagens. Isso garante que ele printe as
		// imagens referentes ao �ltimo cen�rio.
		while ((linha_dois = ler_feature_pra_comparacao.readLine()) != null) {
			linha_dois = linha_dois.replace("á", "a");

			if (linha_dois.contains("Cenario")) {
				contador_para_verificar_o_proximo_cenario = contador_para_verificar_o_proximo_cenario + 1;
			}
			if (contador_para_verificar_o_proximo_cenario == 2) {

				validar_screenshots_com_cenario(cenario_corrente.toUpperCase(), lista_de_imagens);
				adicionar_break_na_pagina(document, paragraph, run);
				contador_para_verificar_o_proximo_cenario = 1;
			}
			linha = ler_feature.readLine();
			linha = linha.replace("á", "a");
			if (linha.contains("#") || linha.contains("@")) {
			} else {
				escrever(linha);
			}
			if (linha.contains("Cenario")) {
				cenario_corrente = linha;
			}
		}
		validar_screenshots_com_cenario(cenario_corrente.toUpperCase(), lista_de_imagens);
	}

	// Aqui � verificado qual print refere-se a qual cenario
	private void validar_screenshots_com_cenario(String nome_cenario, Map<String, String> lista_de_imagens)
			throws InvalidFormatException, FileNotFoundException, IOException {

		// aqui corta os caracteres: "Cen�rio :"
		nome_cenario = nome_cenario.substring(9).replace(" ", "");
		nome_cenario = nome_cenario.replace("-", "");

		for (String caminho_da_imagem : lista_de_imagens.keySet()) {

			String nome_da_imagem = lista_de_imagens.get(caminho_da_imagem).toUpperCase();

			nome_da_imagem = nome_da_imagem.substring(0, obter_posicao_do_caracter(nome_da_imagem, "."));
			nome_da_imagem = nome_da_imagem.replace(" ", "");
			nome_da_imagem = nome_da_imagem.replace("-", "");
			nome_da_imagem = validar_se_o_nome_da_imagem_possui_underline(nome_da_imagem);

			if (validar_nome_da_imagem_com_o_nome_do_cenario(nome_da_imagem, nome_cenario, caminho_da_imagem)) {
				adicionar_imagem(caminho_da_imagem);
			}
		}
	}

	private void criar_tabela_de_cenario() {
		
		document.getLastParagraph();
		criar_paragrafo(document, paragraph, run, 1);
		table = document.createTable(2, 1);
		linhaTabela = table.getRow(0);
		linhaTabela.getCell(0).setColor("b8b79f");
		linhaTabela.createCell();
		table.getCTTbl().addNewTblGrid().addNewGridCol().setW(BigInteger.valueOf(850));
		table.getCTTbl().getTblGrid().addNewGridCol().setW(BigInteger.valueOf(7690));
		alinhar_tabela(table, STJc.CENTER);
		table.setCellMargins(10, 10, 10, 10);
	}

	private void escrever(String linha) throws AWTException {
		if (!linha.contains("Funcionalidade")) {
			if (linha.contains("Cenario")) {
				criar_tabela_de_cenario();
				escrever_a_palavra_cenario_na_tabela();
				escrever_o_nome_do_cenario_na_Tabela(linha);
			} else if (!linha.matches("")) {
				adicionar_palavra_chave_do_step_na_tabela_de_cenario_na_linha_dois_da_tabela_de_cenario(linha);
				adicionar_step_na_tabela_de_cenario(linha);
			}
		}
	}

	private void escrever_a_palavra_cenario_na_tabela() {
		paragraph = table.getRow(0).getCell(0).getParagraphs().get(0);
		paragraph.setAlignment(ParagraphAlignment.LEFT);
		run = paragraph.createRun();
		run.setBold(true);
		run.setText("Cenário:");
		run.setFontFamily("Calibri");
	}

	private void escrever_o_nome_do_cenario_na_Tabela(String linha) {
		linhaTabela.getCell(1).setText(linha.substring(8, linha.length() - 1));
	}

	private void adicionar_palavra_chave_do_step_na_tabela_de_cenario_na_linha_dois_da_tabela_de_cenario(String linha) {
		paragraph = table.getRow(1).getCell(0).getParagraphs().get(0);
		paragraph.setAlignment(ParagraphAlignment.LEFT);
		paragraph.setWordWrapped(true);
		run = paragraph.createRun();
		run.setBold(true);
		run.setFontFamily("Calibri");
		run.setText(linha.substring(0, linha.indexOf(" ")));
	}

	private void adicionar_step_na_tabela_de_cenario(String linha) {
		paragraph = table.getRow(1).getCell(0).getParagraphs().get(0);
		paragraph.setAlignment(ParagraphAlignment.LEFT);
		run = paragraph.createRun();
		run.setFontFamily("Calibri");
		run.setText(linha.substring(linha.indexOf(" "), linha.length() - 1));
		run.addBreak(BreakType.TEXT_WRAPPING);
	}

	private void adicionar_imagem(String caminho_da_imagem)
			throws InvalidFormatException, FileNotFoundException, IOException {
		XWPFParagraph paragrafo = document.createParagraph();
		XWPFRun runner = paragrafo.createRun();
		paragrafo = document.createParagraph();
		paragrafo.setAlignment(ParagraphAlignment.CENTER);
		runner = paragrafo.createRun();
		

		// 1 - largura 2 - altura
		runner.addPicture(new FileInputStream(caminho_da_imagem), XWPFDocument.PICTURE_TYPE_PNG, caminho_da_imagem,
				Units.pixelToEMU(571), Units.pixelToEMU(190));
	}
	

	private XWPFDocument obter_template_padrao(XWPFDocument document) throws InvalidFormatException, FileNotFoundException, IOException {
		return new XWPFDocument(
				OPCPackage.open(new FileInputStream("src\\main\\java\\armazenador\\template.doc")));
	}

	private void salvar_documento_e_fechar(FileOutputStream out, File filefeature, XWPFDocument document) throws IOException, InterruptedException {
		Thread.sleep(1000);
		out = new FileOutputStream(new File("src\\test\\resources\\relatorios\\evidencias\\"
				+ obter_nome_da_feature_sem_a_extensao(filefeature.getName()) + Utils.escreverHoraMinutoSegundo() + ".doc"));

		// finaliza a grava��o no documento
		document.write(out);
		out.close();
		document.close();
	}

	private int obter_posicao_do_caracter(String texto, String caracter) {
		return texto.indexOf(caracter);
	}

	private void criar_paragrafo(XWPFDocument document, XWPFParagraph paragraph, XWPFRun run, int quantidade) {
		for (int i = 1; i <= quantidade; i++) {
			paragraph = document.createParagraph();
			run = paragraph.createRun();
		}
	}

	private void alinhar_tabela(XWPFTable table, STJc.Enum justification) {
		CTTblPr tblPr = table.getCTTbl().getTblPr();
		CTJc jc = (tblPr.isSetJc() ? tblPr.getJc() : tblPr.addNewJc());
		jc.setVal(justification);
	}

	private void adicionar_break_na_pagina(XWPFDocument document, XWPFParagraph paragraph, XWPFRun run) {
		paragraph = document.getLastParagraph();
		run = paragraph.createRun();
		run.addBreak(BreakType.PAGE);
		run.addCarriageReturn();
	}

	// valida se o nome da imagem possui "_". Caso possua, vai cortar at� o ponto do
	// underline.
	private String validar_se_o_nome_da_imagem_possui_underline(String nome_da_imagem) {
		if (obter_posicao_do_caracter(nome_da_imagem, "_") > 0) {
			return nome_da_imagem.substring(0, obter_posicao_do_caracter(nome_da_imagem, "_"));
		} else {
			return nome_da_imagem;
		}
	}

	// validar se o nome da imagem � igual ao nome do cen�rio
	private boolean validar_nome_da_imagem_com_o_nome_do_cenario(String nome_da_imagem, String nome_cenario,
			String caminho_da_imagem) throws InvalidFormatException, FileNotFoundException, IOException {
		// validar se o nome da imagem � igual ao nome do cen�rio
		if (nome_da_imagem.matches(nome_cenario)) {
			System.out.println(nome_da_imagem + " " + nome_cenario);
			return true;
//			adicionar_imagem(caminho_da_imagem);
		} else {
			return false;
		}
	}

	private String obter_nome_da_feature_sem_a_extensao(String nome) {
		return nome.substring(0, nome.length() - 8);
	}
}