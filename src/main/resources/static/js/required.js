
 function showPassword(){
	 
	 var pass = document.getElementById('pwd');
	 
	 if(pass.type === "password"){
		 pass.type = "text";
	 }else{
		 pass.type = "password";
	 }
	 
 }
 
 
 $('#phn').val(function(i,text){
	 return text.replace(/(\d{3})(\d{3})(\d{3})/, '$1 $2 $3');
	 
 });
 
 
 function checkNames(){
	 
	 var firstName = $('#first').val();
	 var lastName = $('#last').val();
	 
	 if(firstName === lastName){
		 
		 alert("Your first name can't be same as last name");
		 
		 $('#last').val(" ");
		 
		 $('#btn-register').attr("disabled", "disabled");
		 
	 }
	 
 }
 

 
 
 
 
 

 
 
 function disappearErrors(){
	 
	 $('.err').fadeOut("medium");
	 
 }
	
 