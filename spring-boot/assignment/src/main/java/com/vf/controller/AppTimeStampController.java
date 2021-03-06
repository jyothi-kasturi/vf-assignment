package com.vf.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.vf.entities.AppTimeStamp;
import com.vf.services.AppTimeStampService;

/**
 * Rest Controller for POST API to insert timestamp in to DB.
 * This class has GET,
 * POST, PUT, DELETE API methods
 */
@RestController
public class AppTimeStampController {

	@Autowired
	private AppTimeStampService atsService;

	// GET /timeStamps
	@GetMapping(path = "/timeStamps", produces = "application/json")
	public List<AppTimeStamp> findAll() {
		return atsService.findAll();
	}

	// GET /timeStamps/{1}
	@RequestMapping(value = "/timeStamps/{id}", produces = "application/json", method = RequestMethod.GET)
	public ResponseEntity<Optional<AppTimeStamp>> findById(@PathVariable long id) {
		try {
			return new ResponseEntity<Optional<AppTimeStamp>>(atsService.findById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Optional<AppTimeStamp>>(atsService.findById(id), HttpStatus.BAD_REQUEST);
		}
	}

	// POST /timeStamps
	@RequestMapping(value = "/timeStamps", method = { RequestMethod.POST })
	public AppTimeStamp createAppTimeStamp() {
		return atsService.save(new AppTimeStamp());
	}

	// POST /app
	@RequestMapping(value = "/app", method = { RequestMethod.POST })
	public AppTimeStamp addAppTimeStamp() {
		return atsService.save(new AppTimeStamp());
	}

	// DELTE /timeStamps/{1}
	@RequestMapping(value = "/timeStamps/{id}", method = { RequestMethod.DELETE })
	public void deleteAppTimeStamp(@PathVariable long id) {
		atsService.deleteById(id);
	}
	// TODO - PUT and Error Handling

}
