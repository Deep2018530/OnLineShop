package com.lanqiao.zshop.service.impl;

import com.lanqiao.zshop.common.util.StringUtils;
import com.lanqiao.zshop.dao.ProductDao;
import com.lanqiao.zshop.dto.ProductDto;
import com.lanqiao.zshop.pojo.Product;
import com.lanqiao.zshop.pojo.ProductType;
import com.lanqiao.zshop.service.ProductService;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StreamUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public void add(ProductDto productDto) throws FileUploadException {
        //1.文件上传
        String fileName = StringUtils.renameFileName(productDto.getFileName());
        String filePath = productDto.getUploadPath() + "/" + fileName;
        try {
            StreamUtils.copy(productDto.getInputStream(), new FileOutputStream(filePath));
        } catch (IOException e) {
            throw new FileUploadException("文件上传失败" + e.getMessage());
        }
        //2.保存到数据库,将DTO转换为POJO
        Product product = new Product();
        try {
            PropertyUtils.copyProperties(product, productDto);
            product.setImage(filePath);

            ProductType productType = new ProductType();
            productType.setId(productDto.getProductTypeId());

            product.setProductType(productType);

            productDao.insert(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
