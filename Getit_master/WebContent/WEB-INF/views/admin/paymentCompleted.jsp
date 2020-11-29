<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제완료</title>
</head>
<body>
	<h1>결제 완료</h1>
	<table border="1">
		<tr>
			<th>주문날짜</th>
			<th>고객 ID</th>
			<th>고객명</th>
			<th>연락처</th>
			<th>상품 상세정보</th>
			<th>주소</th>
			<th>택배사</th>
			<th>배송 요청사항</th>
		</tr>
		
		<c:forEach items="${pList}" var="payment" varStatus="index">
			<tr>
				<td>${payment.orderDate }</td>
				<!-- 하나의 게시글에 대한 내용을 검색하기 위해서 noticeNo를 서블릿으로 넘겨줌-->
				<td>${payment.userID }</td>
				<td>${payment.userName }</td>
				<td>${payment.phone }</td>
				<td>${payment.orderInfo }</td>
				<td>${payment.address }</td>
				<td>${payment.deliveryCP }</td>
				<td>${payment.deliveryRequest }</td>
			</tr>	
		</c:forEach>
	</table>

	


</body>
</html>