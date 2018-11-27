package util;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

import driver.web.DriverWeb;

public class Utils {
	private static String caminho = "src/test/resources/relatorios/screenshot/";

	public static void tirarScreenshot(String string) throws IOException {
		File screenshot = ((TakesScreenshot) DriverWeb.getDriver()).getScreenshotAs(OutputType.FILE);
		File destino = new File(caminho + string + ".png");
		FileUtils.copyFile(screenshot, destino);
	}
	
	public static String escreverHoraMinutoSegundo() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH.mm.ss");
		LocalDateTime agora = LocalDateTime.now(ZoneId.systemDefault());
		String agoraFormatado = agora.format(formatter);
		return agoraFormatado;
	}
	
	public String escreverData() {
		LocalDate lcd = LocalDate.now(ZoneId.systemDefault());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String data = lcd.format(formatter);
		return data;
	}

	public String escreverDataFutura(int dias) {
		LocalDate lcd = LocalDate.now(ZoneId.systemDefault());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate data = lcd.plusDays(dias);
		return data.format(formatter).toString();
	}
	
	
	public String parsePdf(String pdf) throws IOException {
	    PdfReader reader = new PdfReader(pdf);
	    PdfReaderContentParser parser = new PdfReaderContentParser(reader);
	    TextExtractionStrategy strategy = null;
	    String texto = null;
	    for (int i = 1; i <= reader.getNumberOfPages(); i++) {
	        strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
	        texto = texto + " " + strategy.getResultantText();
	    }
	    reader.close();
	    return texto;
	}

}