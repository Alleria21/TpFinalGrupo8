package ar.edu.unju.fi.tpfinalgrupo8.util;

public enum Modalidad {
	ONLINE("online");
	
	private final String displayValue;
    Modalidad(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
