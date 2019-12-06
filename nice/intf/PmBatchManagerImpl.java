package com.solutionlink.itscope.intface.service;

import java.math.BigDecimal;
import java.util.List;

import com.solutionlink.itscope.common.dao.PmDeptDAO;
import com.solutionlink.itscope.common.dao.PmUserDAO;
import com.solutionlink.itscope.common.model.PmDept;
import com.solutionlink.itscope.common.model.PmUser;
import com.solutionlink.itscope.framework.util.DateUtil;
import com.solutionlink.itscope.intface.dao.PmBatchDeptDAO;
import com.solutionlink.itscope.intface.dao.PmBatchUserDAO;
import com.solutionlink.itscope.intface.model.PmBatchDept;
import com.solutionlink.itscope.intface.model.PmBatchUser;

public class PmBatchManagerImpl implements PmBatchManager {
	private PmBatchUserDAO pmBatchUserDao;
	private PmBatchDeptDAO pmBatchDeptDao;
	private PmUserDAO userDao;
	private PmDeptDAO deptDao;

	public void setPmBatchUserDao(PmBatchUserDAO pmBatchUserDao) {
		this.pmBatchUserDao = pmBatchUserDao;
	}

	public void setPmBatchDeptDao(PmBatchDeptDAO pmBatchDeptDao) {
		this.pmBatchDeptDao = pmBatchDeptDao;
	}



	public void setUserDao(PmUserDAO userDao) {
		this.userDao = userDao;
	}

	public void setDeptDao(PmDeptDAO deptDao) {
		this.deptDao = deptDao;
	}

	/**
	 * <PRE>
	 * 1. MethodName	: deleteUserTable
	 * 2. ClassName		: PmBatchManagerImpl
	 * 3. Comment		: Batch용 User table data삭제
	 * 4. 작성자			: JWNAM
	 * 5. 작성일			: 2017. 2. 23. 오후 12:06:00
	 * </PRE>
	 * 		@return void
	 * 		@param
	 * 		@return
	 */
	@Override
	public void deleteUserTable() {
		// TODO Auto-generated method stub
		pmBatchUserDao.deleteBatchUserTable();
	}

	/**
	 * <PRE>
	 * 1. MethodName	: deleteDeptTable
	 * 2. ClassName		: PmBatchManagerImpl
	 * 3. Comment		: Batch용 Dept table data삭제
	 * 4. 작성자			: JWNAM
	 * 5. 작성일			: 2017. 2. 23. 오후 12:06:00
	 * </PRE>
	 * 		@return void
	 * 		@param
	 * 		@return
	 */
	@Override
	public void deleteDeptTable() {
		// TODO Auto-generated method stub
		pmBatchDeptDao.deleteBatchDeptTable();
	}

	/**
	 * <PRE>
	 * 1. MethodName	: insertUserData
	 * 2. ClassName		: PmBatchManagerImpl
	 * 3. Comment		: Batch용 User Table에 데이터 insert
	 * 4. 작성자			: JWNAM
	 * 5. 작성일			: 2017. 2. 23. 오후 12:06:00
	 * </PRE>
	 * 		@return void
	 * 		@param List
	 * 		@return
	 */
	@Override
	public void insertUserData(List userList) {
		// TODO Auto-generated method stub
		for(int i = 0; i < userList.size(); i++){
			pmBatchUserDao.insertUserList((PmBatchUser) userList.get(i));
		}
	}

	/**
	 * <PRE>
	 * 1. MethodName	: insertDeptData
	 * 2. ClassName		: PmBatchManagerImpl
	 * 3. Comment		: Batch용 Dept Table에 데이터 insert
	 * 4. 작성자			: JWNAM
	 * 5. 작성일			: 2017. 2. 23. 오후 12:06:00
	 * </PRE>
	 * 		@return void
	 * 		@param List
	 * 		@return
	 */
	@Override
	public void insertDeptData(List deptList) {
		// TODO Auto-generated method stub
		for(int i = 0; i < deptList.size(); i++){
			pmBatchDeptDao.insertDeptList((PmBatchDept) deptList.get(i));
		}
	}

