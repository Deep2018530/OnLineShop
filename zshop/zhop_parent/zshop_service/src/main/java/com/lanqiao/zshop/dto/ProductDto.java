package com.lanqiao.zshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.InputStream;

/**
 * 数据传输对象
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private String name;
    private Double price;
    private Integer productTypeId;
    private InputStream inputStream; //文件的输入流
    private String fileName;//文件的名称
    private String uploadPath;//文件的上传路径
}
