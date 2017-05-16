package pl.zdunek.myapp.repository.entity;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import pl.zdunek.myapp.domain.entity.Show;


/**
 * Spring Data JPA repository for the Show entity.
 */
public interface ShowRepository extends JpaRepository<Show, Integer> {
	
	@Query(value = "SELECT * FROM shows where theater_name = :theaterName", nativeQuery = true)
	List<Show> findByTheaterName(@Param(value = "theaterName")String theaterName);
	

	
}