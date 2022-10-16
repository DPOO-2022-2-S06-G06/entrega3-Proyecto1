package modelo;
//HMMMM
public class Delantero extends Jugador {
	
	public Delantero(String nombre, int precio, int numero) {
		super(nombre, precio, numero);
	}
	@Override
	public int calcularPuntos(int fecha) {
		Reporte reporte = reportes.get(fecha-1);
		return reporte.calcularPuntosDelantero();
	}
	@Override
	public String darTipo() {
		return "Delantero";
	}
}
