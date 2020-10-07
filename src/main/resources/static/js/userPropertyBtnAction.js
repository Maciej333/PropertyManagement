$(document).ready(function(){
	if( ($("#defineDisplay").text()) == 'current'){
    	$("#associationTitle").text('Ogłoszenia');
		$("#announcementShowDiv").show();
		$("#managersShowDiv").hide();
		$(".current").addClass("active");
	    }  
    if( ($("#defineDisplay").text()) == "all"){
    	$("#associationTitle").text('Ogłoszenia');
		$("#announcementShowDiv").show();
		$("#managersShowDiv").hide();
		$(".all").addClass("active");
    } 
    if( ($("#defineDisplay").text()) == 'previous'){
    	$("#associationTitle").text('Ogłoszenia');
		$("#announcementShowDiv").show();
		$("#managersShowDiv").hide();
		$(".previous").addClass("active");
    }
    if( ($("#defineDisplay").text()) == 'managers'){
    	$("#associationTitle").text('Zarząd');
		$("#announcementShowDiv").hide();
		$("#managersShowDiv").show();
		$(".info").hide();
		$(".managersBtn").addClass("active");
    }
});