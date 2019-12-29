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
		strategy = InheritanceType.JOINED // table stratgy for inhertence implementtion
		// For JOINED strategy there will be 1 table per entity ie. parent entity will have one eparate table
		// and all childs will have a separate tables 
		// columns - Parent entity column will have only parent specific columns,
		//		   - Child entity will parenEntity PK as FK + child's own specific columns
		//***********************/
		/*
		 * Advantage of JOINED  over TABLE_PER_CLASS strategy
		 * - TABLE_PER_CLASS in more normalised than TABLE_PER_CLASS as it contains only child specific columns, w/h TABLE_PER_CLASS has all parent + child's own specific column
		 * - JOINED and  TABLE_PER_CLASS are doing the same thing but data is kept at different tables, choose as per your use case
		 * */
		//***********************/
		// This is called JOINED strategy because in order to get any child entity
		// data we need to apply join as 
		// SELECT * FROM Parent p JOIN Child c ON p.pk = c.fk;
		// This join is not required for Table-Per_class strategy
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
