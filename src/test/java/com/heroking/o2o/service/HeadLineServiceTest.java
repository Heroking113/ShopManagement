package com.heroking.o2o.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.heroking.o2o.BaseTest;
import com.heroking.o2o.dto.HeadLineExecution;
import com.heroking.o2o.dto.ImageHolder;
import com.heroking.o2o.entity.HeadLine;

/**
 * @Author heroking
 * @Date 2019年11月25日 上午10:15:01 类说明
 */
public class HeadLineServiceTest extends BaseTest {
	@Autowired
	private HeadLineService headLineService;

	@Test
	public void testInsertHeadLine() {
		HeadLine headLine = new HeadLine();
		headLine.setLineName("picture6");
		headLine.setLineLink("#");
		headLine.setLineImg("test");
		headLine.setPriority(65);
		headLine.setEnableStatus(1);

		File headLineImg = new File("G:\\eclipse-workspace\\o2oProjectDev\\image\\upload\\images\\item\\shop\\2\\2019111421380468361.jpg");
		InputStream is = null;
		try {
			is = new FileInputStream(headLineImg);
		} catch (Exception e) {
			e.printStackTrace();
		}

		ImageHolder imageHolder = new ImageHolder(headLineImg.getName(), is);

		HeadLineExecution se = headLineService.insertHeadLine(headLine, imageHolder);
		System.out.println("se.getstate:"+se.getState());
	}
}
