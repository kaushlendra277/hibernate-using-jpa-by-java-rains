package poc.orm.javabrains.hibernate.models;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.ToString;

@ToString
@Entity(name = "vehicle_entity")
@Table(name = "vehicle")
@Inheritance( // OPTIONAL , 
			  // use this if we want to configure or change default implemention of  inheritence in ORM
		strategy = InheritanceType.SINGLE_TABLE // table stratgy for inhertence implementtion
		)
@DiscriminatorColumn( // OPTIONAL,
					  // use this to configure dtype column of single-table-stategy
		name = "vehicle_type" // dtype column name of single able strategy
		)
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vehicleId;
	private String vehicleName;
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
}
