package com.theatre.controllerBL;

import com.theatre.domain.ConstBL;
import com.theatre.domain.TransferClass;
import com.theatre.systemoperation.GeneralSystemOperation;
import com.theatre.systemoperation.reservations.ReservationsAdd;
import com.theatre.systemoperation.reservations.ReservationsDelete;
import com.theatre.systemoperation.reservations.ReservationsReturn;
import com.theatre.systemoperation.reservations.ReservationsUpdate;

public class ControllerBLReservations implements ControllerBL {

	@Override
	public void execute(TransferClass transferClass) {
		// TODO Auto-generated method stub
		GeneralSystemOperation operation = null;
		if(transferClass.getConstBL()==ConstBL.ADD_RESERVATIONS) { 
			operation = new ReservationsAdd();
		}else if (transferClass.getConstBL()==ConstBL.DELETE_RESERVATIONS) {
			operation = new ReservationsDelete();
		}else if (transferClass.getConstBL()==ConstBL.RETURN_RESERVATIONS) {
			operation = new ReservationsReturn();
		}else if (transferClass.getConstBL()==ConstBL.EDIT_RESERVATIONS) {
			operation = new ReservationsUpdate();
		}
		operation.doSystemOperation(transferClass);   
		
	}

}
