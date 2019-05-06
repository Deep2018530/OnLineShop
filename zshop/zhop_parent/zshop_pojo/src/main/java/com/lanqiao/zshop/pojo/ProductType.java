package com.lanqiao.zshop.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ProductType {

    @Getter @Setter private Integer id;
    @Getter @Setter private String name;
    @Getter @Setter private Integer status;
}
