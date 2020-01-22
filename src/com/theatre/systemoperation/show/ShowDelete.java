package com.theatre.systemoperation.show;
import com.theatre.broker.Broker;
import com.theatre.domain.Show;
import com.theatre.domain.TransferClass;
import com.theatre.systemoperation.GeneralSystemOperation;

public class ShowDelete extends GeneralSystemOperation{

	@Override
	public void doConcreteSystemOperation(TransferClass object) {
		// TODO Auto-generated method stub
		int idShow = (int) object.getRequest();
		Broker broker = new Broker();
		broker.delete(idShow,new Show(idShow));
	}

}
