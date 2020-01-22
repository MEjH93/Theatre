package com.theatre.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.theatre.connection.Connections;

public class User implements  GeneralDomainDecorator{
	private int id;
	private String username;
	private String password;
	private String phone;
	private String email;
	private int status;
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public PreparedStatement save(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1,username);
			preparedStatement.setString(2, password);
			preparedStatement.setString(3,phone);
			preparedStatement.setString(4, email);
			preparedStatement.setInt(5, status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedStatement;
	}
	
	public String returnTableNames() {
		// TODO Auto-generated method stub
		return "user";
	}
	
	public String returnColumnNames() {
		// TODO Auto-generated method stub
		return "( username, password, phone, email, status)";
	}
	
	public String returnValues() {
		// TODO Auto-generated method stub
		return "(?,?,?,?,?)";
	}
	
	public int returnUser() {
		// TODO Auto-generated method stub
		String sql = "select * from user where username = ? and password  = ?";
		int status = -1;
		try {
			PreparedStatement preparedStatement = Connections.getInstance().getConnection().prepareStatement(sql);
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.first()) {
				status = resultSet.getInt("status");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}
	
	public List<GeneralDomain> select(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String returnIdForDeleting() {
		// TODO Auto-generated method stub
		return "id_user";
	}
	@Override
	public PreparedStatement update(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String returnColumnNamesUpdate() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String returnIdUpdate() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String IdColumnName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PreparedStatement returnNameShow(PreparedStatement preparedstatement) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String returnQuestionMarkForId() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String nameColumn() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String returnTableName() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object readObjects(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public PreparedStatement save1(PreparedStatement preparedStatement) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	
	

}