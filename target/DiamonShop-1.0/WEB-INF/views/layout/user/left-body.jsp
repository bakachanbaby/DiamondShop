<%--Phần body bên trái của trang web--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div id="sidebar" class="span3">
    <div class="well well-small">
        <ul class="nav nav-list">
            <%--Hiển thị danh sách các loại sản phẩm--%>
            <c:forEach var="item" items="${categorys}">
                <li>
                    <a href='<c:url value="/san-pham/${item.id }"/>'>
                        <i class="icon-circle-blank"></i> ${item.name }
                    </a>
                </li>
            </c:forEach>
            <li style="border: 0">&nbsp;</li>
            <li>
                <a class="totalInCart" href="<c:url value="/gio-hang" />">
                    <strong>Đã mua
                        <span class="badge badge-warning pull-right" style="line-height: 18px;">
                        <%--Nếu giỏ hàng trống, hiển thị số tiền đã mua mà 0đ--%>
						<c:if test="${empty  Cart.size()}">
                            <fmt:formatNumber type="number" groupingUsed="true" value="0"/> ₫
                        </c:if>
                        <%--Nếu giỏ hàng có sản phẩm, hiển thị số tiền đã mua--%>
						<c:if test="${not empty Cart.size()}">
                            <fmt:formatNumber type="number" groupingUsed="true" value="${ TotalPriceCart }"/> ₫
                        </c:if>
						</span>
                    </strong>
                </a></li>
        </ul>
    </div>
    <div class="well well-small alert alert-warning cntr">
        <h2>50% Discount</h2>
        <p>only valid for online order. <br> <br> <a class="defaultBtn" href="#">Click here </a></p>
    </div>
    <div class="well well-small">
        <a href="#"><img src="<c:url value="/assets/user/img/paypal.jpg"/>" alt="payment method paypal"></a>
    </div>
    <a class="shopBtn btn-block" href="<c:url value="/san-pham/1" />">Upcoming products <br>
        <small>Click to view</small>
    </a>
    <br>
    <br>
    <ul class="nav nav-list promowrapper">
        <%--Gán giá trị số lượng sản phẩm với biến sizeList--%>
        <c:set var="sizeList" value="${products.size()}"/>
        <%--Nếu số lượng sản phẩm > 3, gán số lượng sản phẩm về 3--%>
        <c:if test="${products.size() > 3 }">
            <c:set var="sizeList" value="3"/>
        </c:if>
        <%--Hiển thị danh sách sản phẩm--%>
        <c:forEach var="item" items="${products}" begin="1" end="${sizeList}">
            <li>
                <div class="thumbnail">
                    <a class="zoomTool"
                       href="<c:url value="/chi-tiet-san-pham/${item.id_product}" />"
                       title="add to cart">
                        <span class="icon-search"></span> QUICK VIEW
                    </a>
                    <img src="<c:url value="/assets/user/img/${item.img }"/>" alt="bootstrap ecommerce templates">
                    <div class="caption">
                        <h4>
                            <a class="defaultBtn"
                               href="<c:url value="/chi-tiet-san-pham/${item.id_product}" />">VIEW</a>
                            <span class="pull-right">
                                <fmt:formatNumber type="number" groupingUsed="true" value="${item.price}"/> ₫
                            </span>
                        </h4>
                    </div>
                </div>
            </li>
            <li style="border: 0">&nbsp;</li>
        </c:forEach>
    </ul>
</div>