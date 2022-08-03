package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author gxm
 * @email 1161561607@qq.com
 * @date 2022-07-06 15:16:21
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
