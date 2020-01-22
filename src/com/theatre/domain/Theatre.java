package com.theatre.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.theatre.connection.Connections;
import com.theatre.controllerUI.ControllerUI;

public class Theatre implements GeneralDomain{
	private int idTheatre;
	private String theatreName;
	private String theatreAddress;
	private Show show;
	
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public int getIdTheatre() {
		return idTheatre;
	}
	public void setIdTheatre(int idTheatre) {
		this.idTheatre = idTheatre;
	}
	public String getTheatreName() {
		return theatreName;
	}
	public void setTheatreName(String theatreName) {
		this.theatreName = theatreName;
	}
	public String getTheatreAddress() {
		return theatreAddress;
	}
	public void setTheatreAddress(String theatreAddress) {
		this.theatreAddress = theatreAddress;
	}
	
	public Theatre(int idTheatre, String theatreName, String theatreAddress) {
		super();
		this.idTheatre = idTheatre;
		this.theatreName = theatreName;
		this.theatreAddress = theatreAddress;
	}
	public Theatre(String theatreName,String theatreAddress) {
		this.theatreName = theatreName;
		this.theatreAddress = theatreAddress;
	}
		
	public PreparedStatement save(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1, theatreName);
			preparedStatement.setString(2, theatreAddress);
			//preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedStatement;
	}
	public Theatre(int idTheatre2) {
		// TODO Auto-generated constructor stub
	}
	public Theatre() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String returnTableNames() {
		// TODO Auto-generated method stub
		return "theatre";
	}
	@Override
	public String returnColumnNames() {
		// TODO Auto-generated method stub
		return "(`theatre_name`, `theatre_address`)";
	}
	@Override
	public String returnValues() {
		// TODO Auto-generated method stub
		return "(?,?)";
	}
	@Override
	public List<GeneralDomain> select(ResultSet resultSet) {
		// TODO Auto-generated method stub
		List<GeneralDomain>list = new ArrayList<GeneralDomain>();
		try {
			while(resultSet.next()) {
				Theatre theatre = new Theatre(idTheatre, theatreName, theatreAddress);
				theatre.setIdTheatre(resultSet.getInt("id_theatre"));
				theatre.setTheatreName(resultSet.getString("theatre_name"));
				theatre.setTheatreAddress(resultSet.getString("theatre_address"));
				list.add(theatre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public String returnIdForDeleting() {
		// TODO Auto-generated method stub
		return "id_theatre";
	}
	public PreparedStatement update(PreparedStatement preparedStatement) {
		String sql = "update theatre set theatre_name = ?, theatre_address = ? where id_theatre = ? ";
		try {
			preparedStatement = Connections.getInstance().getConnection().prepareStatement(sql);
			preparedStatement.setString(1, getTheatreName());
			preparedStatement.setString(2, getTheatreAddress());
			preparedStatement.setInt(3, getIdTheatre());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedStatement;
	}
	@Override
	public String returnColumnNamesUpdate() {
		// TODO Auto-generated method stub
		return "theatre_name = ?, theatre_address = ?";
	}
	@Override
	public String returnIdUpdate() {
		// TODO Auto-generated method stub
		return "id_theatre = ? ";
	}
	@Override
	public String IdColumnName() {return "id_theatre";}
	@Override
	public PreparedStatement returnNameShow(PreparedStatement preparedStatement) {
		        try {
		            preparedStatement.setString(1, theatreName);
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		        return preparedStatement;
		    }
	@Override
	public String returnQuestionMarkForId() {return " ? ";}
	@Override
	public String nameColumn() {return "theatre_name";}
	@Override
	public String returnTableName() {return "theatre";}
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
