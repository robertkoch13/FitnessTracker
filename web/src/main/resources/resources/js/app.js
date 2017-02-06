$(document).ready(function() {
	changePageAndSize();
});

function changePageAndSize() {
	$('#pageSizeSelect').change(function(evt) {
		window.location.replace(window.location.pathname + "?pageSize=" + this.value + "&page=1");
	});
}
