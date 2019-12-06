package com.solutionlink.itscope.intface.service;

import java.util.HashMap;
import java.util.List;

public interface PmBatchManager {
	public void deleteUserTable() ;
	public void deleteDeptTable() ;
	public void insertUserData(List userList) ;
	public void insertDeptData(List deptList) ;
	
	void userDataSyncBatch() ;
	
	void deptDataSyncBatch();
}
