<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="head.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>购物车</title>
<link href="css/before/daohang.css" rel="stylesheet" type="text/css" />
<link href="css/before/common.css" rel="stylesheet" type="text/css" />
<link href="css/before/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	//确认
	function  goOrderConfirm(){
		window.location.href="/ch20/cart/orderConfirm";
	}
	//清空
	function godelete(){
		if(window.confirm("真的清空购物车吗？")){
			window.location.href="/ch20/cart/clear";
			return true;
		}
		return false;
	}
	//删除
	function deleteAgoods(gno){
		if(window.confirm("真的删除该商品吗？")){
			window.location.href="/ch20/cart/deleteAgoods?id=" + gno;
			return true;
		}
		return false;
	}
</script>
</head>
<body>
	<div class="blank"></div>
	<div class="block clearfix">
		<!--当前位置-->
		<div class="location ared">
			当前位置： <a href="before?id=0">首页</a> > 购物流程 > 购物车
		</div>
		<div class="blank"></div>
		<div>
			<div class="nFlowBox">
				<table width="99%" align="center" border="0" cellpadding="5"
					cellspacing="1" bgcolor="#dddddd">
					<tr>
						<th>商品信息</th>
						<th>单价（元）</th>
						<th>数量</th>
						<th>小计</th>
						<th>操作</th>
					</tr>
					<tr>
						<td colspan="5" height="15px"
							style="border: 0 none; background: #FFF"></td>
					</tr> 
					<!-- 这里使用了jstl标签-->
					<c:forEach var="ce" items="${cartlist}"> 
						<tr>
							<td bgcolor="#ffffff" align="center"><a href="goodsDetail?id=${ce.id}"> <img
									style="width: 100px; height: 100px;"
									src="logos/${ce.gpicture}" border="0"
									title="${ce.gname}" />
							</a><br/><a style="text-decoration: none;" href="goodsDetail?id=${ce.id}" class="f6">${ce.gname}</a></td>
							<td bgcolor="#ffffff" width="110px" align="center"><span>${ce.grprice}</span></td>
							<td align="center" bgcolor="#ffffff" width="115px"
								valign="middle"><input type="text" name="goods_number"
								value="${ce.shoppingnum}" size="4"
								class="inputBg"
								style="text-align: center; width: 36px; color: #999999" /></td>
							<td align="center" bgcolor="#ffffff" width="115px">￥&nbsp;<span>${ce.smallsum}</span>&nbsp;
							</td>
							<td align="center" bgcolor="#ffffff" width="185px"><a
								style="text-decoration: none;" href="javaScript:deleteAgoods('${ce.id}')"
								class="f6" title="删除"><img src="images/before/sc.png" />
							</a></td>
						</tr>
					</c:forEach>
					<tr>
						<td align="right" bgcolor="#ffffff" colspan="4" height="41px;"
							style="border-left: 0 none;"><font
							style="color: #a60401; font-size: 13px; font-weight: bold; letter-spacing: 0px;">
								购物金额总计(不含运费) ￥&nbsp;<span id="stotal"></span>
							${total}元
						</font></td>
						<td align="center" bgcolor="#ffffff"><input type="button"
							value="清空购物车" onclick="godelete()" class="bnt_blue_1" id="bnt11" />
						</td>
					</tr>
					<tr>
						<td bgcolor="#ffffff" colspan="4" align="right"
							style="padding: 5px; padding-left: 2px; border-right: 0 none">
							<a href="before"> <img src="images/before/jxgw.jpg" alt="continue" />
						</a>
						</td>
						<td bgcolor="#ffffff" align="center"
							style="border-left: 0 none; padding: 5px; padding-right: 2px;">
							<a style="cursor: pointer;" href="javascript:goOrderConfirm()">
								<img src="images/before/qjs.jpg" alt="checkout" />
						</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
