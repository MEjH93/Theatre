package com.theatre.broker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import com.theatre.domain.Artikal;
import com.theatre.domain.GeneralDomain;
import com.theatre.domain.GeneralDomainDecorator;
import com.theatre.domain.Show;
import com.theatre.domain.Theatre;
import com.theatre.domain.User;
import com.theatre.connection.*;

public class Broker {
	public int returnUser(GeneralDomainDecorator user) {
		
		return user.returnUser();
		
	}
	
		
		
	
	public List<GeneralDomain>select(GeneralDomain generalDomain){
		String sql ="select * from "+generalDomain.returnTableNames();
		PreparedStatement preparedStatement;
		ResultSet resultSet = null;
		try {
			preparedStatement = Connections.getInstance().getConnection().prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return generalDomain.select(resultSet);
		
	}
	public void delete(int id, GeneralDomain generalDomain) {
		String sql ="delete from "+generalDomain.returnTableNames()+" where "+generalDomain.returnIdForDeleting()  +" = ?";
		try {
			PreparedStatement preparedStatement = Connections.getInstance().getConnection().prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void add(GeneralDomain generalDomain) {
		String sql = "INSERT INTO "+generalDomain.returnTableNames()+""+generalDomain.returnColumnNames()+" VALUES"+
				generalDomain.returnValues();
	try {
		PreparedStatement preparedStatement = Connections.getInstance().getConnection().prepareStatement(sql);
		preparedStatement = generalDomain.save(preparedStatement);
		preparedStatement.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public void InsertScheduleByUniqueShowName(GeneralDomain generalDomain) {
		String sql = "INSERT INTO "+generalDomain.returnTableNames()+""+generalDomain.returnColumnNames()+" VALUES"+
				generalDomain.returnValues() + "SELECT `id_show` FROM `show` WHERE show_name='mejh'";
		//String sql2 = "SELECT `id_show` FROM `show` WHERE show_name='mejh'";
		
	try {
		//PreparedStatement preparedStatement1 = Connections.getInstance().getConnection().prepareStatement(sql2);
		PreparedStatement preparedStatement = Connections.getInstance().getConnection().prepareStatement(sql);
		preparedStatement = generalDomain.save1(preparedStatement);
		preparedStatement.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	
	public void update(GeneralDomain generalDomain) {
		String sql = "UPDATE "+generalDomain.returnTableNames()+"SET"+generalDomain.returnColumnNamesUpdate()+" WHERE "+generalDomain.returnIdUpdate();
		try {
			PreparedStatement preparedStatement = Connections.getInstance().getConnection().prepareStatement(sql);
			preparedStatement = generalDomain.update(preparedStatement);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}




	public List<Object> Names(GeneralDomain generalDomain) {
			List<Object> objectList = new ArrayList<>();
			String sql = "SELECT "+generalDomain.nameColumn()+" FROM "+generalDomain.returnTableName();
	        PreparedStatement preparedStatement;
	        try {
	            preparedStatement = Connections.getInstance().getConnection().prepareStatement(sql);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) objectList.add(resultSet.getString(generalDomain.nameColumn()));
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return objectList;
		
	}




	public int returnIdEach(GeneralDomain generalDomain) {
		// TODO Auto-generated method stub
	        int idTheatre = 0;
	        String sql = "select " +generalDomain.IdColumnName()  + " from " + generalDomain.returnTableName() +
	                " where " + generalDomain.nameColumn() + " = " + generalDomain.returnQuestionMarkForId();
	        try {
	        	PreparedStatement preparedStatement = Connections.getInstance().getConnection().prepareStatement(sql);
	            preparedStatement = generalDomain.returnNameShow(preparedStatement);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if (resultSet.first())
	                idTheatre = resultSet.getInt(generalDomain.IdColumnName());
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return idTheatre;
	    }




	public List<String> returnNameColumns(GeneralDomain generalDomain) {
		  List<String> list = new ArrayList<>();
	        String sql = "select column_name from information_schema.columns where table_name = n'" + generalDomain.returnTableName() + "'";
	        try {
	            PreparedStatement preparedStatement = Connections.getInstance().getConnection().prepareStatement(sql);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) list.add(resultSet.getString("column_name"));
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }




	public List<Object> returnData(GeneralDomain generalDomain) {
		// TODO Auto-generated method stub
		List<Object> listObject = new ArrayList<>();
        Object object = null;
        String sql = "select * from " + generalDomain.returnTableName();
        PreparedStatement preparedStatement;
        try {
            preparedStatement = Connections.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                object = generalDomain.readObjects(resultSet);
                listObject.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listObject;
    }
}

	


	
	
	
	

