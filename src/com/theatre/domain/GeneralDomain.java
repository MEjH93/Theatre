package com.theatre.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface GeneralDomain {
	public PreparedStatement save(PreparedStatement preparedStatement);
	public String returnTableNames();
	public String returnColumnNames();
	public String returnValues();
	public List<GeneralDomain> select(ResultSet resultSet);
	public String returnIdForDeleting();
	public PreparedStatement update(PreparedStatement preparedStatement);
	public String returnColumnNamesUpdate(); 
	public String returnIdUpdate();
	public String IdColumnName();
	public PreparedStatement returnNameShow(PreparedStatement preparedstatement);
	public String returnQuestionMarkForId();
	public String nameColumn();
	public String returnTableName();
	public Object readObjects(ResultSet resultSet);
	public PreparedStatement save1(PreparedStatement preparedStatement);

	
	
	

}
