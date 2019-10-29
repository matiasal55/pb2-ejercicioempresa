package pb2.empresa;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Servicio extends Item {
	private Integer cantidadHora;
	private Double precioPorHora;

	public Servicio(Long id, String descripcion, Integer cantidadHora, Double precioPorHora) {
		super(id, descripcion);
		this.cantidadHora = cantidadHora;
		this.precioPorHora = precioPorHora;
	}
	
	

}
