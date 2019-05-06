package com.lanqiao.zshop.service;

import com.lanqiao.zshop.dto.ProductDto;
import org.apache.commons.fileupload.FileUploadException;

/**
 *
 */
public interface ProductService {

    public void add(ProductDto productDto) throws FileUploadException;
}
