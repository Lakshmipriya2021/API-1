package com.springboot1.validator;

import java.time.LocalDate;
import java.sql.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public abstract class UserDobValidator  implements ConstraintValidator<UserDob, String> {
	
	 @Override
	   public void initialize(UserDob udob)
	 {
	 }
	@Override
	public boolean isValid(String dob ,ConstraintValidatorContext constraintValidatorContext ) {
		
		if(!dob.matches("^\\d{2}-\\d{2}-\\d{4}$"))
		{
			return false;
		}
		if(Date.valueOf(dob).before(Date.valueOf(LocalDate.now())))
		{
			return false;
		}
		return true;
	
	}	
}
