$(document).ready(function(){
    $("#userEditInfo").click(function(){
        $(".userInfo").hide();
        $(".userEdit").show();
        $(".userPassword").hide();
        $(".userOnButton").hide();
    });
    
    $("#userChangePassword").click(function(){
        $(".userInfo").hide();
        $(".userEdit").hide();
        $(".userPassword").show();
        $(".userOnButton").hide();
    });
});