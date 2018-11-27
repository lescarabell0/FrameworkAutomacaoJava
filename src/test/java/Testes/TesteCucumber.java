package Testes;

import cucumber.api.java.pt.Quando;
import thread.Hooks;

public class TesteCucumber {
	
	@Quando("^realizar uma requisição na url$")
	public void teste() {
		System.out.println(Hooks.nomeCenario);
	}

}
