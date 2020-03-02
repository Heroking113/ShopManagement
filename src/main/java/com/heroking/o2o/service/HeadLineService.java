package com.heroking.o2o.service;

import java.io.IOException;
import java.util.List;

import com.heroking.o2o.dto.HeadLineExecution;
import com.heroking.o2o.dto.ImageHolder;
import com.heroking.o2o.entity.HeadLine;
import com.heroking.o2o.exceptions.HeadLineOperationException;

/**
 * @Author heroking
 * @Date 2019年11月22日 下午4:54:14 类说明
 */

public interface HeadLineService {
	public static final String HLLISTKEY = "headlinelist";
	/**
	 * 根据指定的条件返回指定的头条列表
	 * 
	 * @param headLineCondition
	 * @return
	 * @throws IOException
	 */
	List<HeadLine> getHeadLineList(HeadLine headLineCondition) throws IOException;

	/**
	 * 插入头条信息
	 * @param headLine
	 * @param thumbnail
	 * @return
	 * @throws HeadLineOperationException
	 */
	HeadLineExecution insertHeadLine(HeadLine headLine, ImageHolder thumbnail) throws HeadLineOperationException;
}
