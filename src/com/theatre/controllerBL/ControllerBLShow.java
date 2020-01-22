package com.theatre.controllerBL;

import com.theatre.domain.ConstBL;
import com.theatre.domain.TransferClass;
import com.theatre.systemoperation.GeneralSystemOperation;
import com.theatre.systemoperation.show.ShowAdd;
import com.theatre.systemoperation.show.ShowDelete;
import com.theatre.systemoperation.show.ShowNamesComboBox;
import com.theatre.systemoperation.show.ShowReturn;
import com.theatre.systemoperation.show.ShowReturnColumnNames;
import com.theatre.systemoperation.show.ShowReturnDataShows;
import com.theatre.systemoperation.show.ShowUpdate;

public class ControllerBLShow implements ControllerBL {

	@Override
	public void execute(TransferClass transferClass) {
		// TODO Auto-generated method stub
		GeneralSystemOperation operation = null;
		if(transferClass.getConstBL() == ConstBL.ADD_SHOW) { 
			operation = new ShowAdd();
		}else if (transferClass.getConstBL()==ConstBL.DELETE_SHOW) {
			operation = new ShowDelete();
		}else if (transferClass.getConstBL()==ConstBL.RETURN_SHOW) {
			operation = new ShowReturn();
		}else if (transferClass.getConstBL()==ConstBL.EDIT_SHOW) {
			operation = new ShowUpdate();
		}else if(transferClass.getConstBL()==ConstBL.RETURN_SHOW_COLUMN_NAMES) {
			operation = new ShowReturnColumnNames();
		}else if(transferClass.getConstBL()==ConstBL.RETURN_DATA_SHOWS) {
			operation = new ShowReturnDataShows();
		}else if(transferClass.getConstBL()==ConstBL.SHOW_NAMES_COMBOBOX) {
			operation = new ShowNamesComboBox();
		}
		operation.doSystemOperation(transferClass);   
		
	}

}
