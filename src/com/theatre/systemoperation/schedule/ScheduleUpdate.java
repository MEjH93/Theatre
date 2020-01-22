package com.theatre.systemoperation.schedule;
import com.theatre.broker.Broker;
import com.theatre.domain.Schedule;
import com.theatre.domain.TransferClass;
import com.theatre.systemoperation.GeneralSystemOperation;

public class ScheduleUpdate extends GeneralSystemOperation {

	@Override
	public void doConcreteSystemOperation(TransferClass object) {
		Schedule schedule = (Schedule) object.getRequest();
		Broker broker = new Broker();
		broker.update(schedule);
		
		
		
	}

}
