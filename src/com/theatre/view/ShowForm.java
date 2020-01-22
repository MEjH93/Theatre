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
import com.theatre.domain.MyException;
import com.theatre.domain.Show;
import com.theatre.domain.Theatre;
import com.theatre.domain.TransferClass;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ShowForm extends JFrame {

	private JPanel contentPane;
	private JTextField tfShow;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();
	private int idShow;
	private int idTheatre;
	private JComboBox theatreComboBox;
	private JTextField tfGenre;
	private JTextField tfActors;
	private JButton btnRemoveShow;
	

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public ShowForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 585);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Shows");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(390, 23, 97, 14);
		contentPane.add(lblNewLabel);
		
		JLabel tfTheatre = new JLabel("Theatre");
		tfTheatre.setBounds(10, 58, 66, 14);
		contentPane.add(tfTheatre);
		
		JLabel tfShows = new JLabel("Show");
		tfShows.setBounds(10, 107, 66, 14);
		contentPane.add(tfShows);
		
		theatreComboBox = new JComboBox();
		theatreComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dtm.setRowCount(0);
                String theatreName = theatreComboBox.getSelectedItem().toString();
                Theatre theatre = new Theatre();
                theatre.setTheatreName(theatreName);
                idTheatre = (int) TransferClass.transferClass(theatre, ConstUI.THEATRE, ConstBL.RETURN_ID_THEATRE).getResponse();

                Show show = new Show();
                List<Show> listShow = (List<Show>) TransferClass.transferClass(show, ConstUI.SHOW, ConstBL.RETURN_SHOW).getResponse();
                for (Show Show1: listShow) {

                Object [] red = {Show1.getTheatre().getIdTheatre(),Show1.getIdShow(), Show1.getShowname(),Show1.getGenre(),Show1.getActors()};
                if (Show1.getTheatre().getIdTheatre()==idTheatre)

                    dtm.addRow(red);
            }

        }
	}
);
		theatreComboBox.setBounds(169, 56, 671, 22);
		contentPane.add(theatreComboBox);
		
		tfShow = new JTextField();
		tfShow.setBounds(169, 104, 671, 20);
		contentPane.add(tfShow);
		tfShow.setColumns(10);
		
		JButton btnAddShow = new JButton("Add Show");
		btnAddShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idtheatre = idTheatre;
				String showname = tfShow.getText();
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
		btnAddShow.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAddShow.setBounds(10, 205, 281, 23);
		contentPane.add(btnAddShow);
		
		JButton btnRemoveShow = new JButton("Remove Show");
		btnRemoveShow.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e) {try {
				btnRemoveShowWithException();
				TransferClass.transferClass(idShow, ConstUI.SHOW, ConstBL.DELETE_SHOW);
				showShows();
			} catch (MyException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}}});
		
		btnRemoveShow.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRemoveShow.setBounds(301, 205, 269, 23);
		contentPane.add(btnRemoveShow);
		
		JButton btnUpdateShow = new JButton("Update Show");
		btnUpdateShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Show show = new Show();
				Theatre theatre = new Theatre();
				theatre.setIdTheatre(idTheatre);
				show.setShowname(tfShow.getText());
				show.setGenre(tfGenre.getText());
				show.setActors(tfActors.getText());
				show.setTheatre(theatre);
				show.setIdShow(idShow);
				TransferClass.transferClass(show, ConstUI.SHOW, ConstBL.EDIT_SHOW);
				showShows();
			}
		});
		btnUpdateShow.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdateShow.setBounds(580, 205, 260, 23);
		contentPane.add(btnUpdateShow);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 239, 829, 308);
		contentPane.add(scrollPane);
		
		table = new JTable(dtm);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_1 = new JLabel("Genre");
		lblNewLabel_1.setBounds(10, 142, 48, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Actors");
		lblNewLabel_2.setBounds(10, 180, 48, 14);
		contentPane.add(lblNewLabel_2);
		
		tfGenre = new JTextField();
		tfGenre.setBounds(169, 139, 671, 20);
		contentPane.add(tfGenre);
		tfGenre.setColumns(10);
		
		tfActors = new JTextField();
		tfActors.setColumns(10);
		tfActors.setBounds(169, 177, 671, 20);
		contentPane.add(tfActors);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int red = table.getSelectedRow();
				idTheatre = Integer.parseInt((table.getModel().getValueAt(red,0).toString()));
				idShow = Integer.parseInt(table.getModel().getValueAt(red, 1).toString());
				tfShow.setText(table.getModel().getValueAt(red,2).toString());
				tfGenre.setText(table.getModel().getValueAt(red, 3).toString());
				tfActors.setText(table.getModel().getValueAt(red, 4).toString());
						}
			}
		);
		Object []columns= {"IdTheatre","IdShow","Show","Genre","Actors"};
		dtm.addColumn(columns[0]);
		dtm.addColumn(columns[1]);
		dtm.addColumn(columns[2]);
		dtm.addColumn(columns[3]);
		dtm.addColumn(columns[4]);
		fillTheatreComboBox();
		putColumns();
		showShows();
	}
	private void btnRemoveShowWithException() throws MyException {
		  if(idShow==0) throw new MyException("You can not delete the Show while it has a schedule on it");
		
	}
	private void showShows() {
		//TransferClass.transferClass(ConstUI.SHOW, ConstBL.RETURN_SHOW);
		TransferClass transferClass = new TransferClass();
		transferClass.setConstUI(ConstUI.SHOW);
		transferClass.setConstBL(ConstBL.RETURN_SHOW);
		ControllerUI.getInstance().execute(transferClass);
		dtm.setRowCount(0);
		for(Show show : (List<Show>)transferClass.getResponse()) {
			Object[]row = {show.getTheatre().getIdTheatre(),show.getidShow(),show.getShowname(),show.getGenre(),show.getActors()};
			if(show.getTheatre().getIdTheatre()==idTheatre)
			dtm.addRow(row);
		}
		
	}
	private void fillTheatreComboBox() {
        Theatre theatre = new Theatre();
        List<String> theatreNames = (List<String>) TransferClass.transferClass(theatre, ConstUI.THEATRE, ConstBL.THEATRE_NAMES).getResponse();
        for (String a: theatreNames) {
            theatreComboBox.addItem(a);
        }
    }
	  private void putColumns() {
	        Show show = new Show();
	        List<String> columnList = (List<String>) TransferClass.transferClass(show, ConstUI.SHOW, ConstBL.RETURN_SHOW_COLUMN_NAMES).getResponse();
	        for (String a: columnList) {
	            dtm.addColumn(a);
	        }
	    }
	  /*  private void columnsForIdenticalId() {
            dtm.setRowCount(0);
            Show show = new Show();
            List<Show> showList = (List<Show>) TransferClass.transferClass(show, ConstUI.SHOW, ConstBL.RETURN_DATA_SHOWS).getResponse();
            for(Show show2: showList) {
                Object [] row = {show2.getidShow(),show2.getShowname(),show2.getGenre(),show2.getActors(),show2.getTheatre().getIdTheatre()};
                if (show2.getTheatre().getIdTheatre()==idTheatre)
                dtm.addRow(row);
            }
    }*/
	
}
