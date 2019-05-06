package com.lanqiao.zshop.dao;

import com.lanqiao.zshop.pojo.ProductType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductTypeDao {

    /**
     * 查询所有商品类型
     * @return
     */
    public List<ProductType> selectAll();

    /**
     * 根据id查询商品类型
     * @param id
     * @return
     */
    public ProductType selectById(int id);

    /**
     * 根据名称查找商品
     * @param name
     * @return
     */
    public ProductType selectByName(String name);

    /**
     * 插入一条数据
     * @param name
     */
    public void insert(@Param("name") String name,@Param("status") int status);

    /**
     * 修改姓名
     * @param id
     * @param name
     */
    public void updateName(@Param("id")int id,@Param("name") String name);

    /**
     * 修改状态
     * @param id
     * @param status
     */
    public void updateStatus(@Param("id") int id,@Param("status") int status);

    /**
     * 根据id删除数据
     * @param id
     */
    public void deleteById(int id);

    /**
     *根据状态查找数据
     * @param productTypeEnable
     * @return
     */
    List<ProductType> selectByStatus(int status);
}
