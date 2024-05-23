package ar.edu.unlp.info.oo2.facturacion_llamadas;

public abstract class Llamada {
	private String origen;
	private String destino;
	private int duracion;

	public Llamada(String origen, String destino, int duracion) {
		this.origen= origen;
		this.destino= destino;
		this.duracion = duracion;
	}
	
	
	public double calcularCosto() {
		return this.calcularMontoNeto() + this.calcularMontoIva() + this.getAdicional();
	}
	
	private double calcularMontoNeto() {
		return this.getDuracion() * this.getPrecio();
	}
	
	private double calcularMontoIva() {
		return this.calcularMontoNeto() * this.getIva();
	}
	
	
	
	public abstract double getPrecio();
	
	public abstract double getAdicional();
	
	public double getIva() {
		return 0.21;
	}
	

	public String getRemitente() {
		return destino;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public String getOrigen() {
		return origen;
	}
	
	
}
