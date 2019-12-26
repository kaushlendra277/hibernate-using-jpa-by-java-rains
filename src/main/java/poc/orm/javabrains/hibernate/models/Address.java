package poc.orm.javabrains.hibernate.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.ToString;

@Embeddable
@ToString
public class Address {
	@Column(name = "street_name")
	private String street;
	@Column(name = "city_name")
	private String city;
	@Column(name = "state_name")
	private String state;
	private String pincode;
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
}
