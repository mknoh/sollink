package com.solutionlink.itscope.intface.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.solutionlink.itscope.intface.model.PmIntfaceLog;

/**
 * ==========================================================================
 * P R O G R A M    I N F O R M A T I O N
 * ==========================================================================
 * 0. Project		: ITSCOPE
 *
 * 1. FileName		: PmIntfaceLogDAOImpl.java
 * 2. Package		: com.solutionlink.itscope.intface.dao
 * 3. Comment		: 인터페이스 로그 관리
 * 4. Author		: MKNOH
 * 5. Since			: 2017. 2. 27. 오전 10:24:59
 *
 * ==========================================================================
 * V E R S I O N    C O N T R O L
 * ==========================================================================
 * DATE			AUTHOR		VER.	DESCRIPTION
 * ------------ ----------- ------- -----------------------------------------
 * 2017. 2. 27. MKNOH 		1.0		신규 개발.
 * ==========================================================================
 */
public class PmIntfaceLogDAOImpl  extends SqlMapClientDaoSupport implements PmIntfaceLogDAO {
	
	/**
	 * <PRE>
	 * 1. MethodName	: selectIntfaceLogList
	 * 2. ClassName		: PmIntfaceLogDAOImpl
	 * 3. Comment		: 인터페이스 로그 목록 조회
	 * 4. 작성자			: MKNOH
	 * 5. 작성일			: 2017. 2. 27. 오전 10:25:12
	 * </PRE>
	 * 		@param searchMap
	 * 		@return List
	 */
	public List selectIntfaceLogList(HashMap searchMap)  {
		return getSqlMapClientTemplate().queryForList("PM_INTFACE_LOG.selectInterfaceLogList", searchMap);
	}
	
	/**
	 * <PRE>
	 * 1. MethodName	: selectByPrimaryKey
	 * 2. ClassName		: PmIntfaceLogDAOImpl
	 * 3. Comment		: 인터페이스 로그 상세 조회
	 * 4. 작성자			: MKNOH
	 * 5. 작성일			: 2017. 2. 27. 오후 1:28:56
	 * </PRE>
	 * 		@return PmIntfaceLog
	 * 		@param pmIntfaceLog
	 * 		@return
	 */
	public PmIntfaceLog selectByPrimaryKey(PmIntfaceLog pmIntfaceLog)  {
		return (PmIntfaceLog)getSqlMapClientTemplate().queryForObject("PM_INTFACE_LOG.selectByPrimaryKey", pmIntfaceLog);
	}
	
	/**
	 * <PRE>
	 * 1. MethodName	: selectIntfaceSeq
	 * 2. ClassName		: PmIntfaceLogDAOImpl
	 * 3. Comment		: 인터페이스 로그 키 조회
	 * 4. 작성자			: MKNOH
	 * 5. 작성일			: 2017. 2. 27. 오전 10:25:25
	 * </PRE>
	 * 		@return String
	 */
	public String selectIntfaceSeq () {
		return (String)getSqlMapClientTemplate().queryForObject("PM_INTFACE_LOG.selectIntfaceSeq");
	}
	
	/**
	 * <PRE>
	 * 1. MethodName	: insert
	 * 2. ClassName		: PmIntfaceLogDAOImpl
	 * 3. Comment		: 인터페이스 로그 insert
	 * 4. 작성자			: MKNOH
	 * 5. 작성일			: 2017. 2. 27. 오전 10:26:09
	 * </PRE>
	 * 		@param pmIntfaceLog
	 */
	public void insert(PmIntfaceLog pmIntfaceLog) {
		getSqlMapClientTemplate().insert("PM_INTFACE_LOG.insert", pmIntfaceLog);
	}

	/**
	 * <PRE>
	 * 1. MethodName	: updateByPrimaryKeySelective
	 * 2. ClassName		: PmIntfaceLogDAOImpl
	 * 3. Comment		: 인터페이스 로그 update
	 * 4. 작성자			: MKNOH
	 * 5. 작성일			: 2017. 2. 27. 오전 10:44:53
	 * </PRE>
	 * 		@param pmIntfaceLog
	 * 		@return
	 */
	public int updateByPrimaryKeySelective(PmIntfaceLog pmIntfaceLog) {
		return getSqlMapClientTemplate().update("PM_INTFACE_LOG.updateByPrimaryKeySelective", pmIntfaceLog);
	}

}
