package com.theatre.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.theatre.controllerUI.ControllerUI;
import com.theatre.domain.ConstBL;
import com.theatre.domain.ConstUI;
import com.theatre.domain.TransferClass;
import com.theatre.domain.User;
import com.theatre.view.proxy.Proxy;
import com.theatre.view.proxy.ProxyLogin;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginForm extends JFrame {

	private JPanel contentPane;
	private JTextField tfUser;
	private JPasswordField tfPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm frame = new LoginForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 727, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(158, 133, 198, 30);
		contentPane.add(lblUsername);
		
		JLabel lblNewLabel = new JLabel("Welcome to MEJH's theatre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(249, 21, 551, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(158, 190, 198, 30);
		contentPane.add(lblPassword);
		
		tfUser = new JTextField();
		tfUser.setBounds(227, 139, 96, 20);
		contentPane.add(tfUser);
		tfUser.setColumns(10);
		
		JButton btnSignIn = new JButton("Sign in");
		btnSignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = tfUser.getText();
				char[]pass = tfPass.getPassword();
				String password = String.copyValueOf(pass);
				User user2 = new User();
				user2.setUsername(username);
				user2.setPassword(password);
				TransferClass transferClass = new TransferClass();
				transferClass.setRequest(user2);
				transferClass.setConstUI(ConstUI.USER);
				transferClass.setConstBL(ConstBL.LOGIN);
				ControllerUI.getInstance().execute(transferClass);
				Proxy proxy = new ProxyLogin();
				proxy.login((int)transferClass.getResponse());
				
			}
		});
		btnSignIn.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSignIn.setBounds(227, 296, 96, 23);
		contentPane.add(btnSignIn);
		
		JButton btnSignUp = new JButton("Sign up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Sorry, we are full on users,currently working on it");
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSignUp.setBounds(227, 357, 96, 23);
		contentPane.add(btnSignUp);
		
		tfPass = new JPasswordField();
		tfPass.setBounds(227, 196, 96, 21);
		contentPane.add(tfPass);
	}
}
