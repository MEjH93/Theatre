package com.theatre.controllerBL;

import com.theatre.domain.ConstBL;
import com.theatre.domain.TransferClass;
import com.theatre.systemoperation.GeneralSystemOperation;
import com.theatre.systemoperation.theatre.ReturnTheatreID;
import com.theatre.systemoperation.theatre.TheatreAdd;
import com.theatre.systemoperation.theatre.TheatreDelete;
import com.theatre.systemoperation.theatre.TheatreNames;
import com.theatre.systemoperation.theatre.TheatreReturn;
import com.theatre.systemoperation.theatre.TheatreUpdate;

public class ControllerBLTheatre implements ControllerBL {

	@Override
	public void execute(TransferClass transferClass) {
		// TODO Auto-generated method stub
		GeneralSystemOperation operation = null;
		if(transferClass.getConstBL() == ConstBL.ADD_THEATRE) { 
			operation = new TheatreAdd();
		}else if (transferClass.getConstBL()==ConstBL.DELETE_THEATRE) {
			operation = new TheatreDelete();
		}else if (transferClass.getConstBL()==ConstBL.RETURN_THEATRE) {
			operation = new TheatreReturn();
		}else if(transferClass.getConstBL()==ConstBL.EDIT_THEATRE) {
			operation = new TheatreUpdate();
		}else if(transferClass.getConstBL()==ConstBL.THEATRE_NAMES) {
			operation = new TheatreNames();
		}else if(transferClass.getConstBL()==ConstBL.RETURN_ID_THEATRE) {
			operation = new ReturnTheatreID();
		}
		operation.doSystemOperation(transferClass); 
		
	}

}
