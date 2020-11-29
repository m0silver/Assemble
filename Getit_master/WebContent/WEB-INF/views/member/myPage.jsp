<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>반품신청</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/member/myPage.css"> 
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<!-- <script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script> -->

	


<script>
	$(document).ready(function() {
		$(window).scroll(function() {
			var scroll = $(window).scrollTop();
			if (scroll > 1) {
				$("#nav_bar").css("background", "white");
				$("#nav_bar").css("opacity", "0.5");
				$("#nav_bar").css("color", "black");
			} else {
				$("#nav_bar").css("background", "white");
				$("#nav_bar").css("opacity", "1");
			}
		})
	});
	function execDaumPostcode(){
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                   
                
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById("postcode").value = data.zonecode;
                document.getElementById("address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("detailAddress").focus();
            }
        }).open();
	};
</script>

</head>
<body>
	<header>
		<div id="nav_bar">
			<div id="nav_bar_menu">
				<ul>
					<li><a href="/recommend/listview">Recommend</a></li>
					<li><a href="/getit/Component">Self</a></li>
					<li><a href="/other/allList">Other</a></li>
					<li><a href="/deal/main">Used Deal</a></li>
					<li><a href="/review/main">Community</a></li>
				</ul>
			</div>
			<div id="nav_bar_logo">
				<a href="/mainpage/view">Assemble</a>
			</div>
			<div id="nav_bar_other">
				<div id="wrap">
					<!-- <form action="" autocomplete="on">
						<input id="search" name="search" type="text"
							placeholder="검색어를 입력하세요."><input id="search_submit"
							value="Rechercher" type="submit">
					</form> -->
				</div>
				<c:if test="${ sessionScope.member eq null }">
				<div id="cart">
					
					<a href="#"><i class="fas fa-shopping-cart fa-lg"
						style="color: #3d3d3d; margin-top: 12px; margin-left: 8px;"></i></a>

				</div>
				</c:if>
				
				<c:if test="${ sessionScope.member ne null }">
				<div id="cart">
					
					<a href="/member/shoppingbag?userId=${sessionScope.member.memberId }"><i class="fas fa-shopping-cart fa-lg"
						style="color: #3d3d3d; margin-top: 12px; margin-left: 8px;"></i></a>

				</div>
				</c:if>

				<c:if test="${ sessionScope.member eq null }">
					<!-- 로그인x -->
					<div id="login">
						<div class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
								role="button" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> <i
								class="fas fa-lg fa-user-astronaut" style='color: #3d3d3d;'></i>
							</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/login.html">Log In</a>
									<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="/enroll.jsp">회원가입</a>
							</div>
						</div>
					</div>
				</c:if>

				<c:if test="${ sessionScope.member ne null }">
					<!-- 로그인o -->
					<div id="login">
						<div class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
								role="button" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> <i
								class="fas fa-lg fa-user-astronaut" style='color: #3d3d3d;'></i>
							</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="/member/mypage?userId=${sessionScope.member.memberId }">MyPage</a> 
								<a class="dropdown-item" href="/order/info?userId=${sessionScope.member.memberId }">Order Info</a>
								
								<c:if test="${ sessionScope.member.memberId eq 'admin'}">
								<a class="dropdown-item" href="/WEB-INF/views/admin/adminPage.jsp">Admin Page</a>
								</c:if>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="/member/logout">LogOut</a>
							</div>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</header>
	<section>
		<div id="section_empty"></div>
		<div id="section_contents">
			<div id="section_contents_empty"></div>
			<div class="container" id="section_contents_write">
				<br> <br> <br> <br>

			<div style="transform: translate(-50%, 0%); padding: 50px; position: relative; top: 50%; left: 50%; text-align: center; width: 700px; box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.5); border-radius: 5px;">


					<h2 style="text-align: center; font-family: 'Libre Baskerville', serif; font-weight: bolder; font-size: 40px; color: #0c4237">My Page</h2>
					<br>
					<form action="/member/update" method="post">
						<div>
							<ul style="list-style: none;">
								<li style="text-align: left;">아이디 *</li>
								<li><input type="text" placeholder="아이디를 입력하세요"
									name="userId" id="userId"
									value="${sessionScope.member.memberId }"
									style="color: gray; width: 100%;" readonly></li>
								<br>
								<li style="text-align: left;">이메일 *</li>
								<li><input type="email" placeholder="이메일을 입력하세요"
									name="email" id="email" value="${member.email }"
									style="color: gray; width: 100%;" readonly></li>
								<br>
								<li style="text-align: left;">이름 *</li>
								<li><input type="text" placeholder="이름을 입력하세요"
									name="userName" id="userName"
									value="${sessionScope.member.memberName }"
									style="color: gray; width: 100%;" readonly></li>
								<br>

								<li style="text-align: left;">비밀번호*</li>
								<li><input type="password" placeholder="기존 비밀번호"
									name="userPwd" id="userPwd" style="width: 100%;" required></li>
								<span id="out"></span>

								<li style="text-align: left;">새비밀번호*</li>
								<li><input type="password" placeholder="새 비밀번호"
									name="userPwd" id="userPwd" style="width: 100%;" required></li>
								<span id="out"></span>
								<li style="text-align: left;">새비밀번호 확인*</li>
								<li><input type="password" placeholder="새 비밀번호를 다시 입력하세요"
									name="userPwdRe" style="width: 100%;" required></li>
								<br>
								<li style="text-align: left;">휴대폰 번호*</li>
								<li><input type="phone" placeholder="휴대폰 번호를 입력하세요"
									name="phone" value="${member.phone } " style="width: 100%;"></li>
								<br>

								<li style="text-align: left;">우편주소*</li>
								
								
								<li><input type="text" id="postcode" name="zipcode"	placeholder="우편번호" value="${member.zipcode }"	style="width: 30%; float: left;">
									<input type="button"  onclick="execDaumPostcode()" style="float: left;" value="우편번호 찾기"><br></li>
								<li><input type="text" id="address" name="address" placeholder="주소" value="${member.address }" style="width: 100%;"><br></li>
								<li><input type="text" id="detailAddress" name="detailAddress" placeholder="상세주소"	value="${member.detailAddress }" style="width: 100%;"></li>



								<li style="text-align: left;">생년월일*</li>
								<li><input type="text" placeholder="나이를 입력하세요" name="dob"
									value="${member.dob }" style="float: left;" readonly></li>
								<br>
								<br>
								<li style="text-align: left;">성별 *</li>
								<li style="text-align: left;"><c:if
										test="${member.gender eq 'M' }">
										<input type="radio" name="gender" value="M" checked> Male
				<input type="radio" name="gender" value="F" readonly> Female
				</c:if> <c:if test="${member.gender eq 'F' }">
										<input type="radio" name="gender" value="M" readonly>Male
				<input type="radio" name="gender" value="F" checked>Female
				</c:if></li>
						<br>
						<div style="text-align: left; padding-left:5px;">
							<a href="/member/delete" onclick='return question();' style="color: #0c4237; text-decoration:none; ">회원 탈퇴하기</a>
						</div>
						

								
								<br>
								<li><input type="submit" value="수정"
									class="btn btn-secondary"
									style="background-color: #0c4237; color: white; padding: 10px 70px 10px 70px; font-size: 20px; font-weight: bolder;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
									type="reset" value="취소" class="btn btn-secondary"
									style="background-color: #0c4237; color: white; padding: 10px 70px 10px 70px; font-size: 20px; font-weight: bolder;"></li>

							</ul>
						</div>



						<script>
							function question() {
								return confirm("정말로 탈퇴하시겠습니까?");
							}
						</script>
						
						</form>
				</div>
