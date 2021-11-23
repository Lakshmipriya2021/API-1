package com.springboot1.validator;

import java.time.LocalDate;
import java.sql.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserDobValidator  implements ConstraintValidator<UserDob, String> {
	
	@Override
	public boolean isValid(String dob ,ConstraintValidatorContext constraintValidatorContext ) {
		
		LocalDate dates=LocalDate.of(Integer.parseInt(dob.substring(6)),
				Integer.parseInt(dob.substring(3,5)), Integer.parseInt(dob.substring(0,2)));
			//System.out.println(dates.toString());
		
		if(!Date.valueOf(dates).before(Date.valueOf(LocalDate.now())))
		{
			return false;
		}
		return true;
	
	}	
}
