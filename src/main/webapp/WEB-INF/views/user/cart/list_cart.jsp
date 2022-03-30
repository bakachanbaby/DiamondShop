<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/layout/user/taglib.jsp" %>
<head>
    <title>Giỏ hàng</title>
</head>
<body>
<div class="row">
    <div class="span12">
        <ul class="breadcrumb">
            <li><a href="<c:url  value="/trang-chu"/>">Trang chủ</a> <span class="divider">/</span></li>
            <li class="<c:url value="/gio-hang" />">Giỏ hàng</li>
        </ul>
        <div class="well well-small">
            <%--Hiển thị tổng số sản phẩm trong giỏ hàng--%>
            <h1>Giỏ hàng <small class="pull-right"> ${TotalQuantyCart} Sản phẩm trong giỏ hàng </small></h1>
            <hr class="soften"/>
            <table class="table table-bordered table-condensed">
                <thead>
                <tr>
                    <th>Hình ảnh</th>
                    <th>Mô tả</th>
                    <th>Màu sắc</th>
                    <th>Giá bán</th>
                    <th>Số lượng</th>
                    <th>Chỉnh sửa</th>
                    <th>Xóa</th>
                    <th>Tổng tiền</th>
                </tr>
                </thead>
                <tbody>
                <%--Thực hiện nếu danh sách giỏ hàng không trống--%>
                <c:if test="${not empty Cart }">
                    <c:forEach var="item" items="${ Cart }">
                        <tr>
                            <td><img width="100" src="<c:url value="/assets/user/img/${ item.value.products.img }"/>">
                            </td>
                            <td>${ item.value.products.title }</td>
                            <td>
                                <span class="shopBtn" style="background-color: ${ item.value.products.name_color };">
                                    <span class="icon-ok"></span>
                                </span>
                            </td>
                            <td>
                                <fmt:formatNumber type="number" groupingUsed="true"
                                                  value="${ item.value.products.price }"/> ₫
                            </td>
                            <td>
                                <input type="number" min="0" max="1000" class="span1" style="max-width:34px"
                                       placeholder="1" id="quanty-cart-${item.key }" size="16" type="text"
                                       value="${ item.value.quanty }">
                            </td>
                            <td>
                                    <%--Nút cập nhật số lượng sản phẩm trong giỏ hàng--%>
                                <button data-id="${ item.key }" href="<c:url value="/EditCart/${item.key }"/>"
                                        class="btn btn-mini btn-danger edit-cart" type="button">
                                    <span class="icon-edit"></span>
                                </button>
                            </td>
                            <td>
                                    <%--Nút xóa sản phẩm trong giỏ hàng--%>
                                <a href="<c:url value="/DeleteCart/${ item.key }"/>" class="btn btn-mini btn-danger"
                                   type="button">
                                    <span class="icon-remove"></span>
                                </a>
                            </td>
                            <td>
                                <fmt:formatNumber type="number" groupingUsed="true" value="${ item.value.totalPrice }"/>₫
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
            <br/>
                <%--Trở về trang chủ để tiếp tục mua sắm--%>
            <a href="<c:url value="/trang-chu"/>" class="shopBtn btn-large">
                <span class="icon-arrow-left"></span> Tiếp tục mua sắm
            </a>
                <%--Thực hiện nút thanh toán đơn hàng--%>
            <a href="<c:url value="/checkout"/>" class="shopBtn btn-large pull-right">Thanh toán
                <span class="icon-arrow-right"></span>
            </a>
        </div>
    </div>
</div>
<content tag="script">
    <script>
        //Thực hiện cập nhật số lượng sản phẩm trong giỏ hàng
        $(".edit-cart").on("click", function () {
            var id = $(this).data("id");
            var quanty = $("#quanty-cart-" + id).val();
            window.location = "EditCart/" + id + "/" + quanty;
        })
    </script>
</content>
</body> 