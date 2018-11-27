package interfaces.log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public interface LogDelete {
	/**
	 * @param step
	 * @param url
	 * @param response
	 */
	static void logDelete(String step, Object url, Object response) {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/java/conflogs/logDelete.properties");
		Logger.getLogger("").info(step + System.lineSeparator() + "DELETE: " + url + System.lineSeparator()
				+ "Resultado: " + response + System.lineSeparator());
	}
}