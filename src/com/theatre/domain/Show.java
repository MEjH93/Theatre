package com.theatre.domain;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.theatre.connection.Connections;


public class Show implements GeneralDomain {
	private int idShow;
	private String showname;
	private String genre;
	private String actors;
	private String director;
	private String description;
	private int idHall;
	private Theatre theatre;
	private int idTheatre;

	public Show(int idShow, String showname, String genre, String actors, Theatre theatre) {
		super();
		this.idShow = idShow;
		this.showname = showname;
		this.genre = genre;
		this.actors = actors;
		this.theatre = theatre;
	}
	public Theatre getTheatre() {
		return theatre;
	}
	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}
	public int getIdShow() {
		return idShow;
	}
	public void setIdShow(int idShow) {
		this.idShow = idShow;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getIdHall() {
		return idHall;
	}
	public void setIdHall(int idHall) {
		this.idHall = idHall;
	}
	public int getidShow() {
		return idShow;
	}
	public void setidShow(int idShow) {
		this.idShow = idShow;
	}
	public String getShowname() {
		return showname;
	}
	public void setShowname(String showname) {
		this.showname = showname;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getActors() {
		return actors;
	}
	public void setActors(String actors) {
		this.actors = actors;
	}
	public Show(int idShow, String showname, String genre, String actors) {
		super();
		this.idShow = idShow;
		this.showname = showname;
		this.genre = genre;
		this.actors = actors;
	}
	public Show(int idShow2) {
		// TODO Auto-generated constructor stub
	}
	public Show() {
		// TODO Auto-generated constructor stub
	}
	public Show(int int1, String string, int int2) {
		// TODO Auto-generated constructor stub
	}
	public Show(int int1, String string, String string2, String string3, int int2) {
		// TODO Auto-generated constructor stub
	}
	@Override
	public PreparedStatement save(PreparedStatement preparedStatement) {
		try {
			preparedStatement.setString(1, showname);
			preparedStatement.setString(2, genre);
			preparedStatement.setString(3, actors);
			preparedStatement.setInt(4, theatre.getIdTheatre());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return preparedStatement;
}
		@Override
	public String returnTableNames() {
		// TODO Auto-generated method stub
	return "`show`";
		}
		@Override
	public String returnColumnNames() {
		// TODO Auto-generated method stub
	return "(`show_name`, `genre`, `actors`,`id_theatre`)";

		}
		@Override
	public String returnValues() {
		return "(?,?,?,?)";
		}
		@Override
		public List<GeneralDomain> select(ResultSet resultSet) {
			// TODO Auto-generated method stub
			List<GeneralDomain>list = new ArrayList<GeneralDomain>();
			try {
				while(resultSet.next()) {
					Show show = new Show();
					Theatre theatre = new Theatre();
					theatre.setIdTheatre(resultSet.getInt("id_theatre"));
					show.setIdShow(resultSet.getInt("id_show"));
					show.setShowname(resultSet.getString("show_name"));
					show.setGenre(resultSet.getString("genre"));
					show.setActors(resultSet.getString("actors"));
					show.setTheatre(theatre);
					list.add(show);
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
		return "id_show";
		}
		public void setTheatre(int idTheatre) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public PreparedStatement update(PreparedStatement preparedStatement) {
			try {
				preparedStatement.setInt(1, theatre.getIdTheatre());
				preparedStatement.setInt(5, idShow);
				preparedStatement.setString(2, showname);
				preparedStatement.setString(3, genre);
				preparedStatement.setString(4, actors);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return preparedStatement;
		}
		public String returnColumnNamesUpdate() {
			// TODO Auto-generated method stub
			return " id_theatre = ?,show_name = ?,genre = ?,actors = ?";
		}
		@Override
		public String returnIdUpdate() {
			// TODO Auto-generated method stub
			return "id_show = ? ";
		}
		@Override
		public String IdColumnName() {return "idShow";}
		@Override
		public PreparedStatement returnNameShow(PreparedStatement preparedStatement) {
			        try {
			            preparedStatement.setString(1, showname);
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			        return preparedStatement;
			    }
		@Override
		public String returnQuestionMarkForId() {return " ? ";}
		@Override
		public String nameColumn() {return "show_name";}
		@Override
		public String returnTableName() {return "`show`";}
		@Override
		public Object readObjects(ResultSet resultSet) {
			// TODO Auto-generated method stub
		    Show show = null;
	        try {
	            show = new Show(resultSet.getInt("id_show"), resultSet.getString("show_name"),resultSet.getString("genre"),resultSet.getString("actors"),
	                    resultSet.getInt("id_theatre"));
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } return show;
	    }
		public int getIdTheatre() {
			return idTheatre;
		}
		public void setIdTheatre(int idTheatre) {
			this.idTheatre = idTheatre;
		}
		@Override
		public PreparedStatement save1(PreparedStatement preparedStatement) {
			// TODO Auto-generated method stub
			return null;
		}
	
	

}
