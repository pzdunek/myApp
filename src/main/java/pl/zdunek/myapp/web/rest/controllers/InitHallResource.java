package pl.zdunek.myapp.web.rest.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.zdunek.myapp.domain.entity.InitHall;

import pl.zdunek.myapp.repository.entity.InitHallRepository;

@RestController
@RequestMapping("/api")
public class InitHallResource {

	@Inject
	private InitHallRepository inithallRepository;
	
	private final Logger log = LoggerFactory.getLogger(InitHall.class);
	
	@GetMapping("/initHall")
	public Map<String, List> getInitHall(@RequestParam String theaterName) {
		
		log.debug("REST request to get initial seats");
		
		List<InitHall> colsAndRowsOfTheater = inithallRepository.findAllByTheaterName(theaterName);
		List<String> onlyRows = colsAndRowsOfTheater.stream().map(r -> r.getRowChar()).filter(f -> f.matches("[A-O]")).collect(Collectors.toList());
		List<Integer> onlyCols = colsAndRowsOfTheater.stream().map(c -> c.getColNumber()).filter(f -> f>0).collect(Collectors.toList());
		Map<String, List> toReturn = new HashMap<>();
		toReturn.put("rows", onlyRows);
		toReturn.put("cols", onlyCols);
		//		List<Theater> theaterObjects = theaterRepository.findAll();
//		List<String> onlyTheater = theaterObjects.stream().map(t -> t.getTheaterName()).collect(Collectors.toList());
		return toReturn;
	}
}
