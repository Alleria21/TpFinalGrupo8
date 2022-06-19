package ar.edu.unju.fi.tpfinalgrupo8.util;

public enum Categoria {
	ARTES_DIGITALES("Artes digitales"),
	CIBERSEGURIDAD("Ciberseguridad"),
	PROGRAMACION("Programacion"),
	MARKETING_DIGITAL("Marketing digital"),
	BUSINESS("Business"),
	DATA("Data");
	
	private final String displayValue;
    Categoria(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
