package com.users.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.users.dao.UserDaoImpl;
import com.users.model.User;

@Component
public class UserValidator implements Validator {
	
	private UserDaoImpl userDaoImpl;
	@Autowired
	public UserValidator(UserDaoImpl userDaoImpl){
		this.userDaoImpl=userDaoImpl;
	}
	public boolean supports(Class<?> aClass){
		return User.class.equals(aClass);
	}

	public void validate(Object userObject, Errors errors) {
		User user=(User)userObject;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
		if(user.getUsername().length()<6||user.getUsername().length()>32){
			errors.rejectValue("username", "Size.userForm.username");
		}
		if(userDaoImpl.findByUserName(user.getUsername())!=null){
			errors.rejectValue("username", "Duplicate.userForm.username");
		}
		
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
		
	}
}
