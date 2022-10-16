package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import persistencia.Archivo;

public class xD {
	public static void main(String[] args) {
		Archivo archivo = new Archivo();
		
		HashMap<Integer, ArrayList<String[]>> datos = archivo.cargarFechas();
		System.out.println(datos);
		
		for (ArrayList<String[]> value : datos.values()) {
		    System.out.println("Value = " + value);
		}


	}
}

