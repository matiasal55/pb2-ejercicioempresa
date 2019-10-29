package pb2.empresa;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Empresa {
	private String nombre;
	private ArrayList<Vendedor> listaDeVendedores;
	private LinkedList<Venta> listaDeVentas;

	public Empresa(String nombre) {
		this.nombre = nombre;
		this.listaDeVendedores = new ArrayList<>();
		this.listaDeVentas = new LinkedList<>();
	}

	public Boolean agregarVendedor(String nombre, String apellido, Double porcentajeComision) {
		Vendedor nuevo = new Vendedor(nombre, apellido, porcentajeComision);
		for (Vendedor lista : this.listaDeVendedores) {
			if (lista.equals(nuevo))
				return false;
		}
		this.listaDeVendedores.add(nuevo);
		return true;
	}

	public Boolean agregarVenta(Venta nueva) {
		for (Venta lista : this.listaDeVentas) {
			if (lista.getIdVenta().equals(nueva.getIdVenta()))
				return false;
		}
		this.listaDeVentas.add(nueva);
		return true;
	}

	public Double obtenerComisionDeTodosLosProductosVendidosPorVendedor(String nombreVendedor,
			String apellidoVendedor) {
		Double comisionTotal = 0.0;
		for (Venta lista : this.listaDeVentas) {
			if (lista.getVendedor().getNombre().equals(nombreVendedor)
					&& lista.getVendedor().getApellido().equals(apellidoVendedor)) {
				Double precioProducto = ((Producto) lista.getDetalles()).getPrecio();
				comisionTotal += precioProducto * lista.getVendedor().getPorcentajeComision();
			}
		}
		return comisionTotal;
	}

	public ArrayList<Servicio> obtenerListaServicios(Date fecha, Vendedor vendedor) {
		ArrayList<Servicio> listaDeServicios = new ArrayList<>();
		return listaDeServicios;
	}

	public Boolean buscarVendedor(String nombre, String apellido) {
		for (Vendedor lista : this.listaDeVendedores) {
			if (lista.getNombre().equals(nombre) && lista.getApellido().equals(apellido))
				return true;
		}
		return false;
	}

	public Boolean eliminarVenta(Long id) {
		Iterator<Venta> it=this.listaDeVentas.iterator();
		while(it.hasNext()) {
			Venta aux=it.next();
			if(aux.getIdVenta().equals(id)) {
				it.remove();
				return true;
			}
		}
		return false;
	}
}
