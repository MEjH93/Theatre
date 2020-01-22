package com.theatre.controllerUI;

import java.util.List;

import com.theatre.controllerBL.ControllerBL;
import com.theatre.controllerBL.ControllerBLReservations;
import com.theatre.controllerBL.ControllerBLSchedule;
import com.theatre.controllerBL.ControllerBLShow;
import com.theatre.controllerBL.ControllerBLTheatre;
import com.theatre.controllerBL.ControllerBLUser;
//import com.comtrade.controlerPL.KontrolerBL;
//import com.comtrade.controlerPL.KontrolerBLArtikal;
//import com.comtrade.controlerPL.KontrolerBLUser;
//import com.comtrade.domen.Artikal;
import com.theatre.domain.TransferClass;

public class ControllerUI {
	private static ControllerUI instance;
	private ControllerUI() {
		
	}
	
	public static ControllerUI getInstance() {
		if (instance == null) {
			instance = new ControllerUI();
		}
		return instance;
	}
	
	public void execute(TransferClass transferClass) {
		ControllerBL controllerBL = null;
		switch (transferClass.getConstUI()) {
		case USER:
			controllerBL = new ControllerBLUser();
			break;
		case SHOW:
			controllerBL = new ControllerBLShow();
			break;
		case THEATRE:
			controllerBL = new ControllerBLTheatre();
			break;
		case SCHEDULE:
			controllerBL = new ControllerBLSchedule();
			break;
		case RESERVATIONS:
			controllerBL = new ControllerBLReservations();
			break;

		default:
			break;
		}
		controllerBL.execute(transferClass);
	}
	
}
