/**
 * Description:
 * @author Heroking
 * @date 2019年10月25日
 */
package com.heroking.o2o.dao;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.heroking.o2o.BaseTest;
import com.heroking.o2o.entity.Area;

/**
 * Description:
 * @author Heroking
 * @date 2019年10月25日
 */
public class AreaDaoTest extends BaseTest {
	@Autowired(required = true)
	private AreaDao areaDao;
	
	/**
	 * 测试连接mysql数据库*/
	@Test
	public void TestQueryArea() {
		List<Area> areaList = areaDao.queryArea();
		assertEquals(4, areaList.size());
	}
}
