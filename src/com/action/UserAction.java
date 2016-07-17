package com.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;

import com.dao.UserInfoDao;
import com.dao.ZoneDao;

import com.model.UserInfo;
import com.model.Zone;
import com.opensymphony.xwork2.Preparable;
import com.pojo.MapPojo;
import com.util.Config;

public class UserAction extends BaseAction implements Preparable {
	
	private UserInfo userInfo;
	
	private List<UserInfo> userInfoList;
	private List<Zone> zoneList;
	private List<MapPojo>  mapPojos;
	
	
	public List<MapPojo> getMapPojos() {
		return mapPojos;
	}

	public void setMapPojos(List<MapPojo> mapPojos) {
		this.mapPojos = mapPojos;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public List<UserInfo> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfo> userInfoList) {
		this.userInfoList = userInfoList;
	}

	public List<Zone> getZoneList() {
		return zoneList;
	}

	public void setZoneList(List<Zone> zoneList) {
		this.zoneList = zoneList;
	}

	@Override
	public void prepare() throws Exception {
		
	}

	public String login(){
		System.out.println("inside login");
		
		HttpSession session = getSession();
		String username= (String) session.getAttribute("username");
		if(StringUtils.isNotBlank(username)){
			System.out.println("user is already logined");
			return "login";
		}
		
		UserInfoDao  userInfoDao = (UserInfoDao) Config.getConfig().getBean("userInfoDao");
		System.out.println("userInfoDao:" +userInfoDao);
		List<UserInfo> infos = userInfoDao.getAll();
		boolean login = false;
		if(infos != null && userInfo != null){
			for(UserInfo info:infos){
				if(info.getUserId().equalsIgnoreCase(userInfo.getUserId()) && info.getPassword().equalsIgnoreCase(userInfo.getPassword())){
					session.setAttribute("username", info.getUserId());
					session.setAttribute("role", info.getType());
					login  = true;
					System.out.println("SUCCESS");
					break;
				}
			}
			
			if(login){
				return SUCCESS;
			}else{
				addActionError("Kindly enter valid username and password");
				System.out.println("FAIL");
			}
			
		}
		
		
		return ERROR;
		
	}
	
	public String viewUsers(){
		System.out.println("inside viewUsers");
		ZoneDao zoneDao = (ZoneDao) Config.getConfig().getBean("zoneDao");
		zoneList = zoneDao.getAll();
		
		UserInfoDao  userInfoDao = (UserInfoDao) Config.getConfig().getBean("userInfoDao");
		userInfoList = userInfoDao.getAll();
		
		return SUCCESS;
		
	}
	

	public String addUserForm(){
		System.out.println("inside addUserForm, userinfo:" + userInfo);
		
		
		
		return SUCCESS;
		
	}
	
	public String addUser(){
		System.out.println("inside addUser, userinfo:" + userInfo);
		
		UserInfoDao  userInfoDao = (UserInfoDao) Config.getConfig().getBean("userInfoDao");
		userInfoDao.save(userInfo);
		
		return SUCCESS;
		
	}
	
	public String viewOnMap(){
		System.out.println("inside viewOnMap, userinfo:" + userInfo);
		
//		UserInfoDao  userInfoDao = (UserInfoDao) Config.getConfig().getBean("userInfoDao");
//		LocationDao  locationDao = (LocationDao) Config.getConfig().getBean("locationDao");
//		userInfoList =  userInfoDao.getAll();
//		
//		for(UserInfo info:userInfoList){
//			if("U".equalsIgnoreCase(info.getType())){
//				MapPojo  mapPojo =  new MapPojo();
//				List<Location> 
//				
//			}
//		}
		
		MapPojo  mapPojo =  new MapPojo();
		mapPojo.setId("2");
		mapPojo.setInfo("Sanjay");
		mapPojo.setLongitude("-87.661236");
		mapPojo.setLatitude("42.002707");
		

		MapPojo  mapPojo1 =  new MapPojo();
		mapPojo1.setId("3");
		mapPojo1.setInfo("Arpit");
		mapPojo1.setLongitude("-87.655167");
		mapPojo1.setLatitude("41.939670");
		
		

		MapPojo  mapPojo2 =  new MapPojo();
		mapPojo2.setId("4");
		mapPojo2.setInfo("saurav");
		mapPojo2.setLongitude("-87.659916");
		mapPojo2.setLatitude("41.976816");
		
		mapPojos = new ArrayList<MapPojo>();
		mapPojos.add(mapPojo);
		mapPojos.add(mapPojo1);
		mapPojos.add(mapPojo2);
		
		
		
		
		return SUCCESS;
	}
}
