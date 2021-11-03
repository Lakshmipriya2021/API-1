package com.springboot1.validator;

import javax.validation.Payload;
import javax.validation.Constraint;

//@Documented
//@Constraint(validatedBy = UserDobValidator.class)
//@Retention(value =RUNTIME)
public interface UserDob {
	
	 String message();
	    Class<?>[] groups();
	    Class<? extends Payload>[] payload();

}
