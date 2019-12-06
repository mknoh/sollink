package com.solutionlink.itscope.intface.service;

import java.util.HashMap;
import java.util.List;

import com.solutionlink.itscope.intface.dao.PmIntfaceLogDAO;
import com.solutionlink.itscope.intface.model.PmIntfaceLog;

public class IntfaceManagerImpl implements IntfaceManager {

	private PmIntfaceLogDAO pmIntfaceLogDao;

	public void setPmIntfaceLogDao(PmIntfaceLogDAO pmIntfaceLogDao) {
		this.pmIntfaceLogDao = pmIntfaceLogDao;
	}
	
	/**
	 * <PRE>
	 * 1. MethodName	: selectIntfaceLogList
	 * 2. ClassName		: InterfaceManagerImpl
	 * 3. Comment		: 인터페이스 로그 목록 조회
	 * 4. 작성자			: MKNOH
	 * 5. 작성일			: 2017. 2. 27. 오전 10:37:14
	 * </PRE>
	 * 		@return List
	 * 		@param searchMap
	 * 		@return
	 */
	public List selectIntfaceLogList(HashMap searchMap) {
		return this.pmIntfaceLogDao.selectIntfaceLogList(searchMap);
	}
	
	/**
	 * <PRE>
	 * 1. MethodName	: insertIntfaceLog
	 * 2. ClassName		: InterfaceManagerImpl
	 * 3. Comment		: 인터페이스 로그 저장처리
	 * 4. 작성자			: MKNOH
	 * 5. 작성일			: 2017. 2. 27. 오전 10:43:46
	 * </PRE>
	 * 		@return String 
	 * 		@param pmIntfaceLog
	 * 		@return
	 */
	public String insertIntfaceLog(PmIntfaceLog pmIntfaceLog) {
		String intSeq = this.pmIntfaceLogDao.selectIntfaceSeq();
		pmIntfaceLog.setInfSeq(intSeq);
		
		this.pmIntfaceLogDao.insert(pmIntfaceLog);
		
		return intSeq;
	}
	
	/**
	 * <PRE>
	 * 1. MethodName	: updateIntfaceLog
	 * 2. ClassName		: InterfaceManagerImpl
	 * 3. Comment		: 인터페이스 로그 update 처리
	 * 4. 작성자			: MKNOH
	 * 5. 작성일			: 2017. 2. 27. 오전 10:46:40
	 * </PRE>
	 * 		@return int
	 * 		@param pmIntfaceLog
	 * 		@return
	 */
	public int updateIntfaceLog(PmIntfaceLog pmIntfaceLog) {
		return this.pmIntfaceLogDao.updateByPrimaryKeySelective(pmIntfaceLog);
	}
}
