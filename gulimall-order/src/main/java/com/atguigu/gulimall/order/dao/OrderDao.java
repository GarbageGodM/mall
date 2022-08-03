package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author gxm
 * @email 1161561607@qq.com
 * @date 2022-07-06 15:50:59
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
