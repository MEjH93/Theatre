package com.theatre.systemoperation.reservations;

import com.theatre.broker.Broker;
import com.theatre.domain.Reservations;
import com.theatre.domain.TransferClass;
import com.theatre.systemoperation.GeneralSystemOperation;

public class ReservationsAdd extends GeneralSystemOperation {

	@Override
	public void doConcreteSystemOperation(TransferClass object) {
		// TODO Auto-generated method stub
		Reservations reservations = (Reservations) object.getRequest();
		Broker broker = new Broker();
		broker.add(reservations);
		
	}

}
