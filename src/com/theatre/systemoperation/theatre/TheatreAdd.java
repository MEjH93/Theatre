package com.theatre.systemoperation.theatre;

import com.theatre.broker.Broker;
import com.theatre.domain.Theatre;
import com.theatre.domain.TransferClass;
import com.theatre.systemoperation.GeneralSystemOperation;

public class TheatreAdd extends GeneralSystemOperation {

	@Override
	public void doConcreteSystemOperation(TransferClass object) {
		// TODO Auto-generated method stub
		Theatre theatre = (Theatre) object.getRequest();
		Broker broker = new Broker();
		broker.add(theatre);
		
	}

}
