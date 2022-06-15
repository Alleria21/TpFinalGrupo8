package ar.edu.unju.fi.tpfinalgrupo8.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListaProvincias {
	private List<String> listaProvincias = new ArrayList<String>();
	
	public ListaProvincias() {
		listaProvincias = new ArrayList<String>();
		listaProvincias.add("BUENOS AIRES");
		listaProvincias.add("CABA");
		listaProvincias.add("CATAMARCA");
		listaProvincias.add("CHACO");
		listaProvincias.add("CHUBUT");
		listaProvincias.add("CORDOBA");
		listaProvincias.add("CORRIENTES");
		listaProvincias.add("ENTRE RÍOS");
		listaProvincias.add("FORMOSA");
		//Agregar mas provincias
	}

	public List<String> getListaProvincias() {
		return listaProvincias;
	}

	public void setListaProvincias(List<String> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}
	
	
}
