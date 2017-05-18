$(function() {
	$("input[type=file]").change(function(e) {
		previewFile();
	});
	$("#fake-attach").click(function(e) {
		$("input[type=file]").click();
	});
});