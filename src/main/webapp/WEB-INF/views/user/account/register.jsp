<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/layout/user/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng ký tài khoản</title>
</head>
<body>
<div class="row">
    <%@ include file="/WEB-INF/views/layout/user/left-body.jsp" %>
    <div class="span9">
        <ul class="breadcrumb">
            <li><a href="<c:url value="/trang-chu" />">Trang chủ</a> <span class="divider">/</span></li>
            <li class="active">Người dùng</li>
        </ul>
        <h3>Login</h3>
        <hr class="soft"/>
        <div class="row">
            <div class="span4">
                <div class="well">
                    <%--Form đăng ký tài khoản--%>
                    <h5>Đăng ký tài khoản</h5>
                    <%--In ra trạng thái đăng ký tài khoản (thành công hay không)--%>
                    <h5>${status}</h5>
                    <br/>
                    <form:form action="dang-ky" method="POST" modelAttribute="user">
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">Email</label>
                            <div class="controls">
                                <form:input class="span3" type="email" placeholder="Mời nhập email" path="user"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">Mật khẩu</label>
                            <div class="controls">
                                <form:input class="span3" type="password" placeholder="Mời nhập mật khẩu"
                                            path="password"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">Họ và tên</label>
                            <div class="controls">
                                <form:input class="span3" type="text" placeholder="Mời nhập họ và tên"
                                            path="display_name"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">Địa chỉ</label>
                            <div class="controls">
                                <form:input class="span3" type="text" placeholder="Mời nhập địa chỉ" path="address"/>
                            </div>
                        </div>
                        <div class="controls">
                            <button type="submit" class="btn block">Đăng ký thành viên</button>
                        </div>
                    </form:form>
                </div>
            </div>
            <div class="span1">&nbsp;</div>
            <div class="span4">
                <div class="well">
                    <%--Form đăng nhập tài khoản--%>
                    <h5>Đăng nhập hệ thống</h5>
                    <%--In ra trạng thái đăng nhập tài khoản (thành công hay không)--%>
                    <h5>${statusLogin }</h5>
                    <form:form action="dang-nhap" method="POST" modelAttribute="user">
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">Tài khoản</label>
                            <div class="controls">
                                <form:input class="span3" type="email" placeholder="Mời nhập email" path="user"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <label class="control-label" for="inputPassword">Mật khẩu</label>
                            <div class="controls">
                                <form:input class="span3" type="password" placeholder="Mời nhập mật khẩu"
                                            path="password"/>
                            </div>
                        </div>
                        <div class="control-group">
                            <div class="controls">
                                <button type="submit" class="btn block">Đăng nhập</button>
                                <a href="#">Quên mật khẩu?</a>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>