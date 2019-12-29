package poc.orm.javabrains.hibernate.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "four_wheeler_entity")
@DiscriminatorValue(value = "four_wheeler_veh_type")
public class FourWheeler extends Vehicle{
	
	private String steeringWheel;
}
