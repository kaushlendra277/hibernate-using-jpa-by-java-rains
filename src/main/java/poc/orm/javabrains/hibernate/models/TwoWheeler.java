package poc.orm.javabrains.hibernate.models;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "two_wheeler_entity")
/**
 * Since This entity extending another entity, this is inheritence in ORM
 * and we are Using @MappedSuperclass hence no table will be created for Parent entity
 * */
public class TwoWheeler extends Vehicle{
	private String steeringHandle;
	
}
