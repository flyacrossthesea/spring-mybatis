package org.framestudy.spring_mybatis.aspectjs;

import java.lang.reflect.InvocationTargetException;

import org.apache.ibatis.session.SqlSession;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.framestudy.spring_mybatis.usermag.mapper.UserMapper;
import org.framestudy.spring_mybatis.utils.SessionUtils;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class DaoAspectj {
	private SqlSession session;
	 @AfterReturning(returning="rvt", pointcut="execution(* org.framestudy.spring_mybatis.usermag.dao.impl.*.*(..))")
	public void commit(JoinPoint jp){
		 Object obj=jp.getTarget();
		 try {
			session=(SqlSession) obj.getClass().getMethod("getSession").invoke(obj, null);
			session.commit();
			System.out.println("session被提交了");
			session.close();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	 
	 @AfterThrowing(throwing="exe",pointcut="execution(* org.framestudy.spring_mybatis.usermag.dao.impl.*.*(..))" )
	 public void afterThrowing(JoinPoint jp){
		 Object obj=jp.getTarget();
		 try {
			session=(SqlSession) obj.getClass().getMethod("getSession").invoke(obj, null);
			session.rollback();
			System.out.println("session被回滚了");
			session.close();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }

}
