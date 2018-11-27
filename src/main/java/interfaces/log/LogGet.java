package interfaces.log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public interface LogGet {
	/**
	 * @param step
	 * @param url
	 * @param response
	 */
	static void logGet(String step, Object url, Object response) {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/java/conflogs/logGet.properties");
		Logger.getLogger("").info(step + System.lineSeparator() + "GET: " + url + System.lineSeparator() + "Resultado: " + response
				+ System.lineSeparator());
	}
}