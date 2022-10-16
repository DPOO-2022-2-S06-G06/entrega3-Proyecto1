package modelo;
//HMMMM
public class Defensa extends Jugador {
	
	public Defensa(String nombre, int precio,int numero) {
		super(nombre, precio, numero);
	}
	@Override
	public int calcularPuntos(int fecha) {
		Reporte reporte = reportes.get(fecha-1);
		return reporte.calcularPuntosDefensa();
	}
	@Override
	public String darTipo() {
		return "Defensa";
	}
}