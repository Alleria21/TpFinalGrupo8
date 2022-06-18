package ar.edu.unju.fi.tpfinalgrupo8.util;

public enum DisponibilidadHoraria {

    FULL_TIME("Full time"),
    PART_TIME("Part time");
    private final String displayValue;

    DisponibilidadHoraria(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
