package com.theatre.controllerBL;

import com.theatre.domain.ConstBL;
import com.theatre.domain.TransferClass;
import com.theatre.systemoperation.GeneralSystemOperation;
import com.theatre.systemoperation.schedule.ScheduleAdd;
import com.theatre.systemoperation.schedule.ScheduleDelete;
import com.theatre.systemoperation.schedule.ScheduleReturn;
import com.theatre.systemoperation.schedule.ScheduleUpdate;

public class ControllerBLSchedule implements ControllerBL {

	@Override
	public void execute(TransferClass transferClass) {
		// TODO Auto-generated method stub
		GeneralSystemOperation operation = null;
		if(transferClass.getConstBL() == ConstBL.ADD_SCHEDULE) { 
			operation = new ScheduleAdd();
		}else if (transferClass.getConstBL()==ConstBL.DELETE_SCHEDULE) {
			operation = new ScheduleDelete();
		}else if (transferClass.getConstBL()==ConstBL.RETURN_SCHEDULE) {
			operation = new ScheduleReturn();
		}else if (transferClass.getConstBL()==ConstBL.EDIT_SCHEDULE) {
			operation = new ScheduleUpdate();
		}
		operation.doSystemOperation(transferClass);   
		
	}

}
