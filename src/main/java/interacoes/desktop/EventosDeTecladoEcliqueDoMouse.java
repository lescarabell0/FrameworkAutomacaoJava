package interacoes.desktop;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class EventosDeTecladoEcliqueDoMouse {
	Robot robot = null;

	/**
	 * @throws AWTException
	 * 
	 */
	public EventosDeTecladoEcliqueDoMouse() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void moverParaCima() {
		robot.keyPress(KeyEvent.VK_UP);
	}

	/**
	 * 
	 */
	public void moverParaBaixo() {
		robot.keyPress(KeyEvent.VK_DOWN);
	}

	/**
	 * 
	 */
	public void moverParaEsquerda() {
		robot.keyPress(KeyEvent.VK_LEFT);
	}

	/**
	 * 
	 */
	public void moverParaDireita() {
		robot.keyPress(KeyEvent.VK_RIGHT);
	}

	/**
	 * 
	 */
	public void pressionarEnter() {
		robot.keyPress(KeyEvent.VK_ENTER);
	}

	/**
	 * @param quantidade de BACK_SPACE
	 */
	public void backspace(int quantidade) {
		for (int i = 0; i <= quantidade; i++) {
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
		}
	}

	/**
	 * @param quantidade de DELETE
	 */
	public void delete(int quantidade) {
		for (int i = 0; i <= quantidade; i++) {
			robot.keyPress(KeyEvent.VK_DELETE);
		}
	}

	/**
	 * @param quantidade de ESPAÇO
	 */
	public void espaco(int quantidade) {
		for (int i = 0; i <= quantidade; i++) {
			robot.keyPress(KeyEvent.VK_SPACE);
		}
	}

	/**
	 * 
	 */
	public void esc() {
		robot.keyPress(KeyEvent.VK_ESCAPE);
	}

	/**
	 * 
	 */
	public void control() {
		robot.keyPress(KeyEvent.VK_CONTROL);
	}

	/**
	 * 
	 */
	public void shift() {
		robot.keyPress(KeyEvent.VK_SHIFT);
	}

	/**
	 * 
	 */
	public void alt() {
		robot.keyPress(KeyEvent.VK_ALT);
	}

	/**
	 * 
	 */
	public void pageUp() {
		robot.keyPress(KeyEvent.VK_PAGE_UP);
	}

	/**
	 * 
	 */
	public void pageDown() {
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	}

	/**
	 * 
	 */
	public void end() {
		robot.keyPress(KeyEvent.VK_END);
	}

	/**
	 * 
	 */
	public void home() {
		robot.keyPress(KeyEvent.VK_HOME);
	}

	/**
	 * 
	 */
	public void windows() {
		robot.keyPress(KeyEvent.VK_WINDOWS);
	}

	/**
	 * 
	 */
	public void tab() {
		robot.keyPress(KeyEvent.VK_TAB);
	}

	/**
	 * 
	 */
	public void capsLock() {
		robot.keyPress(KeyEvent.VK_CAPS_LOCK);
	}

	/**
	 * 
	 */
	public void copiar() {
		robot.keyPress(KeyEvent.VK_COPY);
	}

	/**
	 * 
	 */
	public void cortar() {
		robot.keyPress(KeyEvent.VK_CUT);
	}

	/**
	 * 
	 */
	public void colar() {
		robot.keyPress(KeyEvent.VK_PASTE);
	}

	/**
	 * @param quantidade de clique com botão esquerdo do mouse
	 */
	public void clicarBotaoEsquerdoMouse(int quantidade) {
		for (int i = 0; i <= quantidade; i++) {
			robot.mousePress(MouseEvent.BUTTON1);
		}
	}

	/**
	 * @param quantidade de clique com botão direito do mouse
	 */
	public void clicarBotaoDireitoMouse(int quantidade) {
		for (int i = 0; i <= quantidade; i++) {
			robot.mousePress(MouseEvent.BUTTON2);
		}
	}

	/**
	 * @param quantida de rolagem
	 */
	public void rolar(int quantidadeRolagem) {
		robot.mouseWheel(quantidadeRolagem);
	}

	/**
	 * @param mover para coordenada X
	 * @param mover para coordenada Y
	 */
	public void moverParaCoordenada(int coordenadaX, int coordenadaY) {
		robot.mouseMove(coordenadaX, coordenadaY);

	}

	public void digitar(CharSequence characters) {
		int length = characters.length();
		for (int i = 0; i < length; i++) {
			char character = characters.charAt(i);
			tipoCaracteres(character);
		}
	}

	private void tipoCaracteres(char caracteres) {

		switch (caracteres) {
		case 'a':
			tipoCaracteres(KeyEvent.VK_A);
			break;
		case 'b':
			tipoCaracteres(KeyEvent.VK_B);
			break;
		case 'c':
			tipoCaracteres(KeyEvent.VK_C);
			break;
		case 'd':
			tipoCaracteres(KeyEvent.VK_D);
			break;
		case 'e':
			tipoCaracteres(KeyEvent.VK_E);
			break;
		case 'f':
			tipoCaracteres(KeyEvent.VK_F);
			break;
		case 'g':
			tipoCaracteres(KeyEvent.VK_G);
			break;
		case 'h':
			tipoCaracteres(KeyEvent.VK_H);
			break;
		case 'i':
			tipoCaracteres(KeyEvent.VK_I);
			break;
		case 'j':
			tipoCaracteres(KeyEvent.VK_J);
			break;
		case 'k':
			tipoCaracteres(KeyEvent.VK_K);
			break;
		case 'l':
			tipoCaracteres(KeyEvent.VK_L);
			break;
		case 'm':
			tipoCaracteres(KeyEvent.VK_M);
			break;
		case 'n':
			tipoCaracteres(KeyEvent.VK_N);
			break;
		case 'o':
			tipoCaracteres(KeyEvent.VK_O);
			break;
		case 'p':
			tipoCaracteres(KeyEvent.VK_P);
			break;
		case 'q':
			tipoCaracteres(KeyEvent.VK_Q);
			break;
		case 'r':
			tipoCaracteres(KeyEvent.VK_R);
			break;
		case 's':
			tipoCaracteres(KeyEvent.VK_S);
			break;
		case 't':
			tipoCaracteres(KeyEvent.VK_T);
			break;
		case 'u':
			tipoCaracteres(KeyEvent.VK_U);
			break;
		case 'v':
			tipoCaracteres(KeyEvent.VK_V);
			break;
		case 'w':
			tipoCaracteres(KeyEvent.VK_W);
			break;
		case 'x':
			tipoCaracteres(KeyEvent.VK_X);
			break;
		case 'y':
			tipoCaracteres(KeyEvent.VK_Y);
			break;
		case 'z':
			tipoCaracteres(KeyEvent.VK_Z);
			break;
		case 'A':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_A);
			break;
		case 'B':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
			break;
		case 'C':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_C);
			break;
		case 'D':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_D);
			break;
		case 'E':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_E);
			break;
		case 'F':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_F);
			break;
		case 'G':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_G);
			break;
		case 'H':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_H);
			break;
		case 'I':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_I);
			break;
		case 'J':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_J);
			break;
		case 'K':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
			break;
		case 'L':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
			break;
		case 'M':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
			break;
		case 'N':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
			break;
		case 'O':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
			break;
		case 'P':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
			break;
		case 'Q':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
			break;
		case 'R':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
			break;
		case 'S':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
			break;
		case 'T':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
			break;
		case 'U':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
			break;
		case 'V':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
			break;
		case 'W':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
			break;
		case 'X':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
			break;
		case 'Y':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
			break;
		case 'Z':
			tipoCaracteres(KeyEvent.VK_SHIFT, KeyEvent.VK_B);
			break;
		case '0':
			tipoCaracteres(KeyEvent.VK_0);
			break;
		case '1':
			tipoCaracteres(KeyEvent.VK_1);
			break;
		case '2':
			tipoCaracteres(KeyEvent.VK_2);
			break;
		case '3':
			tipoCaracteres(KeyEvent.VK_3);
			break;
		case '4':
			tipoCaracteres(KeyEvent.VK_4);
			break;
		case '5':
			tipoCaracteres(KeyEvent.VK_5);
			break;
		case '6':
			tipoCaracteres(KeyEvent.VK_6);
			break;
		case '7':
			tipoCaracteres(KeyEvent.VK_7);
			break;
		case '8':
			tipoCaracteres(KeyEvent.VK_8);
			break;
		case '9':
			tipoCaracteres(KeyEvent.VK_9);
			break;
		default:
			throw new IllegalArgumentException("Não foi localizado a letra digitada ");
		}
	}

	private void tipoCaracteres(int... keyCodes) {
		tipoCaracteres(keyCodes, 0, keyCodes.length);
	}

	private void tipoCaracteres(int[] keyCodes, int offset, int length) {
		if (length == 0) {
			return;
		}
		robot.keyPress(keyCodes[offset]);
		tipoCaracteres(keyCodes, offset + 1, length - 1);
		robot.keyRelease(keyCodes[offset]);
	}

}
