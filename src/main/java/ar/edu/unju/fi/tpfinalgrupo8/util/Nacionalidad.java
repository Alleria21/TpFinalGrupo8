package ar.edu.unju.fi.tpfinalgrupo8.util;

public enum Nacionalidad{
	ARGENTINA("Argentina"),
	URUGUAY("Uruguay"),
	BRASIL("Brasil"),
	CHILE("Chile"),
	BOLIVIA("Bolivia"),
	VENEZUELA("Venezuela"),
	ECUADOR("Ecuador"),
	COLOMBIA("Colombia"),
	PERU("Peru"),
	OTRO("Otro");
	
    private final String displayValue;
    Nacionalidad(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
