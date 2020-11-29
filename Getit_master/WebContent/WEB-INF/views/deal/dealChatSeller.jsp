<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>구매자와 채팅</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
	 <script src="https://code.jquery.com/jquery-3.5.1.min.js"
      integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
      crossorigin="anonymous"></script>
	
	<style>
		.float-left {
			width:100%;
			height:70%;
		}
		
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
	
	<!-- 유저가 접속할 때마다 이 템플릿으로 채팅창을 생성한다. -->
	<div class="template" style="display:none;">
		<!-- 서버와 메시지를 주고 받는 콘솔 텍스트 영역 -->
		<div id="textArea" class="container"></div>
		
		<!-- 채팅 영역 -->
		<form>
			<!-- 텍스트 박스에 채팅의 내용을 작성한다. -->
			<input type="text" onkeydown="return enter()" class="form-control" id="message" onkeydown="if(event.keyCode === 13) return false;" style="width:90%;float:left;">
			<!-- 서버로 메시지를 전송하는 버튼 -->
			<a href="#" id="sendBtn" class="far fa-paper-plane fa-2x" style="color:dimgray; float:left; text-decoration:none; margin-left:1%;"></a>
		</form>
	</div>
	
	<script type="text/javascript">
		// 서버의 admin의 서블릿으로 웹 소켓을 한다.
		var webSocket = new WebSocket("ws://localhost:2330/deal/chatseller");
		
		
		// 운영자에서의 open, close, error는 의미가 없어서 형태만 선언
		webSocket.onopen = function(message) { };
		webSocket.onclose = function(message) { };
		webSocket.onerror = function(message) { };
		
		// 서버로 부터 메시지가 오면
		webSocket.onmessage = function(message) {

			// 메시지의 구조는 JSON 형태로 만들었다.
			let node = JSON.parse(message.data);
			
			// 메시지의 status는 유저의 접속 형태이다.
			// visit은 유저가 접속했을 때 알리는 메시지다.
			if(node.status === "visit") {
				// 위 템플릿 div를 취득한다.
				let form = $(".template").html();
				
				// div를 감싸고 속성 data-key에 unique키를 넣는다.
				form = $("<div class='float-left'></div>").attr("data-key",node.key).append(form);
				
				// body에 추가한다.
				$("body").append(form);
				// message는 유저가 메시지를 보낼 때 알려주는 메시지이다.
			} else if(node.status === "message") {
				// key로 해당 div영역을 찾는다.
				let $div = $("[data-key='"+node.key+"']");
				
				// console영역을 찾는다.
				// let log = $div.find("#textArea").val();
				
				// 아래에 메시지를 추가한다.
				$div.find("#textArea").append('<div style="width:100%;height:8%;text-align:left;" id="inputText"><input type="button" class="btn btn-dark" value="'+node.message+'" style="font-size:20px;"></div>');
				$div.find("#textArea").scrollTop($div.find("#textArea")[0].scrollHeight);
				
				
				
				// bye는 유저가 접속을 끊었을 때 알려주는 메시지이다.
			} else if(node.status === "bye") {
				// 해당 키로 div를 찾아서 dom을 제거한다.
				$("[data-key='"+node.key+"']").remove();
			}
		};
		
		// 전송 버튼을 클릭하면 발생하는 이벤트
		$(document).on("click", "#sendBtn", function(){
			// div 태그를 찾는다.
			let $div = $(this).closest(".float-left");
			
			// 메시지 텍스트 박스를 찾아서 값을 취득한다.
			let message = $div.find("#message").val();
			
			// 유저 key를 취득한다.
			let key = $div.data("key");
			
			// console영역을 찾는다.
			// let log = $div.find("#textArea").val();
			
			// 아래에 메시지를 추가한다.
			$div.find("#textArea").append('<div style="width:100%;height:8%;text-align:right;" id="inputText"><input type="button" class="btn btn-secondary" value="'+message+'" style="font-size:20px;"></div>');
			$div.find("#textArea").scrollTop($div.find("#textArea")[0].scrollHeight);
			

			// 텍스트 박스의 값을 초기화 한다.
			$div.find("#message").val("");
			
			// 웹소켓으로 메시지를 보낸다.
			webSocket.send(key+"#####"+message);
		});
		
		// 텍스트 박스에서 엔터키를 누르면
		$(document).on("keydown", "#message", function(){
			// keyCode 13은 엔터이다.
			if(event.keyCode === 13) {
				// 버튼을 클릭하는 트리거를 발생한다.
				$(this).closest(".float-left").find("#sendBtn").trigger("click");
				
				// form에 의해 자동 submit을 막는다.
				return false;
			}
			return true;
		});
	</script>
	
</body>
</html>