package poc.orm.javabrains.hibernate.repos;

import org.springframework.data.repository.CrudRepository;

import poc.orm.javabrains.hibernate.models.UserDetails;

public interface UserDetailsRepository extends CrudRepository<UserDetails, Integer>{

}
