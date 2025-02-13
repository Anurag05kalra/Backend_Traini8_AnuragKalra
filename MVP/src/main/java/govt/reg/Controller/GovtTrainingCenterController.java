package govt.reg.Controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import govt.reg.Service.GovtTrainingCenterService;
import govt.reg.entities.TrainingCenters;
import jakarta.validation.Valid;

//REST Controller to handle requests related to Training Centers
@RestController
@RequestMapping("/training-center")
public class GovtTrainingCenterController {
	
	// business logic processing
	private final GovtTrainingCenterService service;
	
	public GovtTrainingCenterController(GovtTrainingCenterService service) {
		this.service = service;
	}
	
	// Post Mapping -> create a new training center
	@PostMapping
	public ResponseEntity<TrainingCenters> createTrainingCenter(@Valid @RequestBody TrainingCenters trainingCenters){
		
		TrainingCenters center = service.createTrainingCenters(trainingCenters);
		return ResponseEntity.ok(center);
	}
	// Get Mapping -> Fetch all available training center
	@GetMapping("/all")
	public ResponseEntity<List<TrainingCenters>> getAllTrainingCenters(){
		List<TrainingCenters> list = service.getAllTrainingCenters();
		return ResponseEntity.ok(list);
	}
	
	
}
