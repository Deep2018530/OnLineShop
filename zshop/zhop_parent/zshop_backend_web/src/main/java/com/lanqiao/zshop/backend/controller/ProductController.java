package com.lanqiao.zshop.backend.controller;

import com.lanqiao.zshop.backend.vo.ProductVo;
import com.lanqiao.zshop.common.constant.ProductTypeConstant;
import com.lanqiao.zshop.dto.ProductDto;
import com.lanqiao.zshop.pojo.ProductType;
import com.lanqiao.zshop.service.ProductService;
import com.lanqiao.zshop.service.ProductTypeService;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * 商品
 */
@Controller
@RequestMapping("/backend/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductTypeService productTypeService;

    @ModelAttribute("productTypes")
    public List<ProductType> loadProductTypes() {
        List<ProductType> productTypes = productTypeService.findEnable();
        return productTypes;
    }

    @RequestMapping("/findAll")
    public String findAll() {

        return "productManager";
    }

    @RequestMapping("/add")
    public String add(ProductVo productVo, HttpSession session, Model model) {
        String uploadPath = session.getServletContext().getRealPath("/WEB-INF/upload");

        //将Vo转换为dto
        ProductDto productDto = new ProductDto();
        try {
            PropertyUtils.copyProperties(productDto, productVo); //对象间属性的拷贝
            productDto.setInputStream(productVo.getFile().getInputStream());
            productDto.setFileName(productVo.getFile().getOriginalFilename());
            productDto.setUploadPath(uploadPath);
            productService.add(productDto);
            model.addAttribute("successMsg", "添加成功");
        } catch (Exception e) {
            //e.printStackTrace();
            model.addAttribute("errorMsg", e.getMessage());
        }
        return "forward:findAll";
    }

}
