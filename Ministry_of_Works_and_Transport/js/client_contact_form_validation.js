function validate(){

	clearErrors();
	
	//declare variables in js with the keyword var
	var valid = true;
		

	// validate the last name data
	var name_element = document.getElementById('name');// retrieves the input object with ID subject.
	var name_regex = /^[a-zA-Z' ]{2,20}$/;


	// An alternative approach is:
	if(!name_regex.test(name_element.value)){
		name_element.value = "";
		name_element.focus();
		// write a message directly onto the web page using the innerHTML property
		var name_err = document.getElementById('name_err');
		name_err.innerHTML = "Name may only contain letter and (').";		
		valid = false;
	}



	// validate the last name data
	var subject_element = document.getElementById('subject');// retrieves the input object with ID subject.
	var subject_regex = /[a-zA-Z ]{2,30}$/;

	// An alternative approach is:
	if(!subject_regex.test(subject_element.value)){
		subject_element.value = "";
		subject_element.focus();
		// write a message directly onto the web page using the innerHTML property
		var fn_err = document.getElementById('subject_err');
		fn_err.innerHTML = "Subject may only contain letters";		
		valid = false;
	}


    // validate the last name data
    var email_element = document.getElementById('email');// retrieves the input object with ID subject.
    var email_regex = /^[a-zA-Z0-9_\-\.]+[@][a-z]+[\.][a-z]{2,3}$/;


    // An alternative approach is:
 if(!email_regex.test(email_element.value)){
	email_element.value = "";
	email_element.focus();
	// write a message directly onto the web page using the innerHTML property
	var email_err = document.getElementById('email_err');
	email_err.innerHTML = "Email ' ! and -";		
	valid = false;
}

   
		// validate the last name data
		var message_element = document.getElementById('message');// retrieves the input object with ID subject.
		var message_regex = /^[a-zA-Z-.' ]{2,400}$/;
	
	
		// An alternative approach is:
		if(!message_regex.test(message_element.value)){
			message_element.value = "";
		    message_element.focus();
			// write a message directly onto the web page using the innerHTML property
			var ln_err = document.getElementById('message_err');
			ln_err.innerHTML = "Message may only contain letters and (-')";		
			valid = false;
		}






	
	return valid;
	
}

// This function is used to remove the error messages from the page when the user resubmits the form... e.g. if a user makes an error with subject and message and tries to correct them both, however the system finds that there is still an error with the last name, it is important that they send the user only the error message for the last name on the second try.  To accomplish this we simply clear all the errors each time the user attempts to submit the form and the validation code will reinsert any errors which were still made on the form.
function clearErrors(){
	var errors = document.getElementsByClassName('error');
	for(var i = 0; i < errors.length; i++){
		errors[i].innerHTML = "";
	}
	
}