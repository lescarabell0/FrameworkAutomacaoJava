package thread;

import cucumber.api.Scenario;
import cucumber.api.java.Before;

public class Hooks {
	public static String nomeCenario;
	
	@Before
	public void obterNomeScenario(Scenario cen) {
		nomeCenario = cen.getName();
	}
}
