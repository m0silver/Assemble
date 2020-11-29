<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송 준비</title>
</head>
<body>
<h1>배송 준비 중</h1>
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
		
		<c:forEach items="${rfdList}" var="rfDelivery" varStatus="index">
			<tr>
				<td>${rfDelivery.orderDate }</td>
				<!-- 하나의 게시글에 대한 내용을 검색하기 위해서 noticeNo를 서블릿으로 넘겨줌-->
				<td>${rfDelivery.userID }</td>
				<td>${rfDelivery.userName }</td>
				<td>${rfDelivery.phone }</td>
				<td>${rfDelivery.orderInfo }</td>
				<td>${rfDelivery.address }</td>
				<td>${rfDelivery.deliveryCP }</td>
				<td>${rfDelivery.deliveryRequest }</td>
			</tr>	
		</c:forEach>
	</table>

</body>
</html>