package com.lanqiao.zshop.backend.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductVo {

    private String name; //商品名称
    private Double price;//商品价格
    private CommonsMultipartFile file; //商品图片(上传文件)
    private Integer productTypeId; //商品类型编号
}
