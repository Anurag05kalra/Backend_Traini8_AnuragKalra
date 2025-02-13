package govt.reg.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import govt.reg.Repository.GovtTrainingCenterRepository;
import govt.reg.entities.TrainingCenters;

@Service
public class GovtTrainingCenterService {
	
	
	private final GovtTrainingCenterRepository govtTrainingCenterRepository;
	
	public GovtTrainingCenterService(GovtTrainingCenterRepository govtTrainingCenterRepository) {
		this.govtTrainingCenterRepository = govtTrainingCenterRepository;
	}
	//Saves a new training center to the database.
	public TrainingCenters createTrainingCenters(TrainingCenters trainingCenters) {
	    return govtTrainingCenterRepository.save(trainingCenters);
	}
	
	//Fetches all training centers from the database.
	public List<TrainingCenters> getAllTrainingCenters(){
		return govtTrainingCenterRepository.findAll();
	}

}
