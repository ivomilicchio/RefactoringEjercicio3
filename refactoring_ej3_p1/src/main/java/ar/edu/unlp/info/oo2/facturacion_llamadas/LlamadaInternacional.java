package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class LlamadaInternacional extends Llamada{
	
	
	public LlamadaInternacional(String origen, String destino, int duracion) {
		super(origen, destino,  duracion);
	}
	
	
	public double getPrecio() {
		return 150;
	}
	
	public double getAdicional() {
		return 50;
	}
	
}
