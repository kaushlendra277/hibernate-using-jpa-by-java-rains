package poc.orm.javabrains.hibernate.models;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
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
	
	@OneToOne // MANDATORY to maintain relationship
	@JoinColumn(name = "vehicle_id") // OPTIONAL , if we want to use some name for join column
	private Vehicle vehicle;
}
