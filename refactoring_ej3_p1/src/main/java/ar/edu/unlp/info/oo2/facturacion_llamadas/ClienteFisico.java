package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class ClienteFisico extends Cliente{
	private String dni;
	
	public ClienteFisico(String nombre, String telefono, String dni){
		super(nombre,telefono);
		this.dni = dni;
	}
	
	public String getDNI() {
		return dni;
	}
	
	public void setDNI(String dni) {
		this.dni = dni;
	}
	
	public double getDescuento() {
		
		return 0;
	}
}