<br><br><br><br><br>

			</div>
		</div>
		

	<br><br><br><br><br>

	</section>
	
	<footer>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
		<div id="empty_space2"></div>
		<div id="footer_icon">
			<h3>Assemble</h3>
		</div>
		<div id="footer_contents">
			<ul>
				<li>(주)어셈블</li>
				<li>대표이사: 노유진</li>
				<li>서울특별시 중구 남대문로 120 대일빌딩 2F,3F</li>
				<li>사업자등록번호: XXX-XX-XXXXXX</li>
				<li>COPYRIGHT © TENBYTEN ALL RIGHTS RESERVED.</li>
			</ul>
		</div>
		<div id="footer_icon">
			<div id="footer_icon_split">
				<i class="fas fa-headset fa-5x"></i>
			</div>
			<div id="footer_empty"></div>
			<div id="footer_icon_split">
				<i class="fas fa-money-check-alt fa-4x"></i>
			</div>
		</div>
		<div id="footer_contents">
			<div id="footer_contents1">
				<ul>
					<li class="phone">02-1234-5678</li>
					<li class="time">평일 09:00~18:00 / 점심시간 12:00~13:00</li>
					<li class="notice">주말 및 공휴일은 휴무입니다.</li>
				</ul>
			</div>
			<div id="footer_empty"></div>
			<div id="footer_contents1">
				<ul>
					<li class="account">국민은행 01234567-00-1234567</li>
					<li class="account_holder">예금주: 노유진</li>
				</ul>
			</div>
		</div>
		<div id="empty_space2"></div>
	</footer>
</body>
</html>