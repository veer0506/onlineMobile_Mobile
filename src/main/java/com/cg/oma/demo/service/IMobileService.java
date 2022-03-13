package com.cg.oma.demo.service;


import java.util.List;

import com.cg.oma.demo.entities.Mobile;
import com.cg.oma.demo.exception.MobileNotFoundException;




public interface IMobileService {
	public String addMobile(Mobile mobile);
	public  String updateMobile(Mobile mobile) throws MobileNotFoundException;
	public String deleteMobile(int id) throws MobileNotFoundException;
	public List<Mobile> showAllMobileByCategoryId(int CategoryId);
	public Mobile showMobileById(int mobileId) throws MobileNotFoundException;
}
