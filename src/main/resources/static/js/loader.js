

$('#load-button').click(function(){
	
	$('body').addClass("loader");
	$('body').addClass("position-loader");
	$('.deposit-menu').addClass("blur");
	$('a').addClass("blur");
	$('.alert').addClass("blur");
});


$('#change-button').click(function(){
	$('.form-control').removeAttr("readonly");
	$('#update-button').removeAttr("disabled");
});


function disError(){
	
	$('#warn-al').fadeIn();
}

