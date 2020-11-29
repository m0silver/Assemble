<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
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
<link rel="stylesheet" type="text/css" href="/css/member/basket.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

<script>
	$(document).ready(function(){
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

						var $All = $('#allCheck');
						$All.change(function() {
							var $this = $(this);
							var checked = $this.prop('checked'); // checked 문자열 참조(true, false)
							// console.log(checked);
							$('input[name="checkRow"]')
									.prop('checked', checked);

						});

						var boxes = $('input[name="checkRow"]');
						boxes
								.change(function() {

									var boxLength = boxes.length;
									// 체크된 체크박스 갯수를 확인하기 위해 :checked 필터를 사용하여 체크박스만 선택한 후 length 프로퍼티를 확인
									var checkedLength = $('input[name="checkRow"]:checked').length;
									var selectAll = (boxLength == checkedLength);

									$All.prop('checked', selectAll);

								});

						//$("#sDelte").on("click", function() {
						$("#sDelte").click(function(e) {
											e.preventDefault();
											console
													.log($("input[name=checkRow]:checked"));
											var basketVal = new Array();
											$("input[name=checkRow]:checked")
													.each(
															function(idx, item) {
																console.log($(item).val());
																basketVal.push($(item).val());
															});
											location.href = "/member/shoppingBagListDelete?basketNo="+ basketVal;
										})

						$("#delete").click(function(e) {
							e.preventDefault();
							location.href = "/member/shoppingBagEmpty";
						});

						/* var sum = 0;
						for(var i =0; i< 5; i++){
							var num = parseInt($("#price"+i).text());
							sum += num;
						} 

						 	$("#selProductPrice").html(sum+"원"); */
						var total = 0;
						$("input[name=basketNo]:checked").each(
								function(idx, item) {
									var num = $(item).parent().siblings()
											.last().html();
									total += parseInt(num);
								});
						
						$("#selProductPrice").html(total + "원");
						var realTotal = total + parseInt(3000);
						$("#total").html(realTotal+"원")
						$("#allPrice").val(realTotal);
						
						$("#memberInfo").change(function() {
							if($("#memberInfo").is(":checked")) {
								$("#deliveryInfo").show();
								$("#receiverInfo").hide();
							}else{
								$("#deliveryInfo").hide();
								$("#receiverInfo").show();
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
				<form action="/memeber/shoppingPay" method="post">
					<h2>Basket(${size })</h2>
					<br>
					<div style="width: 100%">
						<table class="table" id="basket_1">
							<thead class="thead-dark">
								<tr>
									<th scope="col" style="width: 5%;"><input type="checkbox" id="allCheck" onClick="checkAll();" ></th>
									<th scope="col" style="width: 60%;">상품명/구성</th>
									<th scope="col" style="width: 10%;">수량</th>
									<th scope="col" style="width: 25%;">상품금액</th>
								</tr>
							</thead>
							
							<tbody style="border-bottom: 1px solid black;">
							
								<c:forEach items="${sList }" var="shopping" varStatus="status">
									<tr>
										<th scope="row"><input type="checkbox" name="checkRow"
											id="checkRow" value="${shopping.pCode }" checked> <input
											type="hidden" name="basketNo" id="basketNo"
											value="${shopping.basketNo }"></th>
										<td>${shopping.pName }</td>
										<td>${shopping.pAccount }</td>
										<td id="price${status.index}">${shopping.pPrice }</td>
									</tr>

								</c:forEach>
								

								<!--  <tr>
                              <th scope="row"><input type="checkbox"></th>
                                <td>	
                                이엠텍 지포스 GTX 1660 SUPER STORM X Dual OC D6 6GB
                                </td>
                                <td>1</td>
                                <td>278,000원</td>
                            </tr>
                            <tr>
                              <th scope="row"><input type="checkbox"></th>
                                <td>	
                                이엠텍 지포스 GTX 1660 SUPER STORM X Dual OC D6 6GB
                                </td>
                                <td>1</td>
                                <td>278,000원</td>
                            </tr>
                            <tr>
                              <th scope="row"><input type="checkbox"></th>
                                <td>	
                                이엠텍 지포스 GTX 1660 SUPER STORM X Dual OC D6 6GB
                                </td>
                                <td>1</td>
                                <td>278,000원</td>
                            </tr> -->
							</tbody>
						</table>
					</div>
					<div style="text-align: right; width: 100%;">
						<button class="fas fa-trash-alt fa-2x" style="background-color: white; font-size: 15px; height: 100%; border: 1px;" id="sDelte">선택상품 삭제</button>
						<button class="fas fa-dumpster-fire fa-2x" style="background-color: white; font-size: 15px; height: 100%; border: 1px;" id="delete">장바구니 비우기</button>
					</div>
					<br>
					<div style="width: 100%">
						<table class="table" id="basket_2">
							<thead class="thead-dark">
								<tr>
									<th scope="col" style="width: 50%"></th>
									<th scope="col">선택상품 금액</th>
									<th scope="col">배송비</th>
									<th scope="col">최종판매가</th>
								</tr>
							</thead>
							<tbody>

								<tr>
									<th scope="row">판매 최적가</th>
									<td id="selProductPrice">0원</td>
									<td>3000원</td>
									<td id="total">0</td>
								</tr>
							</tbody>
						</table>
					</div>
					<input type="hidden" name="allPrice" id="allPrice"> <br>
					<br>
					<h6 style="font-weight: bold;">구매자 정보</h6>
					<input type="checkBox" id="memberInfo" name="memberInfo" checked><label>주문자
						정보와 동일</label>
					<div style="width: 100%;">
						<table class="table" id="basket_3">
							<tbody id="deliveryInfo" style="display: none;" c>
								<!--만약 체크 되어진다면 회원 정보에 저장된 이름, 메일 , 연락처 , 주소지 를 가져오고
                          	체크가 안될경우 따로 input 에 입력해서 그 값을 결제정보에 넘기기  -->
								<tr>
									<th scope="row"
										style="color: white; background-color: #343A40; width: 15%; text-align: right;">이름</th>
									<td>${ member.memberName}</td>
								</tr>
								<tr>
									<th scope="row"
										style="color: white; background-color: #343A40; width: 15%; text-align: right;">이메일</th>
									<td>${ member.email}</td>
								</tr>
								<tr>
									<th scope="row"
										style="color: white; background-color: #343A40; width: 15%; text-align: right;">연락처</th>
									<td>${ member.phone }</td>
								</tr>
								<tr>
									<th scope="row"
										style="color: white; background-color: #343A40; width: 15%; text-align: right;">배송주소</th>
									<td>${ member.address }${member.detailAddress}</td>
								</tr>
								<tr>
									<th scope="row"
										style="color: white; background-color: #343A40; width: 15%; text-align: right;">배송요청사항</th>
									<td><select name="dMessage">
											<option>부재 시 문앞에 놔주세요.</option>
											<option>배송 전 연락부탁드립니다.</option>
											<option>문앞에 사나운 강아지가 있습니다.주의하세요.</option>
									</select></td>
								</tr>
							</tbody>
							<!--만약 체크 되어진다면 회원 정보에 저장된 이름, 메일 , 연락처 , 주소지 를 가져오고
                          		체크가 안될경우 따로 input 에 입력해서 그 값을 결제정보에 넘기기  -->
							<tbody id="receiverInfo">
								<tr>
									<th scope="row"
										style="color: white; background-color: #343A40; width: 15%; text-align: right;">이름</th>
									<td><input type="name" name="userName"
										placeholder="이름을 입력하세요"></td>
								</tr>
								<tr>
									<th scope="row"
										style="color: white; background-color: #343A40; width: 15%; text-align: right;">이메일</th>
									<td><input type="email" name="email"
										placeholder="이메일을 입력하세요"></td>
								</tr>
								<tr>
									<th scope="row"
										style="color: white; background-color: #343A40; width: 15%; text-align: right;">연락처</th>
									<td><input type="phone" name="phone"
										placeholder="핸드폰 번호를 입력하세요"></td>
								</tr>
								<tr>
									<th rowspan="4" scope="row"
										style="color: white; background-color: #343A40; width: 15%; height: 100px; text-align: right;">배송주소</th>


									<td rowspan="4">
										<input type="name" class="form-control"
										aria-describedby="emailHelp" id="postcode" placeholder="우편번호"
										name="zipcode" style="width:100px; float:left;">
									
									<input type="button" onclick="execDaumPostcode()"
										value="우편번호 찾기" style="font-size: 12px; padding: 9px 3px 9px 3px;"
										class="btn btn-secondary">
									<br>
									
									<input type="name" class="form-control"
										aria-describedby="emailHelp" id="address" name="address"
										placeholder="주소" style="width: 100%; text-align:left;">
									
									<input type="name" class="form-control"
										aria-describedby="emailHelp" id="detailAddress"
										name="detailAddress" placeholder="상세주소" required
										style="width: 100%;"></td>
								</tr>
								<tr></tr>
								<tr></tr>
								<tr></tr>


								<!-- 
										<td><input type="text" id="postcode" placeholder="우편번호"
											name="zipcode"></td>
										<td><input type="button" onclick="execDaumPostcode()"
											value="우편번호 찾기"><br></td>
										<td><input type="text" id="address" name="address"
											placeholder="주소"><br></td>
										<td><input type="text" id="detailAddress"
											name="detailAddress" placeholder="상세주소" required></td> -->

								<tr>
									<th scope="row"
										style="color: white; background-color: #343A40; width: 15%; text-align: right;">배송요청사항</th>
									<td><select name="dMessage">
											<option>부재 시 문앞에 놔주세요.</option>
											<option>배송 전 연락부탁드립니다.</option>
											<option>문앞에 사나운 강아지가 있습니다.주의하세요.</option>
									</select></td>
								</tr>
							</tbody>
						</table>
					</div>
					<br> <br> <br>
					<h6 style="font-weight: bold;">결제수단(무통장 입금)</h6>
					<div style="width: 100%;">
						<table class="table" id="basket_3">
							<tbody>
								<tr>
									<th scope="row"
										style="color: white; background-color: #343A40; width: 15%; text-align: right;">입금은행</th>
									<td>국민은행</td>
								</tr>
								<tr>
									<th scope="row"
										style="color: white; background-color: #343A40; width: 15%; text-align: right;">계좌번호</th>
									<td>015871-09-489-191</td>
								</tr>
								<tr>
									<th scope="row"
										style="color: white; background-color: #343A40; width: 15%; text-align: right;">계좌주</th>
									<td>(주)어셈블</td>
								</tr>
							</tbody>
						</table>
					</div>
					<br> <br> <br>
					<h6 style="font-weight: bold; color: red;">[필수]</h6>
					<h6 style="font-weight: bold;">구매조건 확인</h6>
					<div style="width: 100%;">
						<table class="table" id="basket_3">
							<tbody>
								<tr>
									<th scope="row"
										style="color: white; background-color: #343A40; width: 15%; text-align: right;">항목</th>
									<td>배송지 정보(주소, 받는사람, 연락처) / 결제정보(입금자명, 이메일, 휴대폰)</td>
								</tr>
								<tr>
									<th scope="row"
										style="color: white; background-color: #343A40; width: 15%; text-align: right;">계좌번호</th>
									<td>이용자 식별을 위한 본인 여부 확인 / 서비스 상품 배송 / 안내</td>
								</tr>
								<tr>
									<th scope="row"
										style="color: white; background-color: #343A40; width: 15%; text-align: right;">보유기간</th>
									<td>상품 구매 / 컨텐츠 이용내역 보존 정책으로 인한 기록된 정보는 파기 불가</td>
								</tr>
							</tbody>
						</table>
					</div>
					<br>
					<div style="width: 100%; text-align: center; font-size: 14px;">
						<input type="checkbox" required>위 주문 내용을 확인하였으며, 회원 본인은
						결제에 동의합니다.
					</div>
					<br>
					<div style="width: 100%; font-size: 14px; text-align: center;">
						<button type="submit" class="btn btn-secondary"	style="background-color: #343A40; color: white;" id="orderButton">결제하기</button>
					</div>
				</form>
				<br> <br>
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