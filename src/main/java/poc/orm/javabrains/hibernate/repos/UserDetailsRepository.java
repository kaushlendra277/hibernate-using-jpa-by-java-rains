package poc.orm.javabrains.hibernate.repos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import poc.orm.javabrains.hibernate.models.UserDetails;

public interface UserDetailsRepository extends PagingAndSortingRepository<UserDetails, Integer>{

	// FROM CLAUSE - HQL/JPQL uses entity name in place of table name(as in SQL) to query the records
	// WHERE CLAUSE - HQL/JPQL uses entity field name in place of table column name(as in SQL) to query the records
	@Query("SELECT u FROM USERDETAILSENTITY u WHERE u.userId != NULL ") 
	List<UserDetails> findAllUserDetails(Pageable pageable); // on passing pageable = null it will ignore pagination
															 // on passing pageable != null it will apply pagination as per the object
	
	@Query("SELECT u.username, u.description  FROM USERDETAILSENTITY u")
	List<String[]> findUserNameAndDescriptionOfAllUserDetails();
	
	@Query("SELECT u.username, u.userId  FROM USERDETAILSENTITY u")
	// Here we use Object[] Since username is String but userId is int
	// String[] will also work but we might need to parse userId to integer
	List<Object[]> findUserNameAndUserIdOfAllUserDetails();
	
	// [NOTWORKING]
	// @Query("SELECT map(u.userId, u.username)  FROM USERDETAILSENTITY u")
	// List<Map<Integer, String>> findMapOfUserIdAndUserNameOfAllUserDetails();
	
	
}
