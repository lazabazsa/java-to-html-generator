/**
 * Javascript for handling the click events between the tabs.
 * The file extension is .jss, by purpose. Gmail does not allow to send .js within a .zip file.
 *
 * Created by Balazs Torok on 13/02/17.
 */
function openTab(evt, tabId) {
	var i, tabcontent, tablinks;
	tabcontent = document.getElementsByClassName("tab-content");
	for (i = 0; i < tabcontent.length; i++) {
		tabcontent[i].style.display = "none";
	}
	tablinks = document.getElementsByClassName("tab-links");
	for (i = 0; i < tablinks.length; i++) {
		tablinks[i].className = tablinks[i].className.replace(" active", "");
	}
	document.getElementById(tabId).style.display = "block";
	evt.currentTarget.className += " active";
}

// the first tab is selected by default
document.addEventListener("DOMContentLoaded", function (event) {
	//do work
	var ul = document.getElementsByClassName("tab");
	var items = ul[0].getElementsByTagName("li");
	if (items.length > 0) {
		var a = items[0].getElementsByTagName("a");
		a[0].click();
	}
});
