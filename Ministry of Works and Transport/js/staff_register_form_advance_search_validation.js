function validate(){

	clearErrors();
	
	//declare variables in js with the keyword var
	var valid = true;
		

	// validate the last name data
	var fname_element = document.getElementById('fname');// retrieves the input object with ID fname.
	var fname_regex = /^[a-zA-Z']{2,15}$/;

	// An alternative approach is:
	if(!fname_regex.test(fname_element.value)){
		fname_element.value = "";
		fname_element.focus();
		// write a message directly onto the web page using the innerHTML property
		var fname_err = document.getElementById('fname_err');
		fname_err.innerHTML = "First name may only contain letters and (').";		
		valid = false;
	}

   
		// validate the last name data
		var lname_element = document.getElementById('lname');// retrieves the input object with ID fname.
		var lname_regex = /^[a-zA-Z']{2,15}$/;
	
	
		// An alternative approach is:
		if(!lname_regex.test(lname_element.value)){
			lname_element.value = "";
		    lname_element.focus();
			// write a message directly onto the web page using the innerHTML property
			var lname_err = document.getElementById('lname_err');
			lname_err.innerHTML = "Last name may only contain letters and (').";		
			valid = false;
		}




// validate the last name data
var lnumber_element = document.getElementById('lnumber');// retrieves the input object with ID fname.
var lnumber_regex = /^[0-9]{2,7}$/;


// An alternative approach is:
if(!lnumber_regex.test(lnumber_element.value)){
	lnumber_element.value = "";
	lnumber_element.focus();
	// write a message directly onto the web page using the innerHTML property
	var lnumber_err = document.getElementById('lnumber_err');
	lnumber_err.innerHTML = "License number may only contain numberic.";		
	valid = false;
}


	
	return valid;
	
}

// This function is used to remove the error messages from the page when the user resubmits the form... e.g. if a user makes an error with fname and lname and tries to correct them both, however the system finds that there is still an error with the last name, it is important that they send the user only the error message for the last name on the second try.  To accomplish this we simply clear all the errors each time the user attempts to submit the form and the validation code will reinsert any errors which were still made on the form.
function clearErrors(){
	var errors = document.getElementsByClassName('error_validation');
	for(var i = 0; i < errors.length; i++){
		errors[i].innerHTML = "";
	}
	
}