function validate(){

	clearErrors();
	
	//declare variables in js with the keyword var
	var valid = true;
		

	// validate the last name data
	var uname_element = document.getElementById('uname');// retrieves the input object with ID rfname.
	var uname_regex = /^[0-9a-zA-Z]{2,15}$/;


	// An alternative approach is:
	if(!uname_regex.test(uname_element.value)){
		uname_element.value = "";
		uname_element.focus();
		// write a message directly onto the web page using the innerHTML property
		var uname_err = document.getElementById('uname_err');
		uname_err.innerHTML = "User name may only contain alphanumeric.";		
		valid = false;
	}




	// validate the last name data
	var email_element = document.getElementById('email');// retrieves the input object with ID remail.
	var email_regex = /^[a-zA-Z0-9_\-\.]+[@][a-z]+[\.][a-z]{2,3}$/;

	// An alternative approach is:
	if(!email_regex.test(remail_element.value)){
		email_element.value = "";
		email_element.focus();
		// write a message directly onto the web page using the innerHTML property
		var email_err = document.getElementById('email_err');
		 email_err.innerHTML = "fname may only contain alphanumeric and (_-.@).";		
		valid = false;
	}




   
		// validate the last name data
		var password_element = document.getElementById('password');// retrieves the input object with ID rfname.
		var password_regex = /^[0-9a-zA-Z@$#_-]{2,30}$/;
	
	
		// An alternative approach is:
		if(!password_regex.test(password_element.value)){
			password_element.value = "";
		    password_element.focus();
			// write a message directly onto the web page using the innerHTML property
			var password_err = document.getElementById('password_err');
			password_err.innerHTML = "Password may only contain alphanumeric and (@#_-).";		
			valid = false;
		}


	// validate the last name data
    var cpassword_element = document.getElementById('cpassword');// retrieves the input object with ID rfname.
    var cpassword_regex = /^[0-9a-zA-Z@$#_-]{2,30}$/;


    // An alternative approach is:
    if(!cpassword_regex.test(cpassword_element.value)){
        cpassword_element.value = "";
        cpassword_element.focus();
        // write a message directly onto the web page using the innerHTML property
        var cpassword_err = document.getElementById('cpassword_err');
        cpassword_err.innerHTML = "Password may only contain alphanumeric and (@#_-).";		
        valid = false;
    }




// validate the last name data
var pnumber_element = document.getElementById('pnumber');// retrieves the input object with ID rpnumber.
var pnumber_regex = /^[0-9+-]{2,13}$/;


// An alternative approach is:
if(!pnumber_regex.test(pnumber_element.value)){
	pnumber_element.value = "";
	pnumber_element.focus();
	// write a message directly onto the web page using the innerHTML property
	var fname_err = document.getElementById('fname_err');
	fname_err.innerHTML = "Phone number may only contain numeric and (-).";		
	valid = false;
}







	
	return valid;
	
}

// This function is used to remove the error messages from the page when the user resubmits the form... e.g. if a user makes an error with rfname and password and tries to correct them both, however the system finds that there is still an error with the last name, it is important that they send the user only the error message for the last name on the second try.  To accomplish this we simply clear all the errors each time the user attempts to submit the form and the validation code will reinsert any errors which were still made on the form.
function clearErrors(){
	var errors = document.getElementsByClassName('error');
	for(var i = 0; i < errors.length; i++){
		errors[i].innerHTML = "";
	}
	
}