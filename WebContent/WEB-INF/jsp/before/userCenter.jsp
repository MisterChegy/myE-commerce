<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>用户中心</title>
<link href="css/before/daohang.css" rel="stylesheet" type="text/css" />
<link href="css/before/common.css" rel="stylesheet" type="text/css" />
<link href="css/before/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="blank"></div>
	<div class="block clearfix">
		<div class="location ared">
			我的订单
		</div>
		<div class="blank"></div>
		<div>
			<div class="nFlowBox">
				<table width="99%" align="center" border="0" cellpadding="5"
					cellspacing="1" bgcolor="#dddddd">
					<tr>
						<th>订单编号</th>
						<th>订单金额</th>
						<th>订单日期</th>
						<th>订单状态</th>
						<th>详情</th>
					</tr>
					<tr>
						<td colspan="5" height="15px"
							style="border: 0 none; background: #FFF"></td>
					</tr> 
					<c:forEach var="mo" items="${myOrder}"> 
						<tr>
							<td bgcolor="#ffffff" align="center">${mo.id}</td>
							<td bgcolor="#ffffff"  align="center">${mo.amount}</td>
							<td align="center" bgcolor="#ffffff">${mo.orderdate}</td>
							<td bgcolor="#ffffff"  align="center">
							<c:if test="${mo.status == 0}" >
							未付款&nbsp;&nbsp;
							<a style="text-decoration: none;" class="f6" href="order/pay?ordersn=${mo.id}">去支付</a>
							</c:if>
							<c:if test="${mo.status == 1}" >已付款</c:if>
							</td>
							<td align="center" bgcolor="#ffffff">
							<a style="text-decoration: none;" class="f6" href="orderDetail?ordersn=${mo.id}" target="_blank">详情</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div class="location ared">
			我的关注
		</div>
		<div class="blank"></div>
		<div>
			<div class="nFlowBox">
				<table width="99%" align="center" border="0" cellpadding="5"
					cellspacing="1" bgcolor="#dddddd">
					<tr>
						<th>商品编号</th>
						<th>商品名称</th>
						<th>商品图片</th>
						<th>商品价格</th>
						<th>去看看</th>
					</tr>
					<tr>
						<td colspan="5" height="15px"
							style="border: 0 none; background: #FFF"></td>
					</tr> 
					<c:forEach var="mf" items="${myFocus}"> 
						<tr>
							<td bgcolor="#ffffff" align="center">${mf.id}</td>
							<td bgcolor="#ffffff"  align="center">${mf.gname}</td>
							<td align="center" bgcolor="#ffffff" height="60px"> <img
									style="width: 50px; height: 50px;"
									src="logos/${mf.gpicture}" border="0"
									title="${mf.gname}" /> </td>
							<td align="center" bgcolor="#ffffff">${mf.grprice}</td>
							<td align="center" bgcolor="#ffffff">
								<a style="text-decoration: none;" class="f6" href="goodsDetail?id=${mf.id}">去看看</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>