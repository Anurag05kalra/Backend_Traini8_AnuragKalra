package govt.reg.entities;

import java.time.Instant;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Column;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "training_centers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TrainingCenters {
	
	 // Primary Key with Auto-Generated Value
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tid")
	private Long id;
	
	// Max Length of center name is 40
	
	@NotBlank(message="CenterName can not be empty!!")
	@Size(max = 40 , message = "Center name must be less than 40 characters!!")
	private String centerName;
	
	@NotBlank(message = "CenterCode can not be empty!!")
	@Pattern(regexp = "^[a-zA-Z0-9]{5,12}$", message = "CenterCode should be between 5 to 12 alphanumeric characters")
	private String centerCode;

	
	// Embedded Address entity
	@Embedded
	@Valid
	private Address address;
	
	// Minimum student capacity at least 1
	@Min(value = 1 , message = "Student capacity should be at least 1")
	private Integer studentCapacity;
	
	
	
	@JsonIgnore
	 @Column(name = "courses_offered", columnDefinition = "TEXT")
	    private String coursesOfferedJson;
	
	 
        // Timestamp for when the entity is created (auto-set)
	@Column(nullable = false, updatable = false)
	private Long createdOn;
	
	// valid email format
	@Email(message = "Invalid Email format!!")
	private String contactEmail;
	
	// contact phone must be exactly 10 digits
	@Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
	private String contactPhone;
	
	@PrePersist            // Auto-set before saving
	protected void onCreate() {        
		this.createdOn = Instant.now().toEpochMilli();  // Current Epoch time (milliseconds)
	}
	
	// Getter for Course Offered
	public List<String> getCoursesOffered() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(coursesOfferedJson, List.class);
        } catch (Exception e) {
            return null;  
        }
    }

	// Setter for Course Offered
    public void setCoursesOffered(List<String> courses) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            this.coursesOfferedJson = objectMapper.writeValueAsString(courses);
        } catch (JsonProcessingException e) {
            this.coursesOfferedJson = "[]"; 
        }
    }

}
