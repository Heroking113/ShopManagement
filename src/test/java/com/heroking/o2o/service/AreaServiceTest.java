/**
 * Description:
 * @author Heroking
 * @date 2019年10月26日
 */
package com.heroking.o2o.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.heroking.o2o.BaseTest;
import com.heroking.o2o.entity.Area;
import com.heroking.o2o.service.AreaService;

/**
 * Description:
 * 
 * @author Heroking
 * @date 2019年10月26日
 */
public class AreaServiceTest extends BaseTest {
	@Autowired
	private AreaService areaService;
	@Autowired
	private CacheService cacheService;

	@Test
	public void testGetAreaList() {
		List<Area> areaList = areaService.getAreaList();
		assertEquals("北苑", areaList.get(0).getAreaName());
		cacheService.removeFromCache(areaService.AREALISTKEY);
		areaList = areaService.getAreaList();
	}
}
