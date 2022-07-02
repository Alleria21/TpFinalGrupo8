package ar.edu.unju.fi.tpfinalgrupo8.util;

public enum NivelEducacion{
	PRIMARIOCOMPLETO("Primario Completo"),
	SECUNDARIOCOMPLETO("Secundario Completo"),
	TERCIARIOCOMPLETO("Terciario Completo"),
	UNIVERSITARIOCOMPLETO("Universitario Completo"),
	SINESTUDIOS("Sin Estudios");

    private final String displayValue;
    NivelEducacion(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}