package pl.zdunek.myapp.repository.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pl.zdunek.myapp.domain.entity.InitHall;




public interface InitHallRepository extends JpaRepository<InitHall, Integer> {

//	@Query(value = "select * from init_hall", nativeQuery = true)
	List<InitHall> findAllByTheaterName(String theaterName);
}
