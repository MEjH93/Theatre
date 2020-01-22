package com.theatre.systemoperation.reservations;
import com.theatre.broker.Broker;
import com.theatre.domain.Reservations;
import com.theatre.domain.TransferClass;
import com.theatre.systemoperation.GeneralSystemOperation;

public class ReservationsReturn extends GeneralSystemOperation {

	@Override
	public void doConcreteSystemOperation(TransferClass object) {
		// TODO Auto-generated method stub
		Broker broker = new Broker();
		object.setResponse(broker.select(new Reservations()));
		
	}

}
