package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author gxm
 * @email 1161561607@qq.com
 * @date 2022-07-06 15:28:01
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
