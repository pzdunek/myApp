package pl.zdunek.myapp.repository.entity;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import pl.zdunek.myapp.domain.entity.Theater;


/**
 * Spring Data JPA repository for the User entity.
 */
public interface TheaterRepository extends JpaRepository<Theater, String> {
	

}