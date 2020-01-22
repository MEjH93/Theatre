package com.theatre.domain;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.List;
import java.text.SimpleDateFormat;

import com.theatre.view.ScheduleForm;
import com.theatre.view.TheatreForm;

public class Schedule implements GeneralDomain {
	private int idSchedule;
	private Date date;
	private String time;
	private int numberOfTickets;
	private int idShow;
	
	public int getNumberOfTickets() {
		return numberOfTickets;
	}
	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}
	public int getIdShow() {
		return idShow;
	}
	public void setIdShow(int idShow) {
		this.idShow = idShow;
	}
	public int getIdSchedule() {
		return idSchedule;
	}
	public void setIdSchedule(int idSchedule) {
		this.idSchedule = idSchedule;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Schedule(int numberOfTickets, Date date, String time,int idShow ) {
		super();
		this.date = date;
		this.time = time;
		this.numberOfTickets = numberOfTickets;
		this.idShow = idShow;
	}
	public Schedule(int idschedule2) {
		// TODO Auto-generated constructor stub
	}
	public Schedule() {
		// TODO Auto-generated constructor stub
	}
	public PreparedStatement save(PreparedStatement preparedStatement) {
		try {
			//String sql = "SET FOREIGN_KEY_CHECKS=0";
			preparedStatement.setDate(1, (java.sql.Date)date);
			preparedStatement.setString(2, time);
			preparedStatement.setInt(3, numberOfTickets);
			preparedStatement.setInt(4, idShow);
			//SET FOREIGN_KEY_CHECKS=0
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedStatement;
}

	@Override
	public String returnTableNames() {
		// TODO Auto-generated method stub
		return "schedule";
	}
	@Override
	public String returnColumnNames() {
		// TODO Auto-generated method stub
		return "(date,time,numberOfTickets,id_show)";
	}
	@Override
	public String returnValues() {
		// TODO Auto-generated method stub
		return "(?,?,?,?)";
	}
	@Override
	public List<GeneralDomain> select(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String returnIdForDeleting() {
		// TODO Auto-generated method stub
		return "id_schedule";
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
/*	private void filLComboBoxesDates() {

        String[] hours = new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
        for (String a: hours             ) {
           // hours.addItem(a);
        }
        String[] minutes = new String[] {"00", "30"};
        for (String a: minutes             ) {
          //  minutes.addItem(a);
        }
        String[] yearlist = new String[] {"2020", "2021", "2022"};
        for (String a: year             ) {
          //  year.addItem(a);
        }
        String[] months = new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        for (String a: months             ) {
           // cbmonth.addItem(a);
        }
        String[] days = new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        for (String a: days             ) {
        	scheduleform.cbaday(days);
        	//enum cu za ove brojeve
            //cbDan.addItem(a);
        }

    }
    */
	@Override
	public PreparedStatement save1(PreparedStatement preparedStatement) {
			try {
				preparedStatement.setDate(1, (java.sql.Date)date);
				preparedStatement.setString(2, time);
				preparedStatement.setInt(3, numberOfTickets);
				preparedStatement.setInt(4, idShow);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return preparedStatement;
	}
	
	

}
