package com.atguigu.gulimall.product.dao;

import com.atguigu.gulimall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author gxm
 * @email 1161561607@qq.com
 * @date 2022-07-06 10:06:56
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}
