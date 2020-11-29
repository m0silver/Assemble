<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상세정보</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/other/other_content.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
    

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
    
    <script>
    	$("btn1").click(function() {
    		var position = $(".component").offset();
    		$("body").stop().animate
    	})
    </script>
    
    <script>
	    $(document).ready(function() {  /* script 추가 */
	        $(".review .accordion_title").click(function() {
	            if ($(this).next("div").is(":visible")) {
	                $(this).next("div").slideUp("fast");
	            } else {
	                $(".review .accordion_sub").slideUp("fast");
	                $(this).next("div").slideToggle("fast");
	            }
	        });
	    });
    </script>
    
    <script>
    function review(memberId) {
		if (memberId = null) {
			alert("로그인 후 이용 가능합니다.");
			return false;
		} else {
			return true;
		}
	}
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
                    <li><a href="/qna/main">Community</a></li>

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
    <div class="header_space"></div>


    <section>
        <div class="aside"></div>
        <div class="section_main">
            <div id="detail_main">
                <table class="tg">
			        <tr>
			          <th rowspan="5" style="width:40%;height:100%"><img src="/oupload/${content.pFilename }" width= 150% height= 90%;></th>
			          <td colspan="2" style="font-weight: bold;">${content.pName }</td>
			        </tr>
			        <tr>
			          <td>가격 &nbsp;<fmt:formatNumber value="${content.pPrice }" pattern="###,###,###원"/></td>
			          <%-- ${content.oProductPrice }원 --%>
			          <td>
			          	수량 &nbsp;&nbsp;&nbsp; 1
			          </td>
			        </tr>
			        <tr>
			          <td colspan="2">배송비 3,000원</td>
			        </tr>
			        <tr>
			          <td colspan="2">${content.pContents }</td>
			        </tr>
			        <tr>
			          <td colspan="2">본 상품은 해외배송이 불가한 상품입니다.</td>
			        </tr>
			    </table>
            </div>
            <hr style="width: 45%;height: 2px; background-color:gray; border-top: 1px;opacity: 0.4; margin-left: 750px;">
            <div id="account">
                <div class="detail_main_top_left"><b>총 합계 금액</b></div>
                <div class="detail_main_top_right"><fmt:formatNumber value="${content.pPrice }" pattern="###,###,###원"/></div>
            </div>
            <div id="basket">
                <img src="/img/cart.PNG" style="width: 80px; padding-bottom: 30px;">
                &nbsp;&nbsp;
                <a href="/basket/insert?pCode=${content.pCode }"><b style="font-size: 50px;">장바구니</b></a>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <img src="/img/pay.PNG" style="width: 80px; padding-bottom: 35px;">
                &nbsp;&nbsp;
                <a href="/member/pay?pCode=${content.pCode }"><b style="font-size: 50px; color: red;">결제하기</b></a>
            </div>
            <div id="info">
                <a href="#content" id="btn1">상품정보</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="#review" id="btn2">구매후기</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <a href="#refund" id="btn3">취소/반품/교환 정보</a>
            </div>
            <hr style="width: 87.5%;height: 2px; background-color:gray; border-top: 1px;opacity: 0.4;">
            <div id="content">
                <div class="component">
                    <img src="/oupload/${content.pcFilename }">
                    <input type="hidden" name="pCode" value="${content.pCode }">
                </div>
            </div>
            <br><br><br>
            <hr style="width: 87.5%;height: 2px; background-color:gray; border-top: 1px;opacity: 0.4;">
            <div class="section_space" style="text-align: center;" id="review">구매후기
            <form action="/other/writeform" method="post">
               	<div class="btn-group-toggle" id="input_btn" data-toggle="buttons">
					<button type="submit" class="btn btn-outline-dark">작성하기</button>
					<input type="hidden" name="pCode" value="${content.pCode }">
				</div>
			</form>
            </div>
            <div class="accordion" id="accordionExample">
			      <div class="card">
			      <c:forEach items="${list }" var="rv" varStatus="index">
			        <div class="card-header" id="headingTwo">
			            <span><button id="btn_review" class="btn btn-link btn-block text-left collapsed" type="button" data-toggle="collapse" data-target="#collapse${index.index }" aria-expanded="false" aria-controls="collapseTwo">
			              ${rv.reviewTitle }
			            </button></span>
			             <div style="text-align: right;">${rv.memberId } ${rv.enrollDate }</div>
			        </div>
			        <div id="collapse${index.index }" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
			          <div class="card-body">
			            	${rv.reviewContents }
			          </div>
			        </div>
			        </c:forEach>
			      </div>
			      <div id="empty_space"></div>
		        <div id="section_title2">
		        	<nav aria-label="Page navigation example" id="paging">
		        		<ul class="pagination">${pageReNavi }</ul>
		        	</nav>
		        </div>
		    </div>
            <div class="section_space"></div>
            <hr style="width: 90%;height: 2px; background-color:gray; border-top: 1px;opacity: 0.4;">
            <div class="section_space" style="text-align: center;" id="refund">교환 / 환불</div>
            <div class="card" style="width: 87.5%; margin: 0 auto;">
              <div class="card-body">
			    <blockquote class="blockquote mb-0">
			         <p><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-check" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
				  <path fill-rule="evenodd" d="M10.97 4.97a.75.75 0 0 1 1.071 1.05l-3.992 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.236.236 0 0 1 .02-.022z"/>
				</svg> 단품 : 교환 및 반품이 가능한 경우</p>
				상품등을 실제 받으신 날로부터 7일 이내<br>
				(※ 포장을 개봉하여 사용하거나 또는 설치완료가 되어 상품의 가치가 훼손된 경우에는 반품 및 교환이 불가하오니 이점 양해하여 주시기 바랍니다.)<br>
				받으신 상품의 내용이 표시·광고 사항과 다른 경우에는 상품등을 받으신 날로부터 3개월 이내.<br>
				전자상거래등에서의소비자보호에관한법률에 규정되어 있는 소비자 청약철회 가능범위에 해당되는 경우.<br>
				기타, 고객님의 단순한 변심에 의해 상품의 교환 및 반품을 요청하시는 경우에는 고객님께서 상품 반송에 소요되는 비용을 실비로 부담하셔야 하오니 이점 양해하여 주시기 바랍니다.
				<hr style="height: 2px; background-color:gray; border-top: 1px;opacity: 0.4;">
				<p><svg width="1em" height="1em" viewBox="0 0 16 16" class="bi bi-check" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
				  <path fill-rule="evenodd" d="M10.97 4.97a.75.75 0 0 1 1.071 1.05l-3.992 4.99a.75.75 0 0 1-1.08.02L4.324 8.384a.75.75 0 1 1 1.06-1.06l2.094 2.093 3.473-4.425a.236.236 0 0 1 .02-.022z"/>
				</svg> 교환 및 반품이 불가능한 경우</p>
				고객님의 책임있는 사유로 상품등이 멸실 또는 훼손된 경우.<br>
				고객님의 사용 또는 일부 소비에 의하여 상품등의 가치가 현저히 감소한 경우.<br>
				시간이 경과되어 재판매가 곤란할 정도로 상품등의 가치가 상실된 경우.<br>
				복제가 가능한 상품등의 포장을 훼손한 경우.<br>
				기타, 전자상거래등에서의소비자보호에관한법률이 정하는 소비자 청약철회 제한에 해당되는 경우.(고객변심에 의한 교환, 반품인 경우 상품 반송에 드는 비용은 고객님께서 부담하셔야 합니다.)
			    </blockquote>
			  </div>
            </div>
        </div>
        <div class="aside"></div>
    </section>

    <footer>
        <div class="aside"></div>
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
        <div class="aside"></div>
    </footer>

</body></html>