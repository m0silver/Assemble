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
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
	integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="/css/member/depositWating.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

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
	})
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

						<a
							href="/member/shoppingbag?userId=${sessionScope.member.memberId }"><i
							class="fas fa-shopping-cart fa-lg"
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
								<a class="dropdown-item"
									href="/member/mypage?userId=${sessionScope.member.memberId }">MyPage</a>
								<a class="dropdown-item"
									href="/order/info?userId=${sessionScope.member.memberId }">Order
									Info</a>

								<c:if test="${ sessionScope.member.memberId eq 'admin'}">
									<a class="dropdown-item"
										href="/WEB-INF/views/admin/adminPage.jsp">Admin Page</a>
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

				<div
					style="transform: translate(-50%, 0%); padding: 50px; position: relative; top: 50%; left: 50%; text-align: center; width: 700px; box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.5); border-radius: 5px;">


					<h2
						style="text-align: center; font-family: 'Libre Baskerville', serif; font-weight: bolder; font-size: 40px; color: #0c4237">Order
						Management</h2>
                    <hr>
					<div class="order">
						<h2 style="text-align: left; margin-left:20px;">
							<i class="fas fa-dolly-flatbed" style="background-color: lightgray; border-radius: 8px; padding: 20px 15px 20px 15px;"></i> 주문
						</h2>
                        
                        <br><br>

						<ul style="list-style: none; ">
							<li style="float:left; font-size: 20px;" ><i class="far fa-pause-circle"></i><a href="/admin/deopositWaiting" style="color: #0c4237; text-decoration: none; font-weight: borlder;">     입금
									대기</a></li>
							<li style="text-align: right; margin-right:50px; font-size: 20px; color: #0c4237; font-weight: borlder;">${depositC}개</li>
							<br>
							<li style="float:left; font-size: 20px;"><i class="fas fa-credit-card"></i><a href="/admin/paymentCompleted" style="color: #0c4237; text-decoration: none; font-weight: borlder;">     결제
									완료</a></li>
							<li style="text-align: right; margin-right:50px; font-size: 20px; color: #0c4237; font-weight: borlder;">${payC}개</li>
							<br>
							<li style="float:left; font-size: 20px;"><i class="fas fa-dolly"></i><a href="/admin/readyfordelivery" style="color:  #0c4237; text-decoration: none; font-weight: borlder;">     배송
									준비</a></li>
							<li style="text-align: right; margin-right:50px; font-size: 20px; color: #0c4237; font-weight: borlder;">${rfd }개</li>
							<br>
							<li style="float:left; font-size: 20px;"><i class="fas fa-shipping-fast"></i><a href="/admin/delivering" style="color: #0c4237; text-decoration: none;font-weight: borlder;">     배송 중</a></li>
							<li style="text-align: right; margin-right:50px; font-size: 20px; color: #0c4237; font-weight: borlder;">${deliveryC }개</li>
							<br>
							<li style="float:left; font-size: 20px;"><i class="far fa-thumbs-up"></i><a href="/admin/deliveryCompelete" style="color: #0c4237; text-decoration: none;font-weight: borlder;">     배송 중</a></li>
							<li style="text-align: right; margin-right:50px; font-size: 20px; color: #0c4237; font-weight: borlder;">${deliveryC }개</li>
							<br>
                            <hr style="margin-left: -40px; ">
                            <br>
							<li style="float:left; font-size: 20px;"><i class="far fa-window-close"></i><a href="/admin/return" style="color: #0c4237; text-decoration: none;font-weight: borlder;">     취소 요청</a></li>
							<li style="text-align: right; margin-right:50px; font-size: 20px; color: #0c4237; font-weight: borlder;">${returnC }개</li>
							<br>
							<li style="float:left; font-size: 20px;"><i class="fas fa-undo"></i><a href="/admin/exchange " style="color: #0c4237; text-decoration: none;font-weight: borlder;">     반품 요청</a></li>
							<li style="text-align: right; margin-right:50px; font-size: 20px; color: #0c4237; font-weight: borlder;">${changeC}개</li>
							<br>
						</ul>
					</div>

				</div>
				
				<br><br>


				<%-- <div class="product">
					<h2>
						<img src=""> 상품
					</h2>
					<ul>
						<li><img src=""><a href="/admin/sale">판매 중</a></li>
						<li>${ }개</li>
						<br>
						<li><img src=""><a href="/admin/outofstock">품절</a></li>
						<li>${ }개</li>
						<br>
						<li><img src=""><a href="/admin/inventory">재고 관리</a></li>
						<li>${ }개</li>
						<br>
					</ul>
				</div>
				<div class="board">
					<h2>
						<img src=""> 게시글
					</h2>
					<ul>
						<li><img src=""><a href="/admin/qa">Q&A</a></li>
						<li>${ }개</li>
						<br>
						<li><img src=""><a href="/admin/usertrade">중고 거래</a></li>
						<li>${ }개</li>
						<br>
						<li><img src=""><a href="/admin/reviews">Review</a></li>
						<li>${ }개</li>
						<br>

					</ul>
				</div>  --%>

			</div>
		</div>




	</section>
	<footer>
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


