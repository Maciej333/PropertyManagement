$(document).ready(function(){
	if( ($("#defineDisplay").text()) == 'userInfo'){
    	$(".userInfo").show();
    	$(".userOnButton").show();
    	$(".userEdit").hide();
    	$(".userPassword").hide();
	    }  
    if( ($("#defineDisplay").text()) == "userEdit"){
    	$(".userInfo").hide();
    	$(".userOnButton").hide();
    	$(".userEdit").show();
    	$(".userPassword").hide();
    } 
    if( ($("#defineDisplay").text()) == 'userPassword'){
    	$(".userInfo").hide();
    	$(".userOnButton").hide();
    	$(".userEdit").hide();
    	$(".userPassword").show();
    }

});