package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class ClienteJuridico extends Cliente{
	private String cuit;
	
	
	public ClienteJuridico(){
		
	}
	
	public String getCuit() {
		return cuit;
	}
	
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	
	public double getDescuento() {
		
		return 0.15;
	}
}
