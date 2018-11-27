package interfaces.api;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.authentication.OAuthSignature;

/**
 * @author paulolobo
 *
 */
public interface IDefinicoesExtras {

	/**
	 * @param urlBase
	 */
	default void definirUrlBase(String urlBase) {
		RestAssured.baseURI = urlBase;
	}

	default void usarHttps() {
		RestAssured.useRelaxedHTTPSValidation();
	}

	default void usarHttps(String protocolo) {
		RestAssured.useRelaxedHTTPSValidation(protocolo);
	}

	/**
	 * @param hostProxy
	 * @param porta
	 */
	default void definirProxy(String hostProxy, int porta) {
		RestAssured.proxy(hostProxy, porta);
	}

	/**
	 * @param username
	 * @param password
	 */
	default void definirAutenticacaoBasica(String username, String password) {
		RestAssured.basic(username, password);
	}

	/**
	 * @param oauth2AccessToken
	 * @param oauth2Signature
	 */
	default void definirAutenticacaoOauth2(String oauth2AccessToken, OAuthSignature oauth2Signature) {
		RestAssured.oauth2(oauth2AccessToken, oauth2Signature);
	}

	/**
	 * @param oauth2AccessToken
	 */
	default void definirAutenticacaoOauth2(String oauth2AccessToken) {
		RestAssured.oauth2(oauth2AccessToken);
	}

	/**
	 * @param oauthConsumerKey
	 * @param oauthConsumerSecret
	 * @param oauthAccessToken
	 * @param oauthSecretToken
	 */
	default void definirAutenticacaoOauth(String oauthConsumerKey, String oauthConsumerSecret, String oauthAccessToken,
			String oauthSecretToken) {
		RestAssured.oauth(oauthConsumerKey, oauthConsumerSecret, oauthAccessToken, oauthSecretToken);
	}

	/**
	 * @param oauthConsumerKey
	 * @param oauthConsumerSecret
	 * @param oauthAccessToken
	 * @param oauthSecretToken
	 * @param oauthSignature
	 */
	default void definirAutenticacaoOauth(String oauthConsumerKey, String oauthConsumerSecret, String oauthAccessToken,
			String oauthSecretToken, OAuthSignature oauthSignature) {
		RestAssured.oauth(oauthConsumerKey, oauthConsumerSecret, oauthAccessToken, oauthSecretToken, oauthSignature);
	}

	/**
	 * 
	 */
	default void resetarConfiguracoesExtras() {
		RestAssured.reset();
	}
}