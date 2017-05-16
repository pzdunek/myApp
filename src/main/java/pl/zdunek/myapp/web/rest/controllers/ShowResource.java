package pl.zdunek.myapp.web.rest.controllers;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.zdunek.myapp.domain.entity.Movie;
import pl.zdunek.myapp.domain.entity.Show;
import pl.zdunek.myapp.repository.entity.ShowRepository;

/**
 * REST controller for managing users.
 *
 */

@RestController
@RequestMapping("/api")
public class ShowResource {

	@Inject
	private ShowRepository showRepository; 
   
	private final Logger log = LoggerFactory.getLogger(Show.class);
	
	@GetMapping(path = "/shows",  params = {"theaterName"})
	public List<Show> getAllShowsByTheaterName(@RequestParam String theaterName) {
		
		log.debug("REST request to get all movies from chosen theater");
		List<Show> shows = showRepository.findByTheaterName(theaterName);
		
		
//		List<String> onlyTheater = theaterObjects.stream().map(t -> t.getTheaterName()).collect(Collectors.toList());
		
		
		return shows;
	}
   
}
