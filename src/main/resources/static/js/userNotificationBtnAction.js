$(document).ready(function(){
	if( ($("#defineDisplay").text()) == 'new'){
		$("#notificationShowDiv").show();
		$("#newNotificationShowDiv").hide();
		$("#notificationMark").show();
		$(".responseNotif").addClass("active");
	}  
	    
    if( ($("#defineDisplay").text()) == "send"){
    	$("#notificationShowDiv").show();
		$("#newNotificationShowDiv").hide();
		$("#notificationMark").hide()
		$(".sentNotif").addClass("active");
    } 
    
    if( ($("#defineDisplay").text()) == 'all'){
    	$("#notificationShowDiv").show();
		$("#newNotificationShowDiv").hide();
		$("#notificationMark").hide()
		$(".allNotif").addClass("active");
    }
    
    if( ($("#defineDisplay").text()) == 'newNotif'){
    	$("#notificationShowDiv").hide();
		$("#newNotificationShowDiv").show();
		$(".info").hide();
		$(".newNotif").addClass("active");
    }

});