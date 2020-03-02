/**
 * Description:
 * @author Heroking
 * @date 2019年10月26日
 */
package com.heroking.o2o.service;

import java.util.List;

import com.heroking.o2o.entity.Area;

/**
 * Description: interface类为“连接数据库的接口”
 * @author Heroking
 * @date 2019年10月26日
 */
public interface AreaService {
	public static final String AREALISTKEY = "arealist";
	/**
	 * 获取区域列表
	 * @return
	 */
	List<Area> getAreaList();
}
