package com.s3.service.impl;

import com.s3.mapper.CategoryMapper;
import com.s3.mapper.ProductImageMapper;
import com.s3.mapper.ProductMapper;
import com.s3.pojo.*;
import com.s3.service.ProductImageService;
import com.s3.service.ProductService;
import com.s3.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *  商品信息业务逻辑层实现类
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    ProductMapper productMapper;
    @Resource
    CategoryServiceImpl categoryService;
    @Resource
    ProductImageServiceImpl productImageService;
    @Resource
    ProductOrderItemServiceImpl productOrderItemService;
    @Resource
    ReviewServiceImpl reviewService;
    @Resource
    UserServiceImpl userService;

    /*@Override
    public PageUtil<Product> get4Page(String productName, Integer categoryId, Integer[] productIsEnabled, Float hPrice, Float lPrice, Integer pageIndex, Integer pageSize) {
        PageUtil<Product> page = new PageUtil<>();
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        page.setTotalCount(productMapper.getCount(productName,categoryId,productIsEnabled,hPrice,lPrice));
        page.setList(productMapper.getProductList(productName,categoryId,productIsEnabled,hPrice,lPrice,(pageIndex-1)*pageSize,pageSize));
        return page;
    }
*/

    @Override
    public List<Product> getImg() {
        return productMapper.getImg();
    }

    @Override
    public List<Product> getProductByCid(Integer cid) {
        return productMapper.getProductByCid(cid);
    }

    @Override
    public List<Product> getListByName(String productName,Integer cid) {
        List<Product> list = productMapper.getListByName(productName,cid);
        for(int i = 0; i < list.size(); i++){
            // 商品的商品类型外键
            Integer productCategoryId = list.get(i).getProductCategoryId();
            // 查询到的每个商品所属的类型
            Category category = categoryService.getCategory(productCategoryId);
            // 获取商品的商品主键
            Integer productId = list.get(i).getProductId();
            // 根据商品主键查询到的每个商品的预览图地址
            List<ProductImage> imgSrc = productImageService.getImgSrc(productId);
            // 根据商品主键查询到的每个商品的成交量
            Integer count = productOrderItemService.saleCount(productId);
            // 根据商品主键查询到的每个商品的评论数量
            Integer review = reviewService.getReviewById(productId);
            list.get(i).setProductReviewCount(review);
            list.get(i).setProductSaleCount(count);
            list.get(i).setSingleProductImageList(imgSrc);
            list.get(i).setProductCategory(category);
        }
        return list;
    }

    @Override
    public Product getDetailById(Integer pid) {
        // 获取到商品对象
        Product product = productMapper.getDetailById(pid);
        // 商品类型外键
        Integer productCategoryId = product.getProductCategoryId();
        // 商品主键
        Integer productId = product.getProductId();
        // 根据商品的商品类型外键获取商品类型对象
        Category category = categoryService.getCategory(productCategoryId);
        // 根据商品类型主键获取商品图片地址
        List<ProductImage> imgSrc = productImageService.getImgSrc(productId);
        // 根据商品主键查询到的每个商品的成交量
        Integer count = productOrderItemService.saleCount(productId);
        // 根据商品主键查询到的每个商品的评论数量
        Integer review = reviewService.getReviewById(productId);
        // 根据商品主键查询到每个商品的评论集合
        List<Review> reviewList = reviewService.getReview(productId);
        // 便利评论集合
        for(int i = 0; i < reviewList.size(); i++){
            // 获取评论集合里的userid外键
            Integer userid = reviewList.get(i).getReviewUserId();
            // 根据外键查询user对象
            User user = userService.getUser(userid);
            // 将user对象存放到评论集合中
            reviewList.get(i).setReviewUser(user);
        }
        product.setReviewList(reviewList);
        product.setProductReviewCount(review);
        product.setProductSaleCount(count);
        product.setSingleProductImageList(imgSrc);
        product.setProductCategory(category);
        return product;
    }

}
