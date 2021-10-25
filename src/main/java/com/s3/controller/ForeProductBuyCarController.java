package com.s3.controller;

import com.alibaba.fastjson.JSON;
import com.s3.pojo.*;
import com.s3.service.impl.CategoryServiceImpl;
import com.s3.service.impl.ProductImageServiceImpl;
import com.s3.service.impl.ProductOrderItemServiceImpl;
import com.s3.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/car")
public class ForeProductBuyCarController {

    @Resource
    ProductServiceImpl productService;
    @Resource
    ProductOrderItemServiceImpl productOrderItemService;
    @Resource
    CategoryServiceImpl categoryService;
    @Resource
    ProductImageServiceImpl productImageService;
    
    // 加入购物车
    @RequestMapping("/toBuyCar/{pid}")
    @ResponseBody
    public String toBuyCar(@PathVariable(value = "pid",required = false) Integer pid,
                           @RequestParam(value = "number",required = false) Integer number,
                           HttpSession session){
        // 在会话中获取用户id
        User user = (User) session.getAttribute("user");
        Integer userId = user.getUserId();
        // 根据登录用户的id获取购物车集合
        List<ProductOrderItem> userList = productOrderItemService.getBuyCarInUser(userId);
        // 遍历购物车集合
        Map<String,Object> map = new HashMap<>();
        int count = 0;
        if(userList.size() > 0){
            for (ProductOrderItem item : userList) {
                // 如果该用户购物车有该商品 则修改商品数量 否则添加商品
                if(item.getProductorderitemProductId() == pid){
                    count = productOrderItemService.updateOrderNumber(pid, userId);
                    map.put("success",true);
                    return JSON.toJSONString(map);
                }
            }
        }
        ProductOrderItem productOrderItem = new ProductOrderItem();
        // 先根据商品id获取商品信息
        Product product = productService.getDetailById(pid);
        // 获取商品促销价格
        Float salePrice = product.getProductSalePrice();
        // 计算商品总价格 = 促销价 * 数量
        float priceCount = salePrice * number;
        // 给订单对象赋值
        productOrderItem.setProductorderitemNumber(number); // 商品数量
        productOrderItem.setProductorderitemPrice(priceCount);  // 商品总价
        productOrderItem.setProductorderitemProductId(pid);     // 商品id
        productOrderItem.setProductorderitemUserId(userId);
        // 新增订单
        count = productOrderItemService.addBuyCar(productOrderItem);
        if(count > 0){
            map.put("success",true);
        }else{
            map.put("success",false);
        }
        return JSON.toJSONString(map);
    }

    // 进入购物车
    @RequestMapping("/toCar")
    public String toCar(Model model,HttpSession session){
        // 先获取用户对象
        User user = (User) session.getAttribute("user");
        // 判断user是否为null 如果是null则跳转登录
        if(user == null){
            return "redirect:/fore/toLogin";
        }
        // 如果不是null 则根据用户id获取购物车集合
        List<ProductOrderItem> orderItemList = productOrderItemService.getBuyCarInUser(user.getUserId());
        List<Category> category = categoryService.get5Category();
        // 声明商品数量变量
        int orderItemTotal = 0;
        // 如果用户购物车集合不是0 则便利
        if(orderItemList.size() > 0){
            for(int i = 0; i < orderItemList.size(); i++){
                // 商品数量增加
                orderItemTotal++;
                // 获取商品id
                Integer productId = orderItemList.get(i).getProductorderitemProductId();
                // 根据商品id查询商品信息
                Product product = productService.getDetailById(productId);
                // 根据商品id查询商品预览图
                List<ProductImage> imgSrc = productImageService.getHomePageImg(productId);
                // 封装属性
                product.setSingleProductImageList(imgSrc);
                // 将该商品封装
                orderItemList.get(i).setProductOrderItemProduct(product);
            }
        }
        model.addAttribute("orderItemTotal",orderItemTotal);
        model.addAttribute("orderItemList",orderItemList);
        model.addAttribute("categoryList",category);
        return "page/fore/productBuyCarPage";
    }

    @RequestMapping("/removeOrder/{oid}")
    @ResponseBody
    public String removeOrder(@PathVariable("oid") Integer oid){
        int count = productOrderItemService.removeOrder(oid);
        Map<String,Object> map = new HashMap<>();
        if(count > 0){
            map.put("success",true);
        }else{
            map.put("success",false);
        }
        return JSON.toJSONString(map);
    }

}
