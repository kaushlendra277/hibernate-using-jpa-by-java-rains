package poc.orm.javabrains.hibernate.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.ToString;

@ToString
@MappedSuperclass //Designates a class whose mapping information is appliedto the entities that inherit from it. 
				  // A mapped superclasshas no separate table defined for it. 
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vehicle_id")
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
