package interfaces.api;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public interface IUtils {
	/**
	 * @Descricao transformar estrutura map em estrutura json
	 * @param parametros
	 * @return
	 */
	default JSONObject transformarMapEmJson(Map<String, ?> parametros) {
		JSONObject requestParams = new JSONObject();
		for (String mapParam : parametros.keySet()) {
			requestParams.put(mapParam, parametros.get(mapParam));
		}
		return requestParams;
	}

	/**
	 * @param tagNameDoElemento
	 * @param xml
	 * @return
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	default List<String> obterValorDeElementoXmlPorTagEspecifica(String tagNameDoElemento, String xml)
			{
		List<String> valorElemento = new ArrayList<>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(false);
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Document doc = null;
		try {
			doc = docBuilder.parse(new InputSource(new StringReader(xml)));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NodeList dadosNodeList = doc.getElementsByTagName(tagNameDoElemento);
		for (int i = 0; i < dadosNodeList.getLength(); i++) {
			valorElemento.add(dadosNodeList.item(i).getTextContent());
		}
		return valorElemento;
	}
	
	
	/**
	 * @param tagNameDoElemento
	 * @param xml
	 * @return
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParserConfigurationException
	 */
	default List<String> obterValorDeElementoXmlPorTagGenerica(String tagNameDoElemento, String xml)
			{
		List<String> valorElemento = new ArrayList<>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		dbf.setNamespaceAware(true);
		DocumentBuilder docBuilder = null;
		try {
			docBuilder = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Document doc = null;
		try {
			doc = docBuilder.parse(new InputSource(new StringReader(xml)));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		NodeList dadosNodeList = doc.getElementsByTagNameNS("*", tagNameDoElemento);
		for (int i = 0; i < dadosNodeList.getLength(); i++) {
			valorElemento.add(dadosNodeList.item(i).getTextContent());
		}
		return valorElemento;
	}

	/**
	 * @param chave
	 * @param json
	 * @return
	 */
	default String obterValorDeElementoJsonPorChave(String chave, String json) {
		JSONObject jsonObject = new JSONObject(json);
		String valorCampo = jsonObject.getString(chave);
		return valorCampo;
	}
}