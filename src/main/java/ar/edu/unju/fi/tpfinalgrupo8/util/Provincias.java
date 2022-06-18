package ar.edu.unju.fi.tpfinalgrupo8.util;

public enum Provincias {
    BUENOS_AIRES("Buenos Aires"),
    CABA("Ciudad Autónoma de Buenos Aires"),
    CATAMARCA("Catamarca"),
    CHACO("Chaco"),
    CHUBUT("Chubut"),
    CÓRDOBA("Córdoba"),
    CORRIENTES("Corrientes"),
    ENTRE_RÍOS("Entre Rios"),
    FORMOSA("Formosa"),
    JUJUY("Jujuy"),
    LA_PAMPA("La Pampa"),
    LA_RIOJA("La Rioja"),
    MENDOZA("Mendoza"),
    MISIONES("Misiones"),
    NEUQUÉN("Neuquén"),
    RÍO_NEGRO("Río Negro"),
    SALTA("Salta"),
    SAN_JUAN("San Juan"),
    SAN_LUIS("San Luis"),
    SANTA_CRUZ("Santa Cruz"),
    SANTA_FE("Santa Fe"),
    SANTIAGO_DEL_ESTERO("Santiago del Estero"),
    TIERRA_DEL_FUEGO("Tierra del Fuego"),
    TUCUMÁN("Tucumán");

    private final String displayValue;
    Provincias(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}
