package pb2.empresa;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Venta {
	private Long idVenta;
	private Date fecha;
	private Integer cantidad;
	private Vendedor vendedor;
	private Item detalles;

}
