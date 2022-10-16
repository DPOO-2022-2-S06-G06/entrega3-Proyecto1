package modelo;
//HMMMM
import java.util.ArrayList;
import java.util.HashMap;

public class Equipo {
	private String nombre;
	private HashMap<String,Jugador> jugadores;
	
	public Equipo(String nombre) {
		this.nombre = nombre;
	}
	public void agregarJugador(String nombre, int precio, String pos, int numero) {
		Jugador nuevoJugador = null;
		if (pos == "delantero")
			nuevoJugador = new Delantero(nombre, precio, numero);
		else if (pos == "mediocampista")
			nuevoJugador = new Mediocampista(nombre, precio, numero);
		else if (pos == "defensor")
			nuevoJugador = new Defensa(nombre, precio,numero);
		else if (pos == "arquero")
			nuevoJugador = new Arquero(nombre, precio,numero);
		try {
			jugadores.put(nombre, nuevoJugador);
		} catch (Exception e) {
			System.out.println("Jugador " + nombre + " no se añadió por posición inválida");
		}
	}
	public String getNombre() {
		return nombre;
	}
	public HashMap<String,Jugador> getJugadores() {
		return this.jugadores;
	}
	
}
