package poc.orm.javabrains.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import poc.orm.javabrains.hibernate.models.Address;
import poc.orm.javabrains.hibernate.models.UserDetails;
import poc.orm.javabrains.hibernate.repos.UserDetailsRepository;

@SpringBootApplication
public class HibernateByJavaBrainsApplication implements CommandLineRunner {

	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateByJavaBrainsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Address homeAddress = new Address();
		homeAddress.setCity("Pune");
		homeAddress.setPincode("411057");
		homeAddress.setState("MH");
		homeAddress.setStreet("Thergaon");
		
		Address officeAddress = new Address();
		officeAddress.setCity("Gwalior");
		officeAddress.setPincode("474006");
		officeAddress.setState("MP");
		officeAddress.setStreet("Pinto Park 2");
		
		Set<Address> setOfAddresses = new HashSet<Address>();
		setOfAddresses.add(homeAddress);
		setOfAddresses.add(officeAddress);
		
		UserDetails entity = UserDetails.builder()
				.userId(1)
				.username("First User")
				.setOfAddresses(setOfAddresses)
				.description("Test description")
				.joinedDate(new Date())
				.build();
		System.out.println(entity);
		userDetailsRepository.save(entity);
	}

}
