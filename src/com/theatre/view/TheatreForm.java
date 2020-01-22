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
import com.theatre.domain.Theatre;
import com.theatre.domain.TransferClass;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.event.ActionEvent;

public class TheatreForm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private int idTheatre;
	private JTextField tfTheatreAddress;
	private JTextField tfTheatreName;
	
	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public TheatreForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 880, 587);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Theatres");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(387, 25, 183, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Theatre name");
		lblNewLabel_1.setBounds(8, 89, 107, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTheatreAddress = new JLabel("Theatre address");
		lblTheatreAddress.setBounds(10, 133, 118, 14);
		contentPane.add(lblTheatreAddress);
		
		tfTheatreName = new JTextField();
		tfTheatreName.setBounds(125, 86, 729, 20);
		contentPane.add(tfTheatreName);
		tfTheatreName.setColumns(10);
		
		tfTheatreAddress = new JTextField();
		tfTheatreAddress.setColumns(10);
		tfTheatreAddress.setBounds(125, 130, 729, 20);
		contentPane.add(tfTheatreAddress);
		
		JButton btnNewButton = new JButton("Add theatre");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String theatreName = tfTheatreName.getText();
				String theatreAddress = tfTheatreAddress.getText();
				Theatre theatre = new Theatre(theatreName,theatreAddress);
				TransferClass.transferClass(theatre, ConstUI.THEATRE, ConstBL.ADD_THEATRE);
				showTheatres();
				removeFields();
			}
		});
		btnNewButton.setBounds(8, 168, 291, 23);
		contentPane.add(btnNewButton);
		
		JButton btnRemoveTheatre = new JButton("Remove theatre");
		btnRemoveTheatre.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemoveTheatre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransferClass.transferClass(idTheatre, ConstUI.THEATRE, ConstBL.DELETE_THEATRE);
				showTheatres();
				removeFields();
			}
		});
		btnRemoveTheatre.setBounds(291, 168, 279, 23);
		contentPane.add(btnRemoveTheatre);
		
		JButton btnUpdateTheatre = new JButton("Update theatre");
		btnUpdateTheatre.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdateTheatre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Theatre theatre = new Theatre();
				theatre.setTheatreName(tfTheatreName.getText());
				theatre.setTheatreAddress(tfTheatreAddress.getText());
				theatre.setIdTheatre(idTheatre);
				TransferClass.transferClass(theatre, ConstUI.THEATRE, ConstBL.EDIT_THEATRE);
				showTheatres();
				removeFields();
			}
		});
		btnUpdateTheatre.setBounds(563, 168, 291, 23);
		contentPane.add(btnUpdateTheatre);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 205, 846, 333);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int red = table.getSelectedRow();
				idTheatre = Integer.parseInt(table.getModel().getValueAt(red, 0).toString());
				tfTheatreName.setText(table.getModel().getValueAt(red,1).toString());
				tfTheatreAddress.setText(table.getModel().getValueAt(red,2).toString());
						}
			}
		);
		Object []columns= {"IdTheatre","Theatre","Address"};
		dtm.addColumn(columns[0]);
		dtm.addColumn(columns[1]);
		dtm.addColumn(columns[2]);
		showTheatres();
		removeFields();
	}
	private void showTheatres() {
		// TODO Auto-generated method stub
		TransferClass transferClass = new TransferClass();
		transferClass.setConstUI(ConstUI.THEATRE);
		transferClass.setConstBL(ConstBL.RETURN_THEATRE);
		ControllerUI.getInstance().execute(transferClass);
		dtm.setRowCount(0);
		for(Theatre theatre : (List<Theatre>)transferClass.getResponse()) {
			Object[]red = {theatre.getIdTheatre(),theatre.getTheatreName(),theatre.getTheatreAddress()};
			dtm.addRow(red);
}
	}
	   private void removeFields() {
	        tfTheatreName.setText("");
	        tfTheatreAddress.setText("");
	    }
}
