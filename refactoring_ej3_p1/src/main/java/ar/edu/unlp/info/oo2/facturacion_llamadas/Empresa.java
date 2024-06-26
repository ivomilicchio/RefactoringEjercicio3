package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private GestorNumerosDisponibles guia = new GestorNumerosDisponibles();

	

	public String obtenerNumeroLibre() {
		return guia.obtenerNumeroLibre();
	}

	
	public ClienteFisico registrarUsuarioFisico(String dni, String nombre) {
		ClienteFisico cliente = new ClienteFisico(nombre,this.obtenerNumeroLibre(),dni);
		clientes.add(cliente);
		return cliente;
		
	}
	
	public ClienteJuridico registrarUsuarioJuridico(String cuit, String nombre) {
		ClienteJuridico cliente = new ClienteJuridico(nombre,this.obtenerNumeroLibre(),cuit);
		clientes.add(cliente);
		return cliente;
		
	}

	public LlamadaNacional registrarLlamadaNacional(Cliente origen, Cliente destino, int duracion) {
		LlamadaNacional llamada = new LlamadaNacional( origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
		origen.addLlamada(llamada);
		return llamada;
	}
	
	public LlamadaInternacional registrarLlamadaInternacional(Cliente origen, Cliente destino, int duracion) {
		LlamadaInternacional llamada = new LlamadaInternacional( origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
		origen.addLlamada(llamada);
		return llamada;
	}

	public double calcularMontoTotalLlamadas(Cliente cliente) {
		return cliente.calcularLlamadas();
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
