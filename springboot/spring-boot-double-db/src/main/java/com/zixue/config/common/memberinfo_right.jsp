<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
					
<div class="col-sm-3 col-md-3 column">
			<div class="row">
				<div class="col-md-12">
					<div class="thumbnail" style="    border-radius: 0px;">
						<img src="${APP_PATH }/img/services-box1.jpg" class="img-thumbnail" alt="">
						<div class="caption" style="text-align:center;">
								<h3>
								${loginMember.nickname} 
								</h3>
								<c:if test="${loginMember.authstatus=='1' }">
									<span class="label label-success" style="cursor:pointer;">已实名认证</span>
								</c:if>
								<c:if test="${loginMember.authstatus!='1' }">
									<span class="label label-danger" onclick="alert('开始进行实名认证')" style="cursor:pointer;">未实名认证</span>
								</c:if>
	                            <br>
	                            <br>
	                            <button class="btn btn-danger" onclick="window.location.href='logout'">安全退出</button>
						</div> 
					</div>
				</div>
			</div>
			<div class="list-group">
				<div id="member_active" class="list-group-item active" style="cursor:pointer;" onclick="window.location.href='${APP_PATH }/member'">
					资产总览<span class="badge"><i class="glyphicon glyphicon-chevron-right"></i></span>
				</div>
				<div id="shop_active" class="list-group-item " style="cursor:pointer;" onclick="window.location.href='${APP_PATH }/member/myShop'">
					我的店铺<span class="badge"><i class="glyphicon glyphicon-chevron-right"></i></span>
				</div>
				<div id="cart_active" class="list-group-item " style="cursor:pointer;" onclick="window.location.href='${APP_PATH }/member/myCart'">
					我的购物车<span class="badge"><i class="glyphicon glyphicon-chevron-right"></i></span>
				</div>
				<div id="order_active" class="list-group-item " style="cursor:pointer;" onclick="window.location.href='${APP_PATH }/member/myOrder'">
					我的订单<span class="badge"><i class="glyphicon glyphicon-chevron-right"></i></span>
				</div>
			</div>
		</div>