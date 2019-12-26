package poc.orm.javabrains.hibernate.models;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Id // MANDATORY annotation // this without @GeneratedValue is "NATURAL PK" e.g. emailId for an employee
	@Column(name = "id") 
	@GeneratedValue(strategy = GenerationType.AUTO) // this with @Id is "SURROGATE PK" e.g. id in user table
	private int userId;
	
	@Column(name ="user_name")
	@Basic
	private String username;
	
	// @Temporal(TemporalType.DATE)// save only date as yyyy-mm-dd
	// @Temporal(TemporalType.TIME)// save only time as hh:mm:ss
	@Temporal(value =TemporalType.TIMESTAMP)// save date and time as timestamp as yyyy-mm-dd hh:mm:ss
	private Date joinedDate;
	
	@Embedded // this annotation is optional, keep for better understanding
	// @AttributeOverrides annotation is optional , and is used to override embedded column name
	// for use cases like we have two same type value(@Embeddble) type in the same entity  then this is mandatory
	@AttributeOverrides(value = {
			@AttributeOverride(name = "street", column = @Column(name = "home_street_name")),
			@AttributeOverride(name = "city", column = @Column(name = "home_city_name")),
			@AttributeOverride(name = "state", column = @Column(name = "home_state_name")),
			@AttributeOverride(name = "pincode", column = @Column(name = "home_pincode_name"))})
	private Address homeAddress;
	
	@Embedded // this annotation is optional, keep for better understanding
	// @AttributeOverrides annotation is optional , and is used to override embedded column name
	// for use cases like we have two same type value(@Embeddble) type in the same entity then this is mandatory
	@AttributeOverrides(value = {
			@AttributeOverride(name = "street", column = @Column(name = "office_street_name")),
			@AttributeOverride(name = "city", column = @Column(name = "office_city_name")),
			@AttributeOverride(name = "state", column = @Column(name = "office_state_name")),
			@AttributeOverride(name = "pincode", column = @Column(name = "office_pincode_name"))})
	private Address officeAddress;
	
	@Lob
	private String description;
}
