package com.heroking.o2o.dao;


import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.heroking.o2o.BaseTest;
import com.heroking.o2o.entity.HeadLine;

/**
* @Author heroking
* @Date 2019年11月22日 下午4:35:53
* 类说明 
*/
public class HeadLineDaoTest extends BaseTest {
	@Autowired
	private HeadLineDao headLineDao;
	
	@Test
	@Ignore
	public void testQueryHeadLine() {
		List<HeadLine> headLineList = headLineDao.queryHeadLine(new HeadLine());
		System.out.println("healineList.size:"+headLineList.size());
		/* assertEquals(3, headLineList.size()); */
	}
	
	@Test
	public void testInsertHeadLine() {
		HeadLine headLine = new HeadLine();
		headLine.setLineName("picture86");
		headLine.setLineLink("#");
		headLine.setLineImg("test");
		headLine.setPriority(1);
		headLine.setEnableStatus(1);
		headLine.setCreateTime(new Date());
		headLine.setLastEditTime(new Date());
		
		int effectedNum = headLineDao.insertHeadLine(headLine);
		System.out.println("effectedNum:"+effectedNum);
	}
	
	@Test
	@Ignore
	public void testUpdateHeadLine() {
		HeadLine headLine = new HeadLine();
		headLine.setLineId(4L);
		headLine.setLineName("picture4");
		int effectedNum = headLineDao.updateHeadLine(headLine);
		System.out.println("effectedNum:"+effectedNum);
		
	}
}
