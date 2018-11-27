package interfaces.log;

import java.util.logging.Logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

public interface LogPatch {
	/**
	 * @param step
	 * @param url
	 * @param response
	 */
	static void logPatch(String step, Object url, Object response) {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/java/conflogs/logPatch.properties");
		Logger.getLogger("").info(step + System.lineSeparator() + "PATCH: " + url + System.lineSeparator() + "Resultado: " + response
				+ System.lineSeparator());
	}
}