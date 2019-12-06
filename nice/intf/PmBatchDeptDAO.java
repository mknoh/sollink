package com.solutionlink.itscope.intface.dao;

import java.util.HashMap;
import java.util.List;

import com.solutionlink.itscope.common.model.PmDept;
import com.solutionlink.itscope.intface.model.PmBatchDept;

public interface PmBatchDeptDAO {
	public void deleteBatchDeptTable()  ;
	public void insertDeptList(PmBatchDept data);
	
	public List<PmBatchDept> selectDeptList(PmBatchDept pmBatchDept) ;
	

	public void insertDeptByBatch(PmDept pmDept) ;
	

	public int updateDeptByBatch(PmDept pmDept) ;
	
	public int updateDeptStatus(PmDept pmDept) ;
}
