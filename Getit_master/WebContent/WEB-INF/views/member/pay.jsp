<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<link rel="stylesheet" type="text/css" href="/css/member/basket.css">
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
        <div id="section_contents">
            <div id="section_contents_empty"></div>
                <div class="container" id="section_contents_write">
                    <br>
                    <br>
                    <br>
                    <br>
                     <form action="/memeber/shoppingPay?pCode=${pCode }" method="post">
                    <h2>PAY</h2>
                    <br>
                    <div style="width:100%">
                        <table class="table" id="basket_1">
                          <thead class="thead-dark">
                            <tr>
                              <th scope="col" style="width:5%;"><input type="checkbox"></th>
                              <th scope="col" style="width:60%;">상품명/구성</th>
                              <th scope="col" style="width:10%;">수량</th>
                              <th scope="col" style="width:25%;">상품금액</th>
                            </tr>
                          </thead>
                          <tbody style="border-bottom: 1px solid black;">
                          	<!--결제 리스트  -->
                          	 <tr>
                              <th scope="row"><input type="checkbox"></th>
                                <td>	
                                	${product.pName }
                                </td>
                                <td>${product.pAccount }</td>
                                <td id="price${status.index}">${product.pPrice }</td>
                            </tr>
                          
                   
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
                    <div div style="text-align:right;width:100%;">
                        <button class="fas fa-trash-alt fa-2x" style="background-color:white;font-size:15px;height:100%;border: 1px;">선택상품 삭제</button>
                        <button class="fas fa-dumpster-fire fa-2x" style="background-color:white;font-size:15px;height:100%;border: 1px;">장바구니 비우기</button>
                    </div>
                    <br>
                    <div style="width:100%">
                        <table class="table" id="basket_2">
                          <thead class="thead-dark">
                            <tr>
                              <th scope="col" style="width:50%"></th>
                              <th scope="col">선택상품 금액</th>
                              <th scope="col">배송비</th>
                              <th scope="col">최종판매가</th>
                            </tr>
                          </thead>
                          <tbody>
                         
                            <tr>
                              <th scope="row">판매 최적가</th>
                              <td>${product.pPrice }</td>
                              <td>3,000원</td>
                              <td><input type="hidden" name="allPrice">${product.pPrice +3000}원</td>
                            </tr>
                          </tbody>
                        </table>
                    </div>
                    <br>
                    <br>
                    <h6 style="font-weight: bold;">구매자 정보</h6><input type="checkBox" id="memberAddr" name="memberInfo"><label>주문자 정보와 동일</label>
                    <div style="width:100%;">
                        <table class="table" id="basket_3">
                          <tbody>
                          <c:if test="${ member ne null }">
                          <!--만약 체크 되어진다면 회원 정보에 저장된 이름, 메일 , 연락처 , 주소지 를 가져오고
                          	체크가 안될경우 따로 input 에 입력해서 그 값을 결제정보에 넘기기  -->
                            <tr>
                              <th scope="row" style="color:white;background-color:#343A40;width:15%;text-align:right;">이름</th>
                              <td> ${ member.memberName}</td>
                            </tr>
                            <tr>
                              <th scope="row" style="color:white;background-color:#343A40;width:15%;text-align:right;">이메일</th>
                              <td> ${ member.email }</td>
                            </tr>
                            <tr>
                              <th scope="row" style="color:white;background-color:#343A40;width:15%;text-align:right;">연락처</th>
                              <td> ${ member.phone }</td>
                            </tr>
                            <tr>
                              <th scope="row" style="color:white;background-color:#343A40;width:15%;text-align:right;">배송주소</th>
                              <td> ${ member.address } ${member.detailAddress}</td>
                            </tr>
                            <tr>
                              <th scope="row" style="color:white;background-color:#343A40;width:15%;text-align:right;">배송요청사항</th>
                              <td>
                                <select name="dMessage" >
                                    <option>부재 시 문앞에 놔주세요.</option>
                                    <option>배송 전 연락부탁드립니다.</option>
                                    <option>문앞에 사나운 강아지가 있습니다.주의하세요.</option>
                                </select>
                              </td>
                            </tr>
                            </c:if>
                            
                            
                            <c:if test="${ member eq null}">
                          <!--만약 체크 되어진다면 회원 정보에 저장된 이름, 메일 , 연락처 , 주소지 를 가져오고
                          	체크가 안될경우 따로 input 에 입력해서 그 값을 결제정보에 넘기기  -->
                            <tr>
                              <th scope="row" style="color:white;background-color:#343A40;width:15%;text-align:right;">이름</th>
                              <td><input type="text" name="userName" placeholder="이름을 입력하세요"></td>
                            </tr>
                            <tr>
                              <th scope="row" style="color:white;background-color:#343A40;width:15%;text-align:right;">이메일</th>
                              <td><input type="email" name="email" placeholder="이메일을 입력하세요"></td>
                            </tr>
                            <tr>
                              <th scope="row" style="color:white;background-color:#343A40;width:15%;text-align:right;">연락처</th>
                              <td><input type="phone" name="phone" placeholder="폰 번호를 입력하세요"></td>
                            </tr>
                            <tr>
                              <th scope="row" style="color:white;background-color:#343A40;width:15%;text-align:right;">배송주소</th>
                              <td>
                             	<input type="text" id="postcode" placeholder="우편번호" name="zipcode">
                              </td>
                              <td>
								<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기"><br>
                              </td>
                              <td>
								<input type="text" id="address" name="address"placeholder="주소"><br>
                              </td>
                              <td>
								<input type="text" id="detailAddress"name ="detailAddress" placeholder="상세주소" required>
                              </td>
                            </tr>
                            <tr>
                              <th scope="row" style="color:white;background-color:#343A40;width:15%;text-align:right;">배송요청사항</th>
                              <td>
                                <select name="dMessage">
                                    <option>부재 시 문앞에 놔주세요.</option>
                                    <option>배송 전 연락부탁드립니다.</option>
                                    <option>문앞에 사나운 강아지가 있습니다.주의하세요.</option>
                                </select>
                              </td>
                            </tr>
                            </c:if>
                          </tbody>
                        </table>
                    </div>
                    <br>
                    <br>
                    <br>
                    <h6 style="font-weight: bold;">결제수단(무통장 입금)</h6>
                    <div style="width:100%;">
                        <table class="table" id="basket_3">
                          <tbody>
                            <tr>
                              <th scope="row" style="color:white;background-color:#343A40;width:15%;text-align:right;">입금은행</th>
                              <td>국민은행</td>
                            </tr>
                            <tr>
                              <th scope="row" style="color:white;background-color:#343A40;width:15%;text-align:right;">계좌번호</th>
                              <td>015871-09-489-191</td>
                            </tr>
                            <tr>
                              <th scope="row" style="color:white;background-color:#343A40;width:15%;text-align:right;">계좌주</th>
                              <td>(주)어셈블</td>
                            </tr>
                          </tbody>
                        </table>
                    </div>
                    <br>
                    <br>
                    <br>
                    <h6 style="font-weight:bold;color:red;">[필수]</h6><h6 style="font-weight: bold;">구매조건 확인</h6>
                    <div style="width:100%;">
                        <table class="table" id="basket_3">
                          <tbody>
                            <tr>
                              <th scope="row" style="color:white;background-color:#343A40;width:15%;text-align:right;">항목</th>
                              <td>
                                  배송지 정보(주소, 받는사람, 연락처) / 결제정보(입금자명, 이메일, 휴대폰)
                              </td>
                            </tr>
                            <tr>
                              <th scope="row" style="color:white;background-color:#343A40;width:15%;text-align:right;">계좌번호</th>
                              <td>이용자 식별을 위한 본인 여부 확인 / 서비스 상품 배송 / 안내</td>
                            </tr>
                            <tr>
                              <th scope="row" style="color:white;background-color:#343A40;width:15%;text-align:right;">보유기간</th>
                              <td>상품 구매 / 컨텐츠 이용내역 보존 정책으로 인한 기록된 정보는 파기 불가</td>
                            </tr>
                          </tbody>
                        </table>
                    </div>
                    <br>
                    <div style="width:100%;text-align:center;font-size:14px;">
                        <input type="checkbox" required>위 주문 내용을 확인하였으며, 회원 본인은 결제에 동의합니다.
                    </div>
                    <br>
                    <div style="width:100%;font-size:14px;text-align:center;">
                       
                            <button type="submit" class="btn btn-secondary" style="background-color:#343A40; color: white;" id="orderButton">결제하기</button>
                        </form>
                    </div>
                    <br>
                    <br>
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