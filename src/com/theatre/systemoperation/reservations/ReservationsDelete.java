package com.theatre.systemoperation.reservations;
import com.theatre.broker.Broker;
import com.theatre.domain.Reservations;
import com.theatre.domain.TransferClass;
import com.theatre.systemoperation.GeneralSystemOperation;

public class ReservationsDelete extends GeneralSystemOperation{

	@Override
	public void doConcreteSystemOperation(TransferClass object) {
		// TODO Auto-generated method stub
		int idreservations = (int) object.getRequest();
		Broker broker = new Broker();
		broker.delete(idreservations,new Reservations(idreservations));
	}

}
