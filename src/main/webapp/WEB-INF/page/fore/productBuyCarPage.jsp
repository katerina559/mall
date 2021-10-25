<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="include/header.jsp" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
    var contextPath = "${ctx}";
</script>
<head>
    <script src="${ctx}/res/js/fore/fore_productBuyCar.js"></script>
    <link href="${ctx}/res/css/fore/fore_productBuyCarPage.css" rel="stylesheet"/>
    <title>mall.com - 购物车</title>
    <script>
        $(function () {
            $('#btn-ok').click(function () {
                $.ajax({
                    url: "${ctx}/orderItem/" + $("#order_id_hidden").val(),
                    type: "DELETE",
                    data: null,
                    dataType: "json",
                    success: function (data) {
                        if (data.success !== true) {
                            alert("购物车商品删除异常，请稍候再试！");
                        }
                        location.href = "/mall/cart";
                    },
                    beforeSend: function () {

                    },
                    error: function () {
                        alert("购物车产品删除异常，请稍后再试！");
                        location.href = "/mall/cart";
                    }
                });
            });
        });

        function removeItem(orderItem_id) {
            if (isNaN(orderItem_id) || orderItem_id === null) {
                return;
            }
            $("#order_id_hidden").val(orderItem_id);
            $('#modalDiv').modal();
        }
    </script>
</head>
<body>
<nav>
    <%@ include file="include/navigator.jsp" %>
    <div class="header">
        <div id="mallLogo">
            <a href="${ctx}"><img
                    src="${ctx}/res/images/fore/WebsiteImage/tmallLogoD.png"><span
                    class="span_tmallBuyCar">购物车</span></a>
        </div>
        <div class="shopSearchHeader">
            <form action="${ctx}/productList/search" method="get">
                <div class="shopSearchInput">
                    <input type="text" class="searchInput" name="productName" placeholder="搜索 商品/品牌/店铺"
                           value="${requestScope.searchValue}" maxlength="50">
                    <input type="submit" value="搜 索" class="searchBtn">
                </div>
            </form>
            <ul>
                <c:forEach items="${requestScope.categoryList}" var="category" varStatus="i">
                    <li>
                        <a href="${ctx}/product?categoryId=${category.categoryId}">${category.categoryName}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
