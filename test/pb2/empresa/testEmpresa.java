package pb2.empresa;

import java.util.ArrayList;
import java.util.Date;

import javax.activation.MimetypesFileTypeMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testEmpresa {

	Vendedor nuevo;
	Item detalleServicio;
	Item detalleProducto;
	Date fecha1;
	Venta nueva1;
	Venta nueva2;
	Empresa miEmpresa;

	@Before
	public void before() {
		nuevo = new Vendedor("Armando", "Perez", 10.0);
		detalleServicio = new Servicio(2010L, "Reparacion", 5, 10.0);
		detalleProducto = new Producto(2001L, "Chocolate", 200.0);
		fecha1 = new Date(119, 8, 20);
		nueva1 = new Venta(20L, fecha1, 1, nuevo, detalleServicio);
		nueva2 = new Venta(201L, fecha1, 1, nuevo, detalleProducto);
		miEmpresa = new Empresa("Pirulo");
	}

	@Test
	public void agregarVendedor() {
		Assert.assertTrue(miEmpresa.agregarVendedor("Armando", "Perez", 10.0));
	}

	@Test
	public void vendedorExistente() {
		miEmpresa.agregarVendedor("Armando", "Perez", 10.0);
		Assert.assertFalse(miEmpresa.agregarVendedor(nuevo.getNombre(), nuevo.getApellido(), 10.0));
	}

	@Test
	public void agregarVentaDeServicio() {
		miEmpresa.agregarVendedor(nuevo.getNombre(), nuevo.getApellido(), 10.0);
		Assert.assertTrue(miEmpresa.agregarVenta(nueva1));
	}

	@Test
	public void agregarVentaDeProducto() {
		miEmpresa.agregarVendedor(nuevo.getNombre(), nuevo.getApellido(), 10.0);
		Assert.assertTrue(miEmpresa.agregarVenta(nueva2));
	}

	@Test
	public void obtenerComision() {
		miEmpresa.agregarVendedor(nuevo.getNombre(), nuevo.getApellido(), 10.0);
		miEmpresa.agregarVenta(nueva2);
		Double valorEsperado = 20.0;
		Double valorObtenido = miEmpresa.obtenerComisionDeTodosLosProductosVendidosPorVendedor("Armando", "Perez");
		Assert.assertEquals(valorEsperado, valorObtenido);
	}

	@Test
	public void obtenerLista() {
		miEmpresa.agregarVendedor(nuevo.getNombre(), nuevo.getApellido(), 10.0);
		miEmpresa.agregarVenta(nueva1);
		ArrayList<Servicio> listaDeServicio = new ArrayList<>();
		listaDeServicio.add((Servicio) nueva1.getDetalles());
		Assert.assertEquals(listaDeServicio, miEmpresa.obtenerListaServicios(fecha1, nuevo));
	}

	@Test
	public void eliminarVentaPorID() {
		miEmpresa.agregarVendedor(nuevo.getNombre(), nuevo.getApellido(), 10.0);
		miEmpresa.agregarVenta(nueva1);
		Long id = 20L;
		Assert.assertTrue(miEmpresa.eliminarVenta(id));
	}
}
