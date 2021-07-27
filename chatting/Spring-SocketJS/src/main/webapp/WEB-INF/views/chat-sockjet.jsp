<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- jstl 코어 태그 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.min.js"></script>
<script type="text/javascript">
	var wsocket;
	
	function connect() 
	{
		wsocket = new SockJS("http://localhost:8080/SocketJs/chat.sockjs");
		wsocket.onopen = onOpen;
		wsocket.onmessage = onMessage;
		wsocket.onclose = onClose;
	}
	function disconnect() 
	{
		wsocket.close();
	}
	function onOpen(evt)
	{
		appendMessage("연결되었습니다.");
	}
	function onMessage(evt) 
	{
		var data = evt.data;
		console.log("데이터 "+ data);
		appendMessage(data);
	}
	function onClose(evt) 
	{
		appendMessage("연결을 끊었습니다.");
	}
	
	function send() 
	{
		var nickname = $("#nickname").val();
		var msg = $("#message").val();
		wsocket.send(nickname+": " + msg);
		$("#message").val("");
	}

	function appendMessage(msg) 
	{
		$("#chatMessageArea").append(msg+"<br>");
		var chatAreaHeight = $("#chatArea").height();
		var maxScroll = $("#chatMessageArea").height() - chatAreaHeight;
		$("#chatArea").scrollTop(maxScroll);
	}

	$(document).ready(function() 
	{
		$('#message').keypress(function(event){
			var keycode = (event.keyCode ? event.keyCode : event.which);
			if(keycode == '13'){
				send();	
			}
			event.stopPropagation();
		});
		$('#sendBtn').click(function() { send(); });
		$('#enterBtn').click(function() { connect(); });
		$('#exitBtn').click(function() { disconnect(); });
	});
</script>
<style>
#chatArea 
{
	width: 200px; height: 100px; overflow-y: auto; border: 1px solid black;
}
</style>
</head>
<body>
	이름:<input type="text" id="nickname">
	<input type="button" id="enterBtn" value="입장">
	<input type="button" id="exitBtn" value="나가기">    
    <h1>대화 영역</h1>
    <div id="chatArea">
    	<div id="chatMessageArea"></div>
    </div>
    <br/>
    <input type="text" id="message">
    <input type="button" id="sendBtn" value="전송">
</body>
</html>