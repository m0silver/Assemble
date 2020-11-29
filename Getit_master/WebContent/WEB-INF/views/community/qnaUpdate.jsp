<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 게시물 작성</title>
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
<link rel="stylesheet" type="text/css" href="/css/community/qnaReviewWrite.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

<script>
        $(document).ready(function(){
          $(window).scroll(function(){
            var scroll = $(window).scrollTop();
            if (scroll > 1) {
              $("#nav_bar").css("background" , "white");
              $("#nav_bar").css("opacity" , "0.5");
              $("#nav_bar").css("color" , "black");
            }
            else{
              $("#nav_bar").css("background" , "white");
              $("#nav_bar").css("opacity" , "1");  
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
					<form action="" autocomplete="on">
						<input id="search" name="search" type="text"
							placeholder="검색어를 입력하세요."><input id="search_submit"
							value="Rechercher" type="submit">
					</form>
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
				<br> <br>
				<h2>QnA 수정 화면</h2>
				<br>

				<form action="/qna/update?qnaNo=${qnaNo }" method="post">
					<div class="form-group">
						<label for="exampleInputEmail1">Title</label>
						<textarea class="form-control" rows="1" id="comment"
							placeholder="제목을 입력해주세요." name="title"></textarea>
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Contents</label>
						<textarea class="form-control" rows="5" id="comment"
							placeholder="내용을 입력해주세요." name="contents"></textarea>
					</div>
					<button type="submit" class="btn btn-default"
						style="margin-left: 83%;">수정하기</button>
					<br> <a href="javascript:history.back()"
						style="text-align: right;">원래 페이지로 이동</a>
				</form>
			</div>
			<div id="section_contents_empty"></div>
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