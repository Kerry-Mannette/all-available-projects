function validate(){

	clearErrors();
	
	//declare variables in js with the keyword var
	var valid = true;
		

	// validate the last name data
	var administrator_user_name_element = document.getElementById('administrator_user_name');// retrieves the input object with ID administrator_user_password.
	var administrator_user_name_regex = /^[a-zA-Z0-9]{2,15}$/;


	// An alternative approach is:
	if(!administrator_user_name_regex.test(administrator_user_name_element.value)){
		administrator_user_name_element.value = "";
		administrator_user_name_element.focus();
		// write a message directly onto the web page using the innerHTML property
		var administrator_user_name_err = document.getElementById('administrator_user_name_err');
		administrator_user_name_err.innerHTML = "User name may only contain alphanumeric.";		
		valid = false;
	}



	// validate the last name data
	var administrator_user_password_element = document.getElementById('administrator_user_password');// retrieves the input object with ID administrator_user_password.
	var administrator_user_password_regex = /^[a-zA-Z'!-]{2,30}$/;

	// An alternative approach is:
	if(!administrator_user_password_regex.test(administrator_user_password_element.value)){
		administrator_user_password_element.value = "";
		administrator_user_password_element.focus();
		// write a message directly onto the web page using the innerHTML property
		var administrator_user_password_element_err = document.getElementById('administrator_user_password_err');
		administrator_user_password_element_err.innerHTML = "Only letters, !,' and - allowed.";		
		valid = false;
	}

   
	
	return valid;
	
}

// This function is used to remove the error messages from the page when the user resubmits the form... e.g. if a user makes an error with administrator_user_password and lname and tries to correct them both, however the system finds that there is still an error with the last name, it is important that they send the user only the error message for the last name on the second try.  To accomplish this we simply clear all the errors each time the user attempts to submit the form and the validation code will reinsert any errors which were still made on the form.
function clearErrors(){
	var errors = document.getElementsByClassName('validation_error');
	for(var i = 0; i < errors.length; i++){
		errors[i].innerHTML = "";
	}
	
}