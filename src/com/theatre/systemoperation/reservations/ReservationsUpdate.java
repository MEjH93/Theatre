package com.theatre.systemoperation.reservations;
import com.theatre.broker.Broker;
import com.theatre.domain.Reservations;
import com.theatre.domain.TransferClass;
import com.theatre.systemoperation.GeneralSystemOperation;

public class ReservationsUpdate extends GeneralSystemOperation {

	@Override
	public void doConcreteSystemOperation(TransferClass object) {
		Reservations reservations = (Reservations) object.getRequest();
		Broker broker = new Broker();
		broker.update(reservations);
		
		
		
	}

}
