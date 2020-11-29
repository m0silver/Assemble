<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>판매자와 채팅</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
	 <script src="https://code.jquery.com/jquery-3.5.1.min.js"
      integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
      crossorigin="anonymous"></script>
      
      <style>
      	.container {
	        width: 505px;
	        height: 720px;
	        overflow: auto;
	      	}
      	
      	.container::-webkit-scrollbar {
		    width: 10px;
		  }
		  .container::-webkit-scrollbar-thumb {
		    background-color: dimgray;
		    border-radius: 10px;
		    background-clip: padding-box;
		    border: 2px solid transparent;
		  }
		  .container::-webkit-scrollbar-track {
		    background-color: gray;
		    border-radius: 10px;
		    box-shadow: inset 0px 0px 5px white;
		  }
      </style>
      
</head>
<body>
	
	<!-- 서버와 메시지를 주고 받는 콘솔 텍스트 영역 -->
	<div id="textArea" class="container"></div>
	
	<script type="text/javascript">
	
	// 서버의 broadsocket의 서블릿으로 웹 소켓을 한다.
	var webSocket = new WebSocket("ws://localhost:2330/broadsocket");
	
	// 콘솔 텍스트 영역
	var messageTextArea = document.getElementById("messageTextArea");
	
	// 접속이 완료되면
	webSocket.onopen = function(message) {
		// 콘솔에 메시지를 남긴다.
		// messageTextArea.value += "Server connect...\n";
	};
	
	// 접속이 끝기는 경우는 브라우저를 닫는 경우이기 떄문에 이 이벤트는 의미가 없음.
	webSocket.onclose = function(message) { };
	
	// 에러가 발생하면
	webSocket.onerror = function(message) {
		// 콘솔에 메시지를 남긴다.
		messageTextArea.value += "error...\n";
	};
	
	// 서버로부터 메시지가 도착하면 콘솔 화면에 메시지를 남긴다.
	webSocket.onmessage = function(message) {
		
		$("#textArea").append('<div style="width:100%;height:8%;text-align:left;"><input type="button" class="btn btn-dark" value="'+message.data+'" style="font-size:20px;"></div>');
		$("#textArea").scrollTop($("#textArea")[0].scrollHeight);
	};
	
	// 서버로 메시지를 발송하는 함수
	// Send 버튼을 누르거나 텍스트 박스에서 엔터를 치면 실행
	function sendMessage() {
		// 텍스트 박스의 객체를 가져옴
		let message = document.getElementById("textMessage");
		// 콘솔에 메세지를 남긴다.
		$("#textArea").append('<div style="width:100%;height:8%;text-align:right;"><input type="button" class="btn btn-secondary" value="'+message.value+'" style="font-size:20px;"></div>');
		$("#textArea").scrollTop($("#textArea")[0].scrollHeight);
		
		// 소켓으로 보낸다.
		webSocket.send(message.value);
		// 텍스트 박스 초기화
		message.value = "";
	}
	
	
	// 텍스트 박스에서 엔터를 누르면
	function enter() {
		// keyCode 13은 엔터이다.
		if(event.keyCode === 13) {
			// 서버로 메시지 전송
			sendMessage();
			// form에 의해 자동 submit을 막는다.
			return false;
		}
		return true;
	}
	</script>
	
	
	<!-- 채팅 영역 -->
	<form>
		<!-- 텍스트 박스에 채팅의 내용을 작성한다. -->
		<input id="textMessage" type="text" onkeydown="return enter()" class="form-control" style="width:90%;float:left;">
		<!-- 서버로 메시지를 전송하는 버튼 -->
		<a href="#" onclick="sendMessage()" class="far fa-paper-plane fa-2x" style="color:dimgray; float:left; text-decoration:none; margin-left:1%;"></a>
	</form>
</body>
</html>