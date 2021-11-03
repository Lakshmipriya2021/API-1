package com.springboot1.validator;

import java.sql.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.springboot1.model.User;

public class UserDobValidator  implements ConstraintValidator<dob, String> {
	
	User user;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		
		if(Date.valueOf(user.getDob()).b)
		return false;
	}
	
		

}
