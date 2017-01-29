package org.teipir.softeng.hrms;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;
import java.io.*;
import java.util.*;
import javax.swing.border.*;

public class Shortlist extends JFrame implements ActionListener {
	public JLabel l, l1, l2, l3, l4, l5, l6, l7, dtx, im;
	public JTextField t1, t2, t4, t5, t6, t7, dtxt;
	public String ts1, ts2, ts3, ts4, ts5, ts6, ts7;
	public TextArea t3;
	public JButton b1, b2, b3;
	public JPanel panel;
	public Font g;

	public Shortlist() {
		g = new Font("", Font.BOLD, 22);
		Container c = this.getContentPane();
		c.setBackground(new java.awt.Color(204, 230, 255));
		panel = (JPanel) getContentPane();
		panel.setLayout(null);

		// ------ Displaying Current System Date ....

		dtx = new JLabel(" Date :- ");
		dtx.setBounds(525, 15, 100, 30);
		dtx.setFont(new Font("Georgia", Font.BOLD, 20));
		add(dtx);

		dtxt = new JTextField();
		dtxt.setFont(new Font("Times New Roman", Font.BOLD, 20));
		dtxt.setBackground(Color.WHITE);
		dtxt.setBounds(600, 15, 100, 30);
		dtxt.setEditable(false);

		String str = String.format("%1$td-%1$tb-%1$ty", new Date());
		dtxt.setText(str);
		add(dtxt);

		// ---------------------------------------------------

		l = new JLabel("Shortlisted Candidates ");
		l1 = new JLabel("Candidate's Id");
		l2 = new JLabel("Candidate's Name");
		l3 = new JLabel("Candidate's Address");
		l4 = new JLabel("Candidate's Phone");
		l5 = new JLabel("Candidate's Resume No.");
		l6 = new JLabel("Round Of Qualified");
		l7 = new JLabel("Candidate's E-mail");

		t3 = new TextArea(5, 8);
		t4 = new JTextField(20);
		t5 = new JTextField(20);
		t6 = new JTextField(20);
		t7 = new JTextField(20);
		t1 = new JTextField(20);
		t2 = new JTextField(20);

		b1 = new JButton("Submit");
		b3 = new JButton("Back");

		t1.setBounds(200, 100, 150, 30);
		t2.setBounds(200, 150, 150, 30);
		t3.setBounds(200, 400, 150, 60);
		t4.setBounds(200, 200, 150, 30);
		t5.setBounds(200, 250, 150, 30);
		t6.setBounds(200, 300, 150, 30);
		t7.setBounds(200, 350, 150, 30);

		panel.add(b1);
		panel.add(b3);

		b1.setBounds(300, 500, 100, 30);
		b3.setBounds(420, 500, 100, 30);

		panel.add(l);
		l.setBounds(250, 10, 300, 35);
		l.setFont(g);
		panel.add(l1);
		l1.setBounds(20, 100, 150, 30);

		panel.add(l2);
		l2.setBounds(20, 150, 150, 30);
		panel.add(l3);
		l3.setBounds(20, 200, 150, 30);
		l4.setBounds(20, 250, 150, 30);
		l5.setBounds(20, 300, 150, 30);
		panel.add(l4);
		l6.setBounds(20, 350, 150, 30);
		l7.setBounds(20, 400, 150, 30);
		panel.add(l5);
		panel.add(l6);
		panel.add(l7);

		panel.add(t1);
		panel.add(t2);
		panel.add(t3);
		panel.add(t4);
		panel.add(t5);
		panel.add(t6);
		panel.add(t7);

		b1.addActionListener(this);
		b3.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		String str1 = ae.getActionCommand();
		if (str1 == "Back") {
			Cd_per f = new Cd_per();
			f.setVisible(true);
			f.setSize(800, 600);
			f.show();
			this.dispose();
		}
		if (str1 == "Submit") {
			try {
				System.out.println("starting Established..");
				Class.forName("com.mysql.jdbc.Driver");
				System.out.println(" Established..");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost.localdomain:3306/hrms");
				System.out.println("DBCon Established.. ........");
				con.setAutoCommit(false);

				ts1 = t1.getText();
				int a1 = Integer.parseInt(ts1);
				ts2 = t2.getText();
				ts3 = t4.getText();
				ts4 = t5.getText();
				int a2 = Integer.parseInt(ts4);
				ts5 = t6.getText();
				int a3 = Integer.parseInt(ts5);
				ts6 = t7.getText();
				int a4 = Integer.parseInt(ts6);
				ts7 = t3.getText();

				System.out.println("query Established..");

				PreparedStatement psm = con.prepareStatement("insert into shortlist values(?,?,?,?,?,?,?)");

				psm.setInt(1, a1);
				psm.setString(2, ts2);
				psm.setString(3, ts3);
				psm.setInt(4, a2);
				psm.setInt(5, a3);
				psm.setInt(6, a4);
				psm.setString(7, ts7);

				int i = psm.executeUpdate();
				System.out.println("query.");

				con.commit();
				JOptionPane.showMessageDialog(this, "Query Executed", "Record Inserted", JOptionPane.WARNING_MESSAGE);
				System.out.println("Query Executed");

				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
			} catch (NumberFormatException ne) {
				JOptionPane.showMessageDialog(this, "Invalid Input", "Operation Not Possible",
						JOptionPane.WARNING_MESSAGE);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException es) {
			}
		}

	}

	public static void main(String args[]) {
		Shortlist f = new Shortlist();
		f.setVisible(true);
		f.setSize(800, 600);
		f.show();
	}
}
