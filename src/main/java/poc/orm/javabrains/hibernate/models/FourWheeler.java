package poc.orm.javabrains.hibernate.models;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "four_wheeler_entity")
public class FourWheeler extends Vehicle{
	private String steeringWheel;
}
