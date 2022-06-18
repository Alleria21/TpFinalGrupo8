package ar.edu.unju.fi.tpfinalgrupo8.util;

public enum EstadoCivil {
    CASADO("Casado"),
    DIVORCIADO("Divorciado"),
    SOLTERO("Soltero"),
    VIUDO("Viudo");

    private final String displayValue;
    EstadoCivil(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
