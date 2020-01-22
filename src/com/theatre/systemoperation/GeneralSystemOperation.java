package com.theatre.systemoperation;

import com.theatre.connection.Connections;
import com.theatre.domain.TransferClass;

public abstract class GeneralSystemOperation {
	public void doSystemOperation(TransferClass object) {
		try {
			startTransaction();
			doConcreteSystemOperation(object);
			confirmTransaction();
			
		}catch (Exception e) {
			// TODO: handle exception
			undoTransaction();
		}finally {
			closeConnection();
		}
	}
	public void closeConnection() {
		Connections.getInstance().closeConnection();
	}
	public void undoTransaction() {
		Connections.getInstance().undoTransaction();
	}
	public void startTransaction() {
		Connections.getInstance().startTransaction();
	}
	public void confirmTransaction() {
		Connections.getInstance().confirmTransaction();
	}
	public abstract void doConcreteSystemOperation(TransferClass object);

	

}
