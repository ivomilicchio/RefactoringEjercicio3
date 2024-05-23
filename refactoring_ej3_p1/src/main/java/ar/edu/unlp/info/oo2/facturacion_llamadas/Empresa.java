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

	public Llamada registrarLlamada(Cliente origen, Cliente destino, String t, int duracion) {
		Llamada llamada = new Llamada(t, origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
		llamadas.add(llamada);
		origen.addLlamada(llamada);
		return llamada;
	}

	public double calcularMontoTotalLlamadas(Cliente cliente) {
		double c = 0;
		for (Llamada l : cliente.getLlamadas()) {
			double auxc = 0;
			if (l.getTipoDeLlamada() == "nacional") {
				// el precio es de 3 pesos por segundo más IVA sin adicional por establecer la llamada
				auxc += l.getDuracion() * 3 + (l.getDuracion() * 3 * 0.21);
			} else if (l.getTipoDeLlamada() == "internacional") {
				// el precio es de 150 pesos por segundo más IVA más 50 pesos por establecer la llamada
				auxc += l.getDuracion() * 150 + (l.getDuracion() * 150 * 0.21) + 50;
			}
			
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
