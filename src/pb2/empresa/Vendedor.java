package pb2.empresa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Vendedor {
	private String nombre;
	private String apellido;
	private Double porcentajeComision;
}
