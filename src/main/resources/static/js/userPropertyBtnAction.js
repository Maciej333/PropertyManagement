$(document).ready(function(){
	if( ($("#defineDisplay").text()) == 'current'){
    	$("#associationTitle").text('Ogłoszenia');
		$("#announcementShowDiv").show();
		$(".current").addClass("active");
	    }  
    if( ($("#defineDisplay").text()) == "all"){
    	$("#associationTitle").text('Ogłoszenia');
		$("#announcementShowDiv").show();
		$(".all").addClass("active");
    } 
    if( ($("#defineDisplay").text()) == 'previous'){
    	$("#associationTitle").text('Ogłoszenia');
		$("#announcementShowDiv").show();
		$(".previous").addClass("active");
    }

});