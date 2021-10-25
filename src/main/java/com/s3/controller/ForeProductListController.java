package com.s3.controller;

import com.s3.pojo.Product;
import com.s3.service.impl.CategoryServiceImpl;
import com.s3.service.impl.ProductServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/productList")
public class ForeProductListController {

    @Resource
    ProductServiceImpl productService;
    @Resource
    CategoryServiceImpl categoryService;

    @RequestMapping("/search")
    public String search(@RequestParam(value = "productName",required = false) String productName,
                         @RequestParam(value = "categoryId",required = false) Integer categoryId,
                         Model model){
        List<Product> productList = productService.getListByName(productName,categoryId);
        model.addAttribute("searchValue",productName);
        model.addAttribute("categoryList",categoryService.get5Category());
        model.addAttribute("productList",productList);
        return "page/fore/productListPage";
    }

}
