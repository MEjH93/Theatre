package com.theatre.view.proxy;

import javax.swing.JOptionPane;

import com.theatre.domain.ConstBL;
import com.theatre.domain.ConstUI;
import com.theatre.domain.TransferClass;
import com.theatre.view.FirstAdminForm;
import com.theatre.view.UserForm;

public class ProxyLogin implements Proxy {

	@Override
	
	//int status = (int) TransferClass.transferClass(user, ConstUI.USER, ConstBL.LOGIN).getResponse();
	
	public int login(int status) {
		if(status == 1) {
			FirstAdminForm firstAdminForm = new FirstAdminForm();
			firstAdminForm.setVisible(true);
		}else if(status == 0) {
			UserForm userForm = new UserForm();
			userForm.setVisible(true);
		}else {
			JOptionPane.showMessageDialog(null, "Your user or password is incorrect,please try again");
		}
		
		return 0;
	}

}