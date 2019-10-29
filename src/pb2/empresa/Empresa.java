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

		for (Vendedor lista : this.listaDeVendedores) {
			if (lista.getNombre().equals(nombre) && lista.getApellido().equals(apellido))
				return false;
		}
		Vendedor nuevo = new Vendedor(nombre, apellido, porcentajeComision);
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
					&& lista.getVendedor().getApellido().equals(apellidoVendedor)
					&& lista.getDetalles() instanceof Producto) {
				Double precioProducto = ((Producto) lista.getDetalles()).getPrecio();
				comisionTotal += (precioProducto * lista.getVendedor().getPorcentajeComision()) / 100;
			}
		}
		return comisionTotal;
	}

	public ArrayList<Servicio> obtenerListaServicios(Date fecha, Vendedor vendedor) {
		ArrayList<Servicio> listaDeServicios = new ArrayList<>();
		for (Venta lista : this.listaDeVentas) {
			if (lista.getFecha().equals(fecha) && lista.getVendedor().equals(vendedor)
					&& lista.getDetalles() instanceof Servicio)
				listaDeServicios.add((Servicio) lista.getDetalles());
		}
		return listaDeServicios;
	}

	public Boolean eliminarVenta(Long id) {
		Iterator<Venta> it = this.listaDeVentas.iterator();
		while (it.hasNext()) {
			Venta aux = it.next();
			if (aux.getIdVenta().equals(id)) {
				it.remove();
				return true;
			}
		}
		return false;
	}
}
