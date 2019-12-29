package poc.orm.javabrains.hibernate.models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "two_wheeler_entity")
/**
 * Since This entity extending another entity, this is inheritence in ORM
 * By default hibernate go for "Single Table Strategy" for implementing inheritence in ORM.
 * 
 * SINGLE TABLE INHERITENCE - 
 * *Table Name - here onle 1 table will be created whose name by default corrospond to Parent entity table name
 * *Columns - This table will have all the columns + 1 (DTYPE) corrosponding to all childs
 * 			  i.e. if if Parent has   2 field , child1 has 1 field , child2 has 1 field
 * 			  then total columns of the table will be 2(parent) + 1(child1) + 1(child2) + 1(DTYPE) = 5 
 * *DTYPE(Discriminator Type) - This colum contains entity name corrosponding to the row.
 * 				i.e. if row corrospond to parent entity dtype will have parent entity name and 
 * 				for child entity rows it will have specific child entity name as per the row
 * 
 * * use of DTYPE - as name suggest it will be used to discriminate rows as per specific entity.
 * 
 * **NOTE**: DTYPE concept is only applicable for "SINGLE TABLE STRATEGY" 
 * */
/*********************************/
/**
 *  if we want to change the default strategy for implementing inheritence in ORM.
 *  we need to use @Inheritance over the Parent Entity (as shown in Vehicle entity)
 * */
@DiscriminatorValue( // OPTIONAL,
					// use this , to change the value of DType column for this child entity
					// by default dtype column contains entity name corrosponding to the row.
		value =  "two_wheeler_veh_type"
		)
public class TwoWheeler extends Vehicle{
	private String steeringHandle;
	
}
