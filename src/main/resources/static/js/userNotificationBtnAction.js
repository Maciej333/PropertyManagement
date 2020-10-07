$(document).ready(function(){
	if( ($("#defineDisplay").text()) == 'response'){
		$(".responseNotif").addClass("active");
	}  
	    
    if( ($("#defineDisplay").text()) == "sent"){
		$(".sentNotif").addClass("active");
    } 
    
    if( ($("#defineDisplay").text()) == 'all'){
		$(".allNotif").addClass("active");
    }
    
    if( ($("#defineDisplay").text()) == 'new'){
		$(".info").hide();
		$(".newNotif").addClass("active");
    }
});