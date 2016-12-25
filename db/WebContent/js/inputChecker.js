function isSsnString(ssn) {
	var re = /^[0-9a-zA-Z_]*$/;
	if (re.test(ssn))
		return true;
	else
		return false;
}

function isNumber(ssn) {
	var re = /^[0-9]*$/;
	if (re.test(ssn))
		return true;
	else
		return false;
}

function isNum(s) {
	 //var regu = "^([0-9]*)$";
	 var regu = "^([0-9]*[.0-9])$"; // decimal testing
	 var re = new RegExp(regu);
	 if (s.search(re) != -1)
	  return true;
	 else
	  return false;
	}