package poc.orm.javabrains.hibernate.models;

import javax.persistence.Column;
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
		strategy = InheritanceType.TABLE_PER_CLASS // table stratgy for inhertence implementtion
		// For Table_per_class strategy there will be 1 table per entity ie. parent entity will have one eparate table
		// and all childs will have a separate tables 
		// columns - Parent entity column will have only parent specific columns,
		//		   - Child entity will have parent columns + child's own specific columns
		//***********************/
		/*
		 * Advantage of TABLE_PER_CLASS over SINGLE_TABLE strategy
		 * - No need of Dtype column i.e less configuration
		 * - TABLE_PER_CLASS in more normalised than SINGLE_TABLE as it contains only child specific columns, w/h SINGLE_TABLE has all columns in one table
		 * */
		//***********************/
		)
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
