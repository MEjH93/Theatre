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
import com.theatre.domain.GeneralDomain;
import com.theatre.domain.Show;
import com.theatre.domain.Theatre;
import com.theatre.domain.TransferClass;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JComboBox;

public class AdminFormBeforeAnUpdate extends JFrame {

	private JPanel contentPane;
	private JTextField tfTheatre;
	private JTextField tfShowName;
	private JTextField tfDate;
	private JLabel lblSchedule;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTextField tfGenre;
	private JTextField tfActors;
	private JTextField tfMaximumTickets;
	private JTextField tfTheatreAddress;
	private int IdShow;
	private JTable table_1;
	private DefaultTableModel dtm2 = new DefaultTableModel();
	private int IdTheatre;
	private JTextField tfNumberOfTickets;
	private JTextField tfIdTheatre;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public AdminFormBeforeAnUpdate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Theatre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(532, 23, 123, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblShow = new JLabel("Show");
		lblShow.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblShow.setBounds(136, 118, 123, 24);
		contentPane.add(lblShow);
		
		lblSchedule = new JLabel("Schedule");
		lblSchedule.setBounds(178, 11, 123, 24);
		contentPane.add(lblSchedule);
		
		tfTheatre = new JTextField();
		tfTheatre.setBounds(398, 58, 347, 20);
		contentPane.add(tfTheatre);
		tfTheatre.setColumns(10);
		
		tfShowName = new JTextField();
		tfShowName.setColumns(10);
		tfShowName.setBounds(172, 245, 201, 20);
		contentPane.add(tfShowName);
		
		tfDate = new JTextField();
		tfDate.setColumns(10);
		tfDate.setBounds(163, 46, 96, 20);
		contentPane.add(tfDate);
		
		JButton btnAddShow = new JButton("Add show");
		btnAddShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idtheatre = Integer.parseInt(tfIdTheatre.getText());
				String showname = tfShowName.getText();
				String genre = tfGenre.getText();
				String actors = tfActors.getText();
				Theatre theatre = new Theatre();
				theatre.setIdTheatre(idtheatre);
				Show show = new Show();
				show.setTheatre(theatre);
				show.setShowname(showname);
				show.setGenre(genre);
				show.setActors(actors);
				TransferClass.transferClass(show, ConstUI.SHOW, ConstBL.ADD_SHOW);
				showShows();
			}
		});
		btnAddShow.setBounds(39, 338, 125, 23);
		contentPane.add(btnAddShow);
		
		JButton btnRemoveShow = new JButton("Remove show");
		btnRemoveShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferClass transferClass = new TransferClass();
				transferClass.setRequest(IdShow);
				transferClass.setConstUI(ConstUI.SHOW);
				transferClass.setConstBL(ConstBL.DELETE_SHOW);
				ControllerUI.getInstance().execute(transferClass);
				showShows();
				
			}
		});
		btnRemoveShow.setBounds(198, 338, 140, 23);
		contentPane.add(btnRemoveShow);
		
		JButton btnEditShow = new JButton("Edit Show");
		btnEditShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Show show = new Show();
				Theatre theatre = new Theatre();
				theatre.setIdTheatre(Integer.parseInt(tfIdTheatre.getText()));
				show.setShowname(tfShowName.getText());
				show.setGenre(tfGenre.getText());
				show.setActors(tfActors.getText());
				show.setTheatre(theatre);
				show.setIdShow(IdShow);
				TransferClass transferClass = new TransferClass();
				transferClass.setRequest(show);
				transferClass.setConstUI(ConstUI.SHOW);
				transferClass.setConstBL(ConstBL.EDIT_SHOW);
				ControllerUI.getInstance().execute(transferClass);
				showShows();
			}
		});
		btnEditShow.setBounds(359, 338, 111, 23);
		contentPane.add(btnEditShow);
		
		JButton loremipsum = new JButton("loremipsum1");
		loremipsum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		loremipsum.setBounds(542, 338, 89, 23);
		contentPane.add(loremipsum);
		
		JButton btnLoremipsum = new JButton("loremipsum2");
		btnLoremipsum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	
			}
		});
		btnLoremipsum.setBounds(656, 338, 89, 23);
		contentPane.add(btnLoremipsum);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 386, 728, 113);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int red = table.getSelectedRow();
				tfIdTheatre.setText(table.getModel().getValueAt(red,0).toString());
				IdShow = Integer.parseInt(table.getModel().getValueAt(red, 1).toString());
				tfShowName.setText(table.getModel().getValueAt(red,2).toString());
				tfGenre.setText(table.getModel().getValueAt(red, 3).toString());
				tfActors.setText(table.getModel().getValueAt(red, 4).toString());
				
			}
		});
		scrollPane.setViewportView(table);
		
		tfGenre = new JTextField();
		tfGenre.setColumns(10);
		tfGenre.setBounds(172, 276, 201, 20);
		contentPane.add(tfGenre);
		
		tfActors = new JTextField();
		tfActors.setColumns(10);
		tfActors.setBounds(172, 307, 201, 20);
		contentPane.add(tfActors);
		
		tfMaximumTickets = new JTextField();
		tfMaximumTickets.setColumns(10);
		tfMaximumTickets.setBounds(163, 87, 96, 20);
		contentPane.add(tfMaximumTickets);
		
		tfTheatreAddress = new JTextField();
		tfTheatreAddress.setColumns(10);
		tfTheatreAddress.setBounds(398, 87, 347, 20);
		contentPane.add(tfTheatreAddress);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(383, 194, 388, 122);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable(dtm2);
		table_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int red = table_1.getSelectedRow();
				IdTheatre = Integer.parseInt(table_1.getModel().getValueAt(red, 0).toString());
				tfTheatre.setText(table_1.getModel().getValueAt(red,1).toString());
				tfTheatreAddress.setText(table_1.getModel().getValueAt(red,2).toString());
						
					}
			}
		);
		scrollPane_1.setViewportView(table_1);
		
		JButton btnAddTheatre = new JButton("Add theatre");
		btnAddTheatre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String theatreName = tfTheatre.getText();
				String theatreAddress = tfTheatreAddress.getText();
				int idTheatre = IdTheatre;
				Theatre theatre = new Theatre(idTheatre,theatreName,theatreAddress);
				TransferClass transferClass = new TransferClass();
				transferClass.setRequest(theatre);
				transferClass.setConstUI(ConstUI.THEATRE);
				transferClass.setConstBL(ConstBL.ADD_THEATRE);
				ControllerUI.getInstance().execute(transferClass);
				showTheatres();
			}
		});
		btnAddTheatre.setBounds(382, 157, 125, 23);
		contentPane.add(btnAddTheatre);
		
		JButton btnRemoveTheatre = new JButton("Remove theatre");
		btnRemoveTheatre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferClass transferClass = new TransferClass();
				transferClass.setRequest(IdTheatre);
				transferClass.setConstUI(ConstUI.THEATRE);
				transferClass.setConstBL(ConstBL.DELETE_THEATRE);
				ControllerUI.getInstance().execute(transferClass);
				showTheatres();
			}
		});
		btnRemoveTheatre.setBounds(519, 157, 125, 23);
		contentPane.add(btnRemoveTheatre);
		
		JButton button_2 = new JButton("Edit theatre");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Theatre theatre = new Theatre();
				theatre.setTheatreName(tfTheatre.getText());
				theatre.setTheatreAddress(tfTheatreAddress.getText());
				theatre.setIdTheatre(IdTheatre);
				TransferClass transferClass = new TransferClass();
				transferClass.setRequest(theatre);
				transferClass.setConstUI(ConstUI.THEATRE);
				transferClass.setConstBL(ConstBL.EDIT_THEATRE);
				ControllerUI.getInstance().execute(transferClass);
				showTheatres();
			}
		});
		button_2.setBounds(656, 157, 125, 23);
		contentPane.add(button_2);
		
		JLabel lblNewLabel_1 = new JLabel("ShowName");
		lblNewLabel_1.setBounds(10, 248, 101, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblShowgenre = new JLabel("Genre");
		lblShowgenre.setBounds(10, 279, 101, 14);
		contentPane.add(lblShowgenre);
		
		JLabel lblActors = new JLabel("Actors");
		lblActors.setBounds(10, 310, 48, 14);
		contentPane.add(lblActors);
		
		JLabel lblTheatrename = new JLabel("TheatreName");
		lblTheatrename.setBounds(305, 61, 83, 14);
		contentPane.add(lblTheatrename);
		
		JLabel lblTheatreaddress = new JLabel("TheatreAddress");
		lblTheatreaddress.setBounds(305, 90, 83, 14);
		contentPane.add(lblTheatreaddress);
		
		JLabel lblNewLabel_2 = new JLabel("Reservations");
		lblNewLabel_2.setBounds(10, 23, 101, 14);
		contentPane.add(lblNewLabel_2);
		
		tfNumberOfTickets = new JTextField();
		tfNumberOfTickets.setBounds(10, 58, 96, 20);
		contentPane.add(tfNumberOfTickets);
		tfNumberOfTickets.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		comboBox.setBounds(172, 177, 201, 23);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Choose Theatre you wanna see Shows in");
		lblNewLabel_3.setBounds(0, 181, 175, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("IdTheatre");
		lblNewLabel_4.setBounds(10, 221, 125, 14);
		contentPane.add(lblNewLabel_4);
		
		tfIdTheatre = new JTextField();
		tfIdTheatre.setBounds(172, 214, 201, 20);
		contentPane.add(tfIdTheatre);
		tfIdTheatre.setColumns(10);
		Object []columns= {"IdTheatre","IdShow","Show","Genre","Actors"};
		dtm.addColumn(columns[0]);
		dtm.addColumn(columns[1]);
		dtm.addColumn(columns[2]);
		dtm.addColumn(columns[3]);
		dtm.addColumn(columns[4]);
		Object []columns2= {"IdTheatre","Theatre","Address"};
		dtm2.addColumn(columns2[0]);
		dtm2.addColumn(columns2[1]);
		dtm2.addColumn(columns2[2]);
		showShows();
		showTheatres();
	}
	
	private void showShows() {
		// TODO Auto-generated method stub
		TransferClass transferClass = new TransferClass();
		transferClass.setConstUI(ConstUI.SHOW);
		transferClass.setConstBL(ConstBL.RETURN_SHOW);
		ControllerUI.getInstance().execute(transferClass);
		dtm.setRowCount(0);
		for(Show show : (List<Show>)transferClass.getResponse()) {
			Object[]red = {show.getTheatre().getIdTheatre(),show.getidShow(),show.getShowname(),show.getGenre(),show.getActors()};
			dtm.addRow(red);
		}
		
	}
	private void showTheatres() {
		// TODO Auto-generated method stub
		TransferClass transferClass = new TransferClass();
		transferClass.setConstUI(ConstUI.THEATRE);
		transferClass.setConstBL(ConstBL.RETURN_THEATRE);
		ControllerUI.getInstance().execute(transferClass);
		dtm2.setRowCount(0);
		for(Theatre theatre : (List<Theatre>)transferClass.getResponse()) {
			Object[]red = {theatre.getIdTheatre(),theatre.getTheatreName(),theatre.getTheatreAddress()};
			dtm2.addRow(red);
}
	}
	
}
