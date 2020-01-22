package com.theatre.systemoperation.theatre;

import com.theatre.broker.Broker;
import com.theatre.domain.Theatre;
import com.theatre.domain.TransferClass;
import com.theatre.systemoperation.GeneralSystemOperation;

public class ReturnTheatreID extends GeneralSystemOperation {

	@Override
	public void doConcreteSystemOperation(TransferClass transferClass) {
		Theatre theatre = (Theatre) transferClass.getRequest();
		Broker broker = new Broker();
		transferClass.setResponse(broker.returnIdEach(theatre));
		
	}

}
