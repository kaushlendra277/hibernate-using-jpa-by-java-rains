package poc.orm.javabrains.hibernate.models;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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

	// @ElementCollection is used for collection of value (@Embeddable) types
	// it is valid for only some collection i.e. Set, List, Collection
	// @ElementCollection creates a separate table which has address info and
	// USERDETAILSENTITY PK as FK in new table
	// The @ElementCollection values are always stored in a separate table. The table
	// is defined through the @CollectionTable
	@ElementCollection(fetch = FetchType.LAZY) // Preferred over FetchType.EAGER  
	// @CollectionTable annotation is useful to give custom name to the table
	// created
	// because of @ElementCollection
	@CollectionTable( // Alternatively we can use @JoinTable but @JoinTable has different purpose
						// refer https://en.wikibooks.org/wiki/Java_Persistence/ElementCollection
			name = "user_set_address" // name of table where PK of UserDetails is FK // [Optional]
			, joinColumns = { @JoinColumn(name = "user_id") } // column name of FK // [Optional]
	)
	private Set<Address> setOfAddresses;
	
	@Lob
	private String description;
}
