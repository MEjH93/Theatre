package com.theatre.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserForm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfTicketCount;
	private JTable table_1;
	private JTextField tfFeedback;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public UserForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 909, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pick a theatre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(80, 23, 274, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pick a show");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(364, 23, 123, 14);
		contentPane.add(lblNewLabel_1);
		
		JComboBox theatreComboBox = new JComboBox();
		theatreComboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		theatreComboBox.setBounds(10, 48, 238, 22);
		contentPane.add(theatreComboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(258, 48, 267, 317);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNumberOfSeats = new JLabel("Number of Tickets");
		lblNumberOfSeats.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumberOfSeats.setBounds(535, 52, 193, 14);
		contentPane.add(lblNumberOfSeats);
		
		JLabel lblMaximumNumberOfSeats2 = new JLabel("new label");
		lblMaximumNumberOfSeats2.setBounds(672, 52, 48, 14);
		contentPane.add(lblMaximumNumberOfSeats2);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblDate.setBounds(535, 93, 48, 14);
		contentPane.add(lblDate);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTime.setBounds(535, 135, 48, 14);
		contentPane.add(lblTime);
		
		JLabel lblNewLabel_3 = new JLabel("Ticket purchase history");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setBounds(36, 339, 196, 26);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 372, 238, 164);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNumberOfTickets = new JLabel("Number of tickets you want to purchase");
		lblNumberOfTickets.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNumberOfTickets.setBounds(535, 258, 249, 14);
		contentPane.add(lblNumberOfTickets);
		
		tfTicketCount = new JTextField();
		tfTicketCount.setBounds(775, 258, 96, 20);
		contentPane.add(tfTicketCount);
		tfTicketCount.setColumns(10);
		
		JLabel lblTicketPrice = new JLabel("One ticket price for the show");
		lblTicketPrice.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTicketPrice.setBounds(535, 179, 204, 14);
		contentPane.add(lblTicketPrice);
		
		JLabel lblDate2 = new JLabel("New label");
		lblDate2.setBounds(593, 93, 48, 14);
		contentPane.add(lblDate2);
		
		JLabel lblTime2 = new JLabel("New label");
		lblTime2.setBounds(593, 135, 48, 14);
		contentPane.add(lblTime2);
		
		JLabel lblTicketPrice2 = new JLabel("New label");
		lblTicketPrice2.setBounds(711, 179, 48, 14);
		contentPane.add(lblTicketPrice2);
		
		JButton btnPurchase = new JButton("Purchase");
		btnPurchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPurchase.setBounds(534, 342, 89, 23);
		contentPane.add(btnPurchase);
		
		JLabel lblFeedback = new JLabel("Please feel free to leave a feedback between 1 and 10");
		lblFeedback.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblFeedback.setBounds(256, 522, 385, 14);
		contentPane.add(lblFeedback);
		
		tfFeedback = new JTextField();
		tfFeedback.setBounds(631, 516, 96, 20);
		contentPane.add(tfFeedback);
		tfFeedback.setColumns(10);
		
		JButton btnFeedback = new JButton("Apply feedback");
		btnFeedback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tfFeedback.getText().equalsIgnoreCase(String.valueOf(' '))) {
					JOptionPane.showMessageDialog(null, "Please insert a number between 1 and 10 for the feedback,thank you");
				}else {
					JOptionPane.showMessageDialog(null, "Thank you for your time and business, and we hope you enjoyed our shows!");
				}
				
			}
		});
		btnFeedback.setBounds(735, 513, 136, 23);
		contentPane.add(btnFeedback);
		
		JLabel lblNewLabel_2 = new JLabel("Remaining seats");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(535, 218, 144, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblRemainingSeats = new JLabel("New label");
		lblRemainingSeats.setBounds(642, 218, 48, 14);
		contentPane.add(lblRemainingSeats);
		
		JLabel lblNewLabel_4 = new JLabel("TOTAL COST");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(535, 302, 106, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblTotalCost = new JLabel("New label");
		lblTotalCost.setBounds(642, 303, 48, 14);
		contentPane.add(lblTotalCost);
	}
}
