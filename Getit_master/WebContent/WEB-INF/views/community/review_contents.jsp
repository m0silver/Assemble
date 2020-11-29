<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ page import="java.util.*" %>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고거래 게시글</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/community/reviewContents.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    
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
    
    <script>
	
   		function question() {
   			return confirm ("정말로 삭제하시겠습니까?");
   		}
   		
    </script>
    
</head>
<body>
    <header>
        <div id="nav_bar">
            <div id="nav_bar_menu">
                <ul>
                    <li><a href="#">Recommend</a></li>
                    <li><a href="#">Self</a></li>
                    <li><a href="#">Other</a></li>
                    <li><a href="#">Used Deal</a></li>
                    <li><a href="#">Community</a></li>
                </ul>
            </div>
            <div id="nav_bar_logo">
                <a href="#">Assemble</a>
            </div>
            <div id="nav_bar_other">
                <div id="wrap">
                  <form action="" autocomplete="on">
                  <input id="search" name="search" type="text" placeholder="검색어를 입력하세요."><input id="search_submit" value="Rechercher" type="submit"> 
                  </form>
                </div>
                <div id="cart">
                    <a href="#" class="fas fa-shopping-cart fa-lg" style="color: black;"></a>
                </div>
                <div id="login">
                    <a href="#" class="fas fa-user fa-lg" style="color: black;"></a>
                </div>
            </div>
        </div>
    </header>
    <section>
        <div id="section_empty"></div>
        <div id="main_image">
            <img src="/rupload/${contents.rFilename }" alt="..." style="height: 100%;width:50%;" class="rounded mx-auto d-block">
        </div>
        <div id="section_title">
            <div id="section_title_icon">
                <i class="fas fa-user-circle fa-3x" style="color: dimgray;margin-top:6%;"></i>
            </div>
            <div id="section_title_p">
                <p id="section_title_pTag" style="margin-top:3.5%;">${contents.memberId }</p>
            </div>
        </div>
        <div id="section_title_empty"></div>
        <div id="section_title_empty_hr"></div>
        <div id="section_title_hr">
            <hr>
        </div>
        <div id="section_title_empty_hr"></div>
        <div id="contents_empty"></div>
        <div id="section_contents">
            <div id="section_contents_title">
                <p style="font-weight: bold;font-size: 20px;">${contents.rTitle }</p>
            </div>
            <div id="section_contents_contents">
                <pre>${contents.rContents }
                </pre>
            </div>
            <div id="section_contents_date">
                <p style="color:dimgray;">${contents.rDate }</p>
            </div>
        </div>
        <div id="contents_empty"></div>
        <div id="section_title_empty_hr"></div>
        <div id="section_title_hr">
            <hr>
        </div>
        <div id="section_title_empty_hr"></div>
        <div id="section_footer_empty"></div>
        

        <!-- 게시물을 작성한 작성자와 현재 로그인 중인 작성자가 같을때 뜨는 화면 -->
        <c:if test="${contents.memberId eq sessionScope.member.memberId }">
	        <div id="section_footer_modify" style="text-align:right;width:42%;height:8%;float:left;">
	            <form action="/review/modifyform" method="post">
	                <button type="submit" class="btn btn-secondary">수정</button>
	                <input type="hidden" name="reviewNo" value="${contents.reviewNo }">
	            </form>
	        </div>
	        <div id="section_footer_delete" style="text-align: right;width:4%;height:8%;float:left;">
	            <form action="/review/delete" method="post">
	                <button type="submit" class="btn btn-secondary" onclick="return question();">삭제</button>
	                <input type="hidden" name="reviewNo" value="${contents.reviewNo }">
	            </form>
	        </div>
	        <div id="section_footer_list" style="text-align: right;width:4%;height:8%;float:left;">
	            <form action="/review/main" method="post">
	                <button type="submit" class="btn btn-secondary">목록</button>
	            </form>
	        </div>
        </c:if>
        
        
        <!-- 게시물을 작성한 작성자와 현재 로그인 중인 작성자가 같지 않을때 뜨는 화면 -->
        <c:if test="${contents.memberId ne sessionScope.member.memberId }">
	        <div id="section_footer_list" style="text-align:right;width:50%;height:8%;float:left;">
	            <form action="/review/main" method="post">
	                <button type="submit" class="btn btn-secondary">목록</button>
	            </form>
	        </div>
        </c:if>
        <div id="section_footer_empty"></div>
        <!-- 여기서부터 댓글 리스트 구간과 댓글 작성 폼 구간입니다. -->
        <div class="review">
        	<table class="table table-sm" id="table">
			  <tbody>
			  <c:forEach items="${list }" var="com" varStatus="index">
			    <tr>
			      <td scope="row" style="width: 100px;"><i class="fas fa-user-circle fa-3x" id="tb-icon" style="color: dimgray;"></i></td>
			      <td class="com-line">${com.memberId }</td>
			      <td class="com-line">${com.cContents }</td>
			      <td class="com-line" style="text-align: center;">${com.cDate }</td>
			      <td class="com-line" style="width: 100px;">
			      	<form action="/review/comdelete" method="post">
			      		<button type="submit" class="btn btn-outline-dark" onclick="return question()">삭제</button>
			      		<input type="hidden" name="cNo" value="${com.cNo }">
			      		<input type="hidden" name="reviewNo" value="${contents.reviewNo }">
			      	</form>
			      </td>
			    </tr>
			  </c:forEach>
			  	<tr>
					<td colspan="5" align="center">${ pageComNavi }</td>
				</tr>
			  </tbody>
			</table>
        </div>
    </section>
    <div style="height: 20%;"></div>
    <div class="container">
        <form action="/review/comwrite" method="get">
            <div class="input-group">
               <label for="content" id="label">댓글</label><input class="form-control form-control-sm" type="text" placeholder="내용을 입력하세요(최대 70글자)" name="contents">
               <span class="input-group-btn">
                    <button class="btn btn-default" id="btn-push" type="submit">등록</button>
                    <input type="hidden" value="${contents.reviewNo }" name="reviewNo">
               </span>
              </div>
        </form>
    </div>
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