package com.theatre.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FirstAdminForm extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public FirstAdminForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome Admin");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(342, 33, 277, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnGoToTheatres = new JButton("Theatres");
		btnGoToTheatres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TheatreForm theatreForm = new TheatreForm();
				theatreForm.setVisible(true);
			}
		});
		btnGoToTheatres.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGoToTheatres.setBounds(177, 129, 133, 23);
		contentPane.add(btnGoToTheatres);
		
		JButton btnGoToShows = new JButton("Shows");
		btnGoToShows.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGoToShows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowForm showForm = new ShowForm();
				showForm.setVisible(true);
			}
		});
		btnGoToShows.setBounds(342, 129, 133, 23);
		contentPane.add(btnGoToShows);
		
		JButton btnGoToSchedule = new JButton("Schedules");
		btnGoToSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScheduleForm scheduleForm = new ScheduleForm();
				scheduleForm.setVisible(true);
			}
		});
		btnGoToSchedule.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGoToSchedule.setBounds(500, 129, 146, 23);
		contentPane.add(btnGoToSchedule);
		
		JButton btnGoToReservations = new JButton("Reservations");
		btnGoToReservations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationsForm reservationsForm = new ReservationsForm();
				reservationsForm.setVisible(true);
			}
		});
		btnGoToReservations.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGoToReservations.setBounds(177, 211, 133, 23);
		contentPane.add(btnGoToReservations);
		
		JButton btnGoToActors = new JButton("Actors");
		btnGoToActors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActorsForm actorsForm = new ActorsForm();
				actorsForm.setVisible(true);
			}
		});
		btnGoToActors.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGoToActors.setBounds(342, 211, 133, 23);
		contentPane.add(btnGoToActors);
		
		JButton btnGoToNew = new JButton("New users");
		btnGoToNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NewUserForm newUserForm = new NewUserForm();
				newUserForm.setVisible(true);
			}
		});
		btnGoToNew.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGoToNew.setBounds(500, 211, 146, 23);
		contentPane.add(btnGoToNew);
		
	}
	
}
