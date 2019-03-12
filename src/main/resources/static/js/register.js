var message = [[${saved}]];

 if(message){
	 $('#first').val("");
	 $('#last').val("");
	 $('#phn').val("");
	 $('#pwd').val("");
	 $('#usrn').val("");
	 $('#email').val("");
	 
	 $('#first').removeAttr("required");
	 $('#last').removeAttr("required");
	 $('#phn').removeAttr("required");
	 $('#pwd').removeAttr("required");
	 $('#usrn').removeAttr("required");
	 $('#email').removeAttr("required");
	 
 }