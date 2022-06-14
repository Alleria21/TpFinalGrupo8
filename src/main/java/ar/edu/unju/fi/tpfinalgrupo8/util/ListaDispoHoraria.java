package ar.edu.unju.fi.tpfinalgrupo8.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListaDispoHoraria {
	private List<String> dispoHoraria = new ArrayList<String>();
	
	public ListaDispoHoraria() {
		dispoHoraria = new ArrayList<String>();
		dispoHoraria.add("Full Time");
		dispoHoraria.add("Part Time");
	}

	public List<String> getDispoHoraria() {
		return dispoHoraria;
	}

	public void setDispoHoraria(List<String> dispoHoraria) {
		this.dispoHoraria = dispoHoraria;
	}
}

