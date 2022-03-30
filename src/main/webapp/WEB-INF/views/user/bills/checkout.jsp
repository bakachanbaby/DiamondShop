<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/layout/user/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thanh toán</title>
</head>
<body>
<div class="row">
    <%@ include file="/WEB-INF/views/layout/user/left-body.jsp" %>
    <div class="span9">
        <ul class="breadcrumb">
            <li><a href="<c:url value="/trang-chu" />">Trang chủ</a> <span class="divider">/</span></li>
            <li class="active">Thanh toán</li>
        </ul>
        <h3>Thanh toán</h3>
        <hr class="soft"/>
        <div class="row">
            <div class="well">
                <%--Form thanh toán đơn hàng--%>
                <form:form class="form-horizontal" action="checkout" method="POST" modelAttribute="bills">
                    <h3>Thanh toán đơn hàng</h3>
                    <div class="control-group">
                        <label class="control-label">Họ tên <sup>*</sup></label>
                        <div class="controls">
                            <form:input class="span3" type="text" placeholder="Mời nhập họ tên" path="display_name"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">Email <sup>*</sup></label>
                        <div class="controls">
                            <form:input class="span3" type="email" placeholder="Mời nhập email" path="user"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">Liên hệ <sup>*</sup></label>
                        <div class="controls">
                            <form:input class="span3" type="phone" placeholder="Mời nhập số điện thoại" path="phone"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">Địa chỉ <sup>*</sup></label>
                        <div class="controls">
                            <form:textarea rows="5" cols="30" path="address"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label">Ghi chú <sup>*</sup></label>
                        <div class="controls">
                            <form:textarea rows="5" cols="30" path="note"/>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <input type="submit" name="submitAccount" value="Register" class="shopBtn exclusive">
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>