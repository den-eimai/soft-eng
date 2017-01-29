package org.teipir.softeng.hrms;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
import java.util.*;

class Loginscreen extends JFrame implements ActionListener {
	DBCon con;
	PreparedStatement pst;
	ResultSet rs;
	Statement st;
	JTextField t1;
	JPasswordField t2;
	JLabel l1, l2, wel;
	JButton ok, cancel, clear;
	String s1, id, pwd;

	public Loginscreen() {
		super("LOGIN SCREEN");

		Container c = this.getContentPane();
		setLayout(null);
		c.setBackground(new java.awt.Color(204, 204, 100));
		wel = new JLabel("HUMAN RESOURCE MANAGEMENT SYSTEM.");
		wel.setFont(new Font("Georgia", Font.BOLD, 22));
		wel.setForeground(Color.RED);
		wel.setBounds(25, 15, 2750, 25);
		c.add(wel);
		// user name
		l1 = new JLabel("Username:");
		l1.setFont(new Font("Georgia", Font.ITALIC, 20));
		l1.setForeground(Color.BLACK);
		l1.setBounds(102, 68, 275, 35);
		c.add(l1);
		// password label
		l2 = new JLabel("Password:");
		l2.setFont(new Font("Georgia", Font.ITALIC, 20));
		l2.setForeground(Color.BLACK);
		l2.setBounds(102, 109, 275, 35);
		c.add(l2);
		// using textfield for Loginscreen
		t1 = new JTextField();
		t1.setText(null);
		t1.setFont(new Font("Georgia", Font.ITALIC, 20));
		t1.setBounds(220, 75, 125, 25);
		c.add(t1);
		// using jpassword field for password
		t2 = new JPasswordField();
		t2.setText(null);
		t2.setFont(new Font("Georgia", Font.ITALIC, 20));
		t2.setBounds(220, 115, 125, 25);
		c.add(t2);
		// adding buttons
		clear = new JButton("Clear");
		clear.setFont(new Font("Georgia", Font.BOLD, 16));
		clear.addActionListener(this);
		clear.setMnemonic('C');
		clear.setBounds(105, 185, 110, 30);
		c.add(clear);

		ok = new JButton("Login");
		ok.setFont(new Font("Georgia", Font.BOLD, 16));
		ok.addActionListener(this);
		ok.setMnemonic('L');
		ok.setBounds(240, 185, 110, 30);
		c.add(ok);

		cancel = new JButton("Exit");
		cancel.setFont(new Font("Georgia", Font.BOLD, 16));
		cancel.addActionListener(this);
		cancel.setMnemonic('E');
		cancel.setBounds(375, 185, 110, 30);
		c.add(cancel);

		setDefaultCloseOperation(1);
		setLocation(150, 100);
		setVisible(true);
		setSize(600, 300);
	}

	public void actionPerformed(ActionEvent a) {
		s1 = a.getActionCommand();

		if (s1.equals("Exit")) {
			int dialogtype = JOptionPane.INFORMATION_MESSAGE;
			JOptionPane.showMessageDialog(null, " Thank You!", "MESSAGE", dialogtype);
			System.exit(0);
		}
		if (s1.equals("Clear")) {
			t1.setText(null);
			t2.setText(null);
		}
		if (s1.equals("Login")) {
			id = t1.getText();
			pwd = t2.getText();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost.localdomain:3306/hrms");
				System.out.println("\nCONNECTION SUCCESSFULL.\n");
				st = con.createStatement();
				String qu = "select des from id_password where login_id='" + id + "' and password='" + pwd + "'";

				rs = st.executeQuery(qu);
				if (rs.next()) {
					String desg = rs.getString("des");
					System.out.println("\ndesg:->" + desg);
					if (desg.equals("clerk")) {
						int dialogtype = JOptionPane.INFORMATION_MESSAGE;
						JOptionPane.showMessageDialog(null, "Login successfull", "Message", dialogtype);
						Menu1 p = new Menu1();
						this.dispose();
					}
					if (desg.equals("librarian")) {
						int dialogtype = JOptionPane.INFORMATION_MESSAGE;
						JOptionPane.showMessageDialog(null, "Login successfull", "Message", dialogtype);
						this.dispose();
					}
				} else {
					System.out.println("Invalid ID or Invalid Password");

					int dialogtype = JOptionPane.INFORMATION_MESSAGE;
					JOptionPane.showMessageDialog(null, "Login Failed \n Please Enter Correct Login Details..",
							"Message", dialogtype);
					t1.setText(null);
					t2.setText(null);
				}
				con.close();
			} catch (Exception e) {
				System.out.println("\nException:\n" + e);
			}
		}

	}

	public static void main(String a[]) {
		Loginscreen f1 = new Loginscreen();

	}// main

}// login_screen_class