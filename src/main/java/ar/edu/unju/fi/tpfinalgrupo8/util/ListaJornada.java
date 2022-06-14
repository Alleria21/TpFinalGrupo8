package ar.edu.unju.fi.tpfinalgrupo8.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListaJornada {
	private List<String> jornada = new ArrayList<String>();
	
	public ListaJornada() {
		jornada = new ArrayList<String>();
		jornada.add("Mañana");
		jornada.add("Tarde");
		jornada.add("Noche");
	}

	public List<String> getJornada() {
		return jornada;
	}

	public void setJornada(List<String> jornada) {
		this.jornada = jornada;
	}
	
}
