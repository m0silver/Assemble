<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>
    <script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <link rel="stylesheet" type="text/css" href="/css/member/enroll.css">
    
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
        
        $(document).ready(function(){
			$(function() {
				$('#userId').blur(function() {
					var id = $('#userId').val()
					if (id == "") {
						alert("아이디를 입력하세요");
						$('#userId').val('');
						return false;
					}
					
				});
				$('#email').blur(function() {
					var email = $('#email').val()
					if (email == "") {
						alert("이메일을 입력하세요.");
						$('#email').val('');
						return false;
					}
	
				});
	
				$('#userPwd').blur(function() {
					var pw = $('#userPwd').val()
					if (pw == "") {
						alert("비밀번호를 입력하세요");
						$('#userPwd').val('');
						return false;
					}
	
				});
	
				$('#userPwdRe').keyup(function() {
					var userPw = $("#userPwd").val();
					if (userPw == "") {
						alert("패스워드를 입력하세요");
						$('#userPwdRe').val('');
						$('#userPwd').focus();
					}
					var userPwr = $("userPwdRe").val();
					if (userPw.legnth != 0 && userPwr.lengt != 0) {
						if (userPw == userPwr) {
							$("#out").html("패스워드가 일치합니다.");
							$("#out").css({
								'color' : 'green',
								'font-weight' : 'bolder'
							});
	
						} else {
							$("#out").html("패스워드가 일치하지 않습니다.")
							$("#out").css({
	
								'color' : 'red',
								'font-weight' : 'bolder'
							})
						}
					}
				});
			/* 	$("form").submit(function() {
					var gender = $(".gedner:checked").length;
					if (gender == 0) {
						alert("성별을 선택하세요");
						return false;
					}
	
				}); */
				});
		
			/* 	$("#allcheck").change(function() {
					if(this.checked) {
						$("#check_item").children().attr("checked", true);
					} else {
						$("#check_item").children().attr("checked", false);
					}
		
				}); */
				
		    var $All = $('#allcheck');
            $All.change(function () {
                var $this = $(this);
                var checked = $this.prop('checked'); // checked 문자열 참조(true, false)
                // console.log(checked);
                $('input[name="check"]').prop('checked', checked);

            });


            var boxes = $('input[name="check"]');
            boxes.change(function () {
         
                var boxLength = boxes.length;
                // 체크된 체크박스 갯수를 확인하기 위해 :checked 필터를 사용하여 체크박스만 선택한 후 length 프로퍼티를 확인
                var checkedLength = $('input[name="check"]:checked').length;
                var selectAll = (boxLength == checkedLength);

                $All.prop('checked', selectAll);

            });
            
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
        
        function test() {
        	var email = $("#email").val();
        	window.open('/email/certified?name='+email,'이메일 인증', 'width=500px, height=160px, location=no');
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
<!--
                  <form action="" autocomplete="on">
                  <input id="search" name="search" type="text" placeholder="검색어를 입력하세요."><input id="search_submit" value="Rechercher" type="submit"> 
                  </form>
-->
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
                    <h2>회원가입</h2>
                    <br>
                    <div style="width:100%">
						<form action="/member/enroll" method="post" name="enrollForm">
                            <label for="exampleInputEmail1">ID</label>
                            <input type="text" class="form-control" aria-describedby="emailHelp" placeholder="아이디를 입력하세요" name="userId" id="userId" required>
                            <br>
                            <label for="exampleInputEmail1">Email</label>
                            <br>
                            <input type="email" class="form-control" aria-describedby="emailHelp" placeholder="이메일을 입력하세요" name="email" id="email" required style="width:87%;float:left;">
                            <input type="button" id="emailCertified" class="btn btn-secondary" value="이메일 인증" onclick="test()" style="float:left;font-size: 16px;" name="emailCertified">
                            <br>
                            <br>
                            <br>
                            <label for="exampleInputEmail1">Name</label>
                            <input type="text" class="form-control" aria-describedby="emailHelp" placeholder="이름을 입력하세요" name="userName" id="userName" required>
                            <br>
                            <label for="exampleInputPassword1">Password</label>
                            <label for="exampleInputPassword1" style="margin-left: 43%;">Recheck Password</label>
                            <br>
                            <input type="password" class="form-control" placeholder="비밀번호를 입력하세요" name="userPwd" id="userPwd" required style="width:49%;float:left;">
                            <input type="password" class="form-control" placeholder="비밀번호를 다시 입력하세요" name="userPwdRe" required style="width:49%;float:left;margin-left: 2%;">
                            <br>
                            <br>
                            <br>
                            <label for="exampleInputEmail1">Phone</label>
                            <input type="text" class="form-control" aria-describedby="emailHelp" placeholder="핸드폰번호를 입력하세요(-제외)" name="phone" required>
                            <br>
                            <label for="exampleInputEmail1">Post Address</label>
                            <input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" style="font-size: 12px;" class="btn btn-secondary">
                            <input type="text" class="form-control" aria-describedby="emailHelp" id="postcode" placeholder="우편번호" name="zipcode" style="width:10%;">
                            <input type="text" class="form-control" aria-describedby="emailHelp" id="address" name="address"placeholder="주소" style="width:60%;float:left;">
                            <input type="text" class="form-control" aria-describedby="emailHelp" id="detailAddress" name ="detailAddress" placeholder="상세주소" required style="width:40%;float:left;">
                            <br>
                            <br>
                            <br>
                            <label for="exampleInputEmail1">The date of one's birth</label>
                            <input type="text" class="form-control" aria-describedby="emailHelp" placeholder="생년월일을 입력하세요" name="dob" required>
                            <br>
                            <label for="exampleInputEmail1">성별</label>
                            <br>
                            <input type="radio" name="gender" class="gender" value="M">Male
				            <input type="radio" name="gender" class="gender" value="F">Female
                            <br>
                            <br>
                            <br>
                            <input type="checkbox" name="all" value="all" id="allcheck">
                            <label for="exampleInputEmail1">약관 모두동의</label>
                            <div id="check_item" style="margin-left: 2%;font-size: 12px;">
                                <input type="checkbox" name="check" value="eccential_1" id="check_1">
                                    <label for="check_1">
                                        (필수) <a href="/terms.jsp">이용약관</a>과<a href="/privacyPolicy.jsp">개인정보수집 및 이용</a>에 동의합니다.
                                    </label>
                                <br>
                                <br>
                                <input type="checkbox" name="check" value="eccential_2" id="check_2">
                                <label for="check_2"> (필수) 만 14세 이상입니다.
                                <br> 
                                </label>
                                <p style="font-size: 10px;margin-left: 2%;">만 19세 미만의 미성년자가 결제 시 법정 대리인이 거래를 취소할 수 있습니다.</p>
                                <input type="checkbox" name="check" value="select_1" id="check_3">
                                <label for="check_3"> (선택) 이메일 및 SMS 마케팅 정보 수신에 동의 합니다.		
                                </label>
                                <p style="font-size: 10px;margin-left: 2%;">회원은 언제든지 회원 정보에서 수신 거부로 변경할 수 있습니다.</p>
                            </div>
                          <button type="submit" class="btn btn-secondary" style="margin-left:45%;">가입하기</button>
                        </form>
                    </div>
                    <br>
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