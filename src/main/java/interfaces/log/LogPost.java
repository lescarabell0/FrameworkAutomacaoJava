package interfaces.log;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public interface LogPost {
	/**
	 * @param step
	 * @param url
	 * @param response
	 */
	static void logPost(String step, Object url, Object response) {
		BasicConfigurator.configure();
		PropertyConfigurator.configure("src/main/java/conflogs/logPost.properties");
		Logger.getLogger("").info(step + System.lineSeparator() + "POST: " + url + System.lineSeparator()
				+ "Resultado: " + response + System.lineSeparator());
	}
}