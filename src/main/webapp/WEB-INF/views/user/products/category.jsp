<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/layout/user/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sản phẩm</title>
</head>
<body>
<div class="well well-small">
    <div class="row">
        <span style="margin-left: 25px;">Danh sách sản phẩm</span> <select class="pull-right">
        <option>A - Z</option>
        <option>Cao - Thấp</option>
    </select>
    </div>
    <c:if test="${ProductsPaginate.size() > 0 }">
    <div class="row-fluid">
        <ul class="thumbnails">
                <%--In ra danh sách sản phẩm có phân trang--%>
            <c:forEach var="item" items="${ProductsPaginate}" varStatus="loop">
            <li class="span4">
                <div class="thumbnail">
                    <a href="<c:url value="/chi-tiet-san-pham/${item.id_product}"/>" class="overlay"></a>
                    <a class="zoomTool" href="<c:url value="/chi-tiet-san-pham/${item.id_product}"/> "
                       title="add to cart">
                        <span class="icon-search"></span> QUICK VIEW
                    </a>
                    <a href="<c:url value="/chi-tiet-san-pham/${item.id_product}" /> ">
                        <img src="<c:url value="/assets/user/img/${item.img }"/>" alt="">
                    </a>
                    <div class="caption cntr">
                        <p>${item.name }</p>
                        <p>
                            <strong>
                                <fmt:formatNumber type="number" groupingUsed="true" value="${item.price}"/> ₫
                            </strong>
                        </p>
                        <h4>
                            <a class="shopBtn"
                               href="<c:url value="/AddCart/${item.id_product}"/>" title="add to cart">Add to cart </a>
                        </h4>
                        <div class="actionList">
                            <a class="pull-left" href="#">Add to Wish List </a>
                            <a class="pull-left" href="#"> Add to Compare </a>
                        </div>
                        <br class="clr">
                    </div>
                </div>
            </li>
                <%--In ra mỗi dòng 3 sản phẩm và lặp lại--%>
            <c:if test="${ (loop.index+1) % 3 == 0 || (loop.index + 1) == ProductsPaginate.size()}">
        </ul>
    </div>
    <c:if test="${(loop.index + 1) < ProductsPaginate.size()}">
    <div class="row-fluid">
        <ul class="thumbnails">
            </c:if>
            </c:if>
            </c:forEach>
            </c:if>

    </div>
</div>
</div>
<div class="pagination">
    <%--Phân trang sản phẩm--%>
    <c:forEach var="item" begin="1" end="${paginateInfo.totalPage }" varStatus="loop">
        <%--Nếu trang hiện tại bằng trang của index, hiển thị nút active--%>
        <c:if test="${(loop.index) == paginateInfo.currentPage}">
            <a href="<c:url value="/san-pham/${idCategory }/${loop.index}"/>" class="active">${loop.index }</a>
        </c:if>
        <c:if test="${(loop.index) != paginateInfo.currentPage}">
            <a href="<c:url value="/san-pham/${idCategory }/${loop.index}"/>" class="">${loop.index }</a>
        </c:if>
    </c:forEach>
</div>
</body>
</html>