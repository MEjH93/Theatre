package com.theatre.systemoperation.theatre;
import com.theatre.broker.Broker;
import com.theatre.domain.GeneralDomainDecorator;
import com.theatre.domain.Theatre;
import com.theatre.domain.TransferClass;
import com.theatre.systemoperation.GeneralSystemOperation;

public class TheatreReturn extends GeneralSystemOperation {

	@Override
	public void doConcreteSystemOperation(TransferClass object) {
		// TODO Auto-generated method stub
		Broker broker = new Broker();
		object.setResponse(broker.select(new Theatre()));
		
	}

}
