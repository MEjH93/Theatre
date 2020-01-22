package com.theatre.systemoperation.schedule;
import com.theatre.broker.Broker;
import com.theatre.domain.Schedule;
import com.theatre.domain.TransferClass;
import com.theatre.systemoperation.GeneralSystemOperation;

public class ScheduleDelete extends GeneralSystemOperation{

	@Override
	public void doConcreteSystemOperation(TransferClass object) {
		// TODO Auto-generated method stub
		int idschedule = (int) object.getRequest();
		Broker broker = new Broker();
		broker.delete(idschedule,new Schedule(idschedule));
	}

}
