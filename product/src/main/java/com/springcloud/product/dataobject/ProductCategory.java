package com.springcloud.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-18 21:52
 * @Modified by:
 **/
@Data
@Entity
public class ProductCategory {
    @Id
    @GeneratedValue   //该注解能够使该主键自增
    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;


}
