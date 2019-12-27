package poc.orm.javabrains.hibernate;

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
	public void run(String... args) throws Exception {
		Vehicle vehicleEntity = new Vehicle();
		vehicleEntity.setVehicleName("car");
		vehicleEntity = vehicleRepository.save(vehicleEntity);
		
		UserDetails userEntity = UserDetails.builder()
				.username("First User")
				.description("Test description")
				.joinedDate(new Date())
				.vehicle(vehicleEntity)
				.build();
		System.out.println(userEntity);
		userEntity = userDetailsRepository.save(userEntity);
		
		userEntity = userDetailsRepository.findById(userEntity.getUserId()).get();
		System.out.println(userEntity);
	}

}
