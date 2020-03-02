/**
 * Description:
 * @author Heroking
 * @date 2019年10月25日
 */
package com.heroking.o2o;

/**
 * Description:
 * @author Heroking
 * @date 2019年10月25日
 */

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring和junit整合，junit启动时加载springIOC容器
 */
//指定单元测试环境
@RunWith(SpringJUnit4ClassRunner.class)
//指定配置文件路径
@ContextConfiguration({ "classpath:spring/spring-dao.xml", "classpath:spring/spring-service.xml",
		"classpath:spring/spring-redis.xml" })
public class BaseTest {

}
