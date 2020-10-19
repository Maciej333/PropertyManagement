$(document).ready(function() {
	if (($("#defineDisplay").text()) == 'current') {
		$("#associationTitle").text('Ogłoszenia');
		$("#announcementShowDiv").show();
		$("#managersShowDiv").hide();
		$("#newAnnouncement").hide();
		$(".current").addClass("active");
	}
	if (($("#defineDisplay").text()) == "all") {
		$("#associationTitle").text('Ogłoszenia');
		$("#announcementShowDiv").show();
		$("#managersShowDiv").hide();
		$("#newAnnouncement").hide();
		$(".all").addClass("active");
	}
	if (($("#defineDisplay").text()) == 'previous') {
		$("#associationTitle").text('Ogłoszenia');
		$("#announcementShowDiv").show();
		$("#managersShowDiv").hide();
		$("#newAnnouncement").hide();
		$(".previous").addClass("active");
	}
	if (($("#defineDisplay").text()) == 'new') {
		$("#associationTitle").text('Ogłoszenia');
		$("#announcementShowDiv").hide();
		$("#managersShowDiv").hide();
		$("#newAnnouncement").show();
		$(".info").hide();
		$(".new").addClass("active");
	}
	if (($("#defineDisplay").text()) == 'managers') {
		$("#associationTitle").text('Zarząd');
		$("#announcementShowDiv").hide();
		$("#managersShowDiv").show();
		$("#newAnnouncement").hide();
		$(".info").hide();
		$(".managersBtn").addClass("active");
	}
});