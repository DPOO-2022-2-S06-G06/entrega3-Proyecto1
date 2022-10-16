package modelo;
//HMMMM
public class Arquero extends Jugador {
	public Arquero(String nombre, int precio, int numero) {
		super(nombre, precio, numero);
	}
	@Override
	public int calcularPuntos(int fecha) {
		Reporte reporte = reportes.get(fecha-1);
		return reporte.calcularPuntosArquero();
	}
	@Override
	public String darTipo() {
		return "Arquero";
	}
}
