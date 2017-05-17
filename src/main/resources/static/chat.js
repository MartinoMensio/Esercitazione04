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
	var content = $("#chat-text").val();
	var preview = $('#img-preview')[0];
	var imageStr = preview.getAttribute('src');
	if (content || imageStr !== "") {
		stompClient.send("/app/" + roomId, {}, JSON.stringify({
			'content' : content,
			'image': imageStr
		}));
		$("#chat-text").val('');
		preview.setAttribute('src', "");
	}
}

function previewFile() {
	var preview = $('#img-preview')[0];
	var file = $('input[type=file]')[0].files[0];
	var reader = new FileReader();

	reader.addEventListener("load", function() {
		preview.src = reader.result;
	}, false);

	if (file) {
		reader.readAsDataURL(file);
	}
}

function showMessage(message) {
	if (message.userId != userId) {
		$(".chat")
				.append(
						'<li class="left clearfix">'
								+ '	<span class="chat-img pull-left">'
								+ '		<img src="http://placehold.it/50/55C1E7/fff&text=U" alt="User Avatar" class="img-circle" />'
								+ '	</span>'
								+ '	<div class="chat-body clearfix">'
								+ '		<div class="header">'
								+ '			<strong class="primary-font">'
								+ message.userNickname
								+ '</strong>'
								+ '			<small class="pull-right text-muted">'
								+ '				<span class="glyphicon glyphicon-time"></span>'
								+ new Date(message.sendingTime)
								+ '			</small> ' + '		</div>' + '		<p>'
								+ message.text + '</p> ' + '	</div>' + '</li>');
	} else {
		$(".chat")
				.append(
						'<li class="right clearfix">'
								+ '	<span class="chat-img pull-right">'
								+ '		<img src="http://placehold.it/50/55C1E7/fff&text=U" alt="User Avatar" class="img-circle" />'
								+ '	</span>'
								+ '	<div class="chat-body clearfix">'
								+ '		<div class="header">'
								+ '			<small class="text-muted">'
								+ '				<span class="glyphicon glyphicon-time"></span>'
								+ new Date(message.sendingTime)
								+ '			</small> '
								+ '			<strong class="pull-right primary-font">'
								+ message.userNickname + '</strong>'
								+ '		</div>' + '		<p>' + message.text + '</p> '
								+ '	</div>' + '</li>');
	}
}

$(function() {
	$("#sendForm").on('submit', function(e) {
		e.preventDefault();
		sendMessage();
	});
	$("#btn-chat").click(function() {
		sendMessage();
	});
	$("input[type=file]").change(function(e) {
		previewFile();
	});
});