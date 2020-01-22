package com.theatre.controllerBL;

import com.theatre.domain.ConstBL;
import com.theatre.domain.TransferClass;
import com.theatre.domain.ConstBL;
import com.theatre.systemoperation.GeneralSystemOperation;
import com.theatre.systemoperation.user.UserSo;

public class ControllerBLUser implements ControllerBL{

	@Override
	public void execute(TransferClass transferClass) {
		GeneralSystemOperation operacija = null;
		if(transferClass.getConstBL() == ConstBL.LOGIN) {
			operacija = new UserSo();
		}
		operacija.doSystemOperation(transferClass);
		
	}

}
