package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<Llamada> llamadas = new ArrayList<Llamada>();
	private GestorNumerosDisponibles guia = new GestorNumerosDisponibles();

	

	public String obtenerNumeroLibre() {
		return guia.obtenerNumeroLibre();
	}

	
	public Cliente registrarUsuarioFisico(String dni, String nombre) {
		ClienteFisico cliente = new ClienteFisico();
		cliente.setNombre(nombre);
		String tel = this.obtenerNumeroLibre();
		cliente.setNumeroTelefono(tel);
		cliente.setDNI(dni);
		clientes.add(cliente);
		return cliente;
		
	}
	
	public Cliente registrarUsuarioJuridico(String cuit, String nombre) {
		ClienteJuridico cliente = new ClienteJuridico();
		cliente.setNombre(nombre);
		String tel = this.obtenerNumeroLibre();
		cliente.setNumeroTelefono(tel);
		cliente.setCuit(cuit);
		clientes.add(cliente);
		return cliente;
		
	}

	public Llamada registrarLlamadaNacional(Cliente origen, Cliente destino, int duracion) {
		Llamada llamada = new LlamadaNacional( origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
		llamadas.add(llamada);
		origen.addLlamada(llamada);
		return llamada;
	}
	
	public Llamada registrarLlamadaInternacional(Cliente origen, Cliente destino, int duracion) {
		Llamada llamada = new LlamadaInternacional( origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
		llamadas.add(llamada);
		origen.addLlamada(llamada);
		return llamada;
	}

	public double calcularMontoTotalLlamadas(Cliente cliente) {
		double c = 0;
		for (Llamada l : cliente.getLlamadas()) {
			double auxc = 0;
			
			auxc += l.getDuracion() * l.getPrecio() + (l.getDuracion() * l.getPrecio() * l.getIva()) + l.getAdicional();
			
			
			auxc -= auxc*cliente.getDescuento();
			
			c += auxc;
		}
		return c;
	}

	public int cantidadDeUsuarios() {
		return clientes.size();
	}

	public boolean existeUsuario(Cliente persona) {
		return clientes.contains(persona);
	}

	public GestorNumerosDisponibles getGestorNumeros() {
		return this.guia;
	}
}
