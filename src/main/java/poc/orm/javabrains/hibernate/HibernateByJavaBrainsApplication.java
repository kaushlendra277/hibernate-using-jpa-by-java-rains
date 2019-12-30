package poc.orm.javabrains.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
	// This is required to fetch Vehicle Lazy (but why ?)
	// @Transactional 
	// alternave of @Transactional, we can enable spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
	public void run(String... args) throws Exception {
		// creating records
		persist();
		
		// get User's all column values(i.e. SELECT * ) using HQL in @Query 
		System.out.println("SELECT * ");
		List<UserDetails> users = userDetailsRepository.findAllUserDetails(null);
		System.out.println(users.size());
		System.out.println(users);
		
		// Pagination
		System.out.println("SELECT * with pagination");
		Pageable pageable = PageRequest.of(0, 5);
		users = userDetailsRepository.findAllUserDetails(pageable);
		System.out.println(users.size());
		System.out.println(users);
		
		pageable = PageRequest.of(1, 5);
		users = userDetailsRepository.findAllUserDetails(pageable);
		System.out.println(users.size());
		System.out.println(users);
		
		// SELECT <selected-columns-with-same-type>
		System.out.println("SELECT u.username, u.description");
		List<String[]> selectedColumns = userDetailsRepository.findUserNameAndDescriptionOfAllUserDetails();
		selectedColumns.forEach(s -> System.out.println("username - "+s[0]+" description - " + s[1]));
		
		// SELECT <selected-columns-with-different-type>
		System.out.println("SELECT u.username, u.description");
		List<Object[]> selectedColumns2 = userDetailsRepository.findUserNameAndUserIdOfAllUserDetails();
		selectedColumns2.forEach(s -> System.out.println("username datatype - "+s[0].getClass().getName()+" userId datatype - " + s[1].getClass().getName()));
		selectedColumns2.forEach(s -> System.out.println("username - "+s[0]+" userId - " + s[1]));
		
		// Parameter Binding / Parameter subsitution
		// SELECT User By User Id
		System.out.println("SELECT User By User Id");
		UserDetails user = userDetailsRepository.findUserDetailsByUserId(users.get(0).getUserId());
		System.out.println(user);
		
		// [NOTWORKING]
		/*
		// SELECT Columns as Map datastucture 
		System.out.println("SELECT map(u.userId, u.username) ");
		List<Map<Integer, String>> selectedColumnsMap = userDetailsRepository.findMapOfUserIdAndUserNameOfAllUserDetails();
		System.out.println(selectedColumnsMap);
		*/
	}

	
	private void persist() throws Exception {
		try {
			List<UserDetails> userEntities = new ArrayList<UserDetails>();
			for(int i = 1; i<=10; i++) {
			
				UserDetails userEntity = UserDetails.builder()
						.username("First User "+i)
						.description("Test description")
						.joinedDate(new Date())
						.build();
				userEntities.add(userEntity);
			}
			
			userDetailsRepository.saveAll(userEntities);
			
		}catch(Exception e) {
			throw e;
		}
	}

}
