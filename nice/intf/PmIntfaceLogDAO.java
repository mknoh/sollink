package com.solutionlink.itscope.intface.dao;

import java.util.HashMap;
import java.util.List;

import com.solutionlink.itscope.intface.model.PmIntfaceLog;

public interface PmIntfaceLogDAO {

	
	public List selectIntfaceLogList(HashMap searchMap);
	
	public PmIntfaceLog selectByPrimaryKey(PmIntfaceLog pmIntfaceLog) ;
	
	public String selectIntfaceSeq () ;
	
	public void insert(PmIntfaceLog pmIntfaceLog) ;
	
	public int updateByPrimaryKeySelective(PmIntfaceLog pmIntfaceLog) ;
	
}
