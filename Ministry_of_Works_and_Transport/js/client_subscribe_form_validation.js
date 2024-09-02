function validate(){

	clearErrors();
	
	//declare variables in js with the keyword var
	var valid = true;
		


// validate the last name data
var email_element = document.getElementById('email');// retrieves the input object with ID fname.
var email_regex = /^[a-zA-Z0-9_\-\.]+[@][a-z]+[\.][a-z]{2,3}$/;


// An alternative approach is:
if(!email_regex.test(email_element.value)){
	email_element.value = "";
	email_element.focus();
	// write a message directly onto the web page using the innerHTML property
	var email_err = document.getElementById('email_err');
	email_err.innerHTML = "Only letters, @ and - allowed.";		
	valid = false;
}


	
	return valid;
	
}

// This function is used to remove the error messages from the page when the user resubmits the form... e.g. if a user makes an error with fname and lname and tries to correct them both, however the system finds that there is still an error with the last name, it is important that they send the user only the error message for the last name on the second try.  To accomplish this we simply clear all the errors each time the user attempts to submit the form and the validation code will reinsert any errors which were still made on the form.
function clearErrors(){
	var errors = document.getElementsByClassName('error');
	for(var i = 0; i < errors.length; i++){
		errors[i].innerHTML = "";
	}
	
}