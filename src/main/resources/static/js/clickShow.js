$(document).ready(function() {
	$(".clickShow").click(function() {
		$(this).parent().next().slideToggle("slow");
	});
});