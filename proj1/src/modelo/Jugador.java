package modelo;
//HMMMM
import java.util.ArrayList;

public abstract class Jugador {
	private String nombre;
	private int precio;
	private int numero;
	private Equipo equipo;
	protected ArrayList<Reporte> reportes;
	
	public Jugador(String nombre, int precio, int numero) {
		this.nombre=nombre;
		this.precio=precio;
		this.numero=numero;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getPrecio() {
		return precio;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public void asociarReporte(Reporte reporte) {
		reportes.add(reporte);
	}
	
	public boolean reportado(int fecha) {
		if(reportes.size()==fecha)
			return true;
		return false;
	}
	
	public abstract int calcularPuntos(int fecha);
	
	public abstract String darTipo();
}