	/**
	 * <PRE>
	 * 1. MethodName	: userDataSyncBatch
	 * 2. ClassName		: PmBatchManagerImpl
	 * 3. Comment		: 사용자 정보 자동 동기화
	 * 4. 작성자			: MKNOH
	 * 5. 작성일			: 2017. 3. 3. 오후 4:22:20
	 * </PRE>
	 * 		@return void
	 */
	public void userDataSyncBatch() {
		PmBatchUser pmBatchUser = new PmBatchUser();
		pmBatchUser.setBatchExeDt(DateUtil.getToDay());
		List<PmBatchUser> batchUserList = this.pmBatchUserDao.selectUserList(pmBatchUser);

		PmBatchUser batchData = null;
		PmUser pmUser = null;
		if (batchUserList != null) {
			for (int i=0; i<batchUserList.size();i++) {
				batchData = batchUserList.get(i);
				if (userDao.selectByPrimaryKeyCnt(batchData.getUserId()) == 0 ) {
					/***********************
					 * 사용자는 신규 사용자 자동 동기화 하지 않음. SYSTEM 메뉴에서 자동 동기화 함.
					pmUser = new PmUser();
					pmUser.setCompId("00001");
					pmUser.setUserId(batchData.getUserId());
					pmUser.setUserName(batchData.getEmpName());
					pmUser.setUserEngName(batchData.getEmpName());
					pmUser.setDeptPartId(batchData.getDeptId());
					pmUser.setHireDate(batchData.getJoinedDate());
					pmUser.setRetireDate(batchData.getRetireDate());
					pmUser.setEmail(batchData.getEmail());
					String empStatus = batchData.getEmpStatus();
					if ("ONLINE".equalsIgnoreCase(empStatus)) {
						pmUser.setStatus("1");
					} else {
						pmUser.setStatus("0");
					}
					pmUser.setCellPhoneNo(batchData.getMobile());
					pmUser.setEntryId("BATCH");

					this.pmBatchUserDao.insertUserByBatch(pmUser);
					*************************/
				} else {
					pmUser = new PmUser();
					pmUser.setCompId("00001");
					pmUser.setUserId(batchData.getUserId());
					pmUser.setUserName(batchData.getEmpName());
					pmUser.setUserEngName(batchData.getEmpName());
					pmUser.setDeptPartId(batchData.getDeptId());
					pmUser.setHireDate(batchData.getJoinedDate());
					pmUser.setRetireDate(batchData.getRetireDate());
					pmUser.setEmail(batchData.getEmail());
					String empStatus = batchData.getEmpStatus();
					if ("ONLINE".equalsIgnoreCase(empStatus)) {
						pmUser.setStatus("1");
					} else {
						pmUser.setStatus("0");
					}
					pmUser.setDutyId(batchData.getTitleName1Cd());	//직위코드
					pmUser.setCellPhoneNo(batchData.getMobile());
					pmUser.setUpdateId("BATCH");
					pmUser.setUpdateDt(DateUtil.getToDay());

					this.pmBatchUserDao.updateUserByBatch(pmUser);
				}
			}
		}
		
		//batch에서 가져온 사용자 외에는 모두 STATUS를 '0'으로 설정함.
		this.pmBatchUserDao.updateUserStatus(pmUser);
	}

	/**
	 * <PRE>
	 * 1. MethodName	: deptDataSyncBatch
	 * 2. ClassName		: PmBatchManagerImpl
	 * 3. Comment		: 부서 정보 자동 동기화
	 * 4. 작성자			: MKNOH
	 * 5. 작성일			: 2017. 3. 3. 오후 5:42:38
	 * </PRE>
	 * 		@return void
	 */
	public void deptDataSyncBatch() {
		PmBatchDept pmBatchDept = new PmBatchDept();
		pmBatchDept.setBatchExeDt(DateUtil.getToDay());

		List<PmBatchDept> batchDeptList = this.pmBatchDeptDao.selectDeptList(pmBatchDept);

		PmBatchDept batchData = null;
		PmDept pmDept = null;
		if (batchDeptList != null) {
			for (int i=0; i<batchDeptList.size();i++) {
				batchData = batchDeptList.get(i);
				if (deptDao.selectDeptCount(batchData.getDeptId()) == 0 ) {

					pmDept = new PmDept();
					pmDept.setCompId("00001");
					pmDept.setDeptId(batchData.getDeptId());
					pmDept.setParentDeptId(batchData.getUpDeptId());
					pmDept.setDeptName(batchData.getDeptName());
					pmDept.setDeptEngName(batchData.getDeptName());

					pmDept.setFullPath(batchData.getPath());
					pmDept.setDeptLevel(new BigDecimal(batchData.getDeptLevel()));

					String deptStatus = batchData.getDeptFg();
					if ("T".equalsIgnoreCase(deptStatus)) {
						pmDept.setDeptStatus("1");
					} else {
						pmDept.setDeptStatus("0");
					}
					pmDept.setDeptManagerId(batchData.getDeptUserId());
					pmDept.setEntryId("BATCH");

					this.pmBatchDeptDao.insertDeptByBatch(pmDept);
				} else {
					pmDept = new PmDept();
					pmDept.setCompId("00001");
					pmDept.setDeptId(batchData.getDeptId());
					pmDept.setParentDeptId(batchData.getUpDeptId());

					pmDept.setDeptName(batchData.getDeptName());
					pmDept.setDeptEngName(batchData.getDeptName());
					pmDept.setFullPath(batchData.getPath());
					pmDept.setDeptLevel(new BigDecimal(batchData.getDeptLevel()));

					String deptStatus = batchData.getDeptFg();
					if ("t".equalsIgnoreCase(deptStatus)) {
						pmDept.setDeptStatus("1");
					} else {
						pmDept.setDeptStatus("0");
					}
					pmDept.setDeptManagerId(batchData.getDeptUserId());
					pmDept.setUpdateId("BATCH");
					pmDept.setUpdateDt(DateUtil.getToDay());

					this.pmBatchDeptDao.updateDeptByBatch(pmDept);
				}
			}
		}
		
		//batch에서 가져온 부서 외에는 모두 DEPT_STATUS를 '0'으로 설정함.
		this.pmBatchDeptDao.updateDeptStatus(pmDept);
	}

}
