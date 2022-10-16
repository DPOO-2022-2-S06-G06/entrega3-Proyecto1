package modelo;

import persistencia.Archivo;

import java.util.ArrayList;
import java.util.HashMap;

public class TemporadaReal {
	private HashMap<Integer,Fecha> fechas;
	private HashMap<String,Equipo> equipos;
	
	public TemporadaReal() {
		fechas = new HashMap<Integer,Fecha>();
		equipos = new HashMap<String,Equipo>();
	}
	public void crearFechas(String partidos) {
		Archivo archivo = new Archivo();
		HashMap<String,ArrayList<String[]>> fechas = archivo.cargarFechas(partidos);
		for(String numFecha: fechas.keySet()) {
			Fecha fecha = new Fecha(Integer.parseInt(numFecha));
			for(String[] info: fechas.get(numFecha)) {
				try {
					fecha.crearPartido(info[2], info[3], equipos.get(info[0]), equipos.get(info[1]));
				} catch (Exception e) {
					System.out.print(info[0] +" o "+ info[1] + " no es un equipo cargado");
				}
			}
			this.fechas.put(Integer.parseInt(numFecha), fecha);
		}
	}
	public void crearEquipos(String nominas) {
		Archivo archivo = new Archivo();
		HashMap<String,ArrayList<String[]>> equipos = archivo.cargarEquipos(nominas);
		for(String nombre: equipos.keySet()) {
			Equipo nuevoEquipo = new Equipo(nombre);
			for(String[] jugador: equipos.get(nombre)) {
				nuevoEquipo.agregarJugador(jugador[0], Integer.parseInt(jugador[1]), 
						jugador[2], Integer.parseInt(jugador[3]));
			}
			this.equipos.put(nombre,nuevoEquipo);
		}
	}
	public int getCantidadFechas() {
		return fechas.size();
	}
	
}
