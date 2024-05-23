package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private List<Llamada> llamadas = new ArrayList<Llamada>();
	private String nombre;
	private String numeroTelefono;
	
	
	
	public double calcularLlamadas() {
		double c = 0;
		for (Llamada l : this.getLlamadas()) {
			double auxc = 0;
			
			auxc += l.calcularCosto();
			
			
			auxc -= auxc*this.getDescuento();
			
			c += auxc;
		}
		return c;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	
	public abstract double getDescuento();
	
	
	public List<Llamada> getLlamadas(){
		return this.llamadas;
	}
	
	public void addLlamada(Llamada llamada) {
		this.llamadas.add(llamada);
	}
}
