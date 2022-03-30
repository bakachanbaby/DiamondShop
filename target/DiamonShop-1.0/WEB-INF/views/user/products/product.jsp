<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/layout/user/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Chi tiết sản phẩm</title>
    <style type="text/css">
        .product-content {
            overflow-x: hidden;
        }
    </style>
</head>
<body>
<!--
Body Section 
-->
<div class="row product-content">
    <%@ include file="/WEB-INF/views/layout/user/left-body.jsp" %>
    <div class="span9">
        <ul class="breadcrumb">
            <li><a href="index.html">Trang chủ</a> <span class="divider">/</span></li>
            <li><a href="products.html">Sản phẩm</a> <span class="divider">/</span></li>
            <li class="active">Chi tiết sản phẩm</li>
        </ul>
        <div class="well well-small">
            <div class="row-fluid">
                <div class="span5">
                    <div id="myCarousel" class="carousel slide cntr">
                        <div class="carousel-inner">
                            <div class="item active">
                                <a href="#"> <img src="<c:url value="/assets/user/img/${product.img}"/>" alt=""
                                                  style="width: 100%"></a>
                            </div>
                        </div>
                        <a class="left carousel-control" href="#myCarousel"
                           data-slide="prev">‹</a> <a class="right carousel-control"
                                                      href="#myCarousel" data-slide="next">›</a>
                    </div>
                </div>
                <div class="span7">
                    <h3>${product.name}</h3>
                    <hr class="soft"/>

                    <form class="form-horizontal qtyFrm" method="get"
                          action="<c:url value="/AddCart/${product.id_product}"/>">
                        <div class="control-group">
                            <label class="control-label"><span><fmt:formatNumber type="number"
                                                                                 groupingUsed="true"
                                                                                 value="${product.price }"/> ₫</span></label>
                            <div class="controls">
                                <input type="number" class="span6" min="0" value="0">
                            </div>
                        </div>

                        <div class="control-group">
                            <label class="control-label"><span>Color</span></label>
                            <div class="controls">
                                <select class="span11">
                                    <option>Red</option>
                                    <option>Purple</option>
                                    <option>Pink</option>
                                    <option>Red</option>
                                </select>
                            </div>
                        </div>

                        <h4></h4>
                        <p>${product.title }
                        <p>
                            <button type="submit" class="shopBtn">
                                <span class=" icon-shopping-cart"></span> Thêm giỏ hàng
                            </button>
                    </form>
                </div>
            </div>
            <hr class="softn clr"/>


            <ul id="productDetail" class="nav nav-tabs">
                <li class="active"><a href="#home" data-toggle="tab">Chi tiết sản phẩm</a></li>
                <li class=""><a href="#profile" data-toggle="tab">Sản phẩm liên quan</a></li>

            </ul>
            <div id="myTabContent" class="tab-content tabWrapper">
                <div class="tab-pane fade active in" id="home">
                    ${product.details }
                </div>
                <div class="tab-pane fade" id="profile">
                    <c:set var="sizeList" value="${productByIdCategory.size()}"/>
                    <c:if test="${productByIdCategory.size() > 5 }">
                        <c:set var="sizeList" value="5"/>

                    </c:if>
                    <c:forEach var="item" items="${productByIdCategory}" begin="1" end="${sizeList}">
                        <div class="row-fluid">
                            <div class="span2">
                                <img src="<c:url value="/assets/user/img/${item.img }"/>" alt="">
                            </div>
                            <div class="span6">
                                <h5>${item.name }</h5>
                                <p>${item.title }</p>
                            </div>
                            <div class="span4 alignR">
                                <form class="form-horizontal qtyFrm">
                                    <h3><fmt:formatNumber type="number"
                                                          groupingUsed="true" value="${item.price }"/> ₫</h3>
                                    <div class="btn-group">
                                        <a href="product_details.html" class="defaultBtn"><span
                                                class=" icon-shopping-cart"></span> Thêm giỏ hàng</a> <a
                                            href="<c:url value="/chi-tiet-san-pham/${item.id_product}" />"
                                            class="shopBtn">VIEW</a>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <hr class="soft">
                    </c:forEach>


                </div>

            </div>

        </div>
    </div>
</div>
<!-- Body wrapper -->
</body>
</html>