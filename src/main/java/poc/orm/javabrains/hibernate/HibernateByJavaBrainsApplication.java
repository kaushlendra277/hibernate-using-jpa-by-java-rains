package poc.orm.javabrains.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import poc.orm.javabrains.hibernate.models.UserDetails;
import poc.orm.javabrains.hibernate.models.Vehicle;
import poc.orm.javabrains.hibernate.repos.UserDetailsRepository;
import poc.orm.javabrains.hibernate.repos.VehicleRepository;

@SpringBootApplication
public class HibernateByJavaBrainsApplication implements CommandLineRunner {

	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HibernateByJavaBrainsApplication.class, args);
	}

	@Override
	// This is required to fetch Vehicle Lazy (but why ?)
	// @Transactional 
	// alternave of @Transactional, we can enable spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
	public void run(String... args) throws Exception {
		UserDetails userEntity = UserDetails.builder()
				.username("First User")
				.description("Test description")
				.joinedDate(new Date())
				.build();
		
		Vehicle vehicleEntity1 = new Vehicle();
		vehicleEntity1.setVehicleName("car");	
		
		Vehicle vehicleEntity2 = new Vehicle();
		vehicleEntity2.setVehicleName("jeep");
		
		Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
		vehicles.add(vehicleEntity1);
		vehicles.add(vehicleEntity2);
		
		userEntity.setVvehicles(vehicles);
		vehicleRepository.save(vehicleEntity1);
		vehicleRepository.save(vehicleEntity2);
		userDetailsRepository.save(userEntity);
		
	}

}
