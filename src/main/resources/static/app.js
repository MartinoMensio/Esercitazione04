var stompClient = null;

// this is the room we are in
// TODO get the room in other ways?
var roomId = new URLSearchParams(window.location.search).get('room');

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}

function connect() {
	// get the csrf token
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	var csrfToken = JSON.parse(xhttp.responseText);
	    	var headers = {};
	    	headers[csrfToken.headerName] = csrfToken.token;
	    	var socket = new SockJS('/chat');
	        stompClient = Stomp.over(socket);
	        stompClient.connect(headers, function (frame) {
	            setConnected(true);
	            console.log('Connected: ' + frame);
	            stompClient.subscribe('/topic/' + roomId, function (message) {
	                showMessage(JSON.parse(message.body));
	            });
	        });
	    }
	};
	xhttp.open("GET", "rest/csrf", true);
	xhttp.send();
    
}

function disconnect() {
    if (stompClient != null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendMessage() {
    stompClient.send("/app/" + roomId, {}, JSON.stringify({'content': $("#message").val()}));
}

function showMessage(message) {
    $("#greetings").append("<tr><td>" + message.sender.nickname + ": " + message.text + "</td></tr>");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#send" ).click(function() { sendMessage(); });
});