</nav>
<div class="content">
    <c:choose>
        <c:when test="${fn:length(requestScope.orderItemList)<=0}">
            <div id="crumbs">
                <span class="cart-tip">购物车帮您一次性完成批量购买与付款，下单更便捷，付款更简单！<a
                        href="http://service.taobao.com/support/help-11746.htm?spm=a1z0d.1.0.0.ogEwpx" target="_blank">如何使用购物车</a></span>
            </div>
            <div id="empty">
                <h2>您的购物车还是空的，赶紧行动吧！您可以：</h2>
                <ul>
                    <li>看看<a href="${ctx}/order">已买到的宝贝</a></li>
                </ul>
            </div>
        </c:when>
        <c:otherwise>
            <div id="J_FilterBar">
                <ul id="J_CartSwitch">
                    <li>
                        <a href="${ctx}/cart" class="J_MakePoint">
                            <em>全部商品</em>
                            <span class="number">${requestScope.orderItemTotal}</span>
                        </a>
                    </li>
                </ul>
                <div class="cart-sum">
                    <span class="pay-text">已选商品（不含运费）</span>
                    <strong class="price"><em id="J_SmallTotal"><span
                            class="total-symbol">&nbsp;</span>0.00</em></strong>
                    <a id="J_SmallSubmit" class="submit-btn submit-btn-disabled">结&nbsp;算</a>
                </div>
                <div class="wrap-line">
                    <div class="floater"></div>
                </div>
            </div>
            <table id="J_CartMain">
                <thead>
                <tr>
                    <th class="selectAll_th"><input type="checkbox" class="cbx_select" id="cbx_select_all"><label
                            for="cbx_select_all">全选</label></th>
                    <th width="474px" class="productInfo_th"><span>商品信息</span></th>
                    <th width="120px"><span>单价</span></th>
                    <th width="120px"><span>数量</span></th>
                    <th width="120px"><span>金额</span></th>
                    <th width="84px"><span>操作</span></th>
                    <th hidden>ID</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.orderItemList}" var="orderItem">
                    <tr class="orderItem_category">
                        <td colspan="6"><span ></span><span
                                class="category_shop">店铺：贤趣${orderItem.productOrderItemProduct.productCategory.categoryName}旗舰店</span>
                        </td>
                    </tr>
                    <tr class="orderItem_info">
                        <td class="tbody_checkbox"><input type="checkbox" class="cbx_select"
                                                          id="cbx_orderItem_select_${orderItem.productorderitemId}"
                                                          name="orderItem_id"><label
                                for="cbx_orderItem_select_${orderItem.productorderitemId}"></label></td>
                        <td><img class="orderItem_product_image"
                                 src="${ctx}/res/images/item/productSinglePicture/${orderItem.productOrderItemProduct.singleProductImageList[0].productImageSrc}"
                                 style="width: 80px;height: 80px;"/><span class="orderItem_product_name"><a
                                href="${ctx}/product/${orderItem.productOrderItemProduct.productId}">${orderItem.productOrderItemProduct.productName}</a></span>
                        </td>
                        <td><span
                                class="orderItem_product_price">￥${orderItem.productorderitemPrice/orderItem.productorderitemNumber}</span>
                        </td>
                        <td>
                            <div class="item_amount">
                                <a href="javascript:void(0)" onclick="up(this)"
                                   class="J_Minus <c:if test="${orderItem.productorderitemNumber<=1}">no_minus</c:if>">-</a>
                                <input type="text" value="${orderItem.productorderitemNumber}"/>
                                <a href="javascript:void(0)" onclick="down(this)" class="J_Plus">+</a>
                            </div>
                        </td>
                        <td>
                            <span class="orderItem_product_realPrice">￥${orderItem.productorderitemPrice}</span>
                        </td>
                        <td><a href="javascript:void(0)" onclick="removeItem('${orderItem.productorderitemId}')"
                               class="remove_order">删除</a></td>
                        <td>
                            <input type="hidden" class="input_orderItem" name="${orderItem.productorderitemId}"/>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div id="J_FloatBar">
                <div id="J_SelectAll2">
                    <div class="cart_checkbox">
                        <input class="J_checkboxShop" id="J_SelectAllCbx2" type="checkbox" value="true"/>
                        <label for="J_SelectAllCbx2" title="勾选购物车内所有商品"></label>
                    </div>
                    <span class="span_selectAll">&nbsp;全选</span>
                </div>
                <div class="operations">
                    <a href="javascript:void(0)" onclick="remove()">删除</a>
                </div>
                <div class="float-bar-right">
                    <div id="J_ShowSelectedItems">
                        <span class="txt">已选商品</span>
                        <em id="J_SelectedItemsCount">0</em>
                        <span class="txt">件</span>
                    </div>
                    <div class="price_sum">
                        <span class="txt">合计（不含运费）:</span>
                        <strong class="price">
                            <em id="J_Total">
                                <span class="total_symbol">&nbsp;  ￥</span>
                                <span class="total_value"> 0.00</span>
                            </em>
                        </strong>
                    </div>
                    <div class="btn_area">
                        <a href="javascript:void(0)" id="J_Go" onclick="create(this)">
                            <span>结&nbsp;算</span>
                        </a>
                    </div>
                </div>
            </div>
        </c:otherwise>
    </c:choose>
</div>
<%-- 模态框 --%>
<div class="modal fade" id="modalDiv" tabindex="-1" role="dialog" aria-labelledby="modalDiv" aria-hidden="true"
     data-backdrop="static">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title" id="myModalLabel">提示</h4>
            </div>
            <div class="modal-body">您确定要取消该宝贝吗？</div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary" id="btn-ok">确定</button>
                <button type="button" class="btn btn-default" data-dismiss="modal" id="btn-close">关闭</button>
                <input type="hidden" id="order_id_hidden">
            </div>
        </div>
        <%-- /.modal-content --%>
    </div>
    <%-- /.modal --%>
</div>
<%@include file="include/footer_two.jsp" %>
<%@include file="include/footer.jsp" %>
</body>
