package poc.orm.javabrains.hibernate.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "USERDETAILSENTITY") // MANDATORY annnotation
@Table(name = "USERDETAILSTABLE")
public class UserDetails {

	@Id // MANDATORY annotation // this without @GeneratedValue is "NATURAL PK" e.g.
		// emailId for an employee
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO) // this with @Id is "SURROGATE PK" e.g. id in user table
	private int userId;

	@Column(name = "user_name")
	@Basic
	private String username;

	// @Temporal(TemporalType.DATE)// save only date as yyyy-mm-dd
	// @Temporal(TemporalType.TIME)// save only time as hh:mm:ss
	@Temporal(value = TemporalType.TIMESTAMP) // save date and time as timestamp as yyyy-mm-dd hh:mm:ss
	private Date joinedDate;
	
	@Lob
	private String description;
	
	
	@OneToMany(fetch = FetchType.LAZY) // 1 User many Vehicles 
			   // MANDATORY to achive relationship.
			   // It works same as @ElementCollection but use case is different
			   // @ElementCOllection works with value (@Embeddable) types where as @OneToMany works with entity (@Entity) types
			   // ****************
			   // Bydefault it will create a new table whose default name OwnerEntityTableName_OwnedEntityVariableName(USERDETAILSENTITY_vvehicles)
			   // this new table will have 2 columns , one for UserDetails PK and second for Vehicle PK
			   // Use @JoinColumn to avoid this 3rd table as shown below
			   // *************
			   // To configure table name and columns name we use @JoinTable as below
	/*
	@JoinTable( // OPTIONAL
			name = "user_vehicles", //  name of table
			joinColumns = {@JoinColumn(name = "user_id")}, // this is used to update column associated with  UserDetails PK
			inverseJoinColumns = {@JoinColumn (name = "vehicle_id")} // this is used to update column associated with  Vehicle PK
			)
			*/
	// Alternative to @JoinTable is @JoinColumn
	// We use @JoinColumn if we don't want 3rd table
	@JoinColumn(
			// IN CASE OF  @OneToMany  this will create a column in containedEntity table(Vehicle) 
			// IN CASE OF  @ManyToOne  this will create a column in containerEntity table(USERDETAILSTABLE)	
			name = "user_id") // 
	private Collection<Vehicle> vvehicles;
}
