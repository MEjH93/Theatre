package com.theatre.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.theatre.controllerUI.ControllerUI;
import com.theatre.domain.ConstBL;
import com.theatre.domain.ConstUI;
import com.theatre.domain.Schedule;
import com.theatre.domain.Show;
import com.theatre.domain.Theatre;
import com.theatre.domain.TransferClass;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ScheduleForm extends JFrame {
	
	private JPanel contentPane;
	private JTextField tfMaximumNumberOfTickets;
	private JTable table;
	private int idSchedule;
	private int idShow;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JComboBox cbMinutes;
	private JComboBox cbHours;
	private JComboBox cbDay;
	private JComboBox cbMonth;
	private JComboBox cbYear;
	private JComboBox cbShow;
	private JComboBox comboBox;
	private int IdTheatre;
	private Schedule schedule;
	private Show show;
	
	public ScheduleForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Show");
		lblNewLabel.setBounds(10, 72, 62, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(236, 203, 48, 14);
		contentPane.add(lblHours);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setBounds(236, 159, 48, 14);
		contentPane.add(lblMinutes);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(495, 119, 48, 14);
		contentPane.add(lblDay);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(495, 159, 48, 14);
		contentPane.add(lblMonth);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(495, 203, 48, 14);
		contentPane.add(lblYear);
		
		cbMinutes = new JComboBox();
		cbMinutes.setBounds(294, 155, 71, 22);
		contentPane.add(cbMinutes);
		
		cbHours = new JComboBox();
		cbHours.setBounds(294, 199, 71, 22);
		contentPane.add(cbHours);
		
		cbDay = new JComboBox();
		cbDay.setBounds(569, 115, 71, 22);
		contentPane.add(cbDay);
		
		cbMonth = new JComboBox();
		cbMonth.setBounds(569, 155, 71, 22);
		contentPane.add(cbMonth);
		
		cbYear = new JComboBox();
		cbYear.setBounds(569, 199, 71, 22);
		contentPane.add(cbYear);
		
		JLabel lblNewLabel_1 = new JLabel("SCHEDULES");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(378, 11, 185, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Total number of tickets for this production");
		lblNewLabel_2.setBounds(10, 232, 274, 14);
		contentPane.add(lblNewLabel_2);
		
		tfMaximumNumberOfTickets = new JTextField();
		tfMaximumNumberOfTickets.setBounds(257, 228, 595, 18);
		contentPane.add(tfMaximumNumberOfTickets);
		tfMaximumNumberOfTickets.setColumns(10);
		
		JButton btnNewButton = new JButton("Add schedule");
		btnNewButton.addActionListener(new ActionListener() {
			 String time =null;
	         String dateInString=null;
			public void actionPerformed(ActionEvent e) {
			
		        if (cbHours.getSelectedItem().toString()!=null && cbMinutes.getSelectedItem().toString()!=null && cbYear.getSelectedItem().toString() !=null
                        && cbMonth.getSelectedItem().toString()!=null && cbDay.getSelectedItem().toString()!=null){

                     time = cbHours.getSelectedItem().toString() + ":"+cbMinutes.getSelectedItem().toString() + ":00";
                     dateInString = cbYear.getSelectedItem().toString() + "-"+cbMonth.getSelectedItem().toString() + "-" + cbDay.getSelectedItem().toString();
		        }
		        	java.sql.Date date = java.sql.Date.valueOf(dateInString);

                int totalTickets = Integer.parseInt(tfMaximumNumberOfTickets.getText());
                System.out.println(cbShow.getSelectedItem().toString());
                System.out.println(totalTickets);
                Schedule schedule = new Schedule(totalTickets, date, time, idShow);
                System.out.println(idShow);
                TransferClass.transferClass(schedule, ConstUI.SCHEDULE, ConstBL.ADD_SCHEDULE);
                putDataInTable();
                removeFields();
            }
        });
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(10, 257, 272, 23);
		contentPane.add(btnNewButton);
		
		JButton btnDeleteSchedule = new JButton("Delete schedule");
		btnDeleteSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteSchedule.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDeleteSchedule.setBounds(554, 257, 298, 23);
		contentPane.add(btnDeleteSchedule);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 291, 842, 254);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("Edit schedule");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(294, 257, 249, 23);
		contentPane.add(btnNewButton_1);
		
		cbShow = new JComboBox();
		cbShow.setBounds(59, 68, 793, 22);
		contentPane.add(cbShow);
		
		JLabel lblNewLabel_3 = new JLabel("Theatre");
		lblNewLabel_3.setBounds(10, 35, 48, 14);
		contentPane.add(lblNewLabel_3);
		
		comboBox = new JComboBox();
		comboBox.setBounds(59, 31, 793, 22);
		contentPane.add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbShow.removeAllItems();
                String theatreName = comboBox.getSelectedItem().toString();
                Theatre theatre = new Theatre();
                theatre.setTheatreName(theatreName);
                IdTheatre = (int) TransferClass.transferClass(theatre, ConstUI.THEATRE, ConstBL.RETURN_ID_THEATRE).getResponse();
                showShows();
                }
			}
);
		fillTheatreComboBox();
		showShows();
		settimeanddatetocomboboxes();

}
	private void fillShowComboBox() {
        Show show = new Show();
        List<String> showNames = (List<String>) TransferClass.transferClass(show, ConstUI.SHOW, ConstBL.SHOW_NAMES_COMBOBOX).getResponse();
        for (String a: showNames) {
           cbShow.addItem(a);
        }
    }
	private void fillTheatreComboBox() {
        Theatre theatre = new Theatre();
        List<String> theatreNames = (List<String>) TransferClass.transferClass(theatre, ConstUI.THEATRE, ConstBL.THEATRE_NAMES).getResponse();
        for (String a: theatreNames) {
            comboBox.addItem(a);
        }
    }
	private void showShows() {
		TransferClass transferClass = new TransferClass();
		transferClass.setConstUI(ConstUI.SHOW);
		transferClass.setConstBL(ConstBL.RETURN_SHOW);
		ControllerUI.getInstance().execute(transferClass);
		cbShow.removeAllItems();
		for(Show show : (List<Show>)transferClass.getResponse()) {
			Object[]row = {show.getTheatre().getIdTheatre(),show.getidShow(),show.getShowname(),show.getGenre(),show.getActors()};
			if(show.getTheatre().getIdTheatre()==IdTheatre)
			cbShow.addItem(show.getShowname().toString());
		}
		
	}
	  private void settimeanddatetocomboboxes() {

	        String[] hourList = new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13",
	                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
	        for (String str: hourList) {
	            cbHours.addItem(str);
	        }
	        String[] minuteList = new String[] {"00","15","30","45"};
	        for (String str: minuteList) {
	            cbMinutes.addItem(str);
	        }
	        String[] yearList = new String[] {"2020", "2021", "2022","2023","2024"};
	        for (String str: yearList) {
	            cbYear.addItem(str);
	        }
	        String[] monthList = new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
	        for (String str: monthList) {
	            cbMonth.addItem(str);
	        }
	        String[] dayList = new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13",
	                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
	        for (String str: dayList) {
	            cbDay.addItem(str);
	        }

	    }
	  private void removeFields() {
		  tfMaximumNumberOfTickets.setText("");
	
	  	}
	    private void putDataInTable() {
	        dtm.setRowCount(0);
	        Schedule Schedule = new Schedule();
	        List<Schedule> scheduleList = (List<Schedule>) TransferClass.transferClass(schedule, ConstUI.SCHEDULE, ConstBL.RETURN_SCHEDULE).getResponse();
	        for (Schedule schedule1: scheduleList) {
	            Object [] red = {schedule1.getIdSchedule(), schedule1.getTime(), schedule1.getDate(), schedule1.getNumberOfTickets(), schedule1.getIdShow()};
	            if (schedule1.getIdShow()==idShow)
	            dtm.addRow(red);
	        }
	    }
}

	  

