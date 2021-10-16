package com.s3.util;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageUtil<T> implements Serializable {
    private Integer pageIndex;
    private Integer pageSize;
    private Integer pageCount;
    private Integer totalCount;
    private List<T> list;

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
        this.pageCount = this.totalCount % this.pageSize == 0?
                this.totalCount / this.pageSize :
                this.totalCount / this.pageSize + 1;
    }
}
