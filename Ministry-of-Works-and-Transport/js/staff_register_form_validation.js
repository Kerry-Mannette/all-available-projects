function validate(){

	clearErrors();
	

	var uimage = document.getElementById('uimage');
    var file_path = uimage.value;
    var file_extensions = /(\.jpg|\.png)$/;
    if(!file_extensions.exec(file_path)){
		var uimage_err = document.getElementById('uimage_err');
		uimage_err.innerHTML = "Image is required. Type allowed: (png and jpg).";
		valid = false;
    }


	// validate the last name data
	var uname_element = document.getElementById('uname');// retrieves the input object with ID remail.
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
	var remail_element = document.getElementById('remail');// retrieves the input object with ID remail.
	var remail_regex = /^[a-zA-Z0-9_\-\.]+[@][a-z]+[\.][a-z]{2,3}$/;

	// An alternative approach is:
	if(!remail_regex.test(remail_element.value)){
		remail_element.value = "";
		remail_element.focus();
		// write a message directly onto the web page using the innerHTML property
		var remail_err = document.getElementById('remail_err');
		remail_err.innerHTML = "fname may only contain alphanumeric and (_-.@).";		
		valid = false;
	}




   
		// validate the last name data
		var password_element = document.getElementById('password');// retrieves the input object with ID remail.
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
    var cpassword_element = document.getElementById('cpassword');// retrieves the input object with ID remail.
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
var fname_element = document.getElementById('fname');// retrieves the input object with ID remail.
var fname_regex = /^[a-zA-Z'-]{2,15}$/;


// An alternative approach is:
if(!fname_regex.test(fname_element.value)){
	fname_element.value = "";
	fname_element.focus();
	// write a message directly onto the web page using the innerHTML property
	var fname_err = document.getElementById('fname_err');
	fname_err.innerHTML = "First name may only contain letters and ('-).";		
	valid = false;
}



// validate the last name data
var lname_element = document.getElementById('lname');// retrieves the input object with ID rlname.
var lname_regex = /^[a-zA-Z'-]{2,15}$/;


// An alternative approach is:
if(!lname_regex.test(lname_element.value)){
	lname_element.value = "";
	lname_element.focus();
	// write a message directly onto the web page using the innerHTML property
	var lname_err = document.getElementById('lname_err');
	lname_err.innerHTML = "Last name may only contain letters and ('-).";		
	valid = false;
}





// validate the last name data
var dob_element = document.getElementById('dob');// retrieves the input object with ID rdob.
var dob_regex = /^[0-9-]{2,10}$/;


// An alternative approach is:
if(!dob_regex.test(dob_element.value)){
	dob_element.value = "";
	dob_element.focus();
	// write a message directly onto the web page using the innerHTML property
	var dob_err = document.getElementById('dob_err');
	dob_err.innerHTML = "Date of birth may only contain numeric.";		
	valid = false;
}




// validate the last name data
var lnumber_element = document.getElementById('lnumber');// retrieves the input object with ID rlnumber.
var lnumber_regex = /^[0-9]{2,7}$/;


// An alternative approach is:
if(!lnumber_regex.test(lnumber_element.value)){
	lnumber_element.value = "";
	lnumber_element.focus();
	// write a message directly onto the web page using the innerHTML property
	var lnumber_err = document.getElementById('lnumber_err');
	lnumber_err.innerHTML = "License number may only contain numeric no more than seven digits long.";		
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

// This function is used to remove the error messages from the page when the user resubmits the form... e.g. if a user makes an error with remail and password and tries to correct them both, however the system finds that there is still an error with the last name, it is important that they send the user only the error message for the last name on the second try.  To accomplish this we simply clear all the errors each time the user attempts to submit the form and the validation code will reinsert any errors which were still made on the form.
function clearErrors(){
	var errors = document.getElementsByClassName('error');
	for(var i = 0; i < errors.length; i++){
		errors[i].innerHTML = "";
	}
	
}