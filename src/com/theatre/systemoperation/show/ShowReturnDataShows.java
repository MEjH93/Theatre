package com.theatre.systemoperation.show;

import com.theatre.broker.Broker;
import com.theatre.domain.Show;
import com.theatre.domain.TransferClass;
import com.theatre.systemoperation.GeneralSystemOperation;

public class ShowReturnDataShows extends GeneralSystemOperation {

	@Override
	public void doConcreteSystemOperation(TransferClass transferClass) {
		// TODO Auto-generated method stub
		  	Show show = (Show) transferClass.getRequest();
	        Broker broker = new Broker();
	        transferClass.setResponse(broker.returnData(show));
		
	}

}
