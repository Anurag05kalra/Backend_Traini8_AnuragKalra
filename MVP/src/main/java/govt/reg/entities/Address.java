package govt.reg.entities;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {

	// Detailed Address cannot be empty
	@NotBlank(message = "Detailed Address cannot be empty!!")
	private String detailedAddress;
	
	// city  cannot be empty
	@NotBlank(message = "City cannot be empty!!")
	private String city;
	
	// state  cannot be empty
	@NotBlank(message = "State cannot be empty!!")
	private String state;
	
	// pincode must be 6 digits
	 @NotBlank
	 @Pattern(regexp = "^[0-9]{6}$", message = "Pincode must be 6 digits!!")
	    private String pincode;
}
