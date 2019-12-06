package com.solutionlink.itscope.intface.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.solutionlink.itscope.common.model.PmUser;
import com.solutionlink.itscope.intface.model.PmBatchDept;
import com.solutionlink.itscope.intface.model.PmBatchUser;

public class PmBatchUserDAOImpl extends SqlMapClientDaoSupport implements PmBatchUserDAO {
	@Override
	public void deleteBatchUserTable() {
		getSqlMapClientTemplate().delete("PM_BATCH_USER.deletePmBatchUserTable");
		
	}
	@Override
	public void insertUserList(PmBatchUser data) {
		// TODO Auto-generated method stub
		getSqlMapClientTemplate().insert("PM_BATCH_USER.insertPmBatchUser", data);
	}
	
	/**
	 * <PRE>
	 * 1. MethodName	: selectUserList
	 * 2. ClassName		: PmBatchUserDAOImpl
	 * 3. Comment		: 실제 PM_USER 테이블과 동기화할  데이터만(배치 실행일에 변경된 데이터, 부서/직위가 있는 사용자만) 가져온다. 
	 * 4. 작성자			: MKNOH
	 * 5. 작성일			: 2017. 3. 3. 오후 3:52:48
	 * </PRE>
	 * 		@param pmBatchUser
	 * 		@return List
	 */
	public List<PmBatchUser> selectUserList(PmBatchUser pmBatchUser) {
		return getSqlMapClientTemplate().queryForList("PM_BATCH_USER.selectUserList", pmBatchUser);
	}
	
	
	/**
	 * <PRE>
	 * 1. MethodName	: insertUserByBatch
	 * 2. ClassName		: PmBatchUserDAOImpl
	 * 3. Comment		: 동기화한 사용자 insert 하기 
	 * 4. 작성자			: MKNOH
	 * 5. 작성일			: 2017. 3. 3. 오후 4:16:24
	 * </PRE>
	 * 		@return void
	 * 		@param PmUser record
	 */
	public void insertUserByBatch(PmUser record) {
		getSqlMapClientTemplate().insert("PM_BATCH_USER.insertUserByBatch", record);
	}
	
	
	/**
	 * <PRE>
	 * 1. MethodName	: updateUserByBatch
	 * 2. ClassName		: PmBatchUserDAOImpl
	 * 3. Comment		: 동기화한 사용자 update 하기
	 * 4. 작성자			: MKNOH
	 * 5. 작성일			: 2017. 3. 3. 오후 4:20:14
	 * </PRE>
	 * 		@return int
	 * 		@param PmUser record
	 */
	public int updateUserByBatch(PmUser record) {
		return getSqlMapClientTemplate().update("PM_BATCH_USER.updateUserByBatch", record);
	}
	@Override
	public PmBatchUser selectByUserId(String userId) {
		// TODO Auto-generated method stub
		return (PmBatchUser) getSqlMapClientTemplate().queryForObject("PM_BATCH_USER.selectByUserId", userId);
	}
	
	
	/**
	 * <PRE>
	 * 1. MethodName	: updateUserStatus
	 * 2. ClassName		: PmBatchUserDAOImpl
	 * 3. Comment		: batch에서 가져온 사용자 외에는 모두 STATUS를 '0'으로 설정함.
	 * 4. 작성자			: MKNOH
	 * 5. 작성일			: 2017. 3. 9. 오후 4:19:37
	 * </PRE>
	 * 		@return int
	 * 		@param record
	 * 		@return
	 */
	public int updateUserStatus(PmUser record) {
		return getSqlMapClientTemplate().update("PM_BATCH_USER.updateUserStatus", record);
	}
}