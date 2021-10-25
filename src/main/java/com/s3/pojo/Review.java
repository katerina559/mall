package com.s3.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 *  评论表
 */
@Data
public class Review implements Serializable {
    private Integer reviewId;           // 评论表主键
    private String reviewContent;       // 评论内容
    @JsonFormat(timezone = "GMT+8")
    private String reviewCreatedate;    // 评论日期
    private Integer reviewUserId;       // 评论人(对应用户表中的主键)
    private Integer reviewProductId;    // 评价的商品(对应商品表中的主键)
    private Integer reviewOrderItemId;  // 在哪个订单中评价(对应商品订单表中的主键)
    private User reviewUser;            // 评论人
}
