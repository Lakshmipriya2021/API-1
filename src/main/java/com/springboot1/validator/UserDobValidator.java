package com.springboot1.validator;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.fasterxml.jackson.databind.deser.std.UntypedObjectDeserializer;

public abstract class UserDobValidator  implements ConstraintValidator<UserDob, LocalDate> {
	
	@Override
	public boolean isValid(LocalDate dob ,ConstraintValidatorContext constraintValidatorContext ) {
	/*	Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");  
	    String strDate = formatter.format(dob);  
	    if(!strDate.matches("^\\d{2}-\\d{2}-\\d{4}$")){
	    	return false;
	    }
	  if(Date.parse(strDate).before(Date.valueOf(LocalDate.now())))
	    {
	    	return false;
	    }
	    return true;*/
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yyyy");
		Boolean b= Boolean.parseBoolean(formatter.format(dob));
		if(b) {
			return true;
		}
		return false;
		
		
	}	
}
