package com.s3.controller;

import com.s3.pojo.Category;
import com.s3.pojo.Product;
import com.s3.service.impl.CategoryServiceImpl;
import com.s3.service.impl.ProductServiceImpl;
import com.s3.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

/**
 *  商品信息控制器
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Resource
    ProductServiceImpl productService;
    @Resource
    CategoryServiceImpl categoryService;

    @RequestMapping("/show")
    public String show(@RequestParam(value = "/productName",required = false) String productName,
                       @RequestParam(value = "categoryId",required = false) Integer categoryId,
                       @RequestParam(value = "checkbox_product_isEnabled",required = false) Integer[] checkbox_product_isEnabled,
                       @RequestParam(value = "lPrice",required = false) Float lPrice,
                       @RequestParam(value = "hPrice",required = false) Float hPirce,
                       @RequestParam(value = "pageIndex",required = true,defaultValue = "1") Integer pageIndex,
                       Model model){
        List<Category> list = categoryService.getList();
        PageUtil<Product> page = productService.get4Page(productName, categoryId, checkbox_product_isEnabled, hPirce, lPrice, pageIndex, 8);
        model.addAttribute("categoryList",list);
        model.addAttribute("productList",page.getList());
        model.addAttribute("page",page);
        model.addAttribute("productCount",page.getTotalCount());
        return "page/admin/homePage";
    }

}
