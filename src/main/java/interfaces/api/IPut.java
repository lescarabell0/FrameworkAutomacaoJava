package interfaces.api;

import static com.jayway.restassured.RestAssured.given;

import java.util.Map;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public interface IPut extends IValidacoes {

	/**
	 * @param url
	 * @param xmlOuJson
	 * @param contentType
	 * @return
	 */
	default Response put(String url, String xmlOuJson, ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().contentType(contentType).body(xmlOuJson).when().put(url).then().extract().response();
		} else {
			resposta = given().contentType(contentType).when().put(url).then().extract().response();
		}
		return resposta;
	}

	/**
	 * @param url
	 * @param parametersMap
	 * @param xmlOuJson
	 * @param contentType
	 * @return
	 */
	default Response putComParametroNaUrl(String url, Map<String, ?> parametersMap, String xmlOuJson,
			ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().contentType(contentType).params(parametersMap).body(xmlOuJson).when().put(url).then()
					.extract().response();
		} else {
			resposta = given().contentType(contentType).params(parametersMap).when().put(url).then().extract()
					.response();
		}
		return resposta;

	}

	/**
	 * @param url
	 * @param pathParametersMap
	 * @param xmlOuJson
	 * @param contentType
	 * @return
	 */
	default Response putComPathParam(String url, Map<String, ?> pathParametersMap, String xmlOuJson,
			ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().contentType(contentType).pathParams(pathParametersMap).body(xmlOuJson).when().put(url)
					.then().extract().response();
		} else {
			resposta = given().contentType(contentType).pathParams(pathParametersMap).when().put(url).then().extract()
					.response();
		}
		return resposta;
	}

	/**
	 * @param url
	 * @param parametros
	 * @param parametroUmDeAutenticacaoNoCabecalho
	 * @param parametroDoisDeAutenticacaoNoCabecalho
	 * @param xmlOuJson
	 * @param contentType
	 * @return
	 */
	default Response putComParametroNaUrlEAutenticacaoNoCabecalho(String url, Map<String, ?> parametros,
			String parametroUmDeAutenticacaoNoCabecalho, String parametroDoisDeAutenticacaoNoCabecalho,
			String xmlOuJson, ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).params(parametros).body(xmlOuJson).when().put(url).then().extract()
					.response();
		} else {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).params(parametros).when().put(url).then().extract().response();
		}
		return resposta;
	}

	// EXAMPLE. http://ergast.com/api/f1/{raceSeason}/circuits.json
	/**
	 * @param url
	 * @param pathParams
	 * @param parametroUmDeAutenticacaoNoCabecalho
	 * @param parametroDoisDeAutenticacaoNoCabecalho
	 * @param xmlOuJson
	 * @param contentType
	 * @return
	 */
	default Response putComPathParamEAutenticacaoNoCabecalho(String url, Map<String, ?> pathParams,
			String parametroUmDeAutenticacaoNoCabecalho, String parametroDoisDeAutenticacaoNoCabecalho,
			String xmlOuJson, ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).pathParams(pathParams).body(xmlOuJson).when().put(url).then().extract()
					.response();
		} else {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).pathParams(pathParams).when().put(url).then().extract().response();
		}
		return resposta;
	}

	/**
	 * @param url
	 * @param parametroUmDeAutenticacaoNoCabecalho
	 * @param parametroDoisDeAutenticacaoNoCabecalho
	 * @param xmlOuJson
	 * @param contentType
	 * @return
	 */
	default Response putComAutenticacaoNoCabecalho(String url, String parametroUmDeAutenticacaoNoCabecalho,
			String parametroDoisDeAutenticacaoNoCabecalho, String xmlOuJson, ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).body(xmlOuJson).when().put(url).then().extract().response();
		} else {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).when().put(url).then().extract().response();
		}
		return resposta;
	}

	/**
	 * @param url
	 * @param pathParams
	 * @param params
	 * @param xmlOuJson
	 * @param contentType
	 * @return
	 */
	default Response putComPathParamEParametroNaUrl(String url, Map<String, ?> pathParams, Map<String, ?> params,
			String xmlOuJson, ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().contentType(contentType).pathParams(pathParams).params(params).body(xmlOuJson).when()
					.put(url).then().extract().response();
		} else {
			resposta = given().contentType(contentType).pathParams(pathParams).params(params).when().put(url).then()
					.extract().response();
		}
		return resposta;
	}

	/**
	 * @param url
	 * @param pathParams
	 * @param params
	 * @param parametroUmDeAutenticacaoNoCabecalho
	 * @param parametroDoisDeAutenticacaoNoCabecalho
	 * @param xmlOuJson
	 * @param contentType
	 * @return
	 */
	default Response putComPathParamAutenticacaoNoCabecalhoEParametroNaUrl(String url, Map<String, ?> pathParams,
			Map<String, ?> params, String parametroUmDeAutenticacaoNoCabecalho,
			String parametroDoisDeAutenticacaoNoCabecalho, String xmlOuJson, ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).pathParams(pathParams).params(params).body(xmlOuJson).when().put(url)
					.then().extract().response();
		} else {

			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).pathParams(pathParams).params(params).when().put(url).then().extract()
					.response();
		}
		return resposta;
	}
}