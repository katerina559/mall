package com.s3.service.impl;

import com.s3.mapper.CategoryMapper;
import com.s3.pojo.Category;
import com.s3.pojo.Product;
import com.s3.pojo.ProductImage;
import com.s3.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.*;
import java.util.List;

/**
 *  商品类型业务逻辑层实现类
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    CategoryMapper categoryMapper;
    @Resource
    ProductServiceImpl productService;
    @Resource
    ProductImageServiceImpl productImageService;

    @Override
    public List<Category> getList() {
        List<Category> list = categoryMapper.getList();
        for(int i = 0; i < list.size(); i++){
            // 获取商品类型主键
            Integer categoryId = list.get(i).getCategoryId();
            // 根据商品类型主键查询所拥有的商品
            List<Product> productList = productService.getProductByCid(categoryId);
            for(int n = 0; n < productList.size(); n++){
                // 获取每个商品的主键
                Integer productId = productList.get(n).getProductId();
                // 根据主键查询预览图
                List<ProductImage> homePageImgSrc = productImageService.getHomePageImg(productId);
                productList.get(n).setSingleProductImageList(homePageImgSrc);
            }
            list.get(i).setProductList(productList);
        }
        return list;
    }

    @Override
    public Category getCategory(Integer pid) {
        return categoryMapper.getCategory(pid);
    }

    @Override
    public List<Category> get5Category() {
        return categoryMapper.get5Category();
    }

}
