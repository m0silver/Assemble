<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SELF COMPONENT</title>
<!-- <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"> -->
<script src='https://code.jquery.com/jquery-3.2.1.min.js'></script>
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter bootstrap/3.3.7/css/bootstrap.min.css"/> -->

<link rel="stylesheet" type="text/css" href="/css/component/selfComputer.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
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





	<!-- SECTION AREA -->

	<section>




		<form action="/basketS/insert" method="get">
			<!-- Component Servlet AREA -->

			<!-- 메인부품  -->
			<input type="hidden" name="sendCPU"> <input type="hidden" name="sendMainBoard"> <input type="hidden" name="sendRAM">
			<input type="hidden" name="sendGCARD"> <input type="hidden" name="sendSSD"> <input type="hidden" name="sendCOOLER">
			<input type="hidden" name="sendPOWER"> <input type="hidden" name="sendSKIN"> <input type="hidden" name="sendHDD">
			<!-- 기타부품 -->
			<input type="hidden" name="sendDESKTOP"> <input type="hidden" name="sendKEYBOARD"> <input type="hidden" name="sendMOUSE">
			<input type="hidden" name="sendHEADSET"> <input type="hidden" name="sendSPEAKER">




			<!-- M A I N  L O G O -->
			<div id="main_image">
				<img src="/img/onofflogo.gif"
					style="display: block; margin: auto; width: 100%; height: 100%;">
				<!-- style="height: 100%; width: 100%;" -->
			</div>





			<!-- 셀프견적 영역 시작-->
			<div class="secHeader">
				<div class="sectextLine">
					<span class="fas fa-cog fa-spin" style="float: left;"></span>
					<p>
						<b>원하는 부품들을 선택하여 <br> &nbsp;&nbsp;&nbsp;자신만의 PC를 조립해보세요 !
						</b>
					</p>
				</div>
				<div class="sectextLineMiddle">
					<p>
						<b>S E L F</b>
					</p>
				</div>
			</div>
			<!-- SECTION CONTENT AREA-->
			<div class="selfsectionContent">
				<div class="componentArea">
					<div class="componentAreaTopTitle">
						<span class="fas fa-cog fa-spin"
							style="float: left; font-size: 25px;"></span>&nbsp;&nbsp;&nbsp;<b>PC
							Component</b>
					</div>
					<br> <br>
					<hr>
					<div class="productListTop">
						<div class="componentMenuBar">
							<b>부품선택</b>
						</div>
						<div class="componentMenuBarTwo">
							<b>부품명</b>
						</div>
						<div class="componentMenuBarThree">
							<b>수량</b>
						</div>
						<div class="componentMenuBarFour">
							<b>가격</b>
						</div>
						<div class="productDelete"></div>
					</div>
					<br>
					<hr>


					<!--모달 버튼영역-->

					<!--         CPU -->

					<div class="productList">
						<div class="productButton">
							<button type="button" data-toggle="modal" data-target="#CPU">
								<img src="/img_selfPage/CPUicon.png" alt="none">
							</button>
						</div>
						<div class="productName">
							CPU <span class="badge badge-secondary">»</span> <span id="cpuName">미선택</span>
						</div>
						<div class="productCount">
							<span id="cpuCount"></span> <b>EA</b>
						</div>
						<div class="productPrice">
							<span id="cpuPrice" class="priceColor"></span> <b>won</b>
						</div>
						<div class="productDelete">
							<button type='button' id='cpuDeleteButton'>
								<img src='/img_selfPage/closeIcon.png' style="width: 18px;">
							</button>
						</div>
					</div>



					<!--         MAINBOARD -->
					<div class="productList">
						<div class="productButton">
							<button type="button" data-toggle="modal"
								data-target="#MAINBOARD">
								<img src="/img_selfPage/MAINBOARDicon.png" alt="none">
							</button>
						</div>
						<div class="productName">
							메인보드 <span class="badge badge-secondary">»</span> <span
								id="mainboardName">미선택</span>
						</div>
						<div class="productCount">
							<span id="mainboardCount"></span> <b>EA</b>
						</div>
						<div class="productPrice">
							<span id="mainboardPrice" class="priceColor"></span> <b>won</b>
						</div>
						<div class="productDelete">
							<button type="button" id="mboardDeleteButton">
								<img src="/img_selfPage/closeIcon.png" style="width: 18px;">
							</button>
						</div>
					</div>


					<!--         RAM -->
					<div class="productList">
						<div class="productButton">
							<button type="button" data-toggle="modal" data-target="#RAM">
								<img src="/img_selfPage/RAMicon.png" alt="none">
							</button>
						</div>
						<div class="productName">
							RAM <span class="badge badge-secondary">»</span> <span id="ramName">미선택</span>
						</div>
						<div class="productCount">
							<span id="ramCount"></span> <b>EA</b>
						</div>
						<div class="productPrice">
							<span id="ramPrice" class="priceColor"></span> <b>won</b>
						</div>
						<div class="productDelete">
							<button type="button" id="ramDeleteButton">
								<img src="/img_selfPage/closeIcon.png" style="width: 18px;">
							</button>
						</div>
					</div>




					<!--         GCARD -->
					<div class="productList">
						<div class="productButton">
							<button type="button" data-toggle="modal" data-target="#GPU">
								<img src="/img_selfPage/GCARDicon.png" alt="none">
							</button>
						</div>
						<div class="productName">
							그래픽카드 <span class="badge badge-secondary">»</span> <span
								id="gcardName">미선택</span>
						</div>
						<div class="productCount">
							<span id="gcardCount"></span> <b>EA</b>
						</div>
						<div class="productPrice">
							<span id="gcardPrice" class="priceColor"></span> <b>won</b>
						</div>
						<div class="productDelete">
							<button type="button" id="gcardDeleteButton">
								<img src="/img_selfPage/closeIcon.png" style="width: 18px;">
							</button>
						</div>
					</div>





					<!--         SSD -->
					<div class="productList">
						<div class="productButton">
							<button type="button" data-toggle="modal" data-target="#SSD">
								<img src="/img_selfPage/SSDicon.png" alt="none">
							</button>
						</div>
						<div class="productName">
							SSD <span class="badge badge-secondary">»</span> <span id="ssdName">미선택</span>
						</div>
						<div class="productCount">
							<span id="ssdCount"></span> <b>EA</b>
						</div>
						<div class="productPrice">
							<span id="ssdPrice" class="priceColor"></span> <b>won</b>
						</div>
						<div class="productDelete">
							<button type="button" id="ssdDeleteButton">
								<img src="/img_selfPage/closeIcon.png" style="width: 18px;">
							</button>
						</div>
					</div>




					<!--         CPU-COOLER -->
					<div class="productList">
						<div class="productButton">
							<button type="button" data-toggle="modal"
								data-target="#CPUCOOLER">
								<img src="/img_selfPage/COOLERicon.png" alt="none">
							</button>
						</div>
						<div class="productName">
							CPU쿨러 <span class="badge badge-secondary">»</span> <span
								id="coolerName">미선택</span>
						</div>
						<div class="productCount">
							<span id="coolerCount"></span> <b>EA</b>
						</div>
						<div class="productPrice">
							<span id="coolerPrice" class="priceColor"></span> <b>won</b>
						</div>
						<div class="productDelete">
							<button type="button" id="coolerDeleteButton">
								<img src="/img_selfPage/closeIcon.png" style="width: 18px;">
							</button>
						</div>
					</div>



					<!--         POWER -->
					<div class="productList">
						<div class="productButton">
							<button type="button" data-toggle="modal" data-target="#POWER">
								<img src="/img_selfPage/POWERicon.png" alt="none">
							</button>
						</div>
						<div class="productName">
							파워 <span class="badge badge-secondary">»</span> <span id="powerName">미선택</span>
						</div>
						<div class="productCount">
							<span id="powerCount"></span> <b>EA</b>
						</div>
						<div class="productPrice">
							<span id="powerPrice" class="priceColor"></span> <b>won</b>
						</div>
						<div class="productDelete">
							<button type="button" id="powerDeleteButton">
								<img src="/img_selfPage/closeIcon.png" style="width: 18px;">
							</button>
						</div>
					</div>




					<!--         SKIN -->
					<div class="productList">
						<div class="productButton">
							<button type="button" data-toggle="modal" data-target="#SKIN">
								<img src="/img_selfPage/SKINicon.png" alt="none">
							</button>
						</div>
						<div class="productName">
							케이스 <span class="badge badge-secondary">»</span> <span id="skinName">미선택</span>
						</div>
						<div class="productCount">
							<span id="skinCount"></span> <b>EA</b>
						</div>
						<div class="productPrice">
							<span id="skinPrice" class="priceColor"></span> <b>won</b>
						</div>
						<div class="productDelete">
							<button type="button" id="skinDeleteButton">
								<img src="/img_selfPage/closeIcon.png" style="width: 18px;">
							</button>
						</div>
					</div>






					<!--         HDD -->
					<div class="productList">
						<div class="productButton">
							<button type="button" data-toggle="modal" data-target="#HDD">
								<img src="/img_selfPage/HDDicon.png" alt="none">
							</button>
						</div>
						<div class="productName">
							HDD <span class="badge badge-secondary">»</span> <span id="hddName">미선택</span>
						</div>
						<div class="productCount">
							<span id="hddCount"></span> <b>EA</b>
						</div>
						<div class="productPrice">
							<span id="hddPrice" class="priceColor"></span> <b>won</b>
						</div>
						<div class="productDelete">
							<button type="button" id="hddDeleteButton">
								<img src="/img_selfPage/closeIcon.png" style="width: 18px;">
							</button>
						</div>
					</div>
				</div>
				<div class="nullArea">
					Price " <span><b class="procutPriceArea">0</b></span> won
				</div>





				<!-- 기타부품 영역-->
				<div class="componentAreaTwo">
					<div class="componentAreaTopTitleTwo">
						<span class="fas fa-cog fa-spin"
							style="float: left; font-size: 25px;"></span>&nbsp;&nbsp;&nbsp;<b>PC
							기타부품</b>
					</div>
					<br> <br>
					<hr>
					<div class="productListTop">
						<div class="componentMenuBar">
							<b>부품선택</b>
						</div>
						<div class="componentMenuBarTwo">
							<b>부품명</b>
						</div>
						<div class="componentMenuBarThree">
							<b>수량</b>
						</div>
						<div class="componentMenuBarFour">
							<b>가격</b>
						</div>
					</div>
					<br>
					<hr>




					<!-- 			모니터  -->
					<div class="productList2">
						<div class="productButton">
							<button type="button" data-toggle="modal" data-target="#DESKTOP">
								<img src="/img_selfPage/moniter.png" alt="none">
							</button>
						</div>
						<div class="productName">
							모니터 <span class="badge badge-secondary">»</span> <span
								id="desktopName">미선택</span>
						</div>
						<div class="productCount">
							<span id="desktopCount"></span> <b>EA</b>
						</div>
						<div class="productPrice">
							<span id="desktopPrice" class="priceColor"></span> <b>won</b>
						</div>
						<div class="productDelete">
							<button type="button" id="desktopDeleteButton">
								<img src="/img_selfPage/closeIcon.png" style="width: 18px;">
							</button>
						</div>
					</div>




					<!--			키보드  -->
					<div class="productList2">
						<div class="productButton">
							<button type="button" data-toggle="modal" data-target="#KEYBOARD">
								<img src="/img_selfPage/KEYBOARDicon.png" alt="none">
							</button>
						</div>
						<div class="productName">
							키보드 <span class="badge badge-secondary">»</span> <span
								id="keyboardName">미선택</span>
						</div>
						<div class="productCount">
							<span id="keyboardCount"></span> <b>EA</b>
						</div>
						<div class="productPrice">
							<span id="keyboardPrice" class="priceColor"></span> <b>won</b>
						</div>
						<div class="productDelete">
							<button type="button" id="keyboardDeleteButton">
								<img src="/img_selfPage/closeIcon.png" style="width: 18px;">
							</button>
						</div>
					</div>




					<!--			마우스  -->
					<div class="productList2">
						<div class="productButton">
							<button type="button" data-toggle="modal" data-target="#MOUSE">
								<img src="/img_selfPage/MOUSEicon.png" alt="none">
							</button>
						</div>
						<div class="productName">
							마우스 <span class="badge badge-secondary">»</span> <span id="mouseName">미선택</span>
						</div>
						<div class="productCount">
							<span id="mouseCount"></span> <b>EA</b>
						</div>
						<div class="productPrice">
							<span id="mousePrice" class="priceColor"></span> <b>won</b>
						</div>
						<div class="productDelete">
							<button type="button" id="mouseDeleteButton">
								<img src="/img_selfPage/closeIcon.png" style="width: 18px;">
							</button>
						</div>
					</div>




					<!--			헤드셋  -->
					<div class="productList2">
						<div class="productButton">
							<button type="button" data-toggle="modal" data-target="#HEADSET">
								<img src="/img_selfPage/HEADSETicon.png" alt="none">
							</button>
						</div>
						<div class="productName">
							헤드셋 <span class="badge badge-secondary">»</span> <span
								id="headsetName">미선택</span>
						</div>
						<div class="productCount">
							<span id="headsetCount"></span> <b>EA</b>
						</div>
						<div class="productPrice">
							<span id="headsetPrice" class="priceColor"></span> <b>won</b>
						</div>
						<div class="productDelete">
							<button type="button" id="headsetDeleteButton">
								<img src="/img_selfPage/closeIcon.png" style="width: 18px;">
							</button>
						</div>
					</div>




					<!--			스피커  -->
					<div class="productList2">
						<div class="productButton">
							<button type="button" data-toggle="modal" data-target="#SPEAKER">
								<img src="/img_selfPage/SOUNDicon.png" alt="none">
							</button>
						</div>
						<div class="productName">
							스피커 <span class="badge badge-secondary">»</span> <span
								id="speakerName">미선택</span>
						</div>
						<div class="productCount">
							<span id="speakerCount"></span> <b>EA</b>
						</div>
						<div class="productPrice">
							<span id="speakerPrice" class="priceColor"></span> <b>won</b>
						</div>
						<div class="productDelete">
							<button type="button" id="speakerDeleteButton">
								<img src="/img_selfPage/closeIcon.png" style="width: 18px;">
							</button>
						</div>
					</div>
				</div>
				<div class="BuyCartArea">
					<button type="submit" class="btn btn-secondary btn-lg btn-block">
						<b>장바구니에 담기</b>
					</button>
				</div>
			</div>
		</form>






		<!--              모달 영역 시작                             -->







		<!-- CPU Modal -->
		<div class="modal fade" id="CPU" tabindex="-1" role="dialog"
			aria-labelledby="CPU_TITLE" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-xl"
				role="document">
				<!-- 센터모달창 추가  modal-dialog-centered -->
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="CPU_TITLE">
							<b>상품선택(CPU)</b>
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<c:forEach items="${ cpuL }" var="cpuL">
							<div class="productArea">
								<div class="productImage">
									<img src="/upload/${cpuL.pFilename}" class="listImage">
								</div>
								<div class="productNP">
									<div class="productN">
										상품명 <span class="badge badge-secondary">Click</span> <b><a
											href="javascript:cpuChoice('${cpuL.pCode}','${cpuL.pName}','${cpuL.pAccount}','${cpuL.pPrice}')"
											class="productlink" data-toggle="componentTool"
											data-placement="right" title="${cpuL.pContents}">
												${cpuL.pName}</a></b>
									</div>
									<div class="productP">
										가격 : <b class="priceColor">${cpuL.pPrice}</b>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">CLOSE</button>
					</div>
				</div>
			</div>
		</div>






		<!-- CPU @ COOLER  -->
		<div class="modal fade" id="CPUCOOLER" tabindex="-1" role="dialog"
			aria-labelledby="COOLER_TITLE" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-xl"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="COOLER_TITLE">
							<b>상품선택(COOLER)</b>
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<c:forEach items="${ coolL }" var="coolL">
							<div class="productArea">
								<div class="productImage">
									<img src="/upload/${coolL.pFilename}" class="listImage">
								</div>
								<div class="productNP">
									<div class="productN">
										상품명 <span class="badge badge-secondary">Click</span> <b><a
											href="javascript:coolerChoice('${coolL.pCode}','${coolL.pName}','${coolL.pAccount}','${coolL.pPrice}')"
											class="productlink" data-toggle="componentTool"
											data-placement="right" title="${coolL.pContents}">
												${coolL.pName}</a></b>
									</div>
									<div class="productP">
										가격 : <b class="priceColor">${coolL.pPrice}</b>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">CLOSE</button>
					</div>
				</div>
			</div>
		</div>







		<!-- GPU  -->
		<div class="modal fade" id="GPU" tabindex="-1" role="dialog"
			aria-labelledby="GPU_TITLE" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-xl"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="GPU_TITLE">
							<b>상품선택(GPU)</b>
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<c:forEach items="${ gcardL }" var="gcardL">
							<div class="productArea">
								<div class="productImage">
									<img src="/upload/${gcardL.pFilename}" class="listImage">
								</div>
								<div class="productNP">
									<div class="productN">
										상품명 <span class="badge badge-secondary">Click</span> <b><a
											href="javascript:gpuChoice('${gcardL.pCode}','${gcardL.pName}','${gcardL.pAccount}','${gcardL.pPrice}')"
											class="productlink" data-toggle="componentTool"
											data-placement="right" title="${gcardL.pContents}">
												${gcardL.pName}</a></b>
									</div>
									<div class="productP">
										가격 : <b class="priceColor">${gcardL.pPrice}</b>
									</div>
								</div>
							</div>
						</c:forEach>


					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">CLOSE</button>
					</div>
				</div>
			</div>
		</div>






		<!-- HDD  -->
		<div class="modal fade" id="HDD" tabindex="-1" role="dialog"
			aria-labelledby="HDD_TITLE" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-xl"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="HDD_TITLE">
							<b>상품선택(HDD)</b>
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<c:forEach items="${ hddL }" var="hddL">
							<div class="productArea">
								<div class="productImage">
									<img src="/upload/${hddL.pFilename}" class="listImage">
								</div>
								<div class="productNP">
									<div class="productN">
										상품명 <span class="badge badge-secondary">Click</span> <b><a
											href="javascript:hddChoice('${hddL.pCode}','${hddL.pName}','${hddL.pAccount}','${hddL.pPrice}')"
											class="productlink" data-toggle="componentTool"
											data-placement="right" title="${hddL.pContents}">
												${hddL.pName}</a></b>
									</div>
									<div class="productP">
										가격 : <b class="priceColor">${hddL.pPrice}</b>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">CLOSE</button>
					</div>
				</div>
			</div>
		</div>






		<!-- RAM  -->

		<div class="modal fade" id="RAM" tabindex="-1" role="dialog"
			aria-labelledby="RAM_TITLE" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-xl"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="RAM_TITLE">
							<b>상품선택(RAM)</b>
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<c:forEach items="${ ramL }" var="ramL">
							<div class="productArea">
								<div class="productImage">
									<img src="/upload/${ramL.pFilename}" class="listImage">
								</div>
								<div class="productNP">
									<div class="productN">
										상품명<span class="badge badge-secondary">Click</span> <b><a
											href="javascript:ramChoice('${ramL.pCode}','${ramL.pName}','${ramL.pAccount}','${ramL.pPrice}')"
											class="productlink" data-toggle="componentTool"
											data-placement="right" title="${ramL.pContents}">
												${ramL.pName}</a></b>
									</div>
									<div class="productP">
										가격 : <b class="priceColor">${ramL.pPrice}</b>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">CLOSE</button>
					</div>
				</div>
			</div>
		</div>







		<!-- SKIN  -->
		<div class="modal fade" id="SKIN" tabindex="-1" role="dialog"
			aria-labelledby="SKIN_TITLE" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-xl"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="SKIN_TITLE">
							<b>상품선택(SKIN)</b>
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<c:forEach items="${ skinL }" var="skinL">
							<div class="productArea">
								<div class="productImage">
									<img src="/upload/${skinL.pFilename}" class="listImage">
								</div>
								<div class="productNP">
									<div class="productN">
										상품명 <span class="badge badge-secondary">Click</span> <b><a
											href="javascript:skinChoice('${skinL.pCode}','${skinL.pName}','${skinL.pAccount}','${skinL.pPrice}')"
											class="productlink" data-toggle="componentTool"
											data-placement="right" title="${skinL.pContents}">
												${skinL.pName}</a></b>
									</div>
									<div class="productP">
										가격 : <b class="priceColor">${skinL.pPrice}</b>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">CLOSE</button>
					</div>
				</div>
			</div>
		</div>






		<!-- SSD Modal -->
		<div class="modal fade" id="SSD" tabindex="-1" role="dialog"
			aria-labelledby="SSD_TITLE" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-xl"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="SSD_TITLE">
							<b>상품선택(SSD)</b>
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<c:forEach items="${ ssdL }" var="ssdL">
							<div class="productArea">
								<div class="productImage">
									<img src="/upload/${ssdL.pFilename}" class="listImage">
								</div>
								<div class="productNP">
									<div class="productN">
										상품명 <span class="badge badge-secondary">Click</span> <b><a
											href="javascript:ssdChoice('${ssdL.pCode}','${ssdL.pName}','${ssdL.pAccount}','${ssdL.pPrice}')"
											class="productlink" data-toggle="componentTool"
											data-placement="right" title="${ssdL.pContents}">
												${ssdL.pName}</a></b>
									</div>
									<div class="productP">
										가격 : <b class="priceColor">${ssdL.pPrice}</b>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">CLOSE</button>
					</div>
				</div>
			</div>
		</div>







		<!-- POWER  -->
		<div class="modal fade" id="POWER" tabindex="-1" role="dialog"
			aria-labelledby="POWER_TITLE" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-xl"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="POWER_TITLE">
							<b>상품선택(POWER)</b>
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<c:forEach items="${ powerL }" var="powerL">
							<div class="productArea">
								<div class="productImage">
									<img src="/upload/${powerL.pFilename}" class="listImage">
								</div>
								<div class="productNP">
									<div class="productN">
										상품명 <span class="badge badge-secondary">Click</span> <b><a
											href="javascript:powerChoice('${powerL.pCode}','${powerL.pName}','${powerL.pAccount}','${powerL.pPrice}')"
											class="productlink" data-toggle="componentTool"
											data-placement="right" title="${powerL.pContents}">
												${powerL.pName}</a></b>
									</div>
									<div class="productP">
										가격 : <b class="priceColor">${powerL.pPrice}</b>
									</div>
								</div>
							</div>
						</c:forEach>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">CLOSE</button>
					</div>
				</div>
			</div>
		</div>






		<!-- MAIN BOARD   호환성 해야됨  -->
		<div class="modal fade" id="MAINBOARD" tabindex="-1" role="dialog"
			aria-labelledby="MAINBOARD_TITLE" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-xl"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="MAINBOARD_TITLE">
							<b>상품선택(MAIN BOARD)</b>
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<c:forEach items="${mboardL}" var="mboardL">
							<div class="productArea">
								<div class="productImage">
									<img src="/upload/${mboardL.pFilename}" class="listImage">
								</div>
								<div class="productNP">
									<div class="productN">
										상품명 <span class="badge badge-secondary">Click</span> <b><a
											href="javascript:mboardChoice('${mboardL.pCode}','${mboardL.pName}','${mboardL.pAccount}','${mboardL.pPrice}')"
											class="productlink" data-toggle="componentTool"
											data-placement="right" title="${mboardL.pContents}">
												${mboardL.pName}</a></b>
									</div>
									<div class="productP">
										가격 : <b class="priceColor">${mboardL.pPrice}</b>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">CLOSE</button>
					</div>
				</div>
			</div>
		</div>






		<!-- DESKTOP 모니터  -->
		<div class="modal fade" id="DESKTOP" tabindex="-1" role="dialog"
			aria-labelledby="DESKTOP_TITLE" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-xl"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="DESKTOP_TITLE">
							<b>상품선택(모니터)</b>
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<c:forEach items="${ deskTopL }" var="deskTopL">
							<div class="productArea">
								<div class="productImage">
									<img src="/upload/${deskTopL.pFilename}" class="listImage">
								</div>
								<div class="productNP">
									<div class="productN">
										상품명 <span class="badge badge-secondary">Click</span> <b><a
											href="javascript:desktopChoice('${deskTopL.pCode}','${deskTopL.pName}','${deskTopL.pAccount}','${deskTopL.pPrice}')"
											class="productlink" data-toggle="componentTool"
											data-placement="right" title="${deskTopL.pContents}">
												${deskTopL.pName}</a></b>
									</div>
									<div class="productP">
										가격 : <b class="priceColor">${deskTopL.pPrice}</b>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">CLOSE</button>
					</div>
				</div>
			</div>
		</div>





		<!-- 키보드  -->
		<div class="modal fade" id="KEYBOARD" tabindex="-1" role="dialog"
			aria-labelledby="KEYBOARD_TITLE" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-xl"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="KEYBOARD_TITLE">
							<b>상품선택(KEYBOARD)</b>
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<c:forEach items="${ keyBoardL }" var="keyBoardL">
							<div class="productArea">
								<div class="productImage">
									<img src="/upload/${keyBoardL.pFilename}" class="listImage">
								</div>
								<div class="productNP">
									<div class="productN">
										상품명 <span class="badge badge-secondary">Click</span> <b><a
											href="javascript:keyboardChoice('${keyBoardL.pCode}','${keyBoardL.pName}','${keyBoardL.pAccount}','${keyBoardL.pPrice}')"
											class="productlink" data-toggle="componentTool"
											data-placement="right" title="${keyBoardL.pContents}">
												${keyBoardL.pName}</a></b>
									</div>
									<div class="productP">
										가격 : <b class="priceColor">${keyBoardL.pPrice}</b>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">CLOSE</button>
					</div>
				</div>
			</div>
		</div>




		<!-- MOUSE 마우스  -->
		<div class="modal fade" id="MOUSE" tabindex="-1" role="dialog"
			aria-labelledby="MOUSE_TITLE" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-xl"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="MOUSE_TITLE">
							<b>상품선택(MOUSE)</b>
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<c:forEach items="${ mouseL }" var="mouseL">
							<div class="productArea">
								<div class="productImage">
									<img src="/upload/${mouseL.pFilename}" class="listImage">
								</div>
								<div class="productNP">
									<div class="productN">
										상품명 <span class="badge badge-secondary">Click</span> <b><a
											href="javascript:mouseChoice('${mouseL.pCode}','${mouseL.pName}','${mouseL.pAccount}','${mouseL.pPrice}')"
											class="productlink" data-toggle="componentTool"
											data-placement="right" title="${mouseL.pContents}">
												${mouseL.pName}</a></b>
									</div>
									<div class="productP">
										가격 : <b class="priceColor">${mouseL.pPrice}</b>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">CLOSE</button>
					</div>
				</div>
			</div>
		</div>




		<!-- HEADSET 헤드셋  -->
		<div class="modal fade" id="HEADSET" tabindex="-1" role="dialog"
			aria-labelledby="HEADSET_TITLE" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-xl"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="HEADSET_TITLE">
							<b>상품선택(HEADSET)</b>
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<c:forEach items="${ headSetL }" var="headSetL">
							<div class="productArea">
								<div class="productImage">
									<img src="/upload/${headSetL.pFilename}" class="listImage">
								</div>
								<div class="productNP">
									<div class="productN">
										상품명 <span class="badge badge-secondary">Click</span> <b><a
											href="javascript:headsetChoice('${headSetL.pCode}','${headSetL.pName}','${headSetL.pAccount}','${headSetL.pPrice}')"
											class="productlink" data-toggle="componentTool"
											data-placement="right" title="${headSetL.pContents}">
												${headSetL.pName}</a></b>
									</div>
									<div class="productP">
										가격 : <b class="priceColor">${headSetL.pPrice}</b>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">CLOSE</button>
					</div>
				</div>
			</div>
		</div>








		<!-- SPEAKER 스피커  -->
		<div class="modal fade" id="SPEAKER" tabindex="-1" role="dialog"
			aria-labelledby="SPEAKER_TITLE" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable modal-xl"
				role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="SPEAKER_TITLE">
							<b>상품선택(SPEAKER)</b>
						</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">

						<c:forEach items="${ speakerL }" var="speakerL">
							<div class="productArea">
								<div class="productImage">
									<img src="/upload/${speakerL.pFilename}" class="listImage">
								</div>
								<div class="productNP">
									<div class="productN">
										상품명 <span class="badge badge-secondary">Click</span> <b><a
											href="javascript:speakerChoice('${speakerL.pCode}','${speakerL.pName}','${speakerL.pAccount}','${speakerL.pPrice}')"
											class="productlink" data-toggle="componentTool"
											data-placement="right" title="${speakerL.pContents}">
												${speakerL.pName}</a></b>
									</div>
									<div class="productP">
										가격 : <b class="priceColor">${speakerL.pPrice}</b>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-dismiss="modal">CLOSE</button>
					</div>
				</div>
			</div>
		</div>


		<!-- 						모달끝               -->
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

	<!-- 모달 스크립트 -->
	<script>
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
      });
	
		// 선택된 상품가격 저장변수
	 	var cpuP = 0; var mboardP = 0; var ramP = 0;
	 	var gcardP = 0; var ssdP = 0; var coolerP = 0;
		var powerP = 0; var skinP = 0; var hddP = 0;
		var desktopP = 0; var keyboardP = 0; var mouseP = 0;
		var headsetP = 0; var speakerP = 0; var totalPrice = 0;
		//CPU
		function cpuChoice(code,name,count,price){
			$("input[name='sendCPU']").val(code);
		 	$("#cpuName").text(name);
			$("#cpuCount").text(count);
			$("#cpuPrice").text(price);
			
			cpuP = parseInt($("#cpuPrice").text() || 0);
			totalPrice = totalPrice + cpuP;
			$(".procutPriceArea").text(totalPrice);
			$('#CPU').modal('hide');
		}
		// COOLER
		function coolerChoice(code, name, count, price){
			$("input[name='sendCOOLER']").val(code);
		 	$("#coolerName").text(name);
			$("#coolerCount").text(count);
			$("#coolerPrice").text(price);
			
			coolerP = parseInt($("#coolerPrice").text() || 0);
			totalPrice = totalPrice + coolerP;
			$(".procutPriceArea").text(totalPrice);
			$('#CPUCOOLER').modal('hide');			
		}
		// GCARD(GPU)
		function gpuChoice(code, name, count, price){
			$("input[name='sendGCARD']").val(code);
		 	$("#gcardName").text(name);
			$("#gcardCount").text(count);
			$("#gcardPrice").text(price);
			
			gcardP = parseInt($("#gcardPrice").text() || 0);
			totalPrice = totalPrice + gcardP;
			$(".procutPriceArea").text(totalPrice);
			$('#GPU').modal('hide');			
		}
		// HDD
		function hddChoice(code, name, count, price){
			$("input[name='sendHDD']").val(code);
		 	$("#hddName").text(name);
			$("#hddCount").text(count);
			$("#hddPrice").text(price);
			
			hddP = parseInt($("#hddPrice").text() || 0);
			totalPrice = totalPrice + hddP;
			$(".procutPriceArea").text(totalPrice);
			$('#HDD').modal('hide');		
		}
		// RAM
		function ramChoice(code, name, count, price) {
			$("input[name='sendRAM']").val(code);
		 	$("#ramName").text(name);
			$("#ramCount").text(count);
			$("#ramPrice").text(price);
			
			ramP = parseInt($("#ramPrice").text() || 0);
			totalPrice = totalPrice + ramP;
			$(".procutPriceArea").text(totalPrice);
			$('#RAM').modal('hide');	
		}
		// SKIN
		function skinChoice(code, name, count, price) {
			$("input[name='sendSKIN']").val(code);
		 	$("#skinName").text(name);
			$("#skinCount").text(count);
			$("#skinPrice").text(price);
			
			skinP = parseInt($("#skinPrice").text() || 0);
			totalPrice = totalPrice + skinP;
			$(".procutPriceArea").text(totalPrice);
			$('#SKIN').modal('hide');	
		}
		// SSD
		function ssdChoice(code, name, count, price) {
			$("input[name='sendSSD']").val(code);
		 	$("#ssdName").text(name);
			$("#ssdCount").text(count);
			$("#ssdPrice").text(price);
			
			ssdP = parseInt($("#ssdPrice").text() || 0);
			totalPrice = totalPrice + ssdP;
			$(".procutPriceArea").text(totalPrice);
			$('#SSD').modal('hide');	
		}
		// POWER
		function powerChoice(code, name, count, price) {
			$("input[name='sendPOWER']").val(code);
		 	$("#powerName").text(name);
			$("#powerCount").text(count);
			$("#powerPrice").text(price);
			
			powerP = parseInt($("#powerPrice").text() || 0);
			totalPrice = totalPrice + powerP;
			$(".procutPriceArea").text(totalPrice);
			$('#POWER').modal('hide');	
		}
		// MAIN BOARD
		function mboardChoice(code, name, count, price){
			$("input[name='sendMainBoard']").val(code);
		 	$("#mainboardName").text(name);
			$("#mainboardCount").text(count);
			$("#mainboardPrice").text(price);
			
			mboardP = parseInt($("#mainboardPrice").text() || 0);
			totalPrice = totalPrice + mboardP;
			$(".procutPriceArea").text(totalPrice);
			$('#MAINBOARD').modal('hide');
		}
		// DESKTOP
		function desktopChoice(code, name, count, price){
			$("input[name='sendDESKTOP']").val(code);
		 	$("#desktopName").text(name);
			$("#desktopCount").text(count);
			$("#desktopPrice").text(price);
			
			desktopP = parseInt($("#desktopPrice").text() || 0);
			totalPrice = totalPrice + desktopP;
			$(".procutPriceArea").text(totalPrice);
			$('#DESKTOP').modal('hide');
		}
		// KEY BOARD
		function keyboardChoice(code, name, count, price){
			$("input[name='sendKEYBOARD']").val(code);
		 	$("#keyboardName").text(name);
			$("#keyboardCount").text(count);
			$("#keyboardPrice").text(price);
			
			keyboardP = parseInt($("#keyboardPrice").text() || 0);
			totalPrice = totalPrice + keyboardP;
			$(".procutPriceArea").text(totalPrice);
			$('#KEYBOARD').modal('hide');			
		}
		// MOUSE
		function mouseChoice(code, name, count, price){
			$("input[name='sendMOUSE']").val(code);
		 	$("#mouseName").text(name);
			$("#mouseCount").text(count);
			$("#mousePrice").text(price);
			
			mouseP = parseInt($("#mousePrice").text() || 0);
			totalPrice = totalPrice + mouseP;
			$(".procutPriceArea").text(totalPrice);
			$('#MOUSE').modal('hide');			
		}
		// HEADSET
		function headsetChoice(code, name, count, price){
			$("input[name='sendHEADSET']").val(code);
		 	$("#headsetName").text(name);
			$("#headsetCount").text(count);
			$("#headsetPrice").text(price);
			
			headsetP = parseInt($("#headsetPrice").text() || 0);
			totalPrice = totalPrice + headsetP;
			$(".procutPriceArea").text(totalPrice);
			$('#HEADSET').modal('hide');			
		}
		// SPEAKER
		function speakerChoice(code, name, count, price){
			$("input[name='sendSPEAKER']").val(code);
		 	$("#speakerName").text(name);
			$("#speakerCount").text(count);
			$("#speakerPrice").text(price);
			
			speakerP = parseInt($("#speakerPrice").text() || 0);
			totalPrice = totalPrice + speakerP;
			$(".procutPriceArea").text(totalPrice);
			$('#SPEAKER').modal('hide');	
		}
		
		// 상품취소 실행함수
		$("#cpuDeleteButton").click(function () {
			cpuP = parseInt($("#cpuPrice").text() || 0);
			totalPrice = totalPrice - cpuP;
			$(".procutPriceArea").text(totalPrice);
			$("input[name='sendCPU']").val('');
		 	$("#cpuName").text('미선택');
			$("#cpuCount").text('');
			$("#cpuPrice").text('');
	    });
		$("#coolerDeleteButton").click(function () {
			coolerP = parseInt($("#coolerPrice").text() || 0);
			totalPrice = totalPrice - coolerP;
			$(".procutPriceArea").text(totalPrice);
			$("input[name='sendCOOLER']").val('');
		 	$("#coolerName").text('미선택');
			$("#coolerCount").text('');
			$("#coolerPrice").text('');
	    });
		$("#gcardDeleteButton").click(function () {
			gcardP = parseInt($("#gcardPrice").text() || 0);
			totalPrice = totalPrice - gcardP;
			$(".procutPriceArea").text(totalPrice);
			$("input[name='sendGCARD']").val('');
		 	$("#gcardName").text('미선택');
			$("#gcardCount").text('');
			$("#gcardPrice").text('');
	    });
		$("#hddDeleteButton").click(function () {
			hddP = parseInt($("#hddPrice").text() || 0);
			totalPrice = totalPrice - hddP;
			$(".procutPriceArea").text(totalPrice);
			$("input[name='sendHDD']").val('');
		 	$("#hddName").text('미선택');
			$("#hddCount").text('');
			$("#hddPrice").text('');
	    });
		$("#ramDeleteButton").click(function () {
			ramP = parseInt($("#ramPrice").text() || 0);
			totalPrice = totalPrice - ramP;
			$(".procutPriceArea").text(totalPrice);
			$("input[name='sendRAM']").val('');
		 	$("#ramName").text('미선택');
			$("#ramCount").text('');
			$("#ramPrice").text('');
	    });
		$("#skinDeleteButton").click(function () {
			skinP = parseInt($("#skinPrice").text() || 0);
			totalPrice = totalPrice - skinP;
			$(".procutPriceArea").text(totalPrice);
			$("input[name='sendSKIN']").val('');
		 	$("#skinName").text('미선택');
			$("#skinCount").text('');
			$("#skinPrice").text('');
	    });
		$("#ssdDeleteButton").click(function () {
			ssdP = parseInt($("#ssdPrice").text() || 0);
			totalPrice = totalPrice - ssdP;
			$(".procutPriceArea").text(totalPrice);
			$("input[name='sendSSD']").val('');
		 	$("#ssdName").text('미선택');
			$("#ssdCount").text('');
			$("#ssdPrice").text('');
	    });
		$("#powerDeleteButton").click(function () {
			powerP = parseInt($("#powerPrice").text() || 0);
			totalPrice = totalPrice - powerP;
			$(".procutPriceArea").text(totalPrice);
			$("input[name='sendPOWER']").val('');
		 	$("#powerName").text('미선택');
			$("#powerCount").text('');
			$("#powerPrice").text('');
	    });
		$("#mboardDeleteButton").click(function () {
			mboardP = parseInt($("#mainboardPrice").text() || 0);
			totalPrice = totalPrice - mboardP;
			$(".procutPriceArea").text(totalPrice);
			$("input[name='sendMainBoard']").val('');
		 	$("#mainboardName").text('미선택');
			$("#mainboardCount").text('');
			$("#mainboardPrice").text('');
	    });
		$("#desktopDeleteButton").click(function () {
			desktopP = parseInt($("#desktopPrice").text() || 0);
			totalPrice = totalPrice - desktopP;
			$(".procutPriceArea").text(totalPrice);
			$("input[name='sendDESKTOP']").val('');
		 	$("#desktopName").text('미선택');
			$("#desktopCount").text('');
			$("#desktopPrice").text('');
	    });
		$("#keyboardDeleteButton").click(function () {
			keyboardP = parseInt($("#keyboardPrice").text() || 0);
			totalPrice = totalPrice - keyboardP;
			$(".procutPriceArea").text(totalPrice);
			$("input[name='sendKEYBOARD']").val('');
		 	$("#keyboardName").text('미선택');
			$("#keyboardCount").text('');
			$("#keyboardPrice").text('');
	    });
		$("#mouseDeleteButton").click(function () {
			mouseP = parseInt($("#mousePrice").text() || 0);
			totalPrice = totalPrice - mouseP;
			$(".procutPriceArea").text(totalPrice);
			$("input[name='sendMOUSE']").val('');
		 	$("#mouseName").text('미선택');
			$("#mouseCount").text('');
			$("#mousePrice").text('');
	    });
		$("#headsetDeleteButton").click(function () {
			headsetP = parseInt($("#headsetPrice").text() || 0);
			totalPrice = totalPrice - headsetP;
			$(".procutPriceArea").text(totalPrice);
			$("input[name='sendHEADSET']").val('');
		 	$("#headsetName").text('미선택');
			$("#headsetCount").text('');
			$("#headsetPrice").text('');
	    });
		$("#speakerDeleteButton").click(function () {
			speakerP = parseInt($("#speakerPrice").text() || 0);
			totalPrice = totalPrice - speakerP;
			$(".procutPriceArea").text(totalPrice);
			$("input[name='sendSPEAKER']").val('');
		 	$("#speakerName").text('미선택');
			$("#speakerCount").text('');
			$("#speakerPrice").text('');
	    });	
		// 상품상세정보 툴팁 실행함수
	    $(function() {
	 		 $('[data-toggle="componentTool"]').tooltip()
		});
    </script>
</body>
</html>