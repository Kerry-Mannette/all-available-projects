function validate(){

	clearErrors();
	
	//declare variables in js with the keyword var
	var valid = true;
		

	// validate the last name data
	var name_element = document.getElementById('name');// retrieves the input object with ID dpnumber.
	var name_regex = /^[a-zA-Z '-]{2,40}$/;


	// An alternative approach is:
	if(!name_regex.test(name_element.value)){
		name_element.value = "";
		name_element.focus();
		// write a message directly onto the web page using the innerHTML property
		var name_err = document.getElementById('name_err');
		name_err.innerHTML = "Name may only contain letters and ('-).";		
		valid = false;
	}


	// validate the last name data
	var dpnumber_element = document.getElementById('dpnumber');// retrieves the input object with ID dpnumber.
	var dpnumber_regex = /^[0-9]{2,7}$/;

	// An alternative approach is:
	if(!dpnumber_regex.test(dpnumber_element.value)){
		dpnumber_element.value = "";
		dpnumber_element.focus();
		// write a message directly onto the web page using the innerHTML property
		var dpnumber_err = document.getElementById('dpnumber_err');
		dpnumber_err.innerHTML = "Driver permit number may only contain numeric no more than seven digits long";		
		valid = false;
	}

   
		// validate the last name data
		var date_element = document.getElementById('date');// retrieves the input object with ID dpnumber.
		var date_regex = /^[0-9-]{2,10}$/;
	
	
		// An alternative approach is:
		if(!date_regex.test(date_element.value)){
			date_element.value = "";
		    date_element.focus();
			// write a message directly onto the web page using the innerHTML property
			var date_err = document.getElementById('date_err');
			date_err.innerHTML = "Date may only contain numerica and (-).";		
			valid = false;
		}




// validate the last name data
var time_element = document.getElementById('time');// retrieves the input object with ID dpnumber.
var time_regex = /^[0-9:]{2,8}$/;


// An alternative approach is:
if(!time_regex.test(time_element.value)){
	time_element.value = "";
	time_element.focus();
	// write a message directly onto the web page using the innerHTML property
	var time_err = document.getElementById('time_err');
	time_err.innerHTML = "Time only contain numeric and (:).";		
	valid = false;
}


	
	return valid;
	
}

// This function is used to remove the error messages from the page when the user resubmits the form... e.g. if a user makes an error with dpnumber and date and tries to correct them both, however the system finds that there is still an error with the last name, it is important that they send the user only the error message for the last name on the second try.  To accomplish this we simply clear all the errors each time the user attempts to submit the form and the validation code will reinsert any errors which were still made on the form.
function clearErrors(){
	var errors = document.getElementsByClassName('error');
	for(var i = 0; i < errors.length; i++){
		errors[i].innerHTML = "";
	}
	
}