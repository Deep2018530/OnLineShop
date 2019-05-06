package com.lanqiao.zshop.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    private Integer id;
    private String name;
    private Double price;
    private String info;
    private String image;
    private ProductType productType;
}
