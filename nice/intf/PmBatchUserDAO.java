package com.solutionlink.itscope.intface.dao;

import java.util.HashMap;
import java.util.List;

import com.solutionlink.itscope.common.model.PmUser;
import com.solutionlink.itscope.intface.model.PmBatchDept;
import com.solutionlink.itscope.intface.model.PmBatchUser;

public interface PmBatchUserDAO {
	void deleteBatchUserTable();

	void insertUserList(PmBatchUser dataMap);
	
	public List<PmBatchUser> selectUserList(PmBatchUser pmBatchUser) ;
	
	public void insertUserByBatch(PmUser record) ;
	
	public int updateUserByBatch(PmUser record);

	public PmBatchUser selectByUserId(String string);
	
	public int updateUserStatus(PmUser record) ;
}
