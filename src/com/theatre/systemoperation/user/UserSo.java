package com.theatre.systemoperation.user;

import com.theatre.broker.Broker;
import com.theatre.domain.TransferClass;
import com.theatre.domain.User;
import com.theatre.systemoperation.GeneralSystemOperation;

public class UserSo extends GeneralSystemOperation{

		@Override
		public void doConcreteSystemOperation(TransferClass object) {
			User user = (User) object.getRequest();
			Broker broker = new Broker();
			Integer status  = broker.returnUser(user);
			user.setStatus(status);
			object.setResponse(status);
			
		}

	
	}


