/**
 * 
 */
package com.dao.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dao.UserInfoDao;
import com.model.UserInfo;

/**
 * @author mVentus
 *
 */
public class UserInfoDaoHibernate extends GenericDaoHibernate<UserInfo, String> implements UserInfoDao{
	
	private static Log log = LogFactory.getLog(UserInfoDaoHibernate.class);
	
	public UserInfoDaoHibernate() {
		super(UserInfo.class);
	}
	
	
}
