package ar.edu.unju.fi.tpfinalgrupo8.util;

public enum EstadoVidaPadres {
	AMBOSVIVOS("Ambos vivos"),
	UNOVIVOOTROFALLECIDO("Uno vivo otro fallecido"),
	AMBOSFALLECIDOS("Ambos fallecidos"),
	DESCONOCE("Desconoce");
	
    private final String displayValue;
   EstadoVidaPadres(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}