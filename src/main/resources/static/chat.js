var stompClient = null;

function setConnected(connected) {
	$("#connect").prop("disabled", connected);
	$("#disconnect").prop("disabled", !connected);
	if (connected) {
		$("#conversation").show();
	} else {
		$("#conversation").hide();
	}
	$("#greetings").html("");
}

function connect() {

	var headers = {};
	headers[csrfToken.headerName] = csrfToken.token;
	var socket = new SockJS('/chat');
	stompClient = Stomp.over(socket);
	stompClient.connect(headers, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/' + roomId, function(message) {
			showMessage(JSON.parse(message.body));
		});
	});
}

function disconnect() {
	if (stompClient != null) {
		stompClient.disconnect();
	}
	setConnected(false);
	console.log("Disconnected");
}

function sendMessage() {
	stompClient.send("/app/" + roomId, {}, JSON.stringify({
		'content' : $("#chat-text").val()
	}));
}

function showMessage(message) {
	$(".chat").append(
			'<li class="left clearfix">' +
			'	<span class="chat-img pull-left">' +
			'		<img src="http://placehold.it/50/55C1E7/fff&text=U" alt="User Avatar" class="img-circle" />' +
			'	</span>' +
			'	<div class="chat-body clearfix">' +
			'		<div class="header">' +
			'			<strong class="primary-font">' + message.userNickname + '</strong>' +
			'			<small class="pull-right text-muted">' +
			'				<span class="glyphicon glyphicon-time"></span>' + new Date(message.sendingTime) +
			'			</small> ' +
			'		</div>' +
			'		<p>' + message.text +'</p> ' +
			'	</div>' +
			'</li>'
		);
}

$(function() {
	$("form").on('submit', function(e) {
		e.preventDefault();
	});
	$("#connect").click(function() {
		connect();
	});
	$("#disconnect").click(function() {
		disconnect();
	});
	$("#btn-chat").click(function() {
		sendMessage();
	});
});