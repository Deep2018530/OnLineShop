package com.lanqiao.zshop.service.impl;

import com.lanqiao.zshop.common.Exception.ProductTypeExistException;
import com.lanqiao.zshop.common.constant.ProductTypeConstant;
import com.lanqiao.zshop.dao.ProductTypeDao;
import com.lanqiao.zshop.pojo.ProductType;
import com.lanqiao.zshop.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeDao productTypeDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<ProductType> findAll() {
        return productTypeDao.selectAll();
    }

    @Override
    public void add(String name) throws ProductTypeExistException {
        ProductType productType = productTypeDao.selectByName(name);
        if (null != productType) {
            throw new ProductTypeExistException("商品类型已存在！");
        }
        productTypeDao.insert(name, ProductTypeConstant.PRODUCT_TYPE_ENABLE);

    }

    @Override
    public ProductType findByid(int id) {
        return productTypeDao.selectById(id);
    }

    @Override
    public void modifyName(int id, String name) throws ProductTypeExistException {
        ProductType productType = productTypeDao.selectByName(name);
        if (null != productType) {
            throw new ProductTypeExistException("商品类型名称已存在！");
        }
        productTypeDao.updateName(id, name);
    }

    @Override
    public void removeById(int id) {
        productTypeDao.deleteById(id);
    }

    @Override
    public void modifyStatus(int id) {
        ProductType productType = findByid(id);
        int status = productType.getStatus();
        if (productType.getStatus() == ProductTypeConstant.PRODUCT_TYPE_ENABLE) {
            status = ProductTypeConstant.PRODUCT_TYPE_DISENABLE;
        } else {
            status = ProductTypeConstant.PRODUCT_TYPE_ENABLE;
        }
        productTypeDao.updateStatus(id, status);
    }

    @Override
    public List<ProductType> findEnable() {

        return productTypeDao.selectByStatus(ProductTypeConstant.PRODUCT_TYPE_ENABLE);
    }
}
