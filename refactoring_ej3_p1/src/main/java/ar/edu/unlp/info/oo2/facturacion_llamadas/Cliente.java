package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private List<Llamada> llamadas = new ArrayList<Llamada>();
	private String nombre;
	private String numeroTelefono;
	
	
	public Cliente(String nombre, String telefono) {
		this.nombre = nombre;
		this.numeroTelefono = telefono;
	}
	
	
	public double calcularLlamadas() {
		double costo = this.llamadas.stream().mapToDouble(l -> l.calcularCosto()).sum();
		return this.calcularDescuento(costo);
	}
	
	private double calcularDescuento(Double costo) {
		return costo - (costo * this.getDescuento());
	}
	
	
	

	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	
	
	public abstract double getDescuento();
	
	
	public List<Llamada> getLlamadas(){
		return this.llamadas;
	}
	
	public void addLlamada(Llamada llamada) {
		this.llamadas.add(llamada);
	}
}
