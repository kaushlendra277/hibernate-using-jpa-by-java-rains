package poc.orm.javabrains.hibernate.repos;

import org.springframework.data.repository.CrudRepository;

import poc.orm.javabrains.hibernate.models.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

}
