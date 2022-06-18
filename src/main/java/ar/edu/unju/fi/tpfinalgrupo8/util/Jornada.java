package ar.edu.unju.fi.tpfinalgrupo8.util;

public enum Jornada {
    MAÑANA("Mañana"),
    TARDE("Tarde"),
    NOCHE("Noche");

    private final String displayValue;
   Jornada(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
