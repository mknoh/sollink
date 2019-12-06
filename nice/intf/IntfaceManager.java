package com.solutionlink.itscope.intface.service;

import java.util.HashMap;
import java.util.List;

import com.solutionlink.itscope.intface.model.PmIntfaceLog;

public interface IntfaceManager {
	

	public List selectIntfaceLogList(HashMap searchMap) ;
	
	public String insertIntfaceLog(PmIntfaceLog pmIntfaceLog);
	
	public int updateIntfaceLog(PmIntfaceLog pmIntfaceLog) ;
}
