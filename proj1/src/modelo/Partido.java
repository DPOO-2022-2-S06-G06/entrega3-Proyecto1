package modelo;

import java.util.HashMap;
import java.util.ArrayList;

import persistencia.Archivo;

public class Partido {
	
	private String dia;
	private String hora;
	private int golesLocal;
	private int golesVisitante;
	private int duracion;
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private ArrayList<Reporte> reportes;
	private boolean reportado;
	private int fecha;
		
	public Partido(String dia, String hora, Equipo equipoLocal, Equipo equipoVisitante, int fecha) {
		this.dia = dia;
		this.hora = hora;
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.reportado = false;
		this.fecha = fecha;
	}
	
	/**
	 * Recibe los resultados de un partido en forma de ArrayList y crea los reportes
	 * y los asocia a su jugador
	 * @param resultados
	 */
	public void reportarPartido(ArrayList<String[]> resultados) {
		HashMap<String,Jugador> locales = getLocales();
		HashMap<String,Jugador> visitantes = getVisitantes();
		for(int i = 1; i < resultados.size();i++) {
			String[] r = resultados.get(i);
			Jugador jugador = locales.get(r[0]);
			//Tengo duda si uno busca en un hashmap una llave inexistente si si retorna null
			if(jugador == null)
				jugador = visitantes.get(r[0]);
			Reporte reporte = new Reporte(p(r[2])-p(r[1]),p(r[3]),p(r[4]),p(r[5]),p(r[9]),p(r[10]),
					p(r[11]),p(r[7]),p(r[8]),jugador);
			if(jugador!=null)
				jugador.asociarReporte(reporte);
		}
		//Se asegura que si hay un jugador que no aparece en los reportes (por no haber jugado) a este se le ponga un reporte vacio
		for(String jugador:locales.keySet()) {
			if(locales.get(jugador).reportado(this.fecha)){
				Reporte vacio = new Reporte(0,0,0,0,0,0,0,0,0,locales.get(jugador));
				locales.get(jugador).asociarReporte(vacio);
			}
		}
		for(String jugador:visitantes.keySet()) {
			if(visitantes.get(jugador).reportado(this.fecha)){
				Reporte vacio = new Reporte(0,0,0,0,0,0,0,0,0,visitantes.get(jugador));
				visitantes.get(jugador).asociarReporte(vacio);
			}
		}
		this.reportado=true;
	}
	
	private int p(String s) {
		return Integer.parseInt(s);
	}
	private HashMap<String,Jugador> getLocales(){
		return equipoLocal.getJugadores();
	}
	private HashMap<String,Jugador> getVisitantes(){
		return equipoVisitante.getJugadores();
	}
	public String getNombreLocal() {
		return equipoLocal.getNombre();
	}
	public String getNombreVisitante() {
		return equipoVisitante.getNombre();
	}
	public boolean isReportado() {
		return this.reportado;
	}
	public String getDia() {
		return dia;
	}
	public String getHora() {
		return hora;
	}
}
