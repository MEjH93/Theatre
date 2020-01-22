package com.theatre.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Reservations implements GeneralDomain {
	private Show show;
	private Theatre theatre;
	private String hallName;
	private double ticketPrice;
	private int numberOfTickets;
	private User user;
	private Schedule schedule;
	
	public String getHallName() {
		return hallName;
	}
	public void setHallName(String hallName) {
		this.hallName = hallName;
	}
	public double getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(double ticketCost) {
		this.ticketPrice = ticketCost;
	}
	public int getNumberOfTickets() {
		return numberOfTickets;
	}
	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}
	
	
	public Reservations(Show show, Theatre theatre, String hallName, double ticketPrice, int numberOfTickets, User user,
			Schedule schedule) {
		super();
		this.show = show;
		this.theatre = theatre;
		this.hallName = hallName;
		this.ticketPrice = ticketPrice;
		this.numberOfTickets = numberOfTickets;
		this.user = user;
		this.schedule = schedule;
	}
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public Reservations() {
		// TODO Auto-generated constructor stub
	}
	public Reservations(int idreservations) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public PreparedStatement save(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setInt(1, numberOfTickets);
			preparedStatement.setDouble(2, ticketPrice);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedStatement;
}
	@Override
	public String returnTableNames() {
		// TODO Auto-generated method stub
		return "reservations";
	}
	@Override
	public String returnColumnNames() {
		// TODO Auto-generated method stub
		return "(numberOfTickets,ticketPrice)";
	}
	@Override
	public String returnValues() {
		// TODO Auto-generated method stub
		return "(?,?)";
	}
	@Override
	public List<GeneralDomain> select(ResultSet resultSet) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String returnIdForDeleting() {
		// TODO Auto-generated method stub
		return "id_reservations";
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
