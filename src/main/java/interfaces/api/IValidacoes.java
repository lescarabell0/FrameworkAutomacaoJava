package interfaces.api;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public interface IValidacoes {
	/**
	 * @Descricao verifica o tempo de resposta da requisicao
	 * @param response
	 * @param unidadeDeTempo
	 * @return tempo de resposta
	 */
	default long verificarTempoDeRequisicaoEresposta(Response resposta, TimeUnit unidadeDeTempo) {
		return resposta.getTimeIn(unidadeDeTempo);
	}

	/**
	 * @Descricao valida a estrutura do Json
	 * @param resposta
	 */
	default void validarEstruturaJson(String jsonAsString) {
		try {
			new JSONObject(jsonAsString);
		} catch (JSONException ex) {
			try {
				new JSONArray(jsonAsString);
			} catch (JSONException ex1) {
				fail();
			}
		}
	}

	/**
	 * @Descricao validar itens do corpo da requisicao
	 * @param response
	 * @param listaItens
	 */
	default void validarItensBody(Response response, Map<String, String> listaItens) {
		for (String chave : listaItens.keySet()) {
			response.then().assertThat().body(chave, equalTo(listaItens.get(chave)));
		}
	}

	/**
	 * @Descricao validar item do corpo da requisicao
	 * @param response
	 * @param item
	 * @param valor
	 */
	default void validarItemBody(Response response, String item, String valor) {
		response.then().assertThat().body(item, equalTo(valor));
	}

	/**
	 * @param xml
	 */
	default void validarEstruturaXml(String xml) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder;
		try {
			builder = factory.newDocumentBuilder();
			builder.parse(new InputSource(new StringReader(xml)));
		} catch (Exception e) {
			fail();
		}
	}

	/**
	 * @Descricao validar codigo de status
	 * @param response
	 * @param statusDesejado
	 */
	default void validarStatusCode(Response response, int statusDesejado) {
		if (response.getStatusCode() == statusDesejado) {

		} else {
			fail();
		}
	}

	/**
	 * @Descricao validar a linha de status
	 * @param response
	 * @param statusLineDesejado
	 */
	default void validarStatusLine(Response response, String statusLineDesejado) {
		Assert.assertEquals(response.statusLine(), statusLineDesejado);
	}

	/**
	 * @Descricao validar tipo do conteudo. Ex.: ContentType.XML ou ContentType.JSON
	 * @param response
	 * @param contentType
	 */
	default void validarContentType(Response response, ContentType contentType) {
		Assert.assertEquals(response.getContentType(), contentType);
	}

	/**
	 * @Descricao validar o valor do cookie
	 * @param response
	 * @param nomeCookie
	 * @param valorDoCookie
	 */
	default void validarValorDoCookie(Response response, String nomeCookie, String valorDoCookie) {
		if (response.getCookie(nomeCookie).contains(valorDoCookie)) {

		} else {
			fail();
		}
	}
	
	/**
	 * @param chave
	 * @param valor
	 * @param json
	 */
	default void validarValorDeElementoJsonPorChave(String chave, String valor, String json) {
		JSONObject jsonObject = new JSONObject(json);
		String valorCampo = jsonObject.getString(chave);
		if(valorCampo.equals("valor")) {
			
		}else {
			fail();
		}
	}
	
	/**
	 * @param tagNameDoElemento
	 * @param valor
	 * @param xml
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	default void validarValorDeElementoXmlPorTagGenerica(String tagNameDoElemento, String valor, String xml)
			throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		int numeroDeVezesEncontrado = 0;
		dbf.setNamespaceAware(false);
		DocumentBuilder docBuilder = dbf.newDocumentBuilder();
		Document doc = docBuilder.parse(new InputSource(new StringReader(xml)));
		NodeList dadosNodeList = doc.getElementsByTagNameNS("*", tagNameDoElemento);
		for (int i = 0; i < dadosNodeList.getLength(); i++) {
			if (dadosNodeList.item(i).getTextContent().equals(valor)) {
				numeroDeVezesEncontrado = numeroDeVezesEncontrado + 1;
			}
		}
		if(numeroDeVezesEncontrado != 0) {
			
		}else {
			fail();
		}
	}
	
	default boolean validarSeFoiInformadoJsonOuXml(ContentType contentType, String xmlOuJson) {
		boolean retorno = false;
		if (contentType != ContentType.ANY && !xmlOuJson.isEmpty()) {
			if (ContentType.JSON == contentType) {
				validarEstruturaJson(xmlOuJson);
				retorno = true;
			} else if (ContentType.XML == contentType) {
				validarEstruturaXml(xmlOuJson);
				retorno = true;
			}
		}
		return retorno;
	}
}