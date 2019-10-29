package pb2.empresa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Producto extends Item {
	private Double precio;

	public Producto(Long id, String descripcion, Double precio) {
		super(id, descripcion);
		this.precio = precio;
	}

}
