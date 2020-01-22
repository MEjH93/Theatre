package com.theatre.systemoperation.show;
import com.theatre.broker.Broker;
import com.theatre.domain.Show;
import com.theatre.domain.TransferClass;
import com.theatre.systemoperation.GeneralSystemOperation;

public class ShowReturn extends GeneralSystemOperation {

	@Override
	public void doConcreteSystemOperation(TransferClass object) {
		// TODO Auto-generated method stub
		Broker broker = new Broker();
		object.setResponse(broker.select(new Show()));
		
	}

}
