package com.heroking.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.heroking.o2o.entity.HeadLine;

/**
 * @Author heroking
 * @Date 2019年11月22日 下午4:34:44 类说明
 */
public interface HeadLineDao {
	/**
	 * 获取头条相关信息
	 * @param headLineCondition
	 * @return
	 */
	List<HeadLine> queryHeadLine(@Param("headLineCondition") HeadLine headLineCondition);
	
	/**
	 * 插入头条信息
	 * @param headLine
	 * @return
	 */
	int insertHeadLine(HeadLine headLine);
	
	/**
	 * 更新头条信息
	 * @param headLine
	 * @return
	 */
	int updateHeadLine(HeadLine headLine);
}
