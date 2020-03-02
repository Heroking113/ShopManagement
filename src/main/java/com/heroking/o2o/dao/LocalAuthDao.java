package com.heroking.o2o.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import com.heroking.o2o.entity.LocalAuth;

/**
 * @Author heroking
 * @Date 2019年12月13日 下午7:17:14 类说明
 */
public interface LocalAuthDao {
	/**
	 * 通过账号密码查询对应信息，用于登录
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	LocalAuth queryLocalByNameAndPwd(@Param("username") String username, @Param("password") String password);

	/**
	 * 通过用户Id查询对应localauth
	 * 
	 * @param userId
	 * @return
	 */
	LocalAuth queryLocalByUserId(@Param("userId") long userId);

	/**
	 * 添加平台账号
	 * 
	 * @param localAuth
	 * @return
	 */
	int insertLocalAuth(LocalAuth localAuth);

	/**
	 * 通过userId，username，password更改密码
	 * 
	 * @param userId
	 * @param username
	 * @param password
	 * @param newPassword
	 * @param lastEditTime
	 * @return
	 */
	int updateLocalAuth(@Param("userId") Long userId, @Param("username") String username,
			@Param("password") String password, @Param("newPassword") String newPassword,
			@Param("lastEditTime") Date lastEditTime);
}
