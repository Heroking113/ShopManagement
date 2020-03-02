/**
 * Description:
 * @author Heroking
 * @date 2019年10月25日
 */
package com.heroking.o2o.dao;

import java.util.List;

import com.heroking.o2o.entity.Area;

/**
 * Description:
 * @author Heroking
 * @date 2019年10月25日
 */

/**
 * 列出区域列表
 * @return areaList
 * */
public interface AreaDao {
	List<Area> queryArea();
}
