package ar.edu.unju.fi.tpfinalgrupo8.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class  ListaEstadoCivil {
	private List<String> estadoCivil = new ArrayList<String>();
	public  ListaEstadoCivil() {
		estadoCivil = new ArrayList<String>();
		estadoCivil.add("casado");
		estadoCivil.add("soltero");
		estadoCivil.add("viudo o divorciado");
	}
	public List<String> getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(List<String> estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
}
