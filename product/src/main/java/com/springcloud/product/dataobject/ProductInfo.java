package com.springcloud.product.dataobject;

/**
 * @program:
 * @description:
 * @author: Song
 * @create: Created in 2019-01-18 20:57
 * @Modified by:
 **/

//import org.hibernate.annotations.Table;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;


//@Table( name = "xxxxxx")
@Data
@Entity
public class ProductInfo {          //与数据库相应的表的名字保持一致，要是不一致的话使用//@Table( name = "xxxxxx"), name就是你的表名
    @Id
    private String productId;

    /** 名字. */
    private String productName;

    /** 单价. */
    private BigDecimal productPrice;

    /** 库存. */
    private Integer productStock;

    /** 描述. */
    private String productDescription;

    /** 小图. */
    private String productIcon;

    /** 状态, 0正常1下架. */
    private Integer productStatus;

    /** 类目编号. */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
