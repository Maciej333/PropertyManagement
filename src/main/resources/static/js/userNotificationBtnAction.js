$(document).ready(function(){
	if( ($("#defineDisplay").text()) == 'response'){
		$("#notificationShowDiv").show();
		$("#newNotificationShowDiv").hide();
		$(".responseNotif").addClass("active");
	}  
	    
    if( ($("#defineDisplay").text()) == "sent"){
    	$("#notificationShowDiv").show();
		$("#newNotificationShowDiv").hide();
		$(".sentNotif").addClass("active");
    } 
    
    if( ($("#defineDisplay").text()) == 'all'){
    	$("#notificationShowDiv").show();
		$("#newNotificationShowDiv").hide();
		$(".allNotif").addClass("active");
    }
    
    if( ($("#defineDisplay").text()) == 'new'){
    	$("#notificationShowDiv").hide();
		$("#newNotificationShowDiv").show();
		$(".info").hide();
		$(".newNotif").addClass("active");
    }
    
	$(".responseBtn").click(function(){
		$(".divToResponse").toggle();
	});
});