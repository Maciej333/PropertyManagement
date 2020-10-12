$(document).ready(function(){
	if( ($("#defineDisplay").text()) == 'userInfo'){
    	$(".infoManager").addClass("active");
    	$("#managerProperty").hide();
    	$("#managerUser").hide();
	} 
	if( ($("#defineDisplay").text()) == 'userEdit'){
    	$(".infoManager").addClass("active");
    	$("#managerProperty").hide();
    	$("#managerUser").hide();
	}  
	if( ($("#defineDisplay").text()) == 'userPassword'){
    	$(".infoManager").addClass("active");
    	$("#managerProperty").hide();
    	$("#managerUser").hide();
	}   
	if( (($("#defineDisplay").text()) == 'managerProperty') || ($("#defineDisplay").text() == 'managerPropertyEdit')){
    	$(".userInfo").hide();
    	$(".userOnButton").hide();
    	$(".userEdit").hide();
    	$(".userPassword").hide();
    	$("#role").hide();
    	$("#managerProperty").show();
    	if($("#defineDisplay").text() == 'managerPropertyEdit'){
    		$(".divContent").hide();
    		$(".newDiv").show();
    		$(".buttonDivContent").hide();
		}
    	$("#managerUser").hide();
    	$(".propertyManager").addClass("active");
	}  
    if( ($("#defineDisplay").text()) == "managerUser"){
    	$(".userInfo").hide();
    	$(".userOnButton").hide();
    	$(".userEdit").hide();
    	$(".userPassword").hide();
    	$("#role").hide();
    	$("#managerProperty").hide();
    	$("#managerUser").show();
    	$(".userManager").addClass("active");
    }   
    
    $("#newProperty").click(function(){
    	$(".divContent").hide();
    	$(".buttonDivContent").hide();
    	$(".newDiv").show();
    }); 
    $("#newUserProfil").click(function(){
    	$(".divContent").hide();
    	$(".buttonDivContent").hide();
    	$("#newUser").show();	
    });
    $("#genereteUserProfil").click(function(){
    	$(".divContent").hide();
    	$(".buttonDivContent").hide();
    	$("#generateUser").show();	
    });
});