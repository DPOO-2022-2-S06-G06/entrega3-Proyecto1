package modelo;

import java.util.HashMap;
import java.util.ArrayList;

import persistencia.Archivo;

public class Fecha {
	
	private int num;
	private ArrayList<Partido> partidos;
	
	public Fecha(int num) {
		this.num = num;
	}
	
	public int getNumFecha() {
		return this.num;
	}
	
	public void crearPartido(String dia, String hora, Equipo local, Equipo visitante) {
		Partido partido = new Partido(dia, hora, local, visitante,num);
		partidos.add(partido);
	}
	
	/**
	 * Busca el partido del archivo y llama a la funcion que elabora los reportes
	 * @return
	 */
	public void hacerReportePartido(String resultados){
		Archivo archivo = new Archivo();
		ArrayList<String[]> reportes = archivo.cargarReportes(resultados);
		String nombreLocal = reportes.get(0)[0];
		String nombreVisitante = reportes.get(0)[1];
		Partido reportable = null;
		for(Partido partido: partidos) {
			if(partido.getNombreLocal().equals(nombreLocal) && 
					partido.getNombreVisitante().equals(nombreVisitante)) {
				reportable = partido;
			}
		}
		if(reportable != null)
			reportable.reportarPartido(reportes);
	}
}
