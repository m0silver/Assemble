<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>취소 요청</title>
</head>
<body>
	<h1>취소 요청</h1>
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
			<th>반품 사유</th>
		</tr>
		
		<c:forEach items="${rList}" var="return" varStatus="index">
			<tr>
				<td>${return.orderDate }</td>
				<!-- 하나의 게시글에 대한 내용을 검색하기 위해서 noticeNo를 서블릿으로 넘겨줌-->
				<td>${return.userID }</td>
				<td>${return.userName }</td>
				<td>${return.phone }</td>
				<td>${return.orderInfo }</td>
				<td>${return.address }</td>
				<td>${return.deliveryCP }</td>
				<td>${return.deliveryRequest }</td>
				<td>${return.reason }</td>
				
			</tr>	
		</c:forEach>
	</table>
</body>
</html>