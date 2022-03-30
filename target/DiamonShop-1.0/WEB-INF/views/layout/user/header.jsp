<%--Phần header của trang web--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--Phần header--%>
<header id="header">
    <div class="row">
        <div class="span4">
            <h1>
                <a class="logo" href="<c:url value="/trang-chu" />"><span>Twitter Bootstrap ecommerce template</span>
                    <img src="<c:url value="/assets/user/img/logo-bootstrap-shoping-cart.png"/>"
                         alt="bootstrap sexy shop">
                </a>
            </h1>
        </div>
        <div class="span4">
            <div class="offerNoteWrapper">
                <h1 class="dotmark">
                    <i class="icon-cut"></i> Twitter Bootstrap shopping cart HTML template is available @ $14
                </h1>
            </div>
        </div>
        <div class="span4 alignR">
            <p>
                <br> <strong> Support (24/7) : 0800 1234 678 </strong>
                <br>
                <br>
            </p>
            <%--Nếu giỏ hàng trống, hiện thị số lượng sản phẩm trong giỏ là 0--%>
            <c:if test="${empty Cart.size() }">
                <span class="btn btn-mini">[ 0 ] <span class="icon-shopping-cart"></span></span>
            </c:if>
            <%--Nếu giỏ hàng không trống, hiện thị số lượng sản phẩm trong giỏ--%>
            <c:if test="${not empty  Cart.size() }">
                <span class="btn btn-mini">[ ${Cart.size() } ] <span class="icon-shopping-cart"></span></span>
            </c:if>
            <span class="btn btn-warning btn-mini">₫</span>
            <span class="btn btn-mini">&pound;</span>
            <span class="btn btn-mini">&euro;</span>
        </div>
    </div>
</header>
<!--
Navigation Bar Section
-->
<div class="navbar">
    <div class="navbar-inner">
        <div class="container">
            <a data-target=".nav-collapse" data-toggle="collapse" class="btn btn-navbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <div class="nav-collapse">
                <ul class="nav">
                    <%--Hiện thị các danh mục của trang web--%>
                    <c:forEach var="item" items="${menus}" varStatus="index">
                        <li><a href="<c:url value="/${item.url}"/>">${item.name}</a></li>
                    </c:forEach>
                </ul>
<%--                <form action="#" class="navbar-search pull-left">--%>
<%--                    <input type="text" placeholder="Search" class="search-query span2">--%>
<%--                </form>--%>
                <ul class="nav pull-right">
                    <%--Nếu chưa đăng nhập, hiển thị dòng đăng ký--%>
                    <c:if test="${empty LoginInfo }">
                        <li class="dropdown">
                            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="icon-lock"></span> Đăng nhập <b class="caret"></b>
                            </a>
                            <div class="dropdown-menu">
                                <form:form class="form-horizontal loginFrm" action="dang-nhap" method="POST"
                                           modelAttribute="user">
                                    <div class="control-group">
                                        <form:input class="span2" id="inputEmail" type="email"
                                                    placeholder="Mời nhập email" path="user"/>
                                    </div>
                                    <div class="control-group">
                                        <form:input class="span2" id="inputPassword" type="password"
                                                    placeholder="Mời nhập mật khẩu" path="password"/>
                                    </div>
                                    <div class="control-group">
                                        <label class="checkbox"> <input type="checkbox">Remember me</label>
                                        <button type="submit" class="shopBtn btn-block">Sign in</button>
                                    </div>
                                </form:form>
                            </div>
                        </li>
                    </c:if>
                    <%--Nếu đã đăng nhập, hiển thị tên user--%>
                    <c:if test="${not empty LoginInfo }">
                        <li><a href="#"><span class="icon-user"></span> ${ LoginInfo.display_name }</a></li>
                    </c:if>
                </ul>
            </div>
        </div>
    </div>
</div>
