package com.theatre.systemoperation.show;


import com.theatre.broker.Broker;
import com.theatre.domain.Show;
import com.theatre.domain.TransferClass;
import com.theatre.systemoperation.GeneralSystemOperation;

public class ShowUpdate extends GeneralSystemOperation {

	@Override
	public void doConcreteSystemOperation(TransferClass object) {
		Show show = (Show) object.getRequest();
		Broker broker = new Broker();
		broker.update(show);
		
		
		
	}

}
