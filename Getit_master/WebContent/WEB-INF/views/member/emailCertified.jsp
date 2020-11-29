<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 이메일 인증</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    
	<script>
	function check(){
		var form = document.authenForm;
		var authNum = ${authNum };
		
		if (!form.authNum.value) {
			alert("인증번호를 입력해주세요.");
			return false;
		}
		
		if (form.authNum.value!=authNum) {
			alert("틀린 인증번호입니다.인증번호를 다시 입력해주세요.");
			form.authNum.value="";
			return false;
		}
		
		if(form.authNum.value==authNum) {
			alert("인증완료!");
			opener.document.enrollForm.emailCertified.value="인증완료";
			window.close();
		}
	}
		
	</script>

</head>
<body>
	<br>
	<h5>인증번호 7자리를 입력하세요</h5>
	<br>
	<div>
		<form method="post" name="authenForm" onSubmit="return check();">
			<input type="text" class="form-control" aria-describedby="emailHelp" placeholder="인증번호를 입력하세요." required style="width:70%;float:left" name="authNum">
			<button type="submit" class="btn btn-secondary" style="float:left;">인증하기</button>
		</form>
	</div>
	
</body>
</html>