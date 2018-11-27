package controladorplanilhadetestes;

import com.poiji.annotation.ExcelCellName;

public class ModelDeDadosDaAbaTres {

	@ExcelCellName("IDENTIFICADOR")
	public String identificador;

	@ExcelCellName("CAMINHOAPK")
	public String caminhoapk;

	@ExcelCellName("DEVICEID")
	public String deviceid;

	@ExcelCellName("VERSAODOSO")
	public String versaodoandroid;

	@ExcelCellName("APPWAITACTIVITY")
	public String appwaitactivity;

}