package interfaces.interacoes.web.java;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.imageio.ImageIO;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.Actions;

import driver.web.DriverWeb;
import interacoes.mobile.InteracaoSeleniumJavaMobileAndroid;
import interacoes.web.InteracaoSeleniumJavaWeb;

public interface IValidacoesWeb extends IEncontraTipoElementoWeb, IObter {
	Log logger = LogFactory.getLog(InteracaoSeleniumJavaMobileAndroid.class);
	Actions action = new Actions(DriverWeb.getDriver());

	default void validarMensagem(String textoOriginal, By elemento) {
		try {
			String textoDeComparacao = obterTexto(elemento);

			if (textoOriginal.equals(textoDeComparacao)) {
				System.out.println("Teste realizado com sucesso.");
			} else {
				Assert.fail();
			}
		} catch (Exception e) {
			Assert.fail();
			System.out.println(e);
		}
	}

	default void validarSeElementoEstaVisivel(By elemento) {
		assertEquals(true, DriverWeb.getDriver().findElement(elemento).isDisplayed());
	}

	default void validarSeElementoEstaHabilitado(By elemento) {
		assertEquals(true, DriverWeb.getDriver().findElement(elemento).isEnabled());
	}

	/**
	 * @Descricao Valida título da aba do browser
	 * @param tituloDaAba
	 */
	default void validarTituloDoBrowser(String tituloDaAba) {
		assertEquals(tituloDaAba, DriverWeb.getDriver().getTitle());
	}

	/**
	 * @Descricao Valida a URL atual
	 * @param URL
	 * 
	 */
	default void validarUrlAtual(String url) {
		assertEquals(url, DriverWeb.getDriver().getCurrentUrl());
	}

