package org.framestudy.spring_mybatis.usermag.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.framestudy.spring_mybatis.usermag.beans.UserInfo;
import org.framestudy.spring_mybatis.usermag.dao.IUserDao;
import org.framestudy.spring_mybatis.usermag.mapper.UserMapper;
import org.framestudy.spring_mybatis.utils.SessionUtils;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements IUserDao {

	private SqlSession session=SessionUtils.getSession();//取得会话对象
	private UserMapper um = session.getMapper(UserMapper.class);//取得接口的实例
	private int rows;
	
	
	
	public SqlSession getSession() {
		return session;
	}

	public int saveUserInfo(UserInfo user) {
		 
		rows=um.saveUserInfo(user);
		
		return rows;
	}

	public int updateUserInfo(UserInfo user) {
		 
		rows = um.updateUserInfo(user);
		
		return rows;
	}

	public int deleteUserInfo(Long id) {
		
		rows = um.deleteUserInfo(id);
		
		return rows;
	}

	public UserInfo getUserInfoById(Long id) {
	 
		UserInfo user = null;
		user = um.getUserInfoById(id);
		return user;
	}

	public UserInfo getUserByLoginNameAndPwd(String loginName, String pwd) {
		 
		UserInfo user = null;
		user = um.getUserByLoginNameAndPwd(loginName,pwd);
		
		return user;
	}

	public List<UserInfo> queryUserListByMap(Map map) {
		 
		List<UserInfo> users = null;		
		users = um.queryUserListByMap(map);
		
		return users;
	}
	
	public int batchSaveUserInfo(List<UserInfo> user) {
		 
		 
		rows = um.batchSaveUserInfo(user);
		
		return rows;
	}

	public int batchDeleteUserInfo(List<UserInfo> user) {
	 
		rows = um.batchDeleteUserInfo(user);
		
		return rows;
	}

}
