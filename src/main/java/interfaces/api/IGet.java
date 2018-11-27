package interfaces.api;

import static com.jayway.restassured.RestAssured.given;

import java.util.Map;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public interface IGet extends IValidacoes {

	/**
	 * @param url
	 * @param xmlOuJson
	 * @param contentType
	 * @return
	 */
	default Response get(String url, String xmlOuJson, ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().contentType(contentType).body(xmlOuJson).when().get(url).then().extract().response();
		} else {
			resposta = given().contentType(contentType).when().get(url).then().extract().response();
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
	default Response getComParametroNaUrl(String url, Map<String, ?> parametersMap, String xmlOuJson,
			ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().contentType(contentType).params(parametersMap).body(xmlOuJson).when().get(url).then()
					.extract().response();
		} else {
			resposta = given().contentType(contentType).params(parametersMap).when().get(url).then().extract()
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
	default Response getComPathParam(String url, Map<String, ?> pathParametersMap, String xmlOuJson,
			ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().contentType(contentType).pathParams(pathParametersMap).body(xmlOuJson).when().get(url)
					.then().extract().response();
		} else {
			resposta = given().contentType(contentType).pathParams(pathParametersMap).when().get(url).then().extract()
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
	default Response getComParametroNaUrlEAutenticacaoNoCabecalho(String url, Map<String, ?> parametros,
			String parametroUmDeAutenticacaoNoCabecalho, String parametroDoisDeAutenticacaoNoCabecalho,
			String xmlOuJson, ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).params(parametros).body(xmlOuJson).when().get(url).then().extract()
					.response();
		} else {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).params(parametros).when().get(url).then().extract().response();
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
	default Response getComPathParamEAutenticacaoNoCabecalho(String url, Map<String, ?> pathParams,
			String parametroUmDeAutenticacaoNoCabecalho, String parametroDoisDeAutenticacaoNoCabecalho,
			String xmlOuJson, ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).pathParams(pathParams).body(xmlOuJson).when().get(url).then().extract()
					.response();
		} else {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).pathParams(pathParams).when().get(url).then().extract().response();
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
	default Response getComAutenticacaoNoCabecalho(String url, String parametroUmDeAutenticacaoNoCabecalho,
			String parametroDoisDeAutenticacaoNoCabecalho, String xmlOuJson, ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).body(xmlOuJson).when().get(url).then().extract().response();
		} else {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).when().get(url).then().extract().response();
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
	default Response getComPathParamEParametroNaUrl(String url, Map<String, ?> pathParams, Map<String, ?> params,
			String xmlOuJson, ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().contentType(contentType).pathParams(pathParams).params(params).body(xmlOuJson).when()
					.get(url).then().extract().response();
		} else {
			resposta = given().contentType(contentType).pathParams(pathParams).params(params).when().get(url).then()
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
	default Response getComPathParamAutenticacaoNoCabecalhoEParametroNaUrl(String url, Map<String, ?> pathParams,
			Map<String, ?> params, String parametroUmDeAutenticacaoNoCabecalho,
			String parametroDoisDeAutenticacaoNoCabecalho, String xmlOuJson, ContentType contentType) {
		Response resposta;
		if (validarSeFoiInformadoJsonOuXml(contentType, xmlOuJson)) {
			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).pathParams(pathParams).params(params).body(xmlOuJson).when().get(url)
					.then().extract().response();
		} else {

			resposta = given().header(parametroUmDeAutenticacaoNoCabecalho, parametroDoisDeAutenticacaoNoCabecalho)
					.contentType(contentType).pathParams(pathParams).params(params).when().get(url).then().extract()
					.response();
		}
		return resposta;
	}
//	default Response getValidarSchemaJsonComParam(String url, String caminhoDoArquivoDeSchema, String parametro,
//			String valorDoParametro, ContentType contentType) {
//		JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder()
//				.setValidationConfiguration(
//						ValidationConfiguration.newBuilder().setDefaultVersion(SchemaVersion.DRAFTV4).freeze())
//				.freeze();
//		Response resposta = given().contentType(contentType).param(parametro, valorDoParametro).when().get(url).then()
//				.body(matchesJsonSchemaInClasspath(caminhoDoArquivoDeSchema).using(jsonSchemaFactory)).extract()
//				.response();
//
//		return resposta;
//	}
}