	/**
	 * @Descricao Verificar se o Radio Button está selecionado
	 * @param elemento
	 * @return boolean
	 */
	default boolean validarSeElementoEstaSelecionado(By elemento) {
		boolean retorno = false;
		try {
			logger.info(" -- Realizar acao de verificar se radio do elemento: " + elemento + " esta marcado.");
			retorno = DriverWeb.getDriver().findElement(elemento).isSelected();
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. NAO foi possivel localizar o elemento: '"
					+ elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. Tempo excedido para encontrar elemento: '"
					+ elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.Elemento: '" + elemento
					+ "NAO visivel' em tela.");
		}
		return retorno;
	}

	/**
	 * @Descricao Verificar se o check box está marcado
	 * @param elemento
	 * @return boolean
	 */
	default boolean validarSeOcheckBoxEstaMarcado(By elemento) {
		boolean retorno = false;
		try {
			retorno = DriverWeb.getDriver().findElement(elemento).isSelected();
		} catch (NoSuchElementException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO encontrado na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. NAO foi possivel localizar o elemento: '"
					+ elemento + "' em tela.");
		} catch (TimeoutException e) {
			logger.warn(" -- Tempo excedido para encontrar elemento: '" + elemento + "' na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. Tempo excedido para encontrar elemento: '"
					+ elemento + "' em tela.");
		} catch (ElementNotVisibleException e) {
			logger.warn(" -- Elemento: '" + elemento + "' NAO esta visivel na plataforma: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.Elemento: '" + elemento
					+ "NAO visivel' em tela.");
		}
		return retorno;
	}

	/**
	 * O método valida a quantidade de caracteres no campo do tipo CPF.
	 * 
	 * @author leonardoananias
	 * @param elemento
	 */
	default void validarQtdCaracteresCampoCpfComMascara(By elemento) {
		try {
			logger.info(" -- Realizar a validação da quantidade de caracteres do campo CPF: ");
			String qtdCpf = obterTexto(elemento);
			if (qtdCpf.length() > 14 || qtdCpf.length() != 14) {
				Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
						+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
						+ "'. O campo possui a quantidade de caracteres mais que o permitido.'");
			}
		} catch (NullPointerException e) {
			logger.warn(" -- Elemento: '" + elemento + "' está nulo: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. : 'o elemento encontra-se nulo");
		}
	}

	/**
	 * O método valida a quantidade de caracteres no campo do tipo cpf.
	 * 
	 * @author leonardoananias
	 * @param elemento
	 */
	default void validarQtdCaracteresCampoCpfSemMascara(By elemento) {
		try {
			logger.info(" -- Realizar a validação da quantidade de caracteres do campo CPF: ");
			String qtdCpf = obterTexto(elemento);
			if (qtdCpf.length() > 11 || qtdCpf.length() != 11) {
				Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
						+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
						+ "'. O campo possui a quantidade de caracteres mais que o permitido.'");
			}
		} catch (NullPointerException e) {
			logger.warn(" -- Elemento: '" + elemento + "' está nulo: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. : 'o elemento encontra-se nulo");
		}
	}

	/**
	 * O método valida a quantidade de caracteres no campo do tipo Cnpj.
	 * 
	 * @author leonardoananias
	 * @param elemento
	 */
	default void validarQtdCaracteresCampoCnpjComMascara(By elemento) {
		try {
			logger.info(" -- Realizar a validação da quantidade de caracteres do campo CNPJ: ");
			String qtdCnpj = obterTexto(elemento);
			if (qtdCnpj.length() > 14 || qtdCnpj.length() != 14) {
				Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
						+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
						+ "'. O campo possui a quantidade de caracteres mais que o permitido.'");
			}
		} catch (NullPointerException e) {
			logger.warn(" -- Elemento: '" + elemento + "' está nulo: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. : 'o elemento encontra-se nulo");
		}
	}

	/**
	 * O método valida a quantidade de caracteres no campo.
	 * 
	 * @author leonardoananias
	 * @param elemento
	 */
	default void validarQtdCaracteresCampoCnpjSemMascara(By elemento) {
		try {
			logger.info(" -- Realizar a validação da quantidade de caracteres do campo CNPJ: ");
			String qtdCnpj = obterTexto(elemento);
			if (qtdCnpj.length() > 11 || qtdCnpj.length() != 11) {
				Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
						+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
						+ "'. O campo possui a quantidade de caracteres mais que o permitido.'");
			}
		} catch (NullPointerException e) {
			logger.warn(" -- Elemento: '" + elemento + "' está nulo: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. : 'o elemento encontra-se nulo");
		}
	}

	/**
	 * O método deve validar se o campo cpf possui letra.
	 * 
	 * @author leonardoananias
	 * @param elemento
	 */
	default void validarCaracteresCampoCpf(By elemento) {
		try {
			logger.info(" -- Realizar a validação no campo cpf caso possuir letras: ");
			String cpf = obterTexto(elemento);
			for (int i = 0; i < cpf.length(); i++) {
				if (Character.isLetter(cpf.charAt(i))) {
					Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
							+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. O campo possui letras.'");
				}
			}
		} catch (NullPointerException e) {
			logger.warn(" -- Elemento: '" + elemento + "' está nulo: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. : 'o elemento encontra-se nulo");
		}
	}

	/**
	 * O método deve validar se o campo cnpj possui letra.
	 * 
	 * @author leonardoananias
	 * @param elemento
	 */
	default void validarCaracteresCampoCnpj(By elemento) {
		try {
			logger.info(" -- Realizar a validação no campo cnpj caso possuir letras: ");
			String cnpj = obterTexto(elemento);
			for (int i = 0; i < cnpj.length(); i++) {
				if (Character.isLetter(cnpj.charAt(i))) {
					Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
							+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. O campo possui letras.'");
				}
			}
		} catch (NullPointerException e) {
			logger.warn(" -- Elemento: '" + elemento + "' está nulo: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'. : 'o elemento encontra-se nulo");
		}
	}

	/**
	 * O método valida se o campo possui a formatação de data correta DD/MM/YYYY
	 * 
	 * @author leonardoananias
	 * @param elemento
	 * @return valida se a data está correta
	 */
	default String validarCampoData(By elemento) {
		String data = null;
		try {
			logger.info(" -- Realizar a validação do campo do tipo data :");
			String dataCampo = obterTexto(elemento);
			SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
			format.setLenient(false);
			data = format.parse(dataCampo).toString();
		} catch (ParseException e) {
			logger.warn(" -- Elemento: '" + elemento + "' não foi possível realizar a conversão: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'conversão com a data informada'" + data);
		} catch (NullPointerException | IllegalArgumentException e) {
			logger.warn(" -- Elemento: '" + elemento + "' está nulo ou recebeu um argumento inválido : '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + ".");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'o elemento obtido está nulo ou recebeu um argumento inválido.'");
		}
		return data;
	}

	/**
	 * O método tem como objetivo obter a cor de um elemento com base no atributo
	 * color do css
	 * 
	 * @author leonardoananias
	 * @param elemento informar o elemento a ser pesquisado
	 * @param tipoCor  informar se o tipo é RGB ou RGBA
	 * @return retorna uma string em formato hexadecimal
	 */
	default String retornaCorDoElementoCssColor(By elemento, String tipoCor) {
		String hex = null;
		try {
			logger.info(" -- Realizar acao de retornar a cor do elemento: " + elemento + ".");
			String corRgb = DriverWeb.getDriver().findElement(elemento).getCssValue("color");
			String[] numbers = corRgb.replace("" + tipoCor + "(", "").replace(")", "").split(",");
			int r = Integer.parseInt(numbers[0].trim());
			int g = Integer.parseInt(numbers[1].trim());
			int b = Integer.parseInt(numbers[2].trim());
			hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
		} catch (NullPointerException | NumberFormatException e) {
			logger.warn(" -- Elemento: '" + elemento + "' está nulo ou recebeu um formato inválido : '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'o elemento obtido está nulo ou recebeu um formato inválido.'");
		}
		return hex;
	}

	/**
	 * O método tem como objetivo obter a cor de um elemento com base no atributo
	 * background do css
	 * 
	 * @author leonardoananias
	 * @param elemento informar o elemento a ser pesquisado
	 * @param tipoCor  informar se o tipo é RGB ou RGBA
	 * @return retorna uma string em formato hexadecimal
	 */
	default String retornaCorDoElementoCssBackground(By elemento, String tipoCor) {
		String hex = null;
		try {
			logger.info(" -- Realizar acao de verificar se radio do elemento: " + elemento + " esta marcado.");
			String corRgb = DriverWeb.getDriver().findElement(elemento).getCssValue("background");
			String[] numeros = corRgb.replace("" + tipoCor + "(", "").replace(")", "").split(",");
			int r = Integer.parseInt(numeros[0].trim());
			int g = Integer.parseInt(numeros[1].trim());
			int b = Integer.parseInt(removeLetrasDoRgb(numeros[2]).trim());
			hex = "#" + Integer.toHexString(r) + Integer.toHexString(g) + Integer.toHexString(b);
		} catch (NullPointerException | NumberFormatException e) {
			logger.warn(" -- Elemento: '" + elemento + "' está nulo ou recebeu um formato inválido : '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'o elemento obtido está nulo ou recebeu um formato inválido.'");
		}
		return hex;
	}

	/**
	 * O método retorna a cor de uma imagem passando por parametros as coordenadas e
	 * o local que se encontra a imagem
	 * 
	 * @param imagemPath local onde está salva a imagem
	 * @param width      informar a largura do pixel para obter a cor
	 * @param height     informar a altura do pixel para obter a cor
	 * @return string com a cor em rgb
	 */
	default String obterCorDaImagem(File imagemPath, int width, int height) {
		String corRgb = null;
		try {
			logger.info(" -- Realizar a ação de obter a cor com base na imagem informada.");
			BufferedImage imagem = ImageIO.read(imagemPath);
			int dataColor = imagem.getRGB(width, height);
			Color c = new Color(dataColor);
			int r = c.getRed();
			int g = c.getGreen();
			int b = c.getBlue();
			corRgb = "Rgb(" + transformarInteiroEmString(r) + ", " + transformarInteiroEmString(g) + ", "
					+ transformarInteiroEmString(b) + ")";
		} catch (IOException e) {
			logger.warn(" -- O arquivo: '" + imagemPath + "'não foi possível processar : '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'Não foi possivel processar a imagem na pasta especifica.'");
		} catch (IllegalArgumentException e) {
			logger.warn(" -- A imagem: '" + imagemPath + "' está com formato inválido : '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'A imagem obtida recebeu um formato inválido.'");
		} catch (NullPointerException e) {
			logger.warn(" -- O arquivo: '" + imagemPath + "'está nulo : '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'A imagem não encontra-se na pasta especifica'");
		}
		return corRgb;
	}

	/**
	 * O método obtem uma variavel do tipo string e remove letras da mesma.
	 * 
	 * @author leonardoananias
	 * @param numeroRgb recebe a string do rgb que deve ser retirado as letras
	 *                  complementares
	 * @return retorna o rgb correto
	 */
	static String removeLetrasDoRgb(String numeroRgb) {
		StringBuilder resultado = new StringBuilder();
		try {
			logger.info(" -- Realiza a verificação do elemento removendo letras -- ");
			String rgb = numeroRgb.substring(0, 3);
			for (int i = 0; i < rgb.length(); i++) {
				if (!Character.isLetter(rgb.charAt(i))) {
					char c = rgb.charAt(i);
					resultado.append(c);
				}
			}
		} catch (NullPointerException | IndexOutOfBoundsException e) {
			logger.warn("o elemento obtido está nulo ou recebeu um index inválido : '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao + "'.");
			Assert.fail(LocalDateTime.now() + " -- Teste falhado com o: '"
					+ InteracaoSeleniumJavaWeb.nomePlataformaDeExecucao
					+ "'o elemento obtido está nulo ou recebeu um index inválido.'");
		}
		return resultado.toString();
	}

	static String transformarInteiroEmString(int numero) {
		logger.info(" -- Realiza a transformação do inteiro para string -- ");
		String texto = Integer.toString(numero);
		return texto;
	}

}
