package com.security.demo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Integer> {

	@Query("select u from User u where u.email = ?1")
	User findByEmail(String id);
}
