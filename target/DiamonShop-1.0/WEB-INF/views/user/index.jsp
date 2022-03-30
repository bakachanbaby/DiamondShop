<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/layout/user/taglib.jsp" %>
<title>Trang Chủ</title>
<body>
<div class="row">
    <%@ include file="/WEB-INF/views/layout/user/left-body.jsp" %>
    <div class="span9">
        <div class="well np">
            <div id="myCarousel" class="carousel slide homCar">
                <div class="carousel-inner">
                    <%--Hiển thị các sản phẩm trình chiếu--%>
                    <c:forEach var="item" items="${slides}" varStatus="index">
                        <%--Hiển thị sản phẩm đầu tiên trước sau đó lần lượt đến các sản phẩm sau--%>
                    <c:if test="${index.first}">
                    <div class="item active"></c:if>
                        <c:if test="${not index.first}">
                        <div class="item"></c:if>
                            <img style="width: 100%" src="<c:url value="/assets/user/img/slide/${item.img}"/>"
                                 alt="">
                            <div class="carousel-caption">
                                <h4>${item.caption}</h4>
                                <p><span>${item.content}</span></p>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                    <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
                    <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
                </div>
            </div>
            <!--New Products-->
            <div class="well well-small">
                <h3>Sản phẩm mới</h3>
                <hr class="soften"/>
                <div class="row-fluid">
                    <div id="newProductCar" class="carousel slide">
                        <div class="carousel-inner">
                            <%--Nếu có sản phẩm trong database, hiển thị danh sách sản phẩm--%>
                            <c:if test="${products.size() > 0 }">
                            <div class="item active">
                                <ul class="thumbnails">
                                    <c:forEach var="item" items="${products}" varStatus="loop">
                                    <li class="span3">
                                        <div class="thumbnail">
                                                <%--Xem chi tiết sản phẩm--%>
                                            <a class="zoomTool"
                                               href="<c:url value="chi-tiet-san-pham/${item.id_product}" /> "
                                               title="add to cart">
                                                <span class="icon-search"></span>QUICK VIEW
                                            </a>
                                            <a href="<c:url value="chi-tiet-san-pham/${item.id_product}" /> "
                                               class="tag">
                                            </a>
                                            <a href="<c:url value="chi-tiet-san-pham/${item.id_product}" /> ">
                                                <img src="<c:url value="/assets/user/img/${item.img }"/>"
                                                     alt="bootstrap-ring">
                                            </a>
                                        </div>
                                    </li>
                                        <%--Hiển thị 4 sản phẩm theo mỗi slide--%>
                                    <c:if test="${ (loop.index+1) % 4 == 0 || (loop.index + 1) == products.size()}">
                                </ul>
                            </div>
                                <%--Thực hiện đóng thẻ--%>
                            <c:if test="${(loop.index + 1) < products.size()}">
                            <div class="item">
                                <ul class="thumbnails">
                                    </c:if>
                                    </c:if>
                                    </c:forEach>
                                    </c:if>
                            </div>
                            <a class="left carousel-control" href="#newProductCar" data-slide="prev">&lsaquo;</a>
                            <a class="right carousel-control" href="#newProductCar" data-slide="next">&rsaquo;</a>
                        </div>
                    </div>

                </div>
                <!--Featured Products-->
                <div class="well well-small">
                    <h3>
                        <a class="btn btn-mini pull-right" href="<c:url  value="/san-pham/1"/>"
                           title="View more">VIew More
                            <span class="icon-plus"></span>
                        </a> Sản phẩm nổi bật
                    </h3>
                    <hr class="soften"/>
                    <div class="row-fluid">
                        <%--Nếu có sản phẩm trong database, hiển thị danh sách sản phẩm--%>
                        <c:if test="${products.size() > 0 }">
                        <ul class="thumbnails">
                            <c:forEach var="item" items="${products}" varStatus="loop">
                            <li class="span4">
                                <div class="thumbnail">
                                        <%--Xem chi tiết sản phẩm--%>
                                    <a class="zoomTool" href="<c:url value="chi-tiet-san-pham/${item.id_product}" /> "
                                       title="add to cart">
                                        <span class="icon-search"></span>
                                        QUICK VIEW
                                    </a>
                                    <a href="<c:url value="chi-tiet-san-pham/${item.id_product}" /> ">
                                        <img src="<c:url value="/assets/user/img/${item.img }"/>" alt="">
                                    </a>
                                    <div class="caption">
                                        <h5>${item.name }</h5>
                                        <h4>
                                            <a class="defaultBtn"
                                               href="<c:url value="chi-tiet-san-pham/${item.id_product}" /> "
                                               title="Click to view">
                                                <span class="icon-zoom-in"></span>
                                            </a>
                                            <a class="shopBtn" href="<c:url value="/AddCart/${item.id_product}"/>"
                                               title="add to cart">
                                                <span class="icon-plus"></span>
                                            </a>
                                            <span class="pull-right">
                                                <fmt:formatNumber type="number" groupingUsed="true"
                                                                  value="${item.price}"/>₫
                                            </span>
                                        </h4>
                                    </div>
                                </div>
                            </li>
                                <%--Hiển thị 3 sản phẩm theo mỗi dòng--%>
                            <c:if test="${ (loop.index+1) % 3 == 0 || (loop.index + 1) == products.size()}">
                        </ul>
                            <%--Thực hiện đóng thẻ--%>
                        <c:if test="${(loop.index + 1) < products.size()}">
                        <ul class="thumbnails">
                            </c:if>
                            </c:if>
                            </c:forEach>
                            </c:if>
                    </div>
                </div>
                <hr>
                <div class="well well-small">
                    <a class="btn btn-mini pull-right" href="<c:url  value="/san-pham/1"/>">Xem thêm
                        <span class="icon-plus"></span>
                    </a> Tất cả sản phẩm
                </div>
            </div>
        </div>
</body>