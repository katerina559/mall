package com.s3.controller;

import com.s3.pojo.Category;
import com.s3.pojo.Product;
import com.s3.pojo.Property;
import com.s3.pojo.PropertyValue;
import com.s3.service.impl.CategoryServiceImpl;
import com.s3.service.impl.ProductServiceImpl;
import com.s3.service.impl.PropertyServiceImpl;
import com.s3.service.impl.PropertyValueServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/detail")
public class ForeProductDetailsController {

    @Resource
    ProductServiceImpl productService;
    @Resource
    CategoryServiceImpl categoryService;
    @Resource
    PropertyServiceImpl propertyService;
    @Resource
    PropertyValueServiceImpl propertyValueService;

    // 根据商品id读取商品信息
    @RequestMapping("/productDetail/{pid}")
    public String productDetail(@PathVariable("pid") Integer pid, Model model){
        Product product = productService.getDetailById(pid);
        List<Category> categoryList = categoryService.get5Category();
        List<Property> propertyList = propertyService.getPropertyByCid(product.getProductCategoryId());
        if(product == null || product.getProductIsEnabled() == 1){
            return "404";
        }
        // 根据商品id查询商品属性值 存储到属性对象的属性值集合中
        List<PropertyValue> value = propertyValueService.getValue(pid);
        for (Property property : propertyList) {
            List<PropertyValue> list = new ArrayList();
            for (PropertyValue propertyValue : value) {
                if(property.getPropertyId() == propertyValue.getPropertyValuePropertyId()){
                    list.add(propertyValue);
                    property.setPropertyValueList(list);
                }
            }
        }
        model.addAttribute("propertyList",propertyList);
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("product",product);
        return "page/fore/productDetailsPage";
    }

}
