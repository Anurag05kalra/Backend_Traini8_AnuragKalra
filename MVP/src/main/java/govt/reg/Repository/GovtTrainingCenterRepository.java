package govt.reg.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import govt.reg.entities.TrainingCenters;

@Repository
public interface GovtTrainingCenterRepository extends JpaRepository<TrainingCenters, Long> {

}
