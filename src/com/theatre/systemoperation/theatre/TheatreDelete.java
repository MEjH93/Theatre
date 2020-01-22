package com.theatre.systemoperation.theatre;

import com.theatre.broker.Broker;
import com.theatre.domain.Show;
import com.theatre.domain.Theatre;
import com.theatre.domain.TransferClass;
import com.theatre.systemoperation.GeneralSystemOperation;

public class TheatreDelete extends GeneralSystemOperation {

	@Override
	public void doConcreteSystemOperation(TransferClass object) {
		// TODO Auto-generated method stub
		int idTheatre = (int) object.getRequest();
		Broker broker = new Broker();
		broker.delete(idTheatre,new Theatre());
	}

}
