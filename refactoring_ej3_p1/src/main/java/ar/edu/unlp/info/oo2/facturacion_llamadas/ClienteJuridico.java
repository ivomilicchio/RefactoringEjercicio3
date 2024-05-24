package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class ClienteJuridico extends Cliente{
	private String cuit;
	
	
	public ClienteJuridico(String nombre, String telefono, String cuit){
		super(nombre,telefono);
		this.cuit = cuit;
	}
	
	
	
	public double getDescuento() {
		
		return 0.15;
	}
}
