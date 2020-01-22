package com.theatre.systemoperation.schedule;

import com.theatre.broker.Broker;
import com.theatre.domain.Schedule;
import com.theatre.domain.TransferClass;
import com.theatre.systemoperation.GeneralSystemOperation;

/**
 * @author xXx
 *
 */
public class ScheduleAdd extends GeneralSystemOperation {

	@Override
	public void doConcreteSystemOperation(TransferClass transferClass) {
		// TODO Auto-generated method stub
		Schedule schedule = (Schedule) transferClass.getRequest();
		Broker broker = new Broker();
		//broker.add(schedule);
		//System.out.println(schedule.getIdShow()); ovde je nula
		broker.InsertScheduleByUniqueShowName(schedule);
		
	}

}
