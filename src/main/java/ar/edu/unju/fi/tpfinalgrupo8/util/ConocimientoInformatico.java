package ar.edu.unju.fi.tpfinalgrupo8.util;

public enum ConocimientoInformatico {
	NINGUNO("Ninguno"),
	POCO("Poco"),
	PROMEDIO("Promedio"),
	AVANZADO("Avanzado");
	
	private final String displayValue;
	ConocimientoInformatico(String displayValue){
		this.displayValue=displayValue;
	}
	
	public String getDisplayValue() {
		return displayValue;
	}
}