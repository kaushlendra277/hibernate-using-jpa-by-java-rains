package poc.orm.javabrains.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import poc.orm.javabrains.hibernate.models.FourWheeler;
import poc.orm.javabrains.hibernate.models.TwoWheeler;
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
		try {
			UserDetails userEntity1 = UserDetails.builder()
					.username("First User")
					.description("Test description")
					.joinedDate(new Date())
					.build();
			
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleName("vehicle");	
			
			TwoWheeler bike = new TwoWheeler();
			bike.setVehicleName("bike");
			bike.setSteeringHandle("bike steering handle");
			
			FourWheeler car = new FourWheeler();
			car.setVehicleName("car");
			car.setSteeringWheel("car steering wheel");
			
			
			
			Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
			vehicles.add(vehicle);
			vehicles.add(bike);
			vehicles.add(car);
			
			userEntity1.setVvehicles(vehicles);
			// userDetailsRepository.save(userEntity1); // this is throwing Batch update returned unexpected row count
			// since above line throwing exception we are persisting vehicle entity
			vehicleRepository.save(vehicle);  
			vehicleRepository.save(bike);
			vehicleRepository.save(car);
			
		}catch(Exception e) {
			throw e;
		}
		
	}

